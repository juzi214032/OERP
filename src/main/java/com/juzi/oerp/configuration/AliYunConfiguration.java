package com.juzi.oerp.configuration;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.profile.DefaultProfile;
import com.juzi.oerp.configuration.properties.AliYunProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Juzi
 * @date 2020/7/16 18:45
 */
@Configuration
public class AliYunConfiguration {

    @Autowired
    private AliYunProperties aliYunProperties;

    @Bean
    public IAcsClient iAcsClient() {
        DefaultProfile profile = DefaultProfile.getProfile(aliYunProperties.getRegionId(), aliYunProperties.getAccessKeyId(), aliYunProperties.getSecret());
        return new DefaultAcsClient(profile);
    }

}
