package com.turing.api.common.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@Data
@Log4j2
public class PageDTO {
    public final int PageSize = 10;
    public final int BLOCK_SIZE = 10;

    private int totalCount;
    private int blockCount;
    private int pageCount;

    private int startRow;
    private int endRow;

    private int startPage;
    private int endPage;

    private int nextBlock;
    private int prevBlock;

    private int blockNumber;
    private int pageNumber;

    private boolean existPrev;
    private boolean existNext;


}
