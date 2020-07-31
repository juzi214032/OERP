package com.juzi.oerp.controller.admin;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.juzi.oerp.model.dto.param.AuditApplicationParamDTO;
import com.juzi.oerp.model.dto.param.CreateApplyParamDTO;
import com.juzi.oerp.model.dto.param.PageParamDTO;
import com.juzi.oerp.model.vo.ApplyInfoVO;
import com.juzi.oerp.model.vo.response.MessageResponseVO;
import com.juzi.oerp.model.vo.response.ResponseVO;
import com.juzi.oerp.service.ApplyService;
import com.juzi.oerp.service.AuditApplicationService;
import com.juzi.oerp.service.UserExamService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Positive;

/**
 * 审核报名
 *
 * @author Juzi
 * @date 2020/7/17 17:35
 */
@RestController
@Api(tags = "审核报名")
@RequestMapping("/admin/apply")
public class ApplyController {

    @Autowired
    private AuditApplicationService auditApplicationService;

    @Autowired
    private UserExamService userExamService;

    @Autowired
    private ApplyService applyService;

    @GetMapping
    @ApiOperation("获取报名信息-分页")
    public ResponseVO<IPage<ApplyInfoVO>> getApplyByPage(@Validated PageParamDTO pageParamDTO) {
        IPage<ApplyInfoVO> result = applyService.getApplyInfoByPage(pageParamDTO);
        return new ResponseVO<>(result);
    }

    @PostMapping
    @ApiOperation("新增报名信息")
    public MessageResponseVO getApplyById(@RequestBody @Validated CreateApplyParamDTO createApplyParamDTO) {
        applyService.createApplyInfo(createApplyParamDTO);
        return new MessageResponseVO(20011);
    }

    @GetMapping("/{applyId}")
    @ApiOperation("获取报名信息")
    public ResponseVO<ApplyInfoVO> getApplyById(
            @PathVariable
            @Positive(message = "报名id格式错误")
            @Validated Integer applyId) {
        ApplyInfoVO result = applyService.getApplyInfoById(applyId);
        return new ResponseVO<>(result);
    }

    @DeleteMapping("/{applyId}")
    @ApiOperation("删除报名信息")
    public MessageResponseVO deleteApplyById(
            @PathVariable
            @Positive(message = "报名id格式错误")
            @Validated Integer applyId) {
        userExamService.removeById(applyId);
        return new MessageResponseVO(20012);
    }

    @PostMapping("/audit")
    @ApiOperation("审核报名")
    public MessageResponseVO auditApply(@RequestBody @Validated AuditApplicationParamDTO auditApplicationParamDTO) {
        auditApplicationService.auditApplication(auditApplicationParamDTO);
        return new MessageResponseVO(20004);
    }

}
