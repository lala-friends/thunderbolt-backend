package com.lala.bolt.thunderboltbackend.repository;

import com.lala.bolt.thunderboltbackend.domain.BoltGroup;
import com.lala.bolt.thunderboltbackend.domain.BoltUser;
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
public class BoltUserRepositoryTest {

    @Autowired
    private BoltUserRepository boltUserRepository;

    @Autowired
    private BoltGroupRepository boltGroupRepository;

    @Before
    public void setup() {
        boltGroupRepository.deleteAll().block();    // 블록으로 해야함 TODO :: 찾아볼것
        boltUserRepository.deleteAll().block();     // 블록으로 해야함 TODO :: 찾아볼것

        boltGroupRepository.save(new BoltGroup(null, "group1", "des1")).subscribe();
        Flux<BoltGroup> boltGroupFlux = boltGroupRepository.findByName("group1");
        List<BoltGroup> boltGroupList = boltGroupFlux.collectList().block();
        List<String> groupList = new ArrayList<>();
        groupList.add(boltGroupList.get(0).getId());
        boltUserRepository.save(new BoltUser(null, "whuk84@gmail.com", "ryanWoo", groupList)).block();
    }

    @Test
    public void boltUserRepositorySaveAndReadTest() {
        Flux<BoltUser> boltUserFlux = boltUserRepository.findByName("ryanWoo");
        StepVerifier.create(boltUserFlux)
                .assertNext(boltUser -> {
                    System.out.println(boltUser.toString());
                    assertEquals("ryanWoo", boltUser.getName());
                })
                .expectComplete()
                .verify();
    }

    @Test
    public void boltUserRepositoryUpdateTest() {
        Mono<BoltUser> boltUserMono = boltUserRepository.findByEmail("whuk84@gmail.com");
        boltUserMono.flatMap(boltUser -> {
            boltUser.setName("Ryan Woo");
            return Mono.just(boltUser);
        }).flatMap(this.boltUserRepository::save).block();

        boltUserMono = boltUserRepository.findByEmail("whuk84@gmail.com");
        StepVerifier.create(boltUserMono)
                .assertNext(boltUser -> {
                    System.out.println(boltUser.toString());
                    assertEquals("Ryan Woo", boltUser.getName());
                })
                .expectComplete()
                .verify();
    }
}
