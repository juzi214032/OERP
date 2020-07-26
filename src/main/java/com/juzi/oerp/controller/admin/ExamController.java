package com.juzi.oerp.controller.admin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.juzi.oerp.model.dto.UpdateExamDTO;
import com.juzi.oerp.model.dto.param.CreateExamParamDTO;
import com.juzi.oerp.model.dto.param.PageParamDTO;
import com.juzi.oerp.model.po.ExamPO;
import com.juzi.oerp.model.vo.response.DeleteResponseVO;
import com.juzi.oerp.model.vo.response.MessageResponseVO;
import com.juzi.oerp.model.vo.response.ResponseVO;
import com.juzi.oerp.service.ExamService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 考试管理
 *
 * @author Juzi
 * @date 2020/7/15 22:45
 */
@RestController
@Api(tags = "考试管理")
@RequestMapping("/admin/exam")
public class ExamController {

    @Autowired
    private ExamService examService;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/test/test")
    public void test(@RequestBody CreateExamParamDTO createExamParamDTO) {

    }

    /**
     * 获取考试_分页
     *
     * @param pageParamDTO 分页参数
     */
    @GetMapping
    @ApiOperation(value = "获取考试信息列表", notes = "分页获取考试列表")
    public ResponseVO<ExamPO> getExamByPage(PageParamDTO pageParamDTO) {
        return null;
    }

    /**
     * 获取考试_根据考试 id
     *
     * @param examId 考试 id
     * @return 考试信息
     */
    @GetMapping("/{examId}")
    @ApiOperation(value = "获取考试信息")
    public ExamPO getExamById(@ApiParam("考试id") @PathVariable Integer examId) {
        return null;
    }

    /**
     * 修改考试
     *
     * @param updateExamDTO 考试信息
     * @param examId        考试 id
     * @return 修改成功信息
     */
    @PutMapping("/{examId}")
    @ApiOperation("修改考试信息")
    public ResponseVO<Object> updateExamById(@RequestBody UpdateExamDTO updateExamDTO, @PathVariable Integer examId) {
        return null;
    }

    /**
     * 创建考试
     *
     * @param createExamParamDTO 考试信息
     * @param image              图片
     * @param word               word 文档
     * @return 创建成功信息
     */
    @PostMapping
    @ApiOperation("创建考试")
    public MessageResponseVO createExam(
            @RequestPart(value = "exam") CreateExamParamDTO createExamParamDTO,
            @RequestPart("image") MultipartFile image,
            @RequestPart("word") MultipartFile word) throws IOException {
        examService.createExam(createExamParamDTO, image, word);
        return new MessageResponseVO(20011);
    }

    /**
     * 删除考试
     *
     * @param examId 考试 id
     * @return 删除成功信息
     */
    @DeleteMapping("/{examId}")
    @ApiOperation("删除考试")
    public ResponseVO<Object> deleteExamById(@ApiParam("考试id") @PathVariable Integer examId) {
        return new DeleteResponseVO();
    }
}
