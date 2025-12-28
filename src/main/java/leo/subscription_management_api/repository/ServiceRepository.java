package leo.subscription_management_api.repository;

import leo.subscription_management_api.entity.StreamingService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<StreamingService, Long> {}
