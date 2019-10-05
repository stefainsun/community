package club.stefanie.community.controller;

import club.stefanie.community.dto.PaginationDTO;
import club.stefanie.community.service.QuestionUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloController {

    @Autowired
    private QuestionUserService questionUserService;

    @RequestMapping("/")
    public String index(Model model,
                        HttpServletRequest request,
                        @RequestParam(name = "page",defaultValue = "1") Integer page,
                        @RequestParam(name = "size",defaultValue = "5") Integer size
    ) {

        PaginationDTO pagination =  questionUserService.list(page,size);
        model.addAttribute("pagination",pagination);
        model.addAttribute("questions",pagination.getQuestions());

        return "index";

    }

}
