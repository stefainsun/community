package club.stefanie.community.dto;

import club.stefanie.community.model.User;
import lombok.Data;

@Data
public class QuestionDTO {
    private int id;
    private String title;
    private String description;
    private long gmtCreate;
    private long gmtModified;
    private int creator;
    private String tag;
    private int viewCount;
    private int likeCount;
    private User user;
    private int commentCount;
}
