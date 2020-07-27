package com.juzi.oerp.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 考试信息
 * </p>
 *
 * @author Juzi
 * @since 2020-07-16
 */
@Data
@TableName("exam")
@Accessors(chain = true)
@ApiModel(description = "考试信息")
public class ExamPO {

    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty("考试id")
    private Integer id;

    @ApiModelProperty("考试名称")
    private String title;

    @ApiModelProperty("考试描述")
    private String description;

    @ApiModelProperty("考试富文本描述")
    private String detail;

    @ApiModelProperty("图片url")
    private String imageUrl;

    @ApiModelProperty("报名开始时间")
    private LocalDateTime beginTime;

    @ApiModelProperty("报名截止时间")
    private LocalDateTime endTime;

    @ApiModelProperty("报名费用")
    private BigDecimal price;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;

}
