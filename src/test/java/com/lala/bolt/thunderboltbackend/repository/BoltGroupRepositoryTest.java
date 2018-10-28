package com.lala.bolt.thunderboltbackend.repository;

import com.lala.bolt.thunderboltbackend.domain.BoltGroup;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BoltGroupRepositoryTest {

    @Autowired
    private BoltGroupRepository boltGroupReppository;

    @Test
    public void boltGroupRepositorySaveAndReadTest() {

        boltGroupReppository.save(new BoltGroup(null, "group1", "des1")).block();
        Flux<BoltGroup> boltGroupFlux = boltGroupReppository.findByName("group1");

        StepVerifier.create(boltGroupFlux)
                .assertNext(boltGroup -> {
                    System.out.println(boltGroup.toString());
                    assertEquals("des1", boltGroup.getDescription());
                        })
                .expectComplete()
                .verify();
    }
}
