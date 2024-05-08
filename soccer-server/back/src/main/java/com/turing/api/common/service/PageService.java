package com.turing.api.common.service;

import com.turing.api.common.model.PageDTO;
import com.turing.api.stadium.web.StadiumRouter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.data.domain.Pageable;
import java.util.HashMap;
import java.util.Map;

@Component
public interface PageService {
    PageDTO getPageDTO(int toTalPageSize, int pageNo);

}
