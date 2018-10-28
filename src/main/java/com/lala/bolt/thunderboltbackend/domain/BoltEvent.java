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
public class BoltEvent {

    @Id
    private String id;
    private String title;
    private String description;
    private String startDate;
    private String endDate;
    private String creator;
    private String groupId;
    private List<String> joinedMember;
    private String confirm;
    private String createDate;
    private String createUser;
    private String updateDate;
    private String updateUser;
}
