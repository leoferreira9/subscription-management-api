package leo.subscription_management_api.dto.subscription;

import leo.subscription_management_api.dto.service.ServiceDTO;
import leo.subscription_management_api.dto.user.UserDTO;
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

    public SubscriptionDTO(Long id, ServiceDTO serviceDTO, BigDecimal value, SubscriptionType subscriptionType, SubscriptionStatus subscriptionStatus, PaymentType paymentType, UserDTO userDTO, LocalDate startDate, LocalDate nextBillingDate) {
        this.id = id;
        this.serviceDTO = serviceDTO;
        this.value = value;
        this.subscriptionType = subscriptionType;
        this.subscriptionStatus = subscriptionStatus;
        this.paymentType = paymentType;
        this.userDTO = userDTO;
        this.startDate = startDate;
        this.nextBillingDate = nextBillingDate;
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
