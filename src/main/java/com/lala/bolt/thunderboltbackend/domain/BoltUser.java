package com.lala.bolt.thunderboltbackend.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.List;


@Getter
@Setter
@Builder
public class BoltUser {

    @Id
    private long id;

    private String email;

    private String name;

    private List<Long> groupId;
}
