package leo.subscription_management_api.service;

import leo.subscription_management_api.dto.service.ServiceCreateDTO;
import leo.subscription_management_api.dto.service.ServiceDTO;
import leo.subscription_management_api.entity.StreamingService;
import leo.subscription_management_api.exception.EntityNotFound;
import leo.subscription_management_api.mapper.StreamingPlatformMapper;
import leo.subscription_management_api.repository.ServiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StreamingPlatformService {

    private final ServiceRepository serviceRepository;
    private final StreamingPlatformMapper mapper;

    public StreamingPlatformService(ServiceRepository serviceRepository, StreamingPlatformMapper mapper){
        this.serviceRepository = serviceRepository;
        this.mapper = mapper;
    }

    public ServiceDTO create(ServiceCreateDTO dto){
        StreamingService service = serviceRepository.save(mapper.streamingPlatformCreateDtoToEntity(dto));
        return mapper.StreamingPlatformEntityToDTO(service);
    }

    public ServiceDTO findById(Long id){
        StreamingService service = serviceRepository.findById(id).orElseThrow(() -> new EntityNotFound("Streaming service not found with ID: " + id));
        return mapper.StreamingPlatformEntityToDTO(service);
    }

    public List<ServiceDTO> findAll(){
        return serviceRepository.findAll().stream().map(mapper::StreamingPlatformEntityToDTO).toList();
    }

    public ServiceDTO update(Long id, ServiceCreateDTO dto){
        StreamingService serviceExists = serviceRepository.findById(id).orElseThrow(() -> new EntityNotFound("Streaming service not found with ID: " + id));
        serviceExists.setName(dto.getName());

        serviceRepository.save(serviceExists);

        return mapper.StreamingPlatformEntityToDTO(serviceExists);
    }

    public void delete(Long id){
        StreamingService service = serviceRepository.findById(id).orElseThrow(() -> new EntityNotFound("Streaming service not found with ID: " + id));
        serviceRepository.delete(service);
    }

}
