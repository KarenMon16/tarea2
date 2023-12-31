package org.example.repositories.data.mapper;

import org.example.dto.UserDTO;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<UserDTO> {
    @Override
    public UserDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new UserDTO(
                rs.getInt("id"),
                rs.getString("username"),
                rs.getString("password"),
                rs.getString("email"),
                rs.getString("createdAt")
        );
    }
}

