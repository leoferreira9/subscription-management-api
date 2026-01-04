package leo.subscription_management_api.controller;

import jakarta.validation.Valid;
import leo.subscription_management_api.dto.service.ServiceCreateDTO;
import leo.subscription_management_api.dto.service.ServiceDTO;
import leo.subscription_management_api.dto.service.ServiceUpdateDTO;
import leo.subscription_management_api.service.StreamingPlatformService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/streamings")
public class StreamingPlatformController {

    private final StreamingPlatformService streamingPlatformService;

    public StreamingPlatformController(StreamingPlatformService streamingPlatformService){
        this.streamingPlatformService = streamingPlatformService;
    }

    @PostMapping
    public ResponseEntity<ServiceDTO> create(@RequestBody @Valid ServiceCreateDTO dto){
        return ResponseEntity.status(201).body(streamingPlatformService.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(streamingPlatformService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<ServiceDTO>> findAll(){
        return ResponseEntity.ok().body(streamingPlatformService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceDTO> update(@PathVariable Long id, @RequestBody @Valid ServiceUpdateDTO dto){
        return ResponseEntity.ok(streamingPlatformService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        streamingPlatformService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
