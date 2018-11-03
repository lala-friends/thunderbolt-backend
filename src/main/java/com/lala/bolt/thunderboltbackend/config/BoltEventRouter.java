package com.lala.bolt.thunderboltbackend.config;

import com.lala.bolt.thunderboltbackend.handler.BoltEventHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.*;

@Configuration
public class BoltEventRouter {

    @Bean
    public RouterFunction<ServerResponse> route(BoltEventHandler boltEventHandler) {
        return RouterFunctions.route(RequestPredicates.GET("/boltEvents").and(RequestPredicates.accept(MediaType.APPLICATION_JSON_UTF8)), boltEventHandler::boltEvents)
                .andRoute(RequestPredicates.POST("/boltEvent").and(RequestPredicates.accept(MediaType.APPLICATION_JSON_UTF8)), boltEventHandler::saveBoltEvent);
    }
}
