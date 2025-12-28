package leo.subscription_management_api.dto.subscription;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import leo.subscription_management_api.enums.PaymentType;
import leo.subscription_management_api.enums.SubscriptionStatus;
import leo.subscription_management_api.enums.SubscriptionType;
import java.math.BigDecimal;
import java.time.LocalDate;

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

    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalDate nextBillingDate;

    public SubscriptionCreateDTO(){}

    public SubscriptionCreateDTO(Long serviceId, BigDecimal value, SubscriptionType subscriptionType, SubscriptionStatus subscriptionStatus, PaymentType paymentType, Long userId, LocalDate startDate, LocalDate nextBillingDate) {
        this.serviceId = serviceId;
        this.value = value;
        this.subscriptionType = subscriptionType;
        this.subscriptionStatus = subscriptionStatus;
        this.paymentType = paymentType;
        this.userId = userId;
        this.startDate = startDate;
        this.nextBillingDate = nextBillingDate;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public void setSubscriptionType(SubscriptionType subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    public void setSubscriptionStatus(SubscriptionStatus subscriptionStatus) {
        this.subscriptionStatus = subscriptionStatus;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setNextBillingDate(LocalDate nextBillingDate) {
        this.nextBillingDate = nextBillingDate;
    }
}
