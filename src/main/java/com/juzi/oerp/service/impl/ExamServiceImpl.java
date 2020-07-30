package com.juzi.oerp.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.io.FileUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.juzi.oerp.common.exception.ApplyException;
import com.juzi.oerp.common.exception.OERPException;
import com.juzi.oerp.dao.ExamDAO;
import com.juzi.oerp.mapper.ExamMapper;
import com.juzi.oerp.mapper.ExamPlaceMapper;
import com.juzi.oerp.mapper.ExamTimeMapper;
import com.juzi.oerp.model.dto.ExamApplyInfoDTO;
import com.juzi.oerp.model.dto.param.PageParamDTO;
import com.juzi.oerp.model.dto.param.UpdateExamParamDTO;
import com.juzi.oerp.model.po.ExamPO;
import com.juzi.oerp.model.po.ExamPlacePO;
import com.juzi.oerp.model.po.ExamTimePO;
import com.juzi.oerp.model.vo.ExamApplyInfoVO;
import com.juzi.oerp.service.ExamPlaceService;
import com.juzi.oerp.service.ExamService;
import com.juzi.oerp.service.ExamTimeService;
import com.juzi.oerp.util.UploadFileUtils;
import com.juzi.oerp.util.WordUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

/**
 * 考试服务
 *
 * @author Juzi
 * @since 2020-07-15
 */
@Service
public class ExamServiceImpl extends ServiceImpl<ExamMapper, ExamPO> implements ExamService {

    @Autowired
    private ExamDAO examDAO;

    @Autowired
    private ExamMapper examMapper;

    @Autowired
    private ExamTimeMapper examTimeMapper;

    @Autowired
    private ExamTimeService examTimeService;

    @Autowired
    private ExamPlaceService examPlaceService;

    @Autowired
    private ExamPlaceMapper examPlaceMapper;

    @Override
    public IPage<ExamPO> getExamPlainInfoByPage(PageParamDTO pageParamDTO) {
        IPage<ExamPO> page = new Page<>(pageParamDTO.getPageOn(), pageParamDTO.getPageSize());
        LambdaQueryWrapper<ExamPO> queryWrapper = new LambdaQueryWrapper<ExamPO>()
                .select(ExamPO::getTitle, ExamPO::getImageUrl, ExamPO::getId, ExamPO::getPrice)
                .like(!StringUtils.isEmpty(pageParamDTO.getKeyword()), ExamPO::getTitle, pageParamDTO.getKeyword())
                .orderByDesc(ExamPO::getCreateTime);
        return examMapper.selectPage(page, queryWrapper);
    }

    @Override
    public ExamPO getExamDetailInfoById(Integer examId) {
        LambdaQueryWrapper<ExamPO> queryWrapper = new LambdaQueryWrapper<ExamPO>()
                .select(ExamPO::getTitle, ExamPO::getImageUrl, ExamPO::getDescription, ExamPO::getId, ExamPO::getDetail, ExamPO::getPrice)
                .eq(ExamPO::getId, examId);
        return examMapper.selectOne(queryWrapper);
    }

    @Override
    public ExamApplyInfoVO getExamApplyInfoById(Integer examId) {
        List<ExamApplyInfoDTO> examApplyInfoDTOList = examDAO.getExamApplyInfoById(examId);
        if (CollectionUtil.isEmpty(examApplyInfoDTOList)) {
            throw new ApplyException(40007);
        }

        Map<LocalDateTime, List<ExamPlacePO>> timePlace = examApplyInfoDTOList
                .stream()
                .collect(groupingBy(ExamApplyInfoDTO::getExamTime, mapping(examApplyInfoDTO -> {
                    ExamPlacePO examPlacePO = new ExamPlacePO();
                    examPlacePO
                            .setId(examApplyInfoDTO.getExamPlaceId())
                            .setExamPlace(examApplyInfoDTO.getExamPlace())
                            .setPeopleNumber(examApplyInfoDTO.getPeopleNumber());
                    return examPlacePO;
                }, toList())));

        ExamApplyInfoVO examApplyInfoVO = new ExamApplyInfoVO();
        examApplyInfoVO
                .setId(examId)
                .setTimePlace(timePlace)
                .setTitle(examApplyInfoDTOList.get(0).getTitle());

        return examApplyInfoVO;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void createExam(UpdateExamParamDTO updateExamParamDTO, MultipartFile image, MultipartFile word) throws IOException {
        // 将 word 转换为 html
        String html = WordUtils.docxToHTML(word.getInputStream());

        // 上传图片
        String imagePath = UploadFileUtils.upload(image.getInputStream(), FileUtil.extName(image.getOriginalFilename()));

        ExamPO examPO = new ExamPO();
        BeanUtils.copyProperties(updateExamParamDTO, examPO);
        examPO
                .setImageUrl(imagePath)
                .setDetail(html);
        examMapper.insert(examPO);

        // 批量插入考试时间
        List<ExamTimePO> examTimePOList = updateExamParamDTO.getTimePlace().keySet()
                .stream().map(examTime -> new ExamTimePO()
                        .setExamId(examPO.getId())
                        .setExamTime(examTime)).collect(toList());
        examTimeService.saveBatch(examTimePOList);

        // 批量插入考试地点
        List<ExamPlacePO> examPlacePOList = examTimePOList.stream().flatMap(examTime ->
                updateExamParamDTO.getTimePlace().get(examTime.getExamTime()).stream().map(examPlace -> {
                    ExamPlacePO examPlacePO = new ExamPlacePO();
                    // 将参数信息 copy 到 PO 对象中
                    BeanUtils.copyProperties(examPlace, examPlacePO);
                    // 将考试时间 id 和考试地点绑定
                    return examPlacePO.setExamTimeId(examTime.getId());
                }).collect(toList()).stream()
        ).collect(toList());
        examPlaceService.saveBatch(examPlacePOList);
    }

    @Override
    public IPage<ExamPO> getExamListByPage(PageParamDTO pageParamDTO) {
        String keyword = pageParamDTO.getKeyword();
        IPage<ExamPO> page = new Page<>(pageParamDTO.getPageOn(), pageParamDTO.getPageSize());
        LambdaQueryWrapper<ExamPO> queryWrapper = new LambdaQueryWrapper<ExamPO>()
                .like(!StringUtils.isEmpty(keyword), ExamPO::getTitle, keyword)
                .orderByDesc(ExamPO::getCreateTime);
        return examMapper.selectPage(page, queryWrapper);
    }

    @Override
    public void deleteExam(Integer examId) {
        ExamPO examPO = examMapper.selectById(examId);
        // 考试不存在
        if (examPO == null) {
            throw new OERPException(40007);
        }
        // 删除考试
        examMapper.deleteById(examId);

        // 删除考试时间
        List<ExamTimePO> examTimePOList = examTimeMapper.selectList(new LambdaQueryWrapper<ExamTimePO>().eq(ExamTimePO::getExamId, examId));
        List<Integer> examTimeIdList = examTimePOList
                .stream()
                .map(ExamTimePO::getId)
                .collect(toList());
        examTimeMapper.deleteBatchIds(examTimeIdList);

        // 删除考试地点
        List<Integer> examPlaceIdList = examTimeIdList
                .stream()
                .flatMap(examTimeId -> examPlaceMapper.selectList(new LambdaQueryWrapper<ExamPlacePO>().eq(ExamPlacePO::getExamTimeId, examTimeId)).stream())
                .map(ExamPlacePO::getId)
                .collect(toList());
        examPlaceMapper.deleteBatchIds(examPlaceIdList);
    }
}
