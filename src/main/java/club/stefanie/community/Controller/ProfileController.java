package club.stefanie.community.controller;

import club.stefanie.community.dto.PaginationDTO;
import club.stefanie.community.mapper.UserMapper;
import club.stefanie.community.model.User;
import club.stefanie.community.service.QuestionUserService;
import org.h2.engine.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ProfileController {
    @Autowired
    QuestionUserService questionUserService;
    @Autowired
    UserMapper userMapper;
    @GetMapping("/profile/{action}")
    public String profile(@PathVariable(name = "action") String action,
                          @RequestParam(name = "page",defaultValue = "1") int page,
                          @RequestParam(name = "size",defaultValue = "2") int size,
                          HttpServletRequest request,
                          Model model){
        if("questions".equals(action)){
            model.addAttribute("section","question");
            model.addAttribute("sectionName","我的提问");
        }
        if("repies".equals(action)){
            model.addAttribute("section","repies");
            model.addAttribute("sectionName","最新回复");
        }
        User user=null;
        Cookie[] cookies = request.getCookies();
        if(cookies!=null){
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                System.out.println(name);
                if(name.equals("token")){
                    String token = cookie.getValue();
                    user = userMapper.findByToken(token);
                    if(user!=null){
                        request.getSession().setAttribute("user",user);
                    }
                }
            }
        }
        if(user==null){
                return "redirect:/";
        }
        PaginationDTO pagination =  questionUserService.list(user.getId(),page,size);
        model.addAttribute("pagination",pagination);
        model.addAttribute("questions",pagination.getQuestions());

        return "profile";
    }
}
