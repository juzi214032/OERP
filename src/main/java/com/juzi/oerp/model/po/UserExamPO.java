package com.juzi.oerp.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.juzi.oerp.common.jackson.LocalDateTimeDeserializer;
import com.juzi.oerp.common.jackson.LocalDateTimeSerializer;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 用户考试报名信息
 * </p>
 *
 * @author Juzi
 * @since 2020-07-16
 */
@Data
@Accessors(chain = true)
@TableName("user_exam")
public class UserExamPO {

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 考试id
     */
    private Integer examId;

    /**
     * 考试时间id
     */
    private Integer examTimeId;

    /**
     * 考试地点id
     */
    private Integer examPlaceId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 报名状态：
     * 0 - 已申请
     * 1 - 已支付
     * 2 - 审核通过
     * 3 - 审核未通过
     */
    private Integer status;

}
