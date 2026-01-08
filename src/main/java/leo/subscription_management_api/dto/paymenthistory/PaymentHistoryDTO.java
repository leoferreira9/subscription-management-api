package leo.subscription_management_api.dto.paymenthistory;

import leo.subscription_management_api.enums.PaymentStatus;

import java.math.BigDecimal;

public class PaymentHistoryDTO {

    private Long id;
    private Long subscriptionId;
    private PaymentStatus paymentStatus;
    private BigDecimal value;

    public PaymentHistoryDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(Long subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
