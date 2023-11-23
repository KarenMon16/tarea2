package org.example.domain.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table (name = "users")
public class User {
    @Id
    @SequenceGenerator(name = "users_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_sequence")
    private Integer id;
    private String username;
    private String password;
    private String email;
    private Timestamp createdAt;



}
