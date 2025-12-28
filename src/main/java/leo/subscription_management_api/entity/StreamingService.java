package leo.subscription_management_api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import leo.subscription_management_api.dto.service.ServiceCreateDTO;

@Entity
public class StreamingService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, length = 100)
    private String name;

    public StreamingService(){}

    public StreamingService(String name) {
        this.name = name;
    }

    public StreamingService(ServiceCreateDTO dto){
        this.name = dto.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
