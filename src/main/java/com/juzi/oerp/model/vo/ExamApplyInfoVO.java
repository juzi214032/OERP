package com.juzi.oerp.model.vo;

import com.juzi.oerp.model.po.ExamPlacePO;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * 报名页面的考试信息
 * @author Juzi
 * @date 2020/7/18 18:50
 */
@Data
@Accessors(chain = true)
public class ExamApplyInfoVO {

    /**
     * 考试 id
     */
    private Integer id;

    /**
     * 考试名称
     */
    private String title;

    /**
     * 考试时间、地点
     */
    private Map<LocalDateTime, List<ExamPlacePO>> timePlace;

}
