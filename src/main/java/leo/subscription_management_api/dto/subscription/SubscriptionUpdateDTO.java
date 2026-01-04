package leo.subscription_management_api.dto.subscription;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import leo.subscription_management_api.enums.PaymentType;
import leo.subscription_management_api.enums.SubscriptionStatus;
import leo.subscription_management_api.enums.SubscriptionType;

import java.math.BigDecimal;

public class SubscriptionUpdateDTO {

    @NotNull
    @DecimalMin(value = "0.0")
    private BigDecimal value;

    @NotNull
    private SubscriptionType subscriptionType;

    @NotNull
    private SubscriptionStatus subscriptionStatus;

    @NotNull
    private PaymentType paymentType;

    public SubscriptionUpdateDTO(){}

    public SubscriptionUpdateDTO(BigDecimal value, SubscriptionType subscriptionType, SubscriptionStatus subscriptionStatus, PaymentType paymentType) {
        this.value = value;
        this.subscriptionType = subscriptionType;
        this.subscriptionStatus = subscriptionStatus;
        this.paymentType = paymentType;
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
}
