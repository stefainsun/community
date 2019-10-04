package club.stefanie.community.mapper;

import club.stefanie.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionMapper {

    @Insert("insert into question (title,description,gmt_create,gmt_modified,creator,tag)values (#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
    void create(Question question);
    @Select("select * from question limit #{page},#{next}")
    List<Question> list(@Param(value = "page") int page,@Param(value = "next") int next);
    @Select("select count(1) from question")
    int count();
    @Select("select count(1) from question where creator = #{userId}")
    int countByUser(@Param(value = "userId") int userId);
    @Select("select * from question where creator = #{userId} limit #{offset},#{size}")
    List<Question> listByUser(@Param(value = "userId") int userId, @Param(value = "offset") int offset,@Param(value = "size") int size);
}
