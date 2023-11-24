package org.example.repositories.data.mapper;

import org.example.dto.UserDTO;
import org.example.dto.UserRolDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRolRowMapper implements RowMapper<UserRolDTO> {
    public UserRolDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new UserRolDTO(
                rs.getInt("id"),
                rs.getBoolean("active"),
                rs.getTimestamp("createdAt"),
                rs.getLong("userId"),
                rs.getInt("rolID")
        );
    }
}
