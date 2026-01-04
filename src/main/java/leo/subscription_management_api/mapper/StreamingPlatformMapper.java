package leo.subscription_management_api.mapper;

import leo.subscription_management_api.dto.service.ServiceCreateDTO;
import leo.subscription_management_api.dto.service.ServiceDTO;
import leo.subscription_management_api.dto.service.ServiceUpdateDTO;
import leo.subscription_management_api.entity.StreamingService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface StreamingPlatformMapper {

    ServiceDTO StreamingPlatformEntityToDTO(StreamingService streamingService);

    StreamingService streamingPlatformCreateDtoToEntity(ServiceCreateDTO serviceCreateDTO);

    @Mapping(target = "id", ignore = true)
    void updateStreamingPlatformFromDto(ServiceUpdateDTO serviceUpdateDTO, @MappingTarget StreamingService streamingService);
}
