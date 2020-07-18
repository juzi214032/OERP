package com.juzi.oerp.model.vo;

import lombok.Data;

/**
 * @author Juzi
 * @date 2020/7/18 18:41
 */
@Data
public class ExamDetailInfoVO {
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
     * 富文本描述
     */
    private String detail;

    /**
     * 图片url
     */
    private String imageUrl;
}
