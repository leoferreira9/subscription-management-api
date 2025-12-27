package leo.subscription_management_api.repository;

import leo.subscription_management_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}
