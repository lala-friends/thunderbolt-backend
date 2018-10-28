package com.lala.bolt.thunderboltbackend.repository;

import com.lala.bolt.thunderboltbackend.domain.BoltGroup;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;


@Repository
public interface BoltGroupRepository extends ReactiveMongoRepository<BoltGroup, String> {

    Flux<BoltGroup> findByName(final String name);
}
