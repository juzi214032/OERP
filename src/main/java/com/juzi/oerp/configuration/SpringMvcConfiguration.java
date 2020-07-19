package com.juzi.oerp.configuration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.juzi.oerp.common.interceptor.AuthenticationInterceptor;
import com.juzi.oerp.common.jackson.LocalDateTimeDeserializer;
import com.juzi.oerp.common.jackson.LocalDateTimeKeySerializer;
import com.juzi.oerp.common.jackson.LocalDateTimeSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.time.LocalDateTime;
import java.util.List;

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

    @Autowired
    private LocalDateTimeSerializer localDateTimeSerializer;

    @Autowired
    private LocalDateTimeKeySerializer localDateTimeKeySerializer;

    @Autowired
    private LocalDateTimeDeserializer localDateTimeDeserializer;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry
                .addMapping("/**")
                .maxAge(3000)
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "PUT", "DELETE");
        super.addCorsMappings(registry);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    /**
     * 配置拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // todo 开启拦截器
        // registry
        //         .addInterceptor(authenticationInterceptor)
        //         .addPathPatterns("/*");
        // super.addInterceptors(registry);
    }

    /**
     * 配置 Jackson
     *
     * @param converters 消息转换器
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addKeySerializer(LocalDateTime.class, localDateTimeKeySerializer);
        ObjectMapper objectMapper = Jackson2ObjectMapperBuilder
                .json()
                // 属性为 null 时不进行序列化
                .serializationInclusion(JsonInclude.Include.NON_NULL)

                .modules(simpleModule)
                // 指定 LocalDateTime 序列化器
                .serializers(localDateTimeSerializer)
                // 指定 LocalDateTime 反序列化器
                .deserializers(localDateTimeDeserializer)
                .build();

        converters.add(new MappingJackson2HttpMessageConverter(objectMapper));
        super.configureMessageConverters(converters);
    }

}
