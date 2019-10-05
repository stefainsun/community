package club.stefanie.community.model;

import lombok.Data;

@Data
public class Question {
    private Integer id;
    private String title;
    private String description;
    private long gmtCreate;
    private long gmtModified;
    private Integer creator;
    private String tag;
    private Integer viewCount;
    private Integer likeCount;

}
