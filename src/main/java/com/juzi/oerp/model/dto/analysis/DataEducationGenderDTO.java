package com.juzi.oerp.model.dto.analysis;

import lombok.Data;

/**
 * 学历性别对比
 *
 * @author Juzi
 * @date 2020/7/22 19:21
 */
@Data
public class DataEducationGenderDTO {

    /**
     * 学历
     */
    private String education;

    /**
     * 性别
     */
    private String gender;

    /**
     * 数量
     */
    private Integer count;

}
