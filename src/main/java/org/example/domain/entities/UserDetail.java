package org.example.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "userDetail")
public class UserDetail {
    @Id
    @SequenceGenerator(name = "userDetail_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "userDetail_sequence")
    private int id;

/*
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid")
    private User user;*/

    private String firstName;
    private String lastName;
    private Integer age;
    private Date birthday;
    private int userId;
}
