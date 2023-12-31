package org.example.repositories.data.interfaces;

import org.example.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {
    Optional<UserDTO> getUser(int id);
     List<UserDTO> getAllUsers();
     int deleteUser(int id);
    int save(UserDTO userDTO);
    int update(UserDTO userDTO);

}
