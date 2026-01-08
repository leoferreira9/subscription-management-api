package leo.subscription_management_api.repository;

import leo.subscription_management_api.entity.PaymentHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentHistoryRepository extends JpaRepository<PaymentHistory, Long> {
    List<PaymentHistory> findAllBySubscriptionId(Long subscriptionId);
}
