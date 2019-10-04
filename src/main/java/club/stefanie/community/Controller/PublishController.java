package club.stefanie.community.controller;

import club.stefanie.community.dto.GithubUser;
import club.stefanie.community.mapper.QuestionMapper;
import club.stefanie.community.mapper.UserMapper;
import club.stefanie.community.model.Question;
import club.stefanie.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Controller
public class PublishController {
    @Autowired
    QuestionMapper questionMapper;
    @Autowired
    UserMapper userMapper;
    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }
    @PostMapping("/publish")
    public String dopublish(@RequestParam(value = "title",required = false)String title,
                            @RequestParam(value = "tag",required = false)String tag,
                            @RequestParam(value = "description",required = false)String description,
                            Model model,
                            HttpServletRequest request)
    {
        User user=null;
        Cookie[] cookies = request.getCookies();
        if(cookies!=null){
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals("token")){
                    String token=cookie.getValue();
                    user=userMapper.findByToken(token);
                    Question question = new Question();
                    question.setDescription(description);
                    question.setTag(tag);
                    question.setTitle(title);
                    question.setGmtCreate(System.currentTimeMillis());
                    question.setGmtModified(question.getGmtCreate());
                    question.setCreator(user.getId());
                    questionMapper.create(question);
                    request.getSession().setAttribute("user",user);
                }
            }
        }

        if(user==null){
            model.addAttribute("error","用户未登录");
            return "/publish";
        }

        model.addAttribute("title",title);
        model.addAttribute("tag",tag);
        model.addAttribute("description",description);
        if(title.equals("")){
            model.addAttribute("error","请输入标题");
            return "publish";
        }
        else if(description.equals("")){
            model.addAttribute("error","请输入内容");
            return "publish";

        }
        else if(tag.equals("")){
            model.addAttribute("error","请输入标签");
            return "publish";
        }
        return "redirect:/";





    }
}
