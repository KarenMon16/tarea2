package org.example.repositories.data.interfaces;

import org.example.dto.UserDTO;
import org.example.dto.UserDetailDTO;

import java.util.List;
import java.util.Optional;

public interface IUserDetailRepository {

    Optional<UserDetailDTO> get(int id);
    int delete(int id);
    int save(UserDetailDTO userDetailDTO);
    int update(UserDetailDTO userDetailDTO);
}
