package com.juzi.oerp.controller.user;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.juzi.oerp.model.dto.param.PageParamDTO;
import com.juzi.oerp.model.po.ExamPO;
import com.juzi.oerp.model.vo.response.ResponseVO;
import com.juzi.oerp.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 考试接口
 *
 * @author Juzi
 * @date 2020/7/17 13:19
 */
@RestController("userExamController")
@RequestMapping("/user/exam")
public class ExamController {

    @Autowired
    private ExamService examService;

    @GetMapping
    public ResponseVO<IPage<ExamPO>> getExamPlainInfoByPage(PageParamDTO pageParamDTO) {
        IPage<ExamPO> result = examService.getExamPlainInfoByPage(pageParamDTO);
        return new ResponseVO<>(result);
    }
}
