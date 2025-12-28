package leo.subscription_management_api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import leo.subscription_management_api.dto.user.UserCreateDTO;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, length = 150)
    private String name;

    @NotBlank
    @Column(nullable = false, unique = true, length = 100)
    @Email
    private String email;

    public User(){}

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public User(UserCreateDTO dto){
        this.name = dto.getName();
        this.email = dto.getEmail();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
