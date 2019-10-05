package club.stefanie.community.dto;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
@Data
public class PaginationDTO {
    private List<Integer> pages;
    private List<QuestionDTO> questions;
    private boolean showPrevious;
    private boolean showFirstPage;
    private boolean showNext;
    private boolean showEndPage;
    private Integer page;
    Integer totalPages;
    public void setPagination(Integer size, Integer page,Integer totalPage) {
        this.page=page;
        this.totalPages=totalPage;
        pages = new ArrayList<>();
        pages.add(page);
        for(Integer i=1;i<=3;i++) {
            if (page - i > 0) {
                pages.add(0, page-i);
            }
            if (page + i <= totalPage) {
                pages.add(page + i);
            }
        }
        //是否展示第一页
        showFirstPage=pages.contains(1)?false:true;
        //是否展示最后一页
        showEndPage=pages.contains(totalPage)?false:true;
        //是否展示前一页
        showPrevious=page==1?false:true;
        //是否展示后一页
        showNext=page==totalPage?false:true;
    }
}
