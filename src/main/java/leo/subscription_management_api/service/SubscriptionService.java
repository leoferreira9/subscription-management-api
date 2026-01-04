package leo.subscription_management_api.service;

import leo.subscription_management_api.dto.subscription.SubscriptionCreateDTO;
import leo.subscription_management_api.dto.subscription.SubscriptionDTO;
import leo.subscription_management_api.dto.subscription.SubscriptionUpdateDTO;
import leo.subscription_management_api.entity.StreamingService;
import leo.subscription_management_api.entity.Subscription;
import leo.subscription_management_api.entity.User;
import leo.subscription_management_api.exception.EntityNotFound;
import leo.subscription_management_api.mapper.SubscriptionMapper;
import leo.subscription_management_api.repository.StreamingServiceRepository;
import leo.subscription_management_api.repository.SubscriptionRepository;
import leo.subscription_management_api.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final StreamingServiceRepository streamingServiceRepository;
    private final UserRepository userRepository;
    private final SubscriptionMapper subscriptionMapper;

    public SubscriptionService(SubscriptionRepository subscriptionRepository,
                               StreamingServiceRepository streamingServiceRepository,
                               UserRepository userRepository,
                               SubscriptionMapper subscriptionMapper){
        this.subscriptionRepository = subscriptionRepository;
        this.streamingServiceRepository = streamingServiceRepository;
        this.userRepository = userRepository;
        this.subscriptionMapper = subscriptionMapper;
    }

    public SubscriptionDTO create(SubscriptionCreateDTO dto){
        StreamingService service = streamingServiceRepository.findById(dto.getServiceId()).orElseThrow(() -> new EntityNotFound("Streaming service not found with ID: " + dto.getServiceId()));
        User user = userRepository.findById(dto.getUserId()).orElseThrow(() -> new EntityNotFound("User not found with ID: " + dto.getUserId()));

        LocalDate startDate = LocalDate.now();
        LocalDate nextBillingDate = startDate.plusMonths(1);

        Subscription subscription = subscriptionRepository.save(
                new Subscription(service,
                        dto.getValue(),
                        dto.getSubscriptionType(),
                        dto.getSubscriptionStatus(),
                        dto.getPaymentType(),
                        user,
                        startDate,
                        nextBillingDate)
        );
        return subscriptionMapper.subscriptionEntityToDto(subscription);
    }

    public SubscriptionDTO findById(Long id){
        Subscription subscription = subscriptionRepository.findById(id).orElseThrow(() -> new EntityNotFound("Subscription not found with ID: " + id));
        return subscriptionMapper.subscriptionEntityToDto(subscription);
    }

    public List<SubscriptionDTO> findAll(){
        return subscriptionRepository.findAll().stream()
                .map(subscriptionMapper::subscriptionEntityToDto)
                .toList();
    }

    public SubscriptionDTO update(Long id, SubscriptionUpdateDTO dto){
        Subscription subscriptionExists = subscriptionRepository.findById(id).orElseThrow(() -> new EntityNotFound("Subscription not found with ID: " + id));

        subscriptionExists.setSubscriptionStatus(dto.getSubscriptionStatus());
        subscriptionExists.setSubscriptionType(dto.getSubscriptionType());
        subscriptionExists.setValue(dto.getValue());
        subscriptionExists.setPaymentType(dto.getPaymentType());

        subscriptionRepository.save(subscriptionExists);

        return subscriptionMapper.subscriptionEntityToDto(subscriptionExists);
    }

    public void delete(Long id){
        Subscription subscription = subscriptionRepository.findById(id).orElseThrow(() -> new EntityNotFound("Subscription not found with ID: " + id));
        subscriptionRepository.delete(subscription);
    }
}
