package com.sabapathy.tutorial.service.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data @NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(generator = "tutorialSeqGen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="tutorialSeqGen",sequenceName="role_seq", allocationSize=1)
    @Column(name = "role_id")
    private Long id;

    @Column(nullable = false)
    private String role;

    public Role(String role) {
        this.role = role;
    }
}
