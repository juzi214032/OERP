package com.juzi.oerp.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.HashMap;
import java.util.Map;

/**
 * 消息码配置
 *
 * @author Juzi
 * @date 2020/7/16 15:45
 */
@ConfigurationProperties
@PropertySource(value = "classpath:code-message.properties", encoding = "UTF-8")
public class CodeMessageProperties {
    /**
     * 消息码
     */
    private Map<Integer, String> codeMessage = new HashMap<>(16);
}
