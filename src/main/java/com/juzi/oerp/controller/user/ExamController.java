package com.juzi.oerp.controller.user;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.juzi.oerp.model.dto.param.PageParamDTO;
import com.juzi.oerp.model.po.ExamPO;
import com.juzi.oerp.model.vo.ExamApplyInfoVO;
import com.juzi.oerp.model.vo.response.ResponseVO;
import com.juzi.oerp.service.ExamService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 考试接口
 *
 * @author Juzi
 * @date 2020/7/17 13:19
 */
@Api(tags = "考试信息")
@RequestMapping("/user/exam")
@RestController("userExamController")
public class ExamController {

    @Autowired
    private ExamService examService;

    /**
     * 获取考试简要信息
     *
     * @param pageParamDTO 分页参数
     * @return 首页考试信息
     */
    @GetMapping
    @ApiOperation("获取考试简要信息")
    public ResponseVO<IPage<ExamPO>> getExamPlainInfoByPage(PageParamDTO pageParamDTO) {
        IPage<ExamPO> result = examService.getExamPlainInfoByPage(pageParamDTO);
        return new ResponseVO<>(result);
    }

    /**
     * 获取考试详细信息
     *
     * @param examId 考试 id
     * @return 考试详情页信息
     */
    @GetMapping("/{examId}")
    @ApiOperation("获取考试详细信息")
    public ResponseVO<ExamPO> getExamDetailInfoById(@ApiParam("考试id") @PathVariable Integer examId) {
        ExamPO result = examService.getExamDetailInfoById(examId);
        return new ResponseVO<>(result);
    }

    /**
     * 获取考试报名信息
     * @param examId 考试id
     * @return 考试报名信息
     */
    @GetMapping("/apply/{examId}")
    @ApiOperation("获取考试报名信息")
    public ResponseVO<ExamApplyInfoVO> getExamApplyInfoById(@ApiParam("考试id") @PathVariable Integer examId){
        ExamApplyInfoVO result = examService.getExamApplyInfoById(examId);
        return new ResponseVO<>(result);
    }
}
