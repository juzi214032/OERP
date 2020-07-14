package com.juzi.oerp.config;

import com.juzi.oerp.common.interceptor.AuthenticationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author Juzi
 * @date 2020/7/14 14:56
 */
@Configuration
public class SpringMvcConfiguration extends WebMvcConfigurationSupport {

    /**
     * 认证拦截器
     */
    @Autowired
    private AuthenticationInterceptor authenticationInterceptor;

    /**
     * 配置拦截器
     * @param registry
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry
                .addInterceptor(authenticationInterceptor)
                .addPathPatterns("/*");
        super.addInterceptors(registry);
    }
}
