package africa.breej.africa.breej.service.auth;

import africa.breej.africa.breej.model.auth.Tutor;
import africa.breej.africa.breej.payload.auth.tutorauth.TutorAuthResponse;
import africa.breej.africa.breej.payload.auth.tutorauth.TutorLoginRequest;
import africa.breej.africa.breej.payload.auth.tutorauth.TutorSignUpRequest;

import java.net.URI;
import java.util.Optional;

public interface TutorAuthService {
    TutorAuthResponse authenticateTutor(TutorLoginRequest tutorLoginRequest);

    URI registerTutor(TutorSignUpRequest tutorSignUpRequest);

    Optional<Tutor> findByEmail(String email);

    TutorAuthResponse logoutTutor(String id);
}
