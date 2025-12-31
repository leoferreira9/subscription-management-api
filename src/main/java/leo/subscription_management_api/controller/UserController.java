package leo.subscription_management_api.controller;

import jakarta.validation.Valid;
import leo.subscription_management_api.dto.user.UserCreateDTO;
import leo.subscription_management_api.dto.user.UserDTO;
import leo.subscription_management_api.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody @Valid UserCreateDTO dto){
        return ResponseEntity.status(201).body(userService.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(userService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        return ResponseEntity.ok().body(userService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable Long id, @RequestBody @Valid UserCreateDTO dto){
        return ResponseEntity.ok().body(userService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
