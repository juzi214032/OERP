package com.juzi.oerp.controller.user;

import com.juzi.oerp.model.dto.param.ApplyExamParamDTO;
import com.juzi.oerp.model.po.UserExamPO;
import com.juzi.oerp.model.vo.response.MessageResponseVO;
import com.juzi.oerp.model.vo.response.ResponseVO;
import com.juzi.oerp.service.ApplyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Positive;

/**
 * 报名接口
 *
 * @author Juzi
 * @date 2020/7/15 23:03
 */
@RestController("userApplyController")
@Api(tags = "考试报名")
@RequestMapping("/user/apply")
public class ApplyController {

    @Autowired
    private ApplyService applyService;

    /**
     * 用户报名考试
     *
     * @param applyExamParamDTO 报名参数
     * @return 报名记录
     */
    @PostMapping
    @ApiOperation("考试报名")
    public ResponseVO<UserExamPO> applyExam(@RequestBody @Validated ApplyExamParamDTO applyExamParamDTO) {
        UserExamPO result = applyService.applyExam(applyExamParamDTO);
        return new ResponseVO<>(result);
    }

    /**
     * 模拟支付接口
     *
     * @param applyId 报名记录id
     * @return 支付结果信息
     */
    @PostMapping("/pay/{applyId}")
    @ApiOperation("考试支付")
    public MessageResponseVO pay(
            @ApiParam("报名 id")
            @PathVariable
            @Positive(message = "报名id格式错误")
            @Validated Integer applyId) {
        applyService.pay(applyId);
        return new MessageResponseVO(20005);
    }

}
