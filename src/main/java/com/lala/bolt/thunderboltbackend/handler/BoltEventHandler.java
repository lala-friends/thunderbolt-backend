package com.lala.bolt.thunderboltbackend.handler;

import com.lala.bolt.thunderboltbackend.domain.BoltEvent;
import com.lala.bolt.thunderboltbackend.repository.BoltEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class BoltEventHandler {

    @Autowired
    private BoltEventRepository boltEventRepository;

    public Mono<ServerResponse> boltEvents(ServerRequest serverRequest) {
        Flux<BoltEvent> boltEventFlux = boltEventRepository.findAll();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON_UTF8).body(boltEventFlux, BoltEvent.class);
    }
}
