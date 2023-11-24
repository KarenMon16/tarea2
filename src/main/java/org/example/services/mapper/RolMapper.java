package org.example.services.mapper;

import org.example.domain.entities.Rol;
import org.example.dto.RolDTO;
import org.springframework.stereotype.Component;

@Component
public class RolMapper implements CustomMapper<RolDTO, Rol>{

    public RolDTO toDto(Rol rol) {
        RolDTO rolDTO = new RolDTO();
        rolDTO.setId(rol.getId());
        rolDTO.setName(rol.getName());
        return rolDTO;
    }

    public Rol toEntity(RolDTO rolDTO) {
        Rol rol = new Rol();
        rol.setId(rolDTO.getId());
        rol.setName(rolDTO.getName());
        return rol;
    }
}
