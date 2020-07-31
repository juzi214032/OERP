package com.juzi.oerp.dao;

import com.juzi.oerp.model.vo.ApplyInfoVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Juzi
 * @date 2020/7/27 11:18
 */
public interface ApplyDAO {

    List<ApplyInfoVO> getApplyInfoByPage(@Param("offset") Integer offset, @Param("rows") Integer rows, @Param("keyword") String keyword);

    ApplyInfoVO getApplyInfoById(@Param("applyId") Integer applyId);

}
