package leo.subscription_management_api.service;

import leo.subscription_management_api.dto.user.UserCreateDTO;
import leo.subscription_management_api.dto.user.UserDTO;
import leo.subscription_management_api.entity.User;
import leo.subscription_management_api.exception.EntityNotFound;
import leo.subscription_management_api.mapper.UserMapper;
import leo.subscription_management_api.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDTO create (UserCreateDTO dto){
        User user = userRepository.save(userMapper.userCreateDtoToEntity(dto));
        return userMapper.userEntityToDTO(user);
    }

    public UserDTO findById(Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new EntityNotFound("User not found with ID: " + id));
        return userMapper.userEntityToDTO(user);
    }

    public List<UserDTO> findAll(){
        return userRepository.findAll().stream().map(userMapper::userEntityToDTO).toList();
    }

    public UserDTO update(Long id, UserCreateDTO dto){
        User userExists = userRepository.findById(id).orElseThrow(() -> new EntityNotFound("User not found with ID: " + id));
        userExists.setName(dto.getName());
        userExists.setEmail(dto.getEmail());

        userRepository.save(userExists);

        return userMapper.userEntityToDTO(userExists);
    }

    public void delete(Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new EntityNotFound("User not found with ID: " + id));
        userRepository.delete(user);
    }
}
