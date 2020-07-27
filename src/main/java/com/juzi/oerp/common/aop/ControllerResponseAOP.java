package com.juzi.oerp.common.aop;

import com.juzi.oerp.configuration.properties.CodeMessageProperties;
import com.juzi.oerp.model.vo.response.MessageResponseVO;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author Juzi
 * @date 2020/7/20 14:11
 */
@Aspect
@Component
public class ControllerResponseAOP {
    @Autowired
    private CodeMessageProperties codeMessageProperties;

    @AfterReturning(returning = "messageResponseVO", pointcut = "execution(public * com.juzi.oerp.controller..*.*(..))")
    public void doAfterReturning(MessageResponseVO messageResponseVO) {
        if(messageResponseVO==null){
            return;
        }

        int code = messageResponseVO.getCode();
        String oldMessage = messageResponseVO.getMessage();
        String newMessage = codeMessageProperties.getCodeMessage().get(code);

        if (StringUtils.isEmpty(oldMessage)) {
            messageResponseVO.setMessage(newMessage);
        }

    }
}
