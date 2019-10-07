package club.stefanie.community.controller;

import club.stefanie.community.dto.CommentDTO;
import club.stefanie.community.mapper.CommentMapper;
import club.stefanie.community.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class commentController {
    @Autowired
    CommentMapper commentMapper;
    @RequestMapping(value = "/comment",method = RequestMethod.POST)
    public String comment(@RequestBody CommentDTO commentDTO){
        Comment comment = new Comment();
        comment.setCommentator(commentDTO.getCommentator());
        comment.setContent(commentDTO.getContent());
        comment.setGmtCreate(System.currentTimeMillis());
        comment.setGmtModified(System.currentTimeMillis());
        comment.setLikeCount(0L);
        comment.setType(commentDTO.getType());
        commentMapper.create(comment);
        return "getOne";

    }
}
