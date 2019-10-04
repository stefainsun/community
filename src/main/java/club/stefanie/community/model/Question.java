package club.stefanie.community.model;

import lombok.Data;

@Data
public class Question {
    private int id;
    private String title;
    private String description;
    private long gmtCreate;
    private long gmtModified;
    private int creator;
    private String tag;
    private int viewCount;
    private int likeCount;

}
