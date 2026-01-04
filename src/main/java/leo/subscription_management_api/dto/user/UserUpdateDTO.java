package leo.subscription_management_api.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserUpdateDTO {

    @NotBlank
    @Size(max = 150)
    private String name;

    @NotBlank
    @Size(max = 100)
    private String email;

    public UserUpdateDTO(){}

    public UserUpdateDTO(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
