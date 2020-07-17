package com.juzi.oerp.model.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.juzi.oerp.common.jackson.LocalDateTimeDeserializer;
import com.juzi.oerp.common.jackson.LocalDateTimeSerializer;
import com.juzi.oerp.model.po.ExamPlacePO;
import com.juzi.oerp.model.po.ExamTimePO;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * 完整考试信息
 *
 * @author Juzi
 * @date 2020/7/16 18:56
 */
@Data
public class ExamInfoAllPO {

    private Integer id;

    /**
     * 考试名称
     */
    private String title;

    /**
     * 描述
     */
    private String description;

    /**
     * 考试页面信息：富文本
     */
    private String detail;

    /**
     * 图片 url
     */
    private String imageUrl;

    /**
     * 报名开始时间
     */
    private LocalDateTime beginTime;

    /**
     * 报名截止时间
     */
    private LocalDateTime endTime;

    /**
     * 最多可报名多少人：-1 无限制
     */
    private Integer peopleNumber;

    /**
     * 报名费用
     */
    private BigDecimal price;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 考试 时间-地点 信息
     */
    private Map<ExamTimePO, List<ExamPlacePO>> examTimePlace;
}
