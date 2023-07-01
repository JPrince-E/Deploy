package africa.breej.africa.breej.payload.auth.tutorauth;

import africa.breej.africa.breej.payload.tutor.TutorResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TutorAuthResponse {
    private String accessToken;
    private String tokenType = "Bearer";
    private TutorResponse tutor;

    public TutorAuthResponse(String accessToken, TutorResponse tutor) {
        this.accessToken = accessToken;
        this.tutor = tutor;
    }

    // Getters and Setters (Omitted for brevity)
}
