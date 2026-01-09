package leo.subscription_management_api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import leo.subscription_management_api.dto.subscription.SubscriptionCreateDTO;
import leo.subscription_management_api.dto.subscription.SubscriptionDTO;
import leo.subscription_management_api.dto.subscription.SubscriptionUpdateDTO;
import leo.subscription_management_api.service.SubscriptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Subscriptions", description = "Manage subscriptions")
@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService){
        this.subscriptionService = subscriptionService;
    }

    @Operation(summary = "Create new subscription", description = "Add a new subscription")
    @PostMapping
    public ResponseEntity<SubscriptionDTO> create(@RequestBody @Valid SubscriptionCreateDTO dto){
        return ResponseEntity.status(201).body(subscriptionService.create(dto));
    }

    @Operation(summary = "Find subscription by ID", description = "Find a subscription by its ID")
    @GetMapping("/{id}")
    public ResponseEntity<SubscriptionDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(subscriptionService.findById(id));
    }

    @Operation(summary = "List all subscriptions", description = "Find all registered subscriptions")
    @GetMapping
    public ResponseEntity<List<SubscriptionDTO>> findAll(){
        return ResponseEntity.ok(subscriptionService.findAll());
    }

    @Operation(summary = "Update subscription", description = "Update a subscription by its ID")
    @PutMapping("/{id}")
    public ResponseEntity<SubscriptionDTO> update(@PathVariable Long id, @RequestBody @Valid SubscriptionUpdateDTO dto){
        return ResponseEntity.ok(subscriptionService.update(id, dto));
    }

    @Operation(summary = "Delete subscription", description = "Delete a subscription by its ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        subscriptionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
