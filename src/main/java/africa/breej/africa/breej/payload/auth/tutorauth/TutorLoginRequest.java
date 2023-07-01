package africa.breej.africa.breej.payload.auth.tutorauth;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class TutorLoginRequest {

    @Email
    private String email;

    private String phoneNumber;

    @NotBlank
    private String password;

    // Getters and Setters (Omitted for brevity)
}
