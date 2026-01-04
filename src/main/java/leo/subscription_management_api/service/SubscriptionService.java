package leo.subscription_management_api.service;

import leo.subscription_management_api.dto.service.ServiceDTO;
import leo.subscription_management_api.dto.subscription.SubscriptionCreateDTO;
import leo.subscription_management_api.dto.subscription.SubscriptionDTO;
import leo.subscription_management_api.dto.subscription.SubscriptionUpdateDTO;
import leo.subscription_management_api.dto.user.UserDTO;
import leo.subscription_management_api.entity.StreamingService;
import leo.subscription_management_api.entity.Subscription;
import leo.subscription_management_api.entity.User;
import leo.subscription_management_api.exception.EntityNotFound;
import leo.subscription_management_api.repository.ServiceRepository;
import leo.subscription_management_api.repository.SubscriptionRepository;
import leo.subscription_management_api.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final ServiceRepository serviceRepository;
    private final UserRepository userRepository;

    public SubscriptionService(SubscriptionRepository subscriptionRepository, ServiceRepository serviceRepository, UserRepository userRepository){
        this.subscriptionRepository = subscriptionRepository;
        this.serviceRepository = serviceRepository;
        this.userRepository = userRepository;
    }

    public SubscriptionDTO create(SubscriptionCreateDTO dto){
        StreamingService service = serviceRepository.findById(dto.getServiceId()).orElseThrow(() -> new EntityNotFound("Streaming service not found with ID: " + dto.getServiceId()));
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

        ServiceDTO serviceDTO = new ServiceDTO(service);
        UserDTO userDTO = new UserDTO(user);

        return new SubscriptionDTO(subscription, serviceDTO, userDTO);
    }

    public SubscriptionDTO findById(Long id){
        Subscription subscription = subscriptionRepository.findById(id).orElseThrow(() -> new EntityNotFound("Subscription not found with ID: " + id));
        ServiceDTO serviceDTO = new ServiceDTO(subscription.getService());
        UserDTO userDTO = new UserDTO(subscription.getUser());

        return new SubscriptionDTO(subscription, serviceDTO, userDTO);
    }

    public List<SubscriptionDTO> findAll(){
        return subscriptionRepository.findAll().stream()
                .map(sub -> new SubscriptionDTO(sub, new ServiceDTO(sub.getService()), new UserDTO(sub.getUser())))
                .toList();
    }

    public SubscriptionDTO update(Long id, SubscriptionUpdateDTO dto){
        Subscription subscriptionExists = subscriptionRepository.findById(id).orElseThrow(() -> new EntityNotFound("Subscription not found with ID: " + id));

        subscriptionExists.setSubscriptionStatus(dto.getSubscriptionStatus());
        subscriptionExists.setSubscriptionType(dto.getSubscriptionType());
        subscriptionExists.setValue(dto.getValue());
        subscriptionExists.setPaymentType(dto.getPaymentType());

        ServiceDTO serviceDTO = new ServiceDTO(subscriptionExists.getService());
        UserDTO userDTO = new UserDTO(subscriptionExists.getUser());

        return new SubscriptionDTO(subscriptionExists, serviceDTO, userDTO);
    }

    public void delete(Long id){
        Subscription subscription = subscriptionRepository.findById(id).orElseThrow(() -> new EntityNotFound("Subscription not found with ID: " + id));
        subscriptionRepository.delete(subscription);
    }
}
