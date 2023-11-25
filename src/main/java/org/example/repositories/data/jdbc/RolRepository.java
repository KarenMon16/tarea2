package org.example.repositories.data.jdbc;

import org.example.dto.RolDTO;
import org.example.repositories.data.interfaces.IRolRepository;
import org.example.repositories.data.mapper.RolRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public class RolRepository implements IRolRepository {
    private final JdbcTemplate jdbcTemplate;

    public RolRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Optional<RolDTO> get(int id) {
        var sql = """
                SELECT *
                FROM rol
                WHERE id=?
                """;
        return jdbcTemplate.query(sql, new RolRowMapper(), id)
                .stream()
                .findFirst();
    }
    @Override
    public int save(RolDTO rolDTO) {
        System.out.println(rolDTO.getName());
        var sql = """
                INSERT INTO rol (id, name) VALUES (nextval('users_sequence'), ?)
                """;
        return jdbcTemplate.update(sql, rolDTO.getName());
    }
    @Override
    public int delete(int id){
        var sql = """
                DELETE
                FROM rol
                WHERE id=?
                """;
        return jdbcTemplate.update(sql,id);
    }
    @Override
    public int create(RolDTO rolDTO) {
        var sql = """
                INSERT INTO rol (id, name) VALUES (nextval('users_sequence'), ?)
                """;
        return jdbcTemplate.update(sql, rolDTO.getName());
    }
    @Override
    public int update(RolDTO rolDTO) {
        System.out.println(rolDTO.getName());
        var sql = """
                UPDATE rol 
                SET name=? 
                WHERE id=?
                """;
        return jdbcTemplate.update(sql,rolDTO.getName(),rolDTO.getId());
    }
}
