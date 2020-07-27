package com.juzi.oerp.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.juzi.oerp.model.vo.ApplyInfoVO;
import org.apache.ibatis.annotations.Param;

/**
 * @author Juzi
 * @date 2020/7/27 11:18
 */
public interface ApplyDAO {

    IPage<ApplyInfoVO> getApplyInfoByPage(@Param("page") IPage<ApplyInfoVO> page);

    ApplyInfoVO getApplyInfoById(@Param("applyId") Integer applyId);

}
