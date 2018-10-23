package com.lala.bolt.thunderboltbackend.config;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EncryptTest {

    @Autowired
    ThunderboltProperties thunderboltProperties;

    @Test
    public void encryptTest() {
        StandardPBEStringEncryptor jasypt = new StandardPBEStringEncryptor();
        jasypt.setPassword(thunderboltProperties.getThunderboltDataKey());      //암호화 키(password)
        jasypt.setAlgorithm("PBEWithMD5AndDES");

        String encryptedText = jasypt.encrypt("mongodb://lalafriends:ghkehwls1!@13.124.222.140:27417/thunderbolt");    //암호화
        String plainText = jasypt.decrypt(encryptedText);  //복호화

        System.out.println("encryptedText:  " + encryptedText); //암호화된 값
        System.out.println("plainText:  " + plainText);         //복호화된 값

    }
}
