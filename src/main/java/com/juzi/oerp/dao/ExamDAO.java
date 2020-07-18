package com.juzi.oerp.dao;

import com.juzi.oerp.model.dto.ExamAllInfoDTO;
import com.juzi.oerp.model.dto.ExamApplyInfoDTO;
import com.juzi.oerp.model.po.ExamPlacePO;
import com.juzi.oerp.model.po.ExamTimePO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Juzi
 * @date 2020/7/16 15:33
 */
public interface ExamDAO {
    /**
     * 获取考试时间_根据考试 id
     *
     * @param examId 考试id
     * @return 当前考试可选时间
     */
    List<ExamTimePO> getExamTimeByExamId(@Param("examId") Integer examId);

    /**
     * 获取考试地点_根据考试时间
     *
     * @param examTimeId 考试时间 id
     * @return 当前考试时间可选地点
     */
    List<ExamPlacePO> getExamPlaceByExamTimeId(@Param("examTimeId") Integer examTimeId);

    /**
     * 查询考试_根据三个id
     *
     * @param examId      考试id
     * @param examTimeId  考试时间id
     * @param examPlaceId 考试地点id
     * @return 考试信息
     */
    ExamAllInfoDTO getExamByIds(@Param("examId") Integer examId, @Param("examTimeId") Integer examTimeId, @Param("examPlaceId") Integer examPlaceId);

    /**
     * 获取考试报名信息
     * @param examId 考试id
     * @return 考试报名信息
     */
    List<ExamApplyInfoDTO> getExamApplyInfoById(@Param("examId") Integer examId);
}
