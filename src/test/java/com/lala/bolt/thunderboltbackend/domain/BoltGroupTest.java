package com.lala.bolt.thunderboltbackend.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BoltGroupTest {
    // 모든 도메인은
    // @Getter
    // @Setter
    // @Builder

    @Test
    public void domain_bolt_group_member() {
        // 그룹의 멤버는
        // id
        // name
        // description
        BoltGroup group = BoltGroup.builder()
        .id(1)
        .name("group1")
        .description("group1 description")
        .build();

        assertThat(group.getId()).isEqualTo(1L);
        assertThat(group.getName()).isEqualTo("group1");
        assertThat(group.getDescription()).isEqualTo("group1 description");
    }
}
