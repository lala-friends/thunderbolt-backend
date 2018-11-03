package com.lala.bolt.thunderboltbackend.handler;


import org.codehaus.jackson.map.ObjectMapper;
import com.lala.bolt.thunderboltbackend.domain.BoltEvent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BoltEventHandlerTest {

    @Autowired
    private WebTestClient webClient;

    @Test
    public void boltEventWebClientGetTest() {

        String result = webClient.get().uri("/boltEvents").exchange().expectStatus()
                .isOk()
                .expectBody(String.class)
                .returnResult()
                .getResponseBody().toString();

        System.out.println(result);
        assertThat(result).isNotEmpty();
    }

    @Test
    public void boltEventWebClientPostTest() throws IOException {

        List<String> joinedMember = new ArrayList<>();
        joinedMember.add("whuk84@gmail.com");
        BoltEvent boltEvent = BoltEvent.builder()
                .title("모임2")
                .description("평일에봅시다!")
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

        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(boltEvent);

        String result = webClient.post().uri("/boltEvent")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .body(Mono.just(jsonInString), String.class)
                .exchange()
                .toString();
        System.out.println(result);
    }
}
