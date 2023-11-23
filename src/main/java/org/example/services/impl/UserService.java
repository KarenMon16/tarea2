package org.example.services.impl;

import org.example.dto.UserDTO;
import org.example.repositories.data.interfaces.IUserRepository;
import org.example.services.interfaces.IUserService;
import org.example.services.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserService implements IUserService {
    private final IUserRepository userRepository;
    private final UserMapper userMapper;


    public UserService(IUserRepository userRepository, UserMapper userMapper ) {
        this.userRepository = userRepository;
        this.userMapper=userMapper;
    }
    @Override
    public Optional<UserDTO> getUser(int id) {return userRepository.getUser(id);}
    public List<UserDTO> listAllUsers(){return userRepository.getAllUsers();}
    public void deleteUser(int id) {userRepository.deleteUser(id);}
    @Override
    public int create(UserDTO userDTO) {
        return userRepository.save(userDTO);
    }
    @Override
    public Optional<UserDTO> updateUser(UserDTO dto) {
         userRepository.update(dto);
        return getUser(dto.getId());
    }
}
