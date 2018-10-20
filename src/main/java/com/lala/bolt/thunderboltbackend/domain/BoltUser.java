package com.lala.bolt.thunderboltbackend.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

//@Entity(name = "BoltUser")
@Getter
@Setter
@Builder
public class BoltUser {


    @Column(name = "id", nullable = false)
    @Id
    @GeneratedValue(generator = "bolt_user_seq_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "bolt_user_seq_gen", sequenceName = "bolt_user_id_seq")
    private long id;

    @Column(name = "email", length = 300, nullable = false)
    private String email;

    @Column(name = "name", length = 300, nullable = false)
    private String name;

    @Column(name = "groupId")
    private List<Long> groupId;
}
