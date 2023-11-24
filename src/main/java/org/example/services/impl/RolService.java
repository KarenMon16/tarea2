package org.example.services.impl;

import org.example.dto.RolDTO;
import org.example.repositories.data.interfaces.IRolRepository;
import org.example.services.mapper.RolMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class RolService {
    private final IRolRepository rolRepository;
    private final RolMapper rolMapper;


    public RolService(IRolRepository rolRepository, RolMapper rolMapper ) {
        this.rolRepository = rolRepository;
        this.rolMapper=rolMapper;
    }

    public Optional<RolDTO> get(int id) {return rolRepository.get(id);}
    public void delete(int id) {rolRepository.delete(id);}

    public int create(RolDTO rolDTO) {
        return rolRepository.save(rolDTO);
    }

    public Optional<RolDTO> update(RolDTO dto) {
        rolRepository.update(dto);
        return get(dto.getId());
    }
}
