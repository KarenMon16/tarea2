package org.example.web.rest;

import org.example.domain.entities.UserDetail;
import org.example.dto.UserDTO;
import org.example.dto.UserDetailDTO;
import org.example.repositories.data.jdbc.UserDetailRepository;
import org.example.services.impl.UserDetailService;
import org.example.services.impl.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/userDetail")
public class UserDetailController {

    private final UserDetailService userService;

    public UserDetailController(UserDetailService userService) {
        this.userService = userService;
    }
    @GetMapping
    public ResponseEntity<UserDetailDTO> get(@RequestParam(required = true) final Integer id) {
        System.out.println(id);
        return ResponseEntity
                .ok()
                .body(userService.get(id).orElseThrow(() -> new IllegalArgumentException()));
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody final UserDetailDTO dto) throws URISyntaxException {
        System.out.println("Adding?");
        userService.create(dto);
        return ResponseEntity
                .created(null)
                .build();
    }

    @DeleteMapping
    ResponseEntity<UserDetailDTO> delete(@RequestParam(required = true) final Integer id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/{id}")
    public ResponseEntity<Optional<UserDetailDTO>> update(@RequestBody final UserDetailDTO dto, @PathVariable final Integer id) throws URISyntaxException {
        System.out.println(id+" vs "+dto.getId());
        if (!Objects.equals(dto.getId(), id)) {
            throw new IllegalArgumentException("Invalid id");
        }
        return ResponseEntity
                .ok()
                .body(this.userService.updateDetail(dto));
    }
}
