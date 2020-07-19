package com.juzi.oerp.model.vo;

import lombok.Data;

/**
 * 考试简要信息
 *
 * @author Juzi
 * @date 2020/7/17 13:20
 */
@Data
public class ExamPlainInfoPO {

    /**
     * 考试 id
     */
    private Integer id;

    /**
     * 开始名称
     */
    private String title;

    /**
     * 考试描述
     */
    private String description;

    /**
     * 图片url
     */
    private String imageUrl;

}
