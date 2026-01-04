package leo.subscription_management_api.dto.subscription;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import leo.subscription_management_api.enums.PaymentType;
import leo.subscription_management_api.enums.SubscriptionStatus;
import leo.subscription_management_api.enums.SubscriptionType;
import java.math.BigDecimal;

public class SubscriptionCreateDTO {

    @NotNull
    private Long serviceId;

    @NotNull
    @DecimalMin(value = "0.0")
    private BigDecimal value;

    @NotNull
    private SubscriptionType subscriptionType;

    @NotNull
    private SubscriptionStatus subscriptionStatus;

    @NotNull
    private PaymentType paymentType;

    @NotNull
    private Long userId;

    public SubscriptionCreateDTO(){}

    public SubscriptionCreateDTO(Long serviceId, BigDecimal value, SubscriptionType subscriptionType, SubscriptionStatus subscriptionStatus, PaymentType paymentType, Long userId) {
        this.serviceId = serviceId;
        this.value = value;
        this.subscriptionType = subscriptionType;
        this.subscriptionStatus = subscriptionStatus;
        this.paymentType = paymentType;
        this.userId = userId;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public SubscriptionType getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(SubscriptionType subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    public SubscriptionStatus getSubscriptionStatus() {
        return subscriptionStatus;
    }

    public void setSubscriptionStatus(SubscriptionStatus subscriptionStatus) {
        this.subscriptionStatus = subscriptionStatus;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
