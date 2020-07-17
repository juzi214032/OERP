package com.juzi.oerp.controller.admin;

import com.juzi.oerp.model.dto.param.PageParamDTO;
import com.juzi.oerp.model.dto.UpdateExamDTO;
import com.juzi.oerp.model.po.ExamPO;
import com.juzi.oerp.model.vo.response.CreateResponseVO;
import com.juzi.oerp.model.vo.response.DeleteResponseVO;
import com.juzi.oerp.model.vo.response.ResponseVO;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 考试管理
 *
 * @author Juzi
 * @date 2020/7/15 22:45
 */
@RestController
@RequestMapping("/admin/exam")
public class ExamController {

    /**
     * 获取考试_分页
     *
     * @param pageParamDTO 分页参数
     */
    @GetMapping
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
    public ExamPO getExamById(@PathVariable Integer examId) {
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
    public ResponseVO<Object> updateExamById(@RequestBody UpdateExamDTO updateExamDTO, @PathVariable Integer examId) {
        return null;
    }

    /**
     * 创建考试
     *
     * @param updateExamDTO 考试信息
     * @return 创建成功信息
     */
    @PostMapping
    public ResponseVO<Object> createExam(@RequestBody UpdateExamDTO updateExamDTO) {
        return new CreateResponseVO();
    }

    /**
     * 删除考试
     *
     * @param examId 考试 id
     * @return 删除成功信息
     */
    @DeleteMapping("/{examId}")
    public ResponseVO<Object> deleteExamById(@PathVariable Integer examId) {
        return new DeleteResponseVO();
    }
}
