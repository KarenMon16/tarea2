package org.example.repositories.data.jdbc;
import org.example.dto.UserDTO;
import org.example.repositories.data.mapper.UserMapper;
import org.example.repositories.data.interfaces.IUserRepository;
import org.example.services.impl.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository implements IUserRepository {
    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public Optional<UserDTO> getUser(int id) {
        var sql = """
                SELECT *
                FROM users
                WHERE id=?
                """;
        return jdbcTemplate.query(sql, new UserMapper(), id)
                .stream()
                .findFirst();
    }
    @Override
    public List<UserDTO> getAllUsers(){
        System.out.println("Llego allusers");
        var sql = """
                SELECT *
                FROM users
                """;
        System.out.println(sql);
        return jdbcTemplate.query(sql, new UserMapper());
    }

    public int deleteUser(int id){
        var sql = """
                DELETE
                FROM users
                WHERE id=?
                """;
        return jdbcTemplate.update(sql,id);
    }

    public int save(UserDTO userDTO) {
        System.out.println(userDTO.getUsername());
        var sql = """
                INSERT INTO users (id, username, password, email) VALUES (nextval('users_sequence'), ?, ?,?)
                """;
        return jdbcTemplate.update(sql, userDTO.getUsername(),userDTO.getPassword(),userDTO.getEmail());
    }
}