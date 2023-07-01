package africa.breej.africa.breej.model.auth;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@Document(collection = "project_breej_db_tutor")
public class Tutor {
    @Id
    private String id;

    private String firstName;

    private String lastName;

    private String username;

    @Email
    private String email;

    private Boolean emailVerified = false;

    private String password;

    @NotNull
    private AuthProvider provider;

    @NotNull
    private Role role;

    @NotNull
    private Gender gender;

    private String providerId;

    private String specialty;

    private String phoneNumber;

    private boolean deleted=false;

    LocalDateTime timeCreated;

    LocalDateTime timeUpdated;

    LocalDateTime lastLogin;

}
