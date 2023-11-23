package org.example.repositories.data.mapper;

import org.example.dto.UserDTO;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<UserDTO> {
    @Override
    public UserDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        System.out.println("-----------------------------------------");
        System.out.println(rs.getString("createdAt"));
        return new UserDTO(
                rs.getInt("id"),
                rs.getString("username"),
                rs.getString("password"),
                rs.getString("email"),
                rs.getString("createdAt")
        );
    }
}

