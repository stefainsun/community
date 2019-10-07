package club.stefanie.community.model;

import lombok.Data;

@Data
public class Comment {
    int type;
    long parentId;
    long commentator;
    String content;
    long gmtCreate;
    long gmtModified;
    long likeCount;
}
