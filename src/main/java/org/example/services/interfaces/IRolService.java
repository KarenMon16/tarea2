package org.example.services.interfaces;

import org.example.dto.RolDTO;
import org.example.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface IRolService {
    Optional<RolDTO> get(int id);
    void delete(int id);
    int create(RolDTO rolDTO);
    Optional<RolDTO> update(RolDTO dto);
}
