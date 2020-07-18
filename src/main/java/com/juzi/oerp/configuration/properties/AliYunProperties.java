package com.juzi.oerp.configuration.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Juzi
 * @date 2020/7/16 20:58
 */
@Data
@ConfigurationProperties("oerp.aliyun.sms")
public class AliYunProperties {

    /**
     * 地区 ID
     */
    private String regionId = "cn-hangzhou";

    /**
     * accessKey
     */
    private String accessKeyId;

    /**
     * secret
     */
    private String secret;

}
