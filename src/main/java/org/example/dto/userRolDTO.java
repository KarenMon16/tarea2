package org.example.dto;

import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class userRolDTO {
    private Integer id;
    private boolean active;
    private Timestamp createdAt;
    private Long userId;
    private Integer rolID;

}
