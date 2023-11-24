package org.example.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailDTO {

    private long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private Date birthday;
    private Long userId;
}
