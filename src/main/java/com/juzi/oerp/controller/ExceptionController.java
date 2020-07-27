package com.juzi.oerp.controller;

import com.juzi.oerp.common.exception.OERPException;
import com.juzi.oerp.configuration.properties.CodeMessageProperties;
import com.juzi.oerp.model.vo.response.ExceptionResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

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
     * @param e 系统异常
     * @return 异常信息
     */
    @ExceptionHandler(OERPException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponseVO exceptionResponseVO(OERPException e) {
        Integer code = e.getCode();
        String codeMessage = codeMessageProperties.getCodeMessage().get(code);
        if (StringUtils.isEmpty(codeMessage)) {
            codeMessage = "未知错误";
        }

        log.error(codeMessage);
        return new ExceptionResponseVO(code, codeMessage, e.getMessage());
    }

    /**
     * Bean Validator 参数校验异常处理
     *
     * @param e 参数校验异常
     * @return 异常信息
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ExceptionResponseVO methodArgumentNotValidException(MethodArgumentNotValidException e) {
        String validMessage = e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        return new ExceptionResponseVO(40000, validMessage, e.getMessage());
    }

    /**
     * controller 层参数格式转换异常
     *
     * @param e 参数转换异常
     * @return 异常信息
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ExceptionResponseVO methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        return new ExceptionResponseVO(40000, "参数格式错误", e.getMessage());
    }

    /**
     * 上传的文件超时限制的大小
     *
     * @param e 文件过大异常
     * @return 异常信息
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ExceptionResponseVO maxUploadSizeExceededException(MaxUploadSizeExceededException e) {
        return new ExceptionResponseVO(40013, e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestPartException.class)
    public ExceptionResponseVO missingServletRequestPartException(MissingServletRequestPartException e) {
        return new ExceptionResponseVO(40015, e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ExceptionResponseVO httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        return new ExceptionResponseVO(40000, "请求方法不支持", e.getMessage());
    }

    /**
     * 其他未知异常
     *
     * @param runtimeException 运行时异常
     * @return 异常信息
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResponseVO runtimeException(RuntimeException runtimeException) {
        log.error("系统出现未知错误", runtimeException);
        return new ExceptionResponseVO(50000);
    }

}
