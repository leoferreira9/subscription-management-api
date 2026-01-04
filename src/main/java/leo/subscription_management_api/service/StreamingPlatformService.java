package leo.subscription_management_api.service;

import leo.subscription_management_api.dto.service.ServiceCreateDTO;
import leo.subscription_management_api.dto.service.ServiceDTO;
import leo.subscription_management_api.entity.StreamingService;
import leo.subscription_management_api.exception.EntityNotFound;
import leo.subscription_management_api.repository.ServiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StreamingPlatformService {

    private final ServiceRepository serviceRepository;

    public StreamingPlatformService(ServiceRepository serviceRepository){
        this.serviceRepository = serviceRepository;
    }

    public ServiceDTO create(ServiceCreateDTO dto){
        StreamingService service = serviceRepository.save(new StreamingService(dto.getName()));
        return new ServiceDTO(service);
    }

    public ServiceDTO findById(Long id){
        StreamingService service = serviceRepository.findById(id).orElseThrow(() -> new EntityNotFound("Streaming service not found with ID: " + id));
        return new ServiceDTO(service);
    }

    public List<ServiceDTO> findAll(){
        return serviceRepository.findAll().stream().map(ServiceDTO::new).toList();
    }

    public ServiceDTO update(Long id, ServiceCreateDTO dto){
        StreamingService serviceExists = serviceRepository.findById(id).orElseThrow(() -> new EntityNotFound("Streaming service not found with ID: " + id));
        serviceExists.setName(dto.getName());

        StreamingService savedService = serviceRepository.save(serviceExists);
        return new ServiceDTO(savedService);
    }

    public void delete(Long id){
        StreamingService service = serviceRepository.findById(id).orElseThrow(() -> new EntityNotFound("Streaming service not found with ID: " + id));
        serviceRepository.delete(service);
    }

}
