package com.juzi.oerp.controller.user;

import com.juzi.oerp.model.dto.ApplyExamParamDTO;
import com.juzi.oerp.model.vo.response.CreateResponseVO;
import com.juzi.oerp.model.vo.response.ResponseVO;
import com.juzi.oerp.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
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
     * @param applyExamParamDTO 报名参数
     * @return 报名成功信息
     */
    @PostMapping
    public ResponseVO<Object> applyExam(@RequestBody ApplyExamParamDTO applyExamParamDTO){
        applyService.applyExam(applyExamParamDTO);
        return new CreateResponseVO();
    }

}
