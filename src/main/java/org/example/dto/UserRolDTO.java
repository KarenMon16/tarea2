package org.example.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRolDTO {
    private Integer id;
    private boolean active;
    private Timestamp createdAt;
    private Long userId;
    private Integer rolID;

}
