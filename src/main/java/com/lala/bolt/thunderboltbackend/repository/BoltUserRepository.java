package com.lala.bolt.thunderboltbackend.repository;

import com.lala.bolt.thunderboltbackend.domain.BoltUser;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface BoltUserRepository extends ReactiveMongoRepository<BoltUser, String> {
    Flux<BoltUser> findByName(String name);
    Mono<BoltUser> findByEmail(String email);
}
