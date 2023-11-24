package org.example.repositories.data.mapper;

import org.example.dto.RolDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RolRowMapper implements RowMapper<RolDTO> {

    public RolDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new RolDTO(
                rs.getInt("id"),
                rs.getString("name")
        );
    }
}
