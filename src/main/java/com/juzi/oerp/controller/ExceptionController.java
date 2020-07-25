package com.juzi.oerp.controller;

import com.juzi.oerp.common.exception.OERPException;
import com.juzi.oerp.configuration.properties.CodeMessageProperties;
import com.juzi.oerp.model.vo.response.MessageResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

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
    public MessageResponseVO exceptionResponseVO(OERPException oerpException) {
        Integer code = oerpException.getCode();
        String codeMessage = codeMessageProperties.getCodeMessage().get(code);
        if (StringUtils.isEmpty(codeMessage)) {
            codeMessage = "未知错误";
        }

        log.error(codeMessage);
        return new MessageResponseVO(code, codeMessage);
    }

    /**
     * Bean Validator 参数校验异常处理
     *
     * @param methodArgumentNotValidException 参数校验异常
     * @return 异常信息
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public MessageResponseVO methodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {
        String validMessage = methodArgumentNotValidException.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        return new MessageResponseVO(40000, validMessage);
    }

    /**
     * controller 层参数格式转换异常
     *
     * @param e 参数转换异常
     * @return 异常信息
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public MessageResponseVO methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        return new MessageResponseVO(40000);
    }

    /**
     * 上传的文件超时限制的大小
     *
     * @param e 文件过大异常
     * @return 异常信息
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public MessageResponseVO maxUploadSizeExceededException(MaxUploadSizeExceededException e) {
        return new MessageResponseVO(40013);
    }

    /**
     * 其他未知异常
     *
     * @param runtimeException 运行时异常
     * @return 异常信息
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public MessageResponseVO runtimeException(RuntimeException runtimeException) {
        log.error("系统出现未知错误", runtimeException);
        return new MessageResponseVO(50000);
    }

}
