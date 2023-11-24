package org.example.web.rest;

import org.example.dto.RolDTO;
import org.example.services.impl.RolService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/rol")
public class RolController {
    private final RolService rolService;

    public RolController(RolService rolService) {this.rolService = rolService;
    }
    @GetMapping
    public ResponseEntity<RolDTO> get(@RequestParam(required = true) final Integer id) {
        System.out.println(id);
        return ResponseEntity
                .ok()
                .body(rolService.get(id).orElseThrow(() -> new IllegalArgumentException()));
    }
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody final RolDTO dto) throws URISyntaxException {
        if (dto.getId() != null) {
            throw new IllegalArgumentException("That rol exists already");
        }
        System.out.println("Adding?");
        rolService.create(dto);

        return ResponseEntity
                .created(null)
                .build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<RolDTO>> update(@RequestBody final RolDTO dto, @PathVariable final Integer id) throws URISyntaxException {
        if (dto.getId() == null) {
            throw new IllegalArgumentException("Null value");
        }
        if (!Objects.equals(dto.getId(), id)) {
            throw new IllegalArgumentException("Invalid Id");
        }
        return ResponseEntity
                .ok()
                .body(this.rolService.update(dto));
    }

    @DeleteMapping
    ResponseEntity<RolDTO> delete(@RequestParam(required = true) final Integer id){
        rolService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
