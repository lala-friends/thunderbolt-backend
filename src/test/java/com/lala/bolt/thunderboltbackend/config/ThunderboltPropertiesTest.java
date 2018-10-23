package com.lala.bolt.thunderboltbackend.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ThunderboltPropertiesTest {

    @Autowired
    ThunderboltProperties thunderboltProperties;

    @Test
    public void getThunderboltProperties() {
        System.out.println(thunderboltProperties.getThunderboltDataKey());
        assertThat(thunderboltProperties.getThunderboltDataKey()).isNotEmpty();
    }
}
