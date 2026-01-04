package leo.subscription_management_api.dto.subscription;

import leo.subscription_management_api.dto.streamingservice.StreamingServiceDTO;
import leo.subscription_management_api.dto.user.UserDTO;
import leo.subscription_management_api.enums.PaymentType;
import leo.subscription_management_api.enums.SubscriptionStatus;
import leo.subscription_management_api.enums.SubscriptionType;
import java.math.BigDecimal;
import java.time.LocalDate;

public class SubscriptionDTO {

    private Long id;
    private StreamingServiceDTO streamingServiceDTO;
    private BigDecimal value;
    private SubscriptionType subscriptionType;
    private SubscriptionStatus subscriptionStatus;
    private PaymentType paymentType;
    private UserDTO userDTO;
    private LocalDate startDate;
    private LocalDate nextBillingDate;

    public SubscriptionDTO(){}

    public Long getId() {
        return id;
    }

    public StreamingServiceDTO getServiceDTO() {
        return streamingServiceDTO;
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setStreamingServiceDTO(StreamingServiceDTO streamingServiceDTO) {
        this.streamingServiceDTO = streamingServiceDTO;
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

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setNextBillingDate(LocalDate nextBillingDate) {
        this.nextBillingDate = nextBillingDate;
    }
}
