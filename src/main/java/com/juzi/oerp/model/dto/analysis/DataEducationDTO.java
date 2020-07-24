package com.juzi.oerp.model.dto.analysis;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 学历占比
 *
 * @author Juzi
 * @date 2020/7/22 19:19
 */
@Data
public class DataEducationDTO {

    /**
     * 学历
     */
    @JsonProperty("type")
    private String education;

    /**
     * 数量
     */
    @JsonProperty("value")
    private Integer count;

}
