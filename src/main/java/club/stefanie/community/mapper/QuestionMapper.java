package club.stefanie.community.mapper;

import club.stefanie.community.model.Question;
import org.apache.ibatis.annotations.*;

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
    @Select("select * from question where id = #{id}")
    Question findById(@Param(value = "id") int id);
    @Update("update question set title = #{title},gmt_modified = #{gmtModified},tag = #{tag},description = #{description} where id = #{id}")
    void update(Question question);
    @Update("update question set view_count = view_count+1 where id = #{id}")
    void updateViewCount(@Param(value = "id") int id);

}
