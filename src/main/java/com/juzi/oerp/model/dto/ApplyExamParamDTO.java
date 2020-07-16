package com.juzi.oerp.model.dto;

import lombok.Data;

/**
 * @author Juzi
 * @date 2020/7/16 15:22
 */
@Data
public class ApplyExamParamDTO {

    /**
     * 考试 id
     */
    private Integer examId;

    /**
     * 考试时间 id
     */
    private Integer examTimeId;

    /**
     * 考试地点 id
     */
    private Integer examPlaceId;

}
