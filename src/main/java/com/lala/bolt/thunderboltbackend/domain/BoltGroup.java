package com.lala.bolt.thunderboltbackend.domain;


import lombok.*;
import org.springframework.data.annotation.Id;


@Getter
@Setter
@Builder
public class BoltGroup {

    @Id
    private long id;

    private String name;

    private String description;
}
