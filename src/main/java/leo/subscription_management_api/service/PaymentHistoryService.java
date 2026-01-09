package leo.subscription_management_api.service;

import leo.subscription_management_api.dto.paymenthistory.PaymentHistoryDTO;
import leo.subscription_management_api.mapper.PaymentHistoryMapper;
import leo.subscription_management_api.repository.PaymentHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentHistoryService {

    private final PaymentHistoryRepository paymentHistoryRepository;
    private final PaymentHistoryMapper paymentHistoryMapper;

    public PaymentHistoryService(PaymentHistoryRepository paymentHistoryRepository, PaymentHistoryMapper paymentHistoryMapper){
        this.paymentHistoryRepository = paymentHistoryRepository;
        this.paymentHistoryMapper = paymentHistoryMapper;
    }

    public List<PaymentHistoryDTO> findAllBySubscriptionId(Long subscriptionId){
        return paymentHistoryRepository.findAllBySubscriptionId(subscriptionId).stream().map(paymentHistoryMapper::paymentHistoryEntityToDto).toList();
    }
}
