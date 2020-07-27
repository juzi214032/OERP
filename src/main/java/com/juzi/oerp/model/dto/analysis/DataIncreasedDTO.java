package com.juzi.oerp.model.dto.analysis;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Juzi
 * @date 2020/7/22 18:52
 */
@Data
@Accessors(chain = true)
public class DataIncreasedDTO {

    /**
     * 新增人数
     */
    private Long nums;

    /**
     * 增加百分比
     */
    private String increasedPercent;

    /**
     * 占上月总数百分比
     */
    private String totalPercent;

}
