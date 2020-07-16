package com.juzi.oerp.common.interceptor;

import com.juzi.oerp.util.BearerTokenUtils;
import com.juzi.oerp.util.JWTUtils;
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
@Component
public class AuthenticationInterceptor implements HandlerInterceptor {

    /**
     * 用户 id
     */
    private ThreadLocal<Integer> userId = new ThreadLocal<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // String bearerToken = request.getHeader("Authorization");
        // String jwtToken = BearerTokenUtils.parseToken(bearerToken);
        // Integer userId = JWTUtils.parseToken(jwtToken);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        userId.remove();
    }
}
