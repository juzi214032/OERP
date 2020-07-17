package com.juzi.oerp.controller;

import com.juzi.oerp.common.exception.OERPException;
import com.juzi.oerp.config.properties.CodeMessageProperties;
import com.juzi.oerp.model.vo.response.ExceptionResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常统一处理
 *
 * @author Juzi
 * @date 2020/7/17 08:58
 */
@Slf4j
@RestControllerAdvice
public class ExceptionController {

    @Autowired
    private CodeMessageProperties codeMessageProperties;

    /**
     * 系统统一异常处理
     *
     * @param oerpException 系统异常
     * @return 异常信息
     */
    @ExceptionHandler(OERPException.class)
    public ExceptionResponseVO authenticationException(OERPException oerpException) {
        Integer code = oerpException.getCode();
        String codeMessage = codeMessageProperties.getCodeMessage().get(code);
        if (StringUtils.isEmpty(codeMessage)) {
            codeMessage = "未知错误";
        }


        log.error(codeMessage, oerpException);
        return new ExceptionResponseVO(code, codeMessage);
    }
}
