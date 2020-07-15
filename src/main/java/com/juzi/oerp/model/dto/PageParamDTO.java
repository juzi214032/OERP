package com.juzi.oerp.model.dto;

import lombok.Data;

/**
 * 分页参数
 *
 * @author Juzi
 * @date 2020/7/15 12:25
 */
@Data
public class PageParamDTO {

    /**
     * 第几页
     */
    private Integer pageOn;

    /**
     * 每页大小
     */
    private Integer pageSize;
}
