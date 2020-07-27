package com.juzi.oerp.service.impl;

import com.juzi.oerp.dao.DataAnalysisDAO;
import com.juzi.oerp.model.dto.analysis.DataEducationDTO;
import com.juzi.oerp.model.dto.analysis.DataGroupColumnDTO;
import com.juzi.oerp.model.dto.analysis.DataEducationGenderDTO;
import com.juzi.oerp.model.dto.analysis.DataIncreasedDTO;
import com.juzi.oerp.model.dto.analysis.DataUserEducationDTO;
import com.juzi.oerp.service.DataAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.List;

/**
 * @author Juzi
 * @date 2020/7/22 10:53
 */
@Service
public class DataAnalysisServiceImpl implements DataAnalysisService {

    @Autowired
    private DataAnalysisDAO dataAnalysisDAO;

    @Override
    public List<DataGroupColumnDTO> getGenderGistogram() {
        return dataAnalysisDAO.getGenderGistogram();
    }

    @Override
    public List<DataEducationDTO> getEducationRose() {
        return dataAnalysisDAO.getEducationRose();
    }

    @Override
    public DataIncreasedDTO getIncreasedUser(Integer year, Integer month) {
        LocalDate queryDate = LocalDate.of(year, month, 1);
        // 本月新增用户
        long currentTotalUser = dataAnalysisDAO.getIncreasedUser(queryDate);
        long lastMonthTotalUser = dataAnalysisDAO.getIncreasedUser(queryDate.minusMonths(1));
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        // 本月新增百分比
        String currentPercent = decimalFormat.format(((float)currentTotalUser - lastMonthTotalUser)/lastMonthTotalUser);
        // 新增用户占本月和上月的比例
        String totalPercent = decimalFormat.format(currentTotalUser / ((float)currentTotalUser + lastMonthTotalUser));
        DataIncreasedDTO dataIncreasedDTO = new DataIncreasedDTO();
        dataIncreasedDTO
                .setNums(currentTotalUser)
                .setIncreasedPercent(currentPercent)
                .setTotalPercent(totalPercent);
        return dataIncreasedDTO;
    }

    @Override
    public List<DataEducationGenderDTO> getEducationGenderRadar() {
        return dataAnalysisDAO.getEducationGenderRadar();
    }

    @Override
    public List<DataUserEducationDTO> getUserEducation() {
        return dataAnalysisDAO.getUserEducation();
    }

}
