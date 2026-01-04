package leo.subscription_management_api.dto.streamingservice;

import leo.subscription_management_api.entity.StreamingService;

public class StreamingServiceDTO {

    private Long id;
    private String name;

    public StreamingServiceDTO(){}

    public StreamingServiceDTO(StreamingService streamingService) {
        this.id = streamingService.getId();
        this.name = streamingService.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
