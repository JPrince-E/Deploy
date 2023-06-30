package africa.breej.africa.breej.payload.user;

import africa.breej.africa.breej.model.auth.Gender;
import africa.breej.africa.breej.model.auth.Role;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;

@Getter
@Setter
public class UpdateUserProfileRequest {

    private String firstName;

    private String lastName;

    private String username;

    @Email
    private String email;

    private String phoneNumber;

    private String courseOfStudy;

    private String department;

    private String faculty;

    private String nameOfSchool;

    private Gender gender;

    private String yearOfEntry;

    private String level;

    private String cgpa;

}