package leo.subscription_management_api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import leo.subscription_management_api.dto.streamingservice.StreamingServiceCreateDTO;
import leo.subscription_management_api.dto.streamingservice.StreamingServiceDTO;
import leo.subscription_management_api.dto.streamingservice.StreamingServiceUpdateDTO;
import leo.subscription_management_api.service.StreamingServiceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Streaming services", description = "Manage streaming services")
@RestController
@RequestMapping("/streamings")
public class StreamingServiceController {

    private final StreamingServiceService streamingServiceService;

    public StreamingServiceController(StreamingServiceService streamingServiceService){
        this.streamingServiceService = streamingServiceService;
    }

    @Operation(summary = "Create new streaming service", description = "Add a new streaming service")
    @PostMapping
    public ResponseEntity<StreamingServiceDTO> create(@RequestBody @Valid StreamingServiceCreateDTO dto){
        return ResponseEntity.status(201).body(streamingServiceService.create(dto));
    }

    @Operation(summary = "Find streaming service by ID", description = "Find a streaming service by its ID")
    @GetMapping("/{id}")
    public ResponseEntity<StreamingServiceDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(streamingServiceService.findById(id));
    }

    @Operation(summary = "List all streaming services", description = "Retrieve all registered streaming services")
    @GetMapping
    public ResponseEntity<List<StreamingServiceDTO>> findAll(){
        return ResponseEntity.ok().body(streamingServiceService.findAll());
    }

    @Operation(summary = "Update streaming service", description = "Update a streaming service by its ID")
    @PutMapping("/{id}")
    public ResponseEntity<StreamingServiceDTO> update(@PathVariable Long id, @RequestBody @Valid StreamingServiceUpdateDTO dto){
        return ResponseEntity.ok(streamingServiceService.update(id, dto));
    }

    @Operation(summary = "Delete streaming service by ID", description = "Delete a streaming service by its ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        streamingServiceService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
