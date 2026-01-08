package leo.subscription_management_api.mapper;

import leo.subscription_management_api.dto.paymenthistory.PaymentHistoryDTO;
import leo.subscription_management_api.entity.PaymentHistory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PaymentHistoryMapper {

    @Mapping(source = "subscription.id", target = "subscriptionId")
    PaymentHistoryDTO paymentHistoryEntityToDto(PaymentHistory paymentHistory);
}
