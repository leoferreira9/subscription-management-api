package leo.subscription_management_api.dto.service;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ServiceCreateDTO {

    @NotBlank
    @Size(max = 100)
    private String name;

    public ServiceCreateDTO(){}

    public ServiceCreateDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
