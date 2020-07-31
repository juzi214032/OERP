package com.juzi.oerp.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Juzi
 * @date 2020/7/18 19:09
 */
@Data
public class ExamApplyInfoDTO {

    /**
     * 考试 id
     */
    private Integer id;

    /**
     * 考试名称
     */
    private String title;

    /**
     * 考试时间
     */
    private LocalDateTime examTime;

    /**
     * 考试地点id
     */
    private Integer examPlaceId;

    /**
     * 考试地点
     */
    private String examPlace;

    /**
     * 最多可报名人数
     */
    private Integer peopleNumber;
}
