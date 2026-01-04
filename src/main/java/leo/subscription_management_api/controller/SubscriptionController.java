package leo.subscription_management_api.controller;

import jakarta.validation.Valid;
import leo.subscription_management_api.dto.subscription.SubscriptionCreateDTO;
import leo.subscription_management_api.dto.subscription.SubscriptionDTO;
import leo.subscription_management_api.dto.subscription.SubscriptionUpdateDTO;
import leo.subscription_management_api.service.SubscriptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService){
        this.subscriptionService = subscriptionService;
    }

    @PostMapping
    public ResponseEntity<SubscriptionDTO> create(@RequestBody @Valid SubscriptionCreateDTO dto){
        return ResponseEntity.status(201).body(subscriptionService.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubscriptionDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(subscriptionService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<SubscriptionDTO>> findAll(){
        return ResponseEntity.ok(subscriptionService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubscriptionDTO> update(@PathVariable Long id, @RequestBody @Valid SubscriptionUpdateDTO dto){
        return ResponseEntity.ok(subscriptionService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        subscriptionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
