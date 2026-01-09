package leo.subscription_management_api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import leo.subscription_management_api.dto.paymenthistory.PaymentHistoryDTO;
import leo.subscription_management_api.service.PaymentHistoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Payment History", description = "Manage payment history")
@RestController
@RequestMapping("/payments")
public class PaymentHistoryController {

    private final PaymentHistoryService paymentHistoryService;

    public PaymentHistoryController(PaymentHistoryService paymentHistoryService){
        this.paymentHistoryService = paymentHistoryService;
    }

    @Operation(summary = "List payment history by subscription", description = "Retrieve payment history for a specific subscription")
    @GetMapping("/subscriptions/{subscriptionId}")
    public ResponseEntity<List<PaymentHistoryDTO>> findAllById(@PathVariable Long subscriptionId){
        return ResponseEntity.ok().body(paymentHistoryService.findAllBySubscriptionId(subscriptionId));
    }
}
