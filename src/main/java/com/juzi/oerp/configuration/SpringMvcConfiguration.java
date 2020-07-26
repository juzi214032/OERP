package com.juzi.oerp.configuration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.juzi.oerp.common.interceptor.AuthenticationInterceptor;
import com.juzi.oerp.common.jackson.LocalDateTimeDeserializer;
import com.juzi.oerp.common.jackson.LocalDateTimeKeySerializer;
import com.juzi.oerp.common.jackson.LocalDateTimeSerializer;
import com.juzi.oerp.util.UploadFileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Juzi
 * @date 2020/7/14 14:56
 */
@EnableWebMvc
@Configuration
public class SpringMvcConfiguration implements WebMvcConfigurer {

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

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("*");
        config.setAllowCredentials(true);
        config.addAllowedMethod("*");
        config.addAllowedHeader("*");
        UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
        configSource.registerCorsConfiguration("/**", config);
        return new CorsFilter(configSource);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("doc.html", "/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/", "classpath:/META-INF/resources/webjars/");

        // classpath: or file:
        registry.addResourceHandler("/assets/**/")
                .addResourceLocations("file:" + UploadFileUtils.getAbsoluteWorkDirectory());
    }

    /**
     * 配置拦截器
     *
     * @param registry 拦截器注册表
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry
                .addInterceptor(authenticationInterceptor)
                .excludePathPatterns(
                        "/",
                        "/error",
                        "/user/exam",
                        "/assets/**",
                        "/webjars/**",
                        "/user/exam/*",
                        "/doc.html/**",
                        "/auth/login/**",
                        "/auth/registion",
                        "/auth/captcha/**",
                        "/auth/password/sms",
                        "/swagger-resources/**"
                );

    }

    /**
     * 配置 Jackson
     *
     * @param converters 消息转换器
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        SimpleModule customModule = new SimpleModule();
        // Map 的 key 为 LocalDateTime 时，使用此序列化器
        customModule.addKeySerializer(LocalDateTime.class, localDateTimeKeySerializer);
        ObjectMapper objectMapper = Jackson2ObjectMapperBuilder
                .json()
                // 属性为 null 时不进行序列化
                .serializationInclusion(JsonInclude.Include.NON_NULL)
                // 添加自定义模块
                .modules(customModule)
                // 指定 LocalDateTime 序列化器
                .serializers(localDateTimeSerializer)
                // 指定 LocalDateTime 反序列化器
                .deserializers(localDateTimeDeserializer)
                .build();

        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter(StandardCharsets.UTF_8);

        converters.add(new MappingJackson2HttpMessageConverter(objectMapper));
        converters.add(stringHttpMessageConverter);
    }

}