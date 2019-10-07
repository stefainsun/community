package club.stefanie.community.controller;

import club.stefanie.community.dto.QuestionDTO;
import club.stefanie.community.exception.QuestionNotFindException;
import club.stefanie.community.mapper.QuestionMapper;
import club.stefanie.community.service.QuestionUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@Controller
public class QuestionController {
    @Autowired
    QuestionMapper questionMapper;
    @Autowired
    QuestionUserService questionUserService;
    @GetMapping("/question/{id}")
    public String question(@PathVariable(value = "id") Integer id,
                           Model model
    ){
        QuestionDTO questionDTO = null;

        try {
            questionDTO = questionUserService.findbyId(id);
        } catch (QuestionNotFindException e) {
            model.addAttribute("error","问题不存在啊");
            return "errorHandler";
        }

        model.addAttribute("question",questionDTO);
        return "question";
    }
}
