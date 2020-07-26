package com.juzi.oerp.model.dto.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 更新用户信息
 *
 * @author Juzi
 * @date 2020/7/20 14:32
 */
@Data
@ApiModel(description = "修改用户信息参数")
public class UpdateUserInfoParamDTO {

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("身份证号")
    private String identityNo;

    @ApiModelProperty("性别")
    private Integer gender;

    @ApiModelProperty("学校")
    private String school;

    @ApiModelProperty("学历")
    private String education;

}
