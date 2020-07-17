package com.juzi.oerp.configuration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.juzi.oerp.common.interceptor.AuthenticationInterceptor;
import com.juzi.oerp.common.jackson.LocalDateTimeDeserializer;
import com.juzi.oerp.common.jackson.LocalDateTimeSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import java.util.List;

/**
 * @author Juzi
 * @date 2020/7/14 14:56
 */
@Configuration
public class SpringMvcConfiguration extends DelegatingWebMvcConfiguration {

    /**
     * 认证拦截器
     */
    @Autowired
    private AuthenticationInterceptor authenticationInterceptor;

    @Autowired
    private LocalDateTimeSerializer localDateTimeSerializer;

    @Autowired
    private LocalDateTimeDeserializer localDateTimeDeserializer;

    /**
     * 配置拦截器
     *
     * @param registry
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        // todo 开启拦截器
        // registry
        //         .addInterceptor(authenticationInterceptor)
        //         .addPathPatterns("/*");
        super.addInterceptors(registry);
    }

    /**
     * 配置 Jackson
     *
     * @param converters 消息转换器
     */
    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        ObjectMapper objectMapper = Jackson2ObjectMapperBuilder
                .json()
                // 属性为 null 时不进行序列化
                .serializationInclusion(JsonInclude.Include.NON_NULL)
                // 指定 LocalDateTime 序列化器
                .serializers(localDateTimeSerializer)
                // 指定 LocalDateTime 反序列化器
                .deserializers(localDateTimeDeserializer)
                .build();

        converters.add(new MappingJackson2HttpMessageConverter(objectMapper));
        super.configureMessageConverters(converters);
    }
}
