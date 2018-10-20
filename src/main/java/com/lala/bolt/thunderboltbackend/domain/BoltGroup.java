package com.lala.bolt.thunderboltbackend.domain;


import lombok.*;

import javax.persistence.*;

@Entity(name = "BoltGroup")
@Getter
@Setter
@Builder
public class BoltGroup {

    @Column(name = "id", nullable = false)
    @Id
    @GeneratedValue(generator = "bolt_group_seq_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "bolt_group_seq_gen", sequenceName = "bolt_group_id_seq")
    private long id;

    @Column(name = "name", length = 300, nullable = false)
    private String name;

    @Column(name = "description", length = 3000, nullable = false)
    private String description;
}
