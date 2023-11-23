package org.example.web.rest;

import org.example.dto.UserDTO;
import org.example.services.impl.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<UserDTO> getUser(@RequestParam(required = true) final Integer id) {
        System.out.println(id);
        return ResponseEntity
                .ok()
                .body(userService.getUser(id).orElseThrow(() -> new IllegalArgumentException()));
    }

    @GetMapping("/allUsers")
    public ResponseEntity<List<UserDTO>> listAllUsers() {
        System.out.println(111);
        return ResponseEntity.
                ok()
                .body(userService.listAllUsers());
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody  final UserDTO dto) throws URISyntaxException {
        if (dto.getId() != null) {
            throw new IllegalArgumentException("That users already exists");
        }
        System.out.println("Adding?");
        userService.create(dto);

        return ResponseEntity
                .created(null)
                .build();
    }


    @DeleteMapping
    ResponseEntity<UserDTO> deleteUser(@RequestParam(required = true) final Integer id){
        System.out.println("Deleting user "+id);
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/{id}")
    public ResponseEntity<Optional<UserDTO>> updateUser(@RequestBody final UserDTO dto,@PathVariable final Integer id) throws URISyntaxException {
        if (dto.getId() == null) {
            throw new IllegalArgumentException("Invalid course id, null value");
        }
        if (!Objects.equals(dto.getId(), id)) {
            throw new IllegalArgumentException("Invalid id");
        }
        return ResponseEntity
                .ok()
                .body(this.userService.updateUser(dto));
    }
}
