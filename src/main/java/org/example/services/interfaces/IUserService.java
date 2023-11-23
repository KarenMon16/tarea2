package org.example.services.interfaces;

import org.example.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    Optional<UserDTO> getUser(int id);
    List<UserDTO> listAllUsers();
    void deleteUser(int id);
    int create(UserDTO userDTO);

}