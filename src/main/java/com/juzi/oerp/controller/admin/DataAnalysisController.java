package com.juzi.oerp.controller.admin;

import com.juzi.oerp.model.dto.analysis.DataEducationDTO;
import com.juzi.oerp.model.dto.analysis.DataEducationGenderDTO;
import com.juzi.oerp.model.dto.analysis.DataGroupColumnDTO;
import com.juzi.oerp.model.dto.analysis.DataIncreasedDTO;
import com.juzi.oerp.model.dto.analysis.DataUserEducationDTO;
import com.juzi.oerp.model.vo.response.ResponseVO;
import com.juzi.oerp.service.DataAnalysisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 数据分析
 *
 * @author Juzi
 * @date 2020/7/22 10:48
 */
@RestController
@Api(tags = "数据分析")
@RequestMapping("/admin/data")
public class DataAnalysisController {

    @Autowired
    private DataAnalysisService analysisService;

    @GetMapping("/user/histogram")
    @ApiOperation("考生性别对比")
    public ResponseVO<List<DataGroupColumnDTO>> getGenderGistogram() {
        return new ResponseVO<>(analysisService.getGenderGistogram());
    }

    @GetMapping("/user/increased/{year}/{month}")
    @ApiOperation("新增用户统计")
    public ResponseVO<DataIncreasedDTO> getIncreasedUser(@PathVariable Integer year, @PathVariable Integer month) {
        return new ResponseVO<>(analysisService.getIncreasedUser(year, month));
    }

    @GetMapping("/education/rose")
    @ApiOperation("用户学历占比")
    public ResponseVO<List<DataEducationDTO>> getEducationRose() {
        return new ResponseVO<>(analysisService.getEducationRose());
    }

    @GetMapping("/education/radar")
    @ApiOperation("学历性别对比")
    public ResponseVO<List<DataEducationGenderDTO>> getEducationGenderRadar() {
        return new ResponseVO<>(analysisService.getEducationGenderRadar());
    }

    @GetMapping("/user/education")
    @ApiOperation("学历变化趋势")
    public ResponseVO<List<DataUserEducationDTO>> getUserEducation() {
        return new ResponseVO<>(analysisService.getUserEducation());
    }

}
