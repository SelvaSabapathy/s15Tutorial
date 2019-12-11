package com.sabapathy.tutorial.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Role {
    @Id
    @GeneratedValue(generator = "tutorialSeqGen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="tutorialSeqGen",sequenceName="role_seq", allocationSize=1)
    @Column(name = "role_id")
    private Long id;

    @Column(nullable = false)
    private String role;
}
