package africa.breej.africa.breej.payload.tutor;

import africa.breej.africa.breej.model.auth.Gender;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;

@Getter
@Setter
public class UpdateTutorProfileRequest {

    private String firstName;

    private String lastName;

    private String username;

    @Email
    private String email;

    private String phoneNumber;

    private Gender gender;

    private String specialty;

}
