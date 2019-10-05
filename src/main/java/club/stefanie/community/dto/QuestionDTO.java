package club.stefanie.community.dto;

import club.stefanie.community.model.User;
import lombok.Data;

@Data
public class QuestionDTO {
    private Integer id;
    private String title;
    private String description;
    private long gmtCreate;
    private long gmtModified;
    private Integer creator;
    private String tag;
    private Integer viewCount;
    private Integer likeCount;
    private User user;
    private Integer commentCount;
}
