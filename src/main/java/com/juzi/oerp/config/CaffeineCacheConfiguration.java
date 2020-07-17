package com.juzi.oerp.config;

import com.juzi.oerp.util.CacheUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 缓存配置
 *
 * @author Juzi
 * @date 2020/7/17 16:14
 */
@Configuration
public class CaffeineCacheConfiguration {

    @Autowired
    private CacheManager cacheManager;

    @Bean
    public Cache imageCaptchaCache() {
        return CacheUtils.getCache(cacheManager, "IMAGE_CAPTCHA_CACHE");
    }

    @Bean
    public Cache smsCaptchaCache() {
        return CacheUtils.getCache(cacheManager, "SMS_CAPTCHA_CACHE");
    }

}
