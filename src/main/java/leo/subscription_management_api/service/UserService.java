package leo.subscription_management_api.service;

import leo.subscription_management_api.dto.user.UserCreateDTO;
import leo.subscription_management_api.dto.user.UserDTO;
import leo.subscription_management_api.entity.User;
import leo.subscription_management_api.exception.EntityNotFound;
import leo.subscription_management_api.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public UserDTO create (UserCreateDTO dto){
        User user = userRepository.save(new User(dto));
        return new UserDTO(user);
    }

    public UserDTO findById(Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new EntityNotFound("User not found with ID: " + id));
        return new UserDTO(user);
    }

    public List<UserDTO> findAll(){
        return userRepository.findAll().stream().map(UserDTO::new).toList();
    }

    public UserDTO update(Long id, UserCreateDTO dto){
        User userExists = userRepository.findById(id).orElseThrow(() -> new EntityNotFound("User not found with ID: " + id));
        userExists.setName(dto.getName());
        userExists.setEmail(dto.getEmail());

        User savedUser = userRepository.save(userExists);

        return new UserDTO(savedUser);
    }

    public void delete(Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new EntityNotFound("User not found with ID: " + id));
        userRepository.delete(user);
    }
}
