package leo.subscription_management_api.mapper;

import leo.subscription_management_api.dto.user.UserCreateDTO;
import leo.subscription_management_api.dto.user.UserDTO;
import leo.subscription_management_api.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO userEntityToDTO(User user);

    User userDtoToEntity(UserDTO userDTO);

    User userCreateDtoToEntity(UserCreateDTO userCreateDTO);

    @Mapping(target = "id", ignore = true)
    void updateUserFromDTO(UserDTO userDTO, @MappingTarget User user);
}
