package com.juzi.oerp.model.po;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 考试信息
 * </p>
 *
 * @author Juzi
 * @since 2020-07-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("exam")
public class ExamPO {


      @TableId(value = "id", type = IdType.AUTO)
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


}
