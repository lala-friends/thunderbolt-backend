package com.lala.bolt.thunderboltbackend.domain;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BoltGroup {

    @Id
    private String id;

    private String name;

    private String description;
}
