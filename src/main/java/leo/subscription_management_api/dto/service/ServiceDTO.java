package leo.subscription_management_api.dto.service;

import leo.subscription_management_api.entity.StreamingService;

public class ServiceDTO {

    private Long id;
    private String name;

    public ServiceDTO(){}

    public ServiceDTO(StreamingService streamingService) {
        this.id = streamingService.getId();
        this.name = streamingService.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
