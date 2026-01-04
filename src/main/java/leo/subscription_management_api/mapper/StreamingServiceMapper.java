package leo.subscription_management_api.mapper;

import leo.subscription_management_api.dto.streamingservice.StreamingServiceCreateDTO;
import leo.subscription_management_api.dto.streamingservice.StreamingServiceDTO;
import leo.subscription_management_api.dto.streamingservice.StreamingServiceUpdateDTO;
import leo.subscription_management_api.entity.StreamingService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface StreamingServiceMapper {

    StreamingServiceDTO streamingServiceEntityToDTO(StreamingService streamingService);

    StreamingService streamingServiceCreateDtoToEntity(StreamingServiceCreateDTO streamingServiceCreateDTO);

    @Mapping(target = "id", ignore = true)
    void updateStreamingServiceFromDto(StreamingServiceUpdateDTO streamingServiceUpdateDTO, @MappingTarget StreamingService streamingService);
}
