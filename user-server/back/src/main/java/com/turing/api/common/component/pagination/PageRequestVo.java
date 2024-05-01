package com.turing.api.common.component.pagination;

import lombok.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Getter
@Builder
public class PageRequestVo {
    private int page;
    private int size;
    private String type;
    private String keyword;

    public PageRequestVo(){
        this.page = 1;
        this.size = 9;
    }

    public Pageable getPageable(Sort sort){
        return PageRequest.of(page -1, size, sort);
    }
}
