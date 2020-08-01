package com.juzi.oerp.model.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserApplyExamVO {

    /**
     * 考试名称
     */
    private String title;

    /**
     * 考试地点
     */
    private String examPlace;

    /**
     * 考试时间
     */
    private LocalDateTime examTime;

    /**
     * 结束时间
     */
    private LocalDateTime createTime;

    /**
     * 状态
     */
    private Integer status;

}
