package org.example.domain.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table
public class UserRol {
    @Id
    @SequenceGenerator(name = "userRol_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "userRol_sequence")
    private Integer id;
    private boolean active;
    private Timestamp createdAt;
    private Long userId;
    private Integer rolID;
}
