package com.juzi.oerp.model.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户考试报名信息
 * </p>
 *
 * @author Juzi
 * @since 2020-07-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
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
     * 创建时间
     */
      private LocalDateTime createTime;

      /**
     * 修改时间
     */
      private LocalDateTime updateTime;

      /**
     * 报名状态：
0 - 已申请
1 - 已支付
2 - 审核通过
3 - 审核未通过
     */
      private Integer status;


}
