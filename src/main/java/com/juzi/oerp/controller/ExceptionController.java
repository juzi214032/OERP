package com.juzi.oerp.controller;

import com.juzi.oerp.common.exception.OERPException;
import com.juzi.oerp.configuration.properties.CodeMessageProperties;
import com.juzi.oerp.model.vo.response.ExceptionResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
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
     * 系统自定义异常统一处理
     *
     * @param oerpException 系统异常
     * @return 异常信息
     */
    @ExceptionHandler(OERPException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponseVO exceptionResponseVO(OERPException oerpException) {
        Integer code = oerpException.getCode();
        String codeMessage = codeMessageProperties.getCodeMessage().get(code);
        if (StringUtils.isEmpty(codeMessage)) {
            codeMessage = "未知错误";
        }

        log.error(codeMessage);
        return new ExceptionResponseVO(code, codeMessage);
    }

    /**
     * Bean Validator 参数校验异常处理
     *
     * @param methodArgumentNotValidException 参数校验异常
     * @return 异常信息
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ExceptionResponseVO methodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {
        String validMessage = methodArgumentNotValidException.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        return new ExceptionResponseVO(40000, validMessage);
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResponseVO runtimeException(RuntimeException runtimeException) {
        log.error("系统出现未知错误", runtimeException);
        return new ExceptionResponseVO(50000, "系统未知错误");
    }
}
