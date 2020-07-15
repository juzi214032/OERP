package com.juzi.oerp.model.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.juzi.oerp.common.jackson.LocalDateTimeDeserializer;
import com.juzi.oerp.common.jackson.LocalDateTimeSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author Juzi
 * @since 2020-07-15
 */
@Data
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
     * 报名开始时间
     */
      @JsonSerialize(using = LocalDateTimeSerializer.class)
      @JsonDeserialize(using = LocalDateTimeDeserializer.class)
      private LocalDateTime beginTime;

      /**
     * 报名截止时间
     */
      @JsonSerialize(using = LocalDateTimeSerializer.class)
      @JsonDeserialize(using = LocalDateTimeDeserializer.class)
      private LocalDateTime endTime;

      /**
     * 考试时间
     */
      @JsonSerialize(using = LocalDateTimeSerializer.class)
      @JsonDeserialize(using = LocalDateTimeDeserializer.class)
      private LocalDateTime examTime;

      /**
     * 最多可报名多少人：-1 无限制
     */
      private Integer peopleNumber;

      /**
     * 创建时间
     */
      @JsonSerialize(using = LocalDateTimeSerializer.class)
      @JsonDeserialize(using = LocalDateTimeDeserializer.class)
      private LocalDateTime createTime;

      /**
     * 更新时间
     */
      @JsonSerialize(using = LocalDateTimeSerializer.class)
      @JsonDeserialize(using = LocalDateTimeDeserializer.class)
      private LocalDateTime updateTime;


}
