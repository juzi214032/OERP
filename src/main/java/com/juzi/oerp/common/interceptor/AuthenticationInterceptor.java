package com.juzi.oerp.common.interceptor;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.juzi.oerp.common.exception.AuthenticationException;
import com.juzi.oerp.common.store.LocalUserStore;
import com.juzi.oerp.util.JWTUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 认证拦截器
 *
 * @author Juzi
 * @date 2020/7/14 14:52
 */
@Slf4j
@Component
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.isBlank(bearerToken)) {
            throw new AuthenticationException(40009);
        }

        Integer userId = JWTUtils.parseToken(bearerToken);
        log.debug("当前登录用户id为{}", userId);
        LocalUserStore.setLocalUser(userId);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        LocalUserStore.remove();
    }
}
