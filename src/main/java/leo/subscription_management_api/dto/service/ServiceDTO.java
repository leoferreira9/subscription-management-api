package leo.subscription_management_api.dto.service;

public class ServiceDTO {

    private Long id;
    private String name;

    public ServiceDTO(){}

    public ServiceDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
