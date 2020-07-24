package com.juzi.oerp.dao;

import com.juzi.oerp.model.dto.analysis.DataEducationDTO;
import com.juzi.oerp.model.dto.analysis.DataGroupColumnDTO;
import com.juzi.oerp.model.dto.analysis.DataEducationGenderDTO;
import com.juzi.oerp.model.dto.analysis.DataUserEducationDTO;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Juzi
 * @date 2020/7/24 12:01
 */
public interface DataAnalysisDAO {
    List<DataGroupColumnDTO> getGenderGistogram();

    List<DataEducationDTO> getEducationRose();

    long getIncreasedUser(@Param("queryDate") LocalDate queryDate);

    List<DataEducationGenderDTO> getEducationGenderRadar();

    List<DataUserEducationDTO> getUserEducation();
}
