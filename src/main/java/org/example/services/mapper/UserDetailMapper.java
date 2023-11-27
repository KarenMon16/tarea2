package org.example.services.mapper;

import org.example.domain.entities.UserDetail;
import org.example.dto.UserDetailDTO;
import org.springframework.stereotype.Component;

@Component
public class UserDetailMapper implements CustomMapper<UserDetailDTO, UserDetail>{

    @Override
    public UserDetailDTO toDto(UserDetail userDetail) {
        UserDetailDTO userDetailDTO = new UserDetailDTO();
        userDetailDTO.setId(userDetail.getId());
        userDetailDTO.setFirstName(userDetail.getFirstName());
        userDetailDTO.setLastName(userDetail.getLastName());
        userDetailDTO.setAge(userDetail.getAge());
        userDetailDTO.setBirthday(userDetail.getBirthday());
        return userDetailDTO;
    }

    @Override
    public UserDetail toEntity(UserDetailDTO userDetailDTO) {
        UserDetail user = new UserDetail();
        user.setId(userDetailDTO.getId());
        user.setFirstName(userDetailDTO.getFirstName());
        user.setLastName(userDetailDTO.getLastName());
        user.setAge(userDetailDTO.getAge());
        user.setBirthday(userDetailDTO.getBirthday());
        return user;
    }
}
