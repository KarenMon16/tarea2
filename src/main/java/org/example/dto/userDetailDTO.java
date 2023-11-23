package org.example.dto;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class userDetailDTO {

    private long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private Date birthday;
    private Long userId;
}
