package club.stefanie.community.mapper;

import club.stefanie.community.dto.CommentDTO;
import club.stefanie.community.model.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface CommentMapper {
    @Insert("insert into comment (parent_id,content,commentator,type,like_count,gmt_create,gmt_modified)values (#{parentId},#{content},#{commentator},#{type},#{likeCount},#{gmtCreate},#{gmtModified})")
    public void create(Comment comment);
}
