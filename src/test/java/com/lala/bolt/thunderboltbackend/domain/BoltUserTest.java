package com.lala.bolt.thunderboltbackend.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BoltUserTest {

    @Test
    public void domain_bolt_user_member () {
        List<Long> groupList = new ArrayList<>();
        groupList.add(1L);
        groupList.add(2L);

        BoltUser boltUser = BoltUser.builder()
                .id(1L)
                .email("test@naver.com")
                .name("test")
                .groupId(groupList)
                .build();

        assertThat(boltUser.getId()).isEqualTo(1L);
        assertThat(boltUser.getEmail()).isEqualTo("test@naver.com");
        assertThat(boltUser.getName()).isEqualTo("test");
        assertThat(boltUser.getGroupId()).isEqualTo(groupList);

    }
}
