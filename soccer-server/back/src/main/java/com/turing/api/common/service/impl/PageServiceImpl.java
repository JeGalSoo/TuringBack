package com.turing.api.common.service.impl;


import com.turing.api.common.model.PageDTO;
import com.turing.api.common.service.PageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class PageServiceImpl implements PageService {

    private final PageDTO pageDTO;

    @Override
    public PageDTO getPageDTO(int toTalPageSize, int pageNo) {

        int totalCount = toTalPageSize;
        int pageSize = pageDTO.getPageSize();
        int BLOCK_SIZE = pageDTO.getBLOCK_SIZE();

        int startRow = 0;
        int endRow = 0;

        int startPage = 0;
        int endPage = 0;

        int nextBlock = 0;
        int prevBlock = 0;

        int pageNumber = pageNo;
        int blockNumber = (pageNumber+pageSize)%pageSize ==0 ? ((pageNumber+pageSize)/pageSize)-1 :(pageNumber+pageSize)/pageSize ;

        int blockCount = 0;
        int pageCount = 0;

        boolean existPrev = false;
        boolean existNext = false;

        pageDTO.setTotalCount(totalCount);
        pageDTO.setBlockCount(pageDTO.getTotalCount() % (pageSize*BLOCK_SIZE) == 0 ? totalCount/(pageSize*BLOCK_SIZE) : (totalCount/(pageSize*BLOCK_SIZE))+1);
        pageDTO.setPageCount(totalCount % pageSize == 0 ? totalCount/pageSize : (totalCount/pageSize)+1);
        pageDTO.setStartRow((pageNumber-1)*pageSize);
        pageDTO.setEndRow(pageNumber != pageDTO.getPageCount() ? pageDTO.getStartRow()+pageSize-1 : pageDTO.getStartRow() + (totalCount % pageSize));

        pageDTO.setStartPage((blockNumber-1)*BLOCK_SIZE+1);
        pageDTO.setEndPage(blockNumber != pageDTO.getBlockCount() ? startPage+BLOCK_SIZE-1 : startPage +(totalCount % (pageSize*BLOCK_SIZE))%10) ;

        pageDTO.setExistPrev(blockNumber != 1);
        pageDTO.setExistNext(blockNumber != pageDTO.getBlockCount());
        pageDTO.setNextBlock(blockNumber+1);
        pageDTO.setPrevBlock(blockNumber-1);

        

        log.info("MY-INFO : Controller searchPlayer totalCount is {}", totalCount);
        log.info("MY-INFO : Controller searchPlayer pageCount is {}", pageCount);
        log.info("MY-INFO : Controller searchPlayer blockCount is {}", blockCount);
        log.info("MY-INFO : Controller searchPlayer startRow is {}", startRow);
        log.info("MY-INFO : Controller searchPlayer endRow is {}", endRow);
        log.info("MY-INFO : Controller searchPlayer startPage is {}", startPage);
        log.info("MY-INFO : Controller searchPlayer endPage is {}", endPage);
        log.info("MY-INFO : Controller searchPlayer nextBlock is {}", nextBlock);
        log.info("MY-INFO : Controller searchPlayer prevBlock is {}", prevBlock);
        log.info("MY-INFO : Controller searchPlayer blockNumber is {}", blockNumber);
        log.info("MY-INFO : Controller searchPlayer pageNumber is {}", pageNumber);
        log.info("MY-INFO : Controller searchPlayer existPrev is {}", existPrev);
        log.info("MY-INFO : Controller searchPlayer existNext is {}", existNext);
        return null;
    }
}
