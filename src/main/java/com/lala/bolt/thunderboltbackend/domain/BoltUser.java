package com.lala.bolt.thunderboltbackend.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BoltUser {

    @Id
    private String id;

    private String email;

    private String name;

    private List<Long> groupId;
}
