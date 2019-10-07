package club.stefanie.community.dto;

import lombok.Data;

@Data
public class CommentDTO {
    private Long parentId;
    private Integer type;
    private Long commentator;
    private String content;
}
