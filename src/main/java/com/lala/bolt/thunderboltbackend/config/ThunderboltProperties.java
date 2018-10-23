package com.lala.bolt.thunderboltbackend.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource( value = "file:${user.home}/thunderbolt/conf/thunderbolt.properties", ignoreResourceNotFound = true)
public class ThunderboltProperties {

    @Value("${thunderbolt.data.key}")
    private String thunderboltDataKey;

    public String getThunderboltDataKey() {
        return thunderboltDataKey;
    }
}
