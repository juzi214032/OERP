package com.juzi.oerp.config;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.profile.DefaultProfile;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Juzi
 * @date 2020/7/16 18:45
 */
@Configuration
public class AliYunConfiguration {

    @Bean
    public IAcsClient iAcsClient(){
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "<accessKeyId>", "<accessSecret>");
        return new DefaultAcsClient(profile);
    }

}
