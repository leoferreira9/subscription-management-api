package leo.subscription_management_api.dto.user;

import leo.subscription_management_api.entity.User;

public class UserDTO {

    private Long id;
    private String name;
    private String email;

    public UserDTO(){};

    public UserDTO(User user){
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
