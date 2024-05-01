package com.turing.api.common.component.files;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class PropertiesVo {
    private Boolean enabled;
    private String location;
    private String maxFileSize;
    private String maxRequestSize;
    private String fileSizeThreshould;
}
