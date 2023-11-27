package org.example.services.interfaces;

import org.example.dto.UserDetailDTO;

import java.util.Optional;

public interface IUserDetailService {
    Optional<UserDetailDTO> get(int id);
    void delete(int id);
    int create(UserDetailDTO userDetailDTO);
    Optional<UserDetailDTO> updateDetail(UserDetailDTO dto);
}
