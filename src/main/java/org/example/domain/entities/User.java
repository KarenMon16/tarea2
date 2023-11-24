package org.example.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
@Entity
@Table (name = "users")
public class User {
    @Id
    @SequenceGenerator(name = "users_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_sequence")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserDetail detail;

    private String username;
    private String password;
    private String email;
    private Timestamp createdAt;



}
