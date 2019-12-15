package com.sabapathy.tutorial.service.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data @NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(generator = "tutorialSeqGen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="tutorialSeqGen",sequenceName="user_seq", allocationSize=1)
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    private String email;

    @Column(unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "User_Role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
}
