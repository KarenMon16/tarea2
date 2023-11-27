package org.example.repositories.data.mapper;

import org.example.dto.UserDTO;
import org.example.dto.UserDetailDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class UserDetailRowMapper implements RowMapper<UserDetailDTO> {

    public UserDetailDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new UserDetailDTO(
                rs.getInt("id"),
                rs.getString("firstName"),
                rs.getString("lastName"),
                rs.getInt("age"),
                rs.getDate("birthday"),
                rs.getInt("userId")

        );
    }
}
