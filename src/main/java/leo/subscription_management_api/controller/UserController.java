package leo.subscription_management_api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import leo.subscription_management_api.dto.user.UserCreateDTO;
import leo.subscription_management_api.dto.user.UserDTO;
import leo.subscription_management_api.dto.user.UserUpdateDTO;
import leo.subscription_management_api.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Users", description = "Manage users")
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @Operation(summary = "Create new user", description = "Add a new user")
    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody @Valid UserCreateDTO dto){
        return ResponseEntity.status(201).body(userService.create(dto));
    }

    @Operation(summary = "Find user by ID", description = "Find a user by its ID")
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(userService.findById(id));
    }

    @Operation(summary = "List all users", description = "Retrieve all registered users")
    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        return ResponseEntity.ok().body(userService.findAll());
    }

    @Operation(summary = "Update user", description = "Update a user by its ID")
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable Long id, @RequestBody @Valid UserUpdateDTO dto){
        return ResponseEntity.ok().body(userService.update(id, dto));
    }

    @Operation(summary = "Delete user", description = "Delete a user by its ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
