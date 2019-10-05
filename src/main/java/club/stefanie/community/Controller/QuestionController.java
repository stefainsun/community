package club.stefanie.community.controller;

import club.stefanie.community.dto.QuestionDTO;
import club.stefanie.community.service.QuestionUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@Controller
public class QuestionController {
    @Autowired
    QuestionUserService questionUserService;
    @GetMapping("/question/{id}")
    public String question(@PathVariable(value = "id") Integer id,
                           Model model
    ){
        QuestionDTO questionDTO;
        questionDTO = questionUserService.findbyId(id);
        model.addAttribute("question",questionDTO);
        return "question";
    }
}
