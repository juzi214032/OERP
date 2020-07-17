package com.juzi.oerp.controller.user;

import com.juzi.oerp.model.dto.param.ApplyExamParamDTO;
import com.juzi.oerp.model.po.UserExamPO;
import com.juzi.oerp.model.vo.response.CreateResponseVO;
import com.juzi.oerp.model.vo.response.ResponseVO;
import com.juzi.oerp.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 报名接口
 *
 * @author Juzi
 * @date 2020/7/15 23:03
 */
@RestController
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
    public ResponseVO<UserExamPO> applyExam(@RequestBody ApplyExamParamDTO applyExamParamDTO) {
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
    public ResponseVO<Object> pay(@PathVariable Integer applyId) {
        applyService.pay(applyId);
        return new CreateResponseVO();
    }

}
