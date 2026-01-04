package leo.subscription_management_api.controller;

import jakarta.validation.Valid;
import leo.subscription_management_api.dto.streamingservice.StreamingServiceCreateDTO;
import leo.subscription_management_api.dto.streamingservice.StreamingServiceDTO;
import leo.subscription_management_api.dto.streamingservice.StreamingServiceUpdateDTO;
import leo.subscription_management_api.service.StreamingServiceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/streamings")
public class StreamingServiceController {

    private final StreamingServiceService streamingServiceService;

    public StreamingServiceController(StreamingServiceService streamingServiceService){
        this.streamingServiceService = streamingServiceService;
    }

    @PostMapping
    public ResponseEntity<StreamingServiceDTO> create(@RequestBody @Valid StreamingServiceCreateDTO dto){
        return ResponseEntity.status(201).body(streamingServiceService.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StreamingServiceDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(streamingServiceService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<StreamingServiceDTO>> findAll(){
        return ResponseEntity.ok().body(streamingServiceService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<StreamingServiceDTO> update(@PathVariable Long id, @RequestBody @Valid StreamingServiceUpdateDTO dto){
        return ResponseEntity.ok(streamingServiceService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        streamingServiceService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
