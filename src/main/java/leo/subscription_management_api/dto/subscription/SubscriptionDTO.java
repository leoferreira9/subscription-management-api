package leo.subscription_management_api.dto.subscription;

import leo.subscription_management_api.dto.service.ServiceDTO;
import leo.subscription_management_api.dto.user.UserDTO;
import leo.subscription_management_api.entity.Subscription;
import leo.subscription_management_api.enums.PaymentType;
import leo.subscription_management_api.enums.SubscriptionStatus;
import leo.subscription_management_api.enums.SubscriptionType;
import java.math.BigDecimal;
import java.time.LocalDate;

public class SubscriptionDTO {

    private Long id;
    private ServiceDTO serviceDTO;
    private BigDecimal value;
    private SubscriptionType subscriptionType;
    private SubscriptionStatus subscriptionStatus;
    private PaymentType paymentType;
    private UserDTO userDTO;
    private LocalDate startDate;
    private LocalDate nextBillingDate;

    public SubscriptionDTO(){}

    public SubscriptionDTO(Subscription subscription, ServiceDTO serviceDTO, UserDTO userDTO) {
        this.id = subscription.getId();
        this.serviceDTO = serviceDTO;
        this.value = subscription.getValue();
        this.subscriptionType = subscription.getSubscriptionType();
        this.subscriptionStatus = subscription.getSubscriptionStatus();
        this.paymentType = subscription.getPaymentType();
        this.userDTO = userDTO;
        this.startDate = subscription.getStartDate();
        this.nextBillingDate = subscription.getNextBillingDate();
    }

    public Long getId() {
        return id;
    }

    public ServiceDTO getServiceDTO() {
        return serviceDTO;
    }

    public BigDecimal getValue() {
        return value;
    }

    public SubscriptionType getSubscriptionType() {
        return subscriptionType;
    }

    public SubscriptionStatus getSubscriptionStatus() {
        return subscriptionStatus;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getNextBillingDate() {
        return nextBillingDate;
    }
}
