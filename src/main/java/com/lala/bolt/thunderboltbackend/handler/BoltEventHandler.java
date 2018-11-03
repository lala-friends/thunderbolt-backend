package com.lala.bolt.thunderboltbackend.handler;

import com.lala.bolt.thunderboltbackend.domain.BoltEvent;
import com.lala.bolt.thunderboltbackend.repository.BoltEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.UUID;

@Component
public class BoltEventHandler {

    @Autowired
    private BoltEventRepository boltEventRepository;

    public Mono<ServerResponse> boltEvents(ServerRequest serverRequest) {
        Flux<BoltEvent> boltEventFlux = boltEventRepository.findAll();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON_UTF8).body(boltEventFlux, BoltEvent.class);
    }

    public Mono<ServerResponse> saveBoltEvent(ServerRequest serverRequest) {
        Mono<BoltEvent> boltEventMono = serverRequest.bodyToMono(BoltEvent.class);
        final UUID id = UUID.randomUUID();
        return ServerResponse.created(UriComponentsBuilder.fromPath("/boltEvent").build().toUri())
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(BodyInserters.fromPublisher(
                        boltEventMono.map(
                                b -> new BoltEvent(
                                         id.toString()
                                        ,b.getTitle()
                                        ,b.getDescription()
                                        ,b.getStartDate()
                                        ,b.getEndDate()
                                        ,b.getCreator()
                                        ,b.getGroupId()
                                        ,b.getJoinedMember()
                                        ,b.getConfirm()
                                        ,""
                                        ,""
                                        ,""
                                        ,""
                                ))
                                .flatMap(boltEventRepository::save), BoltEvent.class));
    }
}
