package com.lala.bolt.thunderboltbackend.repository;

import com.lala.bolt.thunderboltbackend.domain.BoltEvent;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface BoltEventRepository extends ReactiveMongoRepository<BoltEvent, String> {

    Flux<BoltEvent> findByTitle(String title);
}
