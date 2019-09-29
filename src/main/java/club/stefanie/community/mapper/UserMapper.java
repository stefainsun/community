package club.stefanie.community.mapper;
import club.stefanie.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper {
    @Insert("insert into user (name,count_id,token,gmt_create,gmt_modified}) values (#{name},#{token},#{gtmCreate},#{gtmModified})")
    void insert(User user);


}
