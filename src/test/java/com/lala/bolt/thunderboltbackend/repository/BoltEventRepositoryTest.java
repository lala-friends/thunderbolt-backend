package com.lala.bolt.thunderboltbackend.repository;

import com.lala.bolt.thunderboltbackend.domain.BoltEvent;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BoltEventRepositoryTest {

    @Autowired
    private BoltEventRepository boltEventRepository;

    @Before
    public void setup() {
        boltEventRepository.deleteAll().block();

        List<String> joinedMember = new ArrayList<>();
        joinedMember.add("whuk84@gmail.com");
        boltEventRepository.save(new BoltEvent(null, "모임1", "주말에봐용", "2018-12-31 17:00", "", "whuk84@gmail.com", "", joinedMember, "N", "2018-11-30 17:00", "whuk84@gmail.com", "2018-11-30 17:00", "whuk84@gmail.com")).block();
    }

    @Test
    public void boltEventRepositoryInsertAndRead() {
        Flux<BoltEvent> boltEventFlux = boltEventRepository.findByTitle("모임1");

        StepVerifier.create(boltEventFlux)
                .assertNext(boltEvent -> {
                    System.out.println(boltEvent.toString());
                    assertEquals("주말에봐용", boltEvent.getDescription());
                })
                .expectComplete()
                .verify();
    }
}
