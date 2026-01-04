package leo.subscription_management_api.dto.streamingservice;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class StreamingServiceCreateDTO {

    @NotBlank
    @Size(max = 100)
    private String name;

    public StreamingServiceCreateDTO(){}

    public StreamingServiceCreateDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
