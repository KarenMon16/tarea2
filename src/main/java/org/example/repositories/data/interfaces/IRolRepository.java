package org.example.repositories.data.interfaces;

import org.example.dto.RolDTO;
import org.example.dto.UserDTO;

import java.util.Optional;

public interface IRolRepository {

    Optional<RolDTO> get(int id);
    int delete(int id);
    int create(RolDTO rolDTO);
    int save(RolDTO rolDTO);
    int update(RolDTO rolDTO);
}
