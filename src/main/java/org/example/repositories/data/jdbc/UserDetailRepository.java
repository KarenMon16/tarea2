package org.example.repositories.data.jdbc;

import org.example.dto.UserDetailDTO;
import org.example.repositories.data.interfaces.IUserDetailRepository;
import org.example.repositories.data.mapper.UserDetailRowMapper;
import org.example.repositories.data.mapper.UserRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public class UserDetailRepository implements IUserDetailRepository {
    private final JdbcTemplate jdbcTemplate;

    public UserDetailRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<UserDetailDTO> get(int id) {
        System.out.println("Trying to get "+id);
        var sql = """
                SELECT *
                FROM userdetail
                WHERE id=?
                """;
        return jdbcTemplate.query(sql, new UserDetailRowMapper(), id)
                .stream()
                .findFirst();
    }

    @Override
    public int delete(int id) {

        var sql = """
                DELETE
                FROM userdetail
                WHERE id=?
                """;
        return jdbcTemplate.update(sql,id);
    }

    @Override
    public int save(UserDetailDTO userDetailDTO) {
        var sql = """
                INSERT INTO userDetail (id, firstname,lastname,age,birthday,userId) 
                VALUES (nextval('userDetail_sequence'), ?, ?,?,?,?)
                """;
        return jdbcTemplate.update(sql, userDetailDTO.getFirstName(),userDetailDTO.getLastName(),userDetailDTO.getAge(),userDetailDTO.getBirthday(),userDetailDTO.getUserId());
    }

    @Override
    public int update(UserDetailDTO userDetailDTO) {
        var sql = """
                UPDATE userdetail
                SET firstname=?, lastname=?, age=?, birthday=?, userId=?
                WHERE id=?
                """;
        return jdbcTemplate.update(sql,userDetailDTO.getFirstName(),userDetailDTO.getLastName(),
                userDetailDTO.getAge(), userDetailDTO.getBirthday(),userDetailDTO.getUserId(),userDetailDTO.getId());
    }
}
