package leo.subscription_management_api.controller;

import leo.subscription_management_api.dto.paymenthistory.PaymentHistoryDTO;
import leo.subscription_management_api.dto.streamingservice.PaymentHistoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentHistoryController {

    private final PaymentHistoryService paymentHistoryService;

    public PaymentHistoryController(PaymentHistoryService paymentHistoryService){
        this.paymentHistoryService = paymentHistoryService;
    }

    @GetMapping("/subscriptions/{subscriptionId}")
    public ResponseEntity<List<PaymentHistoryDTO>> findAllById(@PathVariable Long subscriptionId){
        return ResponseEntity.ok().body(paymentHistoryService.findAllBySubscriptionId(subscriptionId));
    }
}
