package com.turing.api.common.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class Box {
    private PageDTO pageDTO;
    private List<?> list;



}
