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

        existPrev=(blockNumber != 1);
        existNext=(blockNumber != pageDTO.getBlockCount());
        pageDTO.setNextBlock(blockNumber+1);
        pageDTO.setPrevBlock(blockNumber-1);
        pageDTO.setExistPrev(existPrev);
        pageDTO.setExistNext(existNext);
        

        log.info("MY-INFO : Controller searchPlayer totalCount is {}", pageDTO.getTotalCount());
        log.info("MY-INFO : Controller searchPlayer pageCount is {}", pageDTO.getPageCount());
        log.info("MY-INFO : Controller searchPlayer blockCount is {}", pageDTO.getBlockCount());
        log.info("MY-INFO : Controller searchPlayer startRow is {}", pageDTO.getStartRow());
        log.info("MY-INFO : Controller searchPlayer endRow is {}", pageDTO.getEndRow());
        log.info("MY-INFO : Controller searchPlayer startPage is {}", pageDTO.getStartPage());
        log.info("MY-INFO : Controller searchPlayer endPage is {}", pageDTO.getEndPage());
        log.info("MY-INFO : Controller searchPlayer nextBlock is {}", pageDTO.getNextBlock());
        log.info("MY-INFO : Controller searchPlayer prevBlock is {}", pageDTO.getPrevBlock());
        log.info("MY-INFO : Controller searchPlayer blockNumber is {}", pageDTO.getBlockNumber());
        log.info("MY-INFO : Controller searchPlayer pageNumber is {}", pageDTO.getPageNumber());
        log.info("MY-INFO : Controller searchPlayer existPrev is {}", existPrev);
        log.info("MY-INFO : Controller searchPlayer existNext is {}", existNext);
        return null;
    }
}
