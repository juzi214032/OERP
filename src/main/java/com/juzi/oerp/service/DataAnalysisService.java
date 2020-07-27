package com.juzi.oerp.service;

import com.juzi.oerp.model.dto.analysis.DataEducationDTO;
import com.juzi.oerp.model.dto.analysis.DataGroupColumnDTO;
import com.juzi.oerp.model.dto.analysis.DataEducationGenderDTO;
import com.juzi.oerp.model.dto.analysis.DataIncreasedDTO;
import com.juzi.oerp.model.dto.analysis.DataUserEducationDTO;

import java.util.List;

/**
 * @author Juzi
 * @date 2020/7/22 10:52
 */
public interface DataAnalysisService {

    /**
     * 分析考生性别占比
     *
     * @return 考生性别占比
     */
    List<DataGroupColumnDTO> getGenderGistogram();

    /**
     * 分析用户学历占比
     *
     * @return 学历占比
     */
    List<DataEducationDTO> getEducationRose();

    /**
     * 新增用户
     *
     * @param year  年
     * @param month 月
     * @return 新增用户
     */
    DataIncreasedDTO getIncreasedUser(Integer year, Integer month);

    /**
     * @return 用户性别、学历雷达图
     */
    List<DataEducationGenderDTO> getEducationGenderRadar();

    /**
     * 获取考生学历变化趋势
     * @return
     */
    List<DataUserEducationDTO> getUserEducation();
}
