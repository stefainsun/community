package club.stefanie.community.controller;

import club.stefanie.community.dto.PaginationDTO;
import club.stefanie.community.dto.QuestionDTO;
import club.stefanie.community.mapper.QuestionMapper;
import club.stefanie.community.mapper.UserMapper;
import club.stefanie.community.model.Question;
import club.stefanie.community.model.User;
import club.stefanie.community.service.QuestionUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class HelloController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionUserService questionUserService;
    @Autowired
    private QuestionMapper questionMapper;
    @RequestMapping("/")
    public String index(Model model,
                        HttpServletRequest request,
                        @RequestParam(name = "page",defaultValue = "1") int page,
                        @RequestParam(name = "size",defaultValue = "5") int size
    ) {

        PaginationDTO pagination =  questionUserService.list(page,size);
        model.addAttribute("pagination",pagination);
        model.addAttribute("questions",pagination.getQuestions());

        return "index";

    }

}
