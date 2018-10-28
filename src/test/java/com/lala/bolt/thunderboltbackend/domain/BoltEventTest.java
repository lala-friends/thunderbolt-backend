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
public class BoltEventTest {

    @Test
    public void domain_bolt_event_member() {

        List<String> joinedMember = new ArrayList<>();
        joinedMember.add("whuk84@gmail.com");

        BoltEvent boltEvent = BoltEvent.builder()
                .title("모임1")
                .description("주말에봐용")
                .startDate("2018-12-31 17:00")
                .endDate("")
                .creator("whuk84@gmail.com")
                .groupId("")
                .joinedMember(joinedMember)
                .confirm("N")
                .createDate("2018-11-30 17:00")
                .createUser("whuk84@gmail.com")
                .updateDate("2018-11-30 17:00")
                .updateUser("whuk84@gmail.com")
                .build();

        assertThat(boltEvent.getTitle()).isEqualTo("모임1");
    }
}
