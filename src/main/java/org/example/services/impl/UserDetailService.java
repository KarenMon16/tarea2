package org.example.services.impl;

import org.example.domain.entities.UserDetail;
import org.example.dto.UserDetailDTO;
import org.example.repositories.data.interfaces.IUserDetailRepository;
import org.example.repositories.data.interfaces.IUserRepository;
import org.example.repositories.data.jdbc.UserDetailRepository;
import org.example.services.interfaces.IUserDetailService;
import org.example.services.mapper.UserDetailMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailService implements IUserDetailService {
    private final UserDetailMapper userMapper;
    private final IUserDetailRepository userRepository;
    public UserDetailService(IUserDetailRepository userRepository, UserDetailMapper userMapper ) {
        this.userRepository = userRepository;
        this.userMapper=userMapper;
    }

    @Override
    public Optional<UserDetailDTO> get(int id) {
        return userRepository.get(id);
    }

    @Override
    public void delete(int id) {
        userRepository.delete(id);
    }

    @Override
    public int create(UserDetailDTO userDetailDTO) {
        return userRepository.save(userDetailDTO);
    }

    @Override
    public Optional<UserDetailDTO> updateDetail(UserDetailDTO dto) {
        userRepository.update(dto);
        return get(dto.getId());
    }
}
