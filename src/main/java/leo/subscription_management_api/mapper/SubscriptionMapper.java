package leo.subscription_management_api.mapper;

import leo.subscription_management_api.dto.subscription.SubscriptionCreateDTO;
import leo.subscription_management_api.dto.subscription.SubscriptionDTO;
import leo.subscription_management_api.dto.subscription.SubscriptionUpdateDTO;
import leo.subscription_management_api.entity.Subscription;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface SubscriptionMapper {

    SubscriptionDTO subscriptionEntityToDto(Subscription subscription);

    Subscription subscriptionCreateDtoToEntity(SubscriptionCreateDTO subscriptionCreateDTO);

    @Mapping(target = "id", ignore = true)
    void updateSubscriptionFromDto(SubscriptionUpdateDTO subscriptionUpdateDTO, @MappingTarget Subscription subscription);
}
