package com.juzi.oerp.service.impl;

import com.juzi.oerp.model.po.ExamTimePO;
import com.juzi.oerp.mapper.ExamTimeMapper;
import com.juzi.oerp.service.ExamTimeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 考试对应的考试时间，一对多 服务实现类
 * </p>
 *
 * @author Juzi
 * @since 2020-07-16
 */
@Service
public class ExamTimeServiceImpl extends ServiceImpl<ExamTimeMapper, ExamTimePO> implements ExamTimeService {

}
