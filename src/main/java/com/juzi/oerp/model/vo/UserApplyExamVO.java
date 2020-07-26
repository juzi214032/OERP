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
     * 开始时间
     */
    private LocalDateTime beginTime;

    /**
     * 结束时间
     */
    private LocalDateTime endTime;

    /**
     * 状态
     */
    private Integer status;

}
