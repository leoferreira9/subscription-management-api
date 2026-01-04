package leo.subscription_management_api.service;

import leo.subscription_management_api.dto.streamingservice.StreamingServiceCreateDTO;
import leo.subscription_management_api.dto.streamingservice.StreamingServiceDTO;
import leo.subscription_management_api.dto.streamingservice.StreamingServiceUpdateDTO;
import leo.subscription_management_api.entity.StreamingService;
import leo.subscription_management_api.exception.EntityNotFound;
import leo.subscription_management_api.mapper.StreamingServiceMapper;
import leo.subscription_management_api.repository.StreamingServiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StreamingServiceService {

    private final StreamingServiceRepository streamingServiceRepository;
    private final StreamingServiceMapper mapper;

    public StreamingServiceService(StreamingServiceRepository streamingServiceRepository, StreamingServiceMapper mapper){
        this.streamingServiceRepository = streamingServiceRepository;
        this.mapper = mapper;
    }

    public StreamingServiceDTO create(StreamingServiceCreateDTO dto){
        StreamingService service = streamingServiceRepository.save(mapper.streamingServiceCreateDtoToEntity(dto));
        return mapper.streamingServiceEntityToDTO(service);
    }

    public StreamingServiceDTO findById(Long id){
        StreamingService service = streamingServiceRepository.findById(id).orElseThrow(() -> new EntityNotFound("Streaming service not found with ID: " + id));
        return mapper.streamingServiceEntityToDTO(service);
    }

    public List<StreamingServiceDTO> findAll(){
        return streamingServiceRepository.findAll().stream().map(mapper::streamingServiceEntityToDTO).toList();
    }

    public StreamingServiceDTO update(Long id, StreamingServiceUpdateDTO dto){
        StreamingService serviceExists = streamingServiceRepository.findById(id).orElseThrow(() -> new EntityNotFound("Streaming service not found with ID: " + id));
        serviceExists.setName(dto.getName());

        streamingServiceRepository.save(serviceExists);

        return mapper.streamingServiceEntityToDTO(serviceExists);
    }

    public void delete(Long id){
        StreamingService service = streamingServiceRepository.findById(id).orElseThrow(() -> new EntityNotFound("Streaming service not found with ID: " + id));
        streamingServiceRepository.delete(service);
    }

}
