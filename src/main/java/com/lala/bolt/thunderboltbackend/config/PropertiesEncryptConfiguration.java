package com.lala.bolt.thunderboltbackend.config;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentPBEConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropertiesEncryptConfiguration {

    @Autowired
    ThunderboltProperties thunderboltProperties;

    @Bean(name = "encryptorBean")
    public StandardPBEStringEncryptor standardPBEStringEncryptor() {
        StandardPBEStringEncryptor standardPBEStringEncryptor = new StandardPBEStringEncryptor();
        EnvironmentPBEConfig environmentPBEConfig = new EnvironmentPBEConfig();
        environmentPBEConfig.setPassword(thunderboltProperties.getThunderboltDataKey());
        environmentPBEConfig.setAlgorithm("PBEWithMD5AndDES");
        standardPBEStringEncryptor.setConfig(environmentPBEConfig);


        return standardPBEStringEncryptor;
    }
}
