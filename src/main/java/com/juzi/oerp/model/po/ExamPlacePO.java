package com.juzi.oerp.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 考试时间对应的考试地点
 * </p>
 *
 * @author Juzi
 * @since 2020-07-16
 */
@Data
@TableName("exam_place")
@ApiModel(description = "考试时间地点信息")
public class ExamPlacePO {


    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("考试时间id")
    private Integer examTimeId;

    @ApiModelProperty("考试地点")
    private String examPlace;

    @ApiModelProperty("最大报名人数；-1无限制")
    private Integer peopleNumber;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;

}
