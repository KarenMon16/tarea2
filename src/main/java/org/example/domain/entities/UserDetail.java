package org.example.domain.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table
public class UserDetail {
    @Id
    @SequenceGenerator(name = "userDetail_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "userDetail_sequence")
    private long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private Date birthday;
    private Long userId;
}
