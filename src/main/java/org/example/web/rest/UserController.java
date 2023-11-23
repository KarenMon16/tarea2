package org.example.web.rest;

import org.example.dto.UserDTO;
import org.example.services.impl.UserService;
import org.springframework.data.relational.core.sql.In;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

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
    public ResponseEntity<Void> createUser( final UserDTO dto) throws URISyntaxException {
        if (dto.getId() != null) {
            throw new IllegalArgumentException("I new country cannot already have an id.");
        }
        System.out.println("Adding?");
        userService.save(dto);

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
}
