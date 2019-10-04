package club.stefanie.community.service;

import club.stefanie.community.dto.PaginationDTO;
import club.stefanie.community.dto.QuestionDTO;
import club.stefanie.community.mapper.QuestionMapper;
import club.stefanie.community.mapper.UserMapper;
import club.stefanie.community.model.Question;
import club.stefanie.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuestionUserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    QuestionMapper questionMapper;

    public PaginationDTO list(int page, int size)
    {
        int totalCount=questionMapper.count();
        int offset;
        int totalPage;
        //总的页数
        if(totalCount%size==0){
            totalPage = totalCount/size;
        }
        else{
            totalPage = totalCount/size + 1;
        }
        page=page>=totalPage?totalPage:page;
        page=page<1?1:page;
        offset=(page-1)*size;
        List<Question> questions = questionMapper.list(offset,size);
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        PaginationDTO paginationDTO = new PaginationDTO();

        for (Question question : questions) {
            User user=userMapper.findByID(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setQuestions(questionDTOList);
        paginationDTO.setPagination(size,page,totalPage);

        return paginationDTO;
    }

    public PaginationDTO list(int userId, int page, int size) {
        int totalCount=questionMapper.countByUser(userId);
        int offset;
        int totalPage;
        //总的页数
        if(totalCount%size==0){
            totalPage = totalCount/size;
        }
        else{
            totalPage = totalCount/size + 1;
        }
        page=page>=totalPage?totalPage:page;
        page=page<1?1:page;
        offset=(page-1)*size;
        List<Question> questions = questionMapper.listByUser(userId,offset,size);
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        PaginationDTO paginationDTO = new PaginationDTO();

        for (Question question : questions) {
            User user=userMapper.findByID(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setQuestions(questionDTOList);
        paginationDTO.setPagination(size,page,totalPage);

        return paginationDTO;
    }
}
