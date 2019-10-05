package club.stefanie.community.controller;

import club.stefanie.community.mapper.QuestionMapper;
import club.stefanie.community.mapper.UserMapper;
import club.stefanie.community.model.Question;
import club.stefanie.community.model.User;
import club.stefanie.community.service.QuestionUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
@Controller
public class PublishController {
    @Autowired
    QuestionMapper questionMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    QuestionUserService questionUserService;
    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }
    @PostMapping("/publish")
    public String dopublish(@RequestParam(value = "title",required = false)String title,
                            @RequestParam(value = "tag",required = false)String tag,
                            @RequestParam(value = "description",required = false)String description,
                            @RequestParam(value = "questionId",required = false) Integer questionId,
                            Model model,
                            HttpServletRequest request)
    {
        User user= (User) request.getSession().getAttribute("user");
        if(user==null){
            model.addAttribute("error","用户未登录");
            return "/publish";
        }

        model.addAttribute("title",title);
        model.addAttribute("tag",tag);
        model.addAttribute("description",description);
        if(title.equals("")){
            model.addAttribute("error","请输入标题");
            return "/publish";
        }
        else if(description.equals("")){
            model.addAttribute("error","请输入内容");
            return "/publish";

        }
        else if(tag.equals("")){
            model.addAttribute("error","请输入标签");
            return "/publish";
        }
        Question question = new Question();
        question.setTag(tag);
        question.setTitle(title);
        question.setCreator(user.getId());
        question.setDescription(description);
        question.setGmtCreate(System.currentTimeMillis());
        question.setGmtModified(question.getGmtCreate());
        question.setId(questionId);
        questionUserService.createOrUpdate(question);
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String dopublishedit(@PathVariable(name = "id") Integer id,
                            Model model,
                            HttpServletRequest request)
    {
        User user= (User) request.getSession().getAttribute("user");
        if(user==null){
            model.addAttribute("error","用户未登录");
            return "/publish";
        }
        Question question = questionMapper.findById(id);
        model.addAttribute("title",question.getTitle());
        model.addAttribute("tag",question.getTag());
        model.addAttribute("description",question.getDescription());
        model.addAttribute("questionId",question.getId());
        return "publish";
    }


}
