package africa.breej.africa.breej.service.auth;

import africa.breej.africa.breej.model.auth.AuthProvider;
import africa.breej.africa.breej.model.auth.Role;
import africa.breej.africa.breej.model.auth.Tutor;
import africa.breej.africa.breej.payload.auth.tutorauth.TutorAuthResponse;
import africa.breej.africa.breej.payload.auth.tutorauth.TutorLoginRequest;
import africa.breej.africa.breej.payload.auth.tutorauth.TutorSignUpRequest;
import africa.breej.africa.breej.payload.tutor.TutorResponse;
import africa.breej.africa.breej.repository.TutorRepository;
import africa.breej.africa.breej.security.JwtAuthenticationToken;
import africa.breej.africa.breej.security.TokenProvider;
import africa.breej.africa.breej.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.NotAcceptableStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TutorAuthServiceImpl implements TutorAuthService{
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthServiceImpl.class);

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private final TutorRepository tutorRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private TokenProvider tokenProvider;

    @Autowired
    public TutorAuthServiceImpl(AuthenticationManager authenticationManager,
                           TutorRepository tutorRepository, TokenProvider tokenProvider) {
        this.authenticationManager = authenticationManager;
        this.tutorRepository = tutorRepository;
        this.tokenProvider = tokenProvider;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }


    @Override
    public URI registerTutor(TutorSignUpRequest tutorSignUpRequest) {

        if(!StringUtil.isBlank(tutorSignUpRequest.getEmail())) {
            if(tutorRepository.existsByEmailAndDeleted(tutorSignUpRequest.getEmail(),false)) {
                LOGGER.info(String.format("Email address already in use: %s", tutorSignUpRequest.getEmail()));
                throw new NotAcceptableStatusException("Email address already in use.");
            }
        }

        if(tutorRepository.existsByPhoneNumberAndDeleted(tutorSignUpRequest.getPhoneNumber(), false)) {
            LOGGER.info(String.format("Phone number already in use: %s", tutorSignUpRequest.getPhoneNumber()));
            throw new NotAcceptableStatusException("Phone number already in use.");
        }

        Tutor tutor = new Tutor();
        tutor.setFirstName(tutorSignUpRequest.getFirstName());
        tutor.setLastName(tutorSignUpRequest.getLastName());
        tutor.setEmail(tutorSignUpRequest.getEmail());
        tutor.setPhoneNumber(tutorSignUpRequest.getPhoneNumber());
        tutor.setProvider(AuthProvider.LOCAL);
        tutor.setRole(Role.ROLE_TUTOR);
        tutor.setTimeCreated(LocalDateTime.now());

        tutor.setPassword(passwordEncoder.encode(tutorSignUpRequest.getPassword()));

        Tutor result = tutorRepository.save(tutor);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/tutor/me")
                .buildAndExpand(result.getId()).toUri();

        return location;
    }

    @Override
    public TutorAuthResponse authenticateTutor(TutorLoginRequest tutorLoginRequest) {
//        Authentication authentication=null;
        Tutor tutor = tutorRepository.findByPhoneNumber(tutorLoginRequest.getPhoneNumber()).get();
        TutorResponse tutorResponse =  getTutorResponseFromTutor(tutor);

        String token = passwordEncoder.encode(tutor.getPhoneNumber());

        JwtAuthenticationToken authenticationToken = new JwtAuthenticationToken(token);


        if(tutorLoginRequest.getEmail()!=null && !tutorLoginRequest.getEmail().isEmpty())  {
            if(!tutorRepository.existsByEmailAndDeleted(tutorLoginRequest.getEmail(),false)) {
                throw new NotAcceptableStatusException("Unauthenticated.");
            }
//            authentication = authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(
//                            tutorLoginRequest.getEmail(),
//                            tutorLoginRequest.getPassword()
//                    )
//            );
            authenticationToken.setAuthenticated(true);
        }

        if(tutorLoginRequest.getPhoneNumber()!=null && !tutorLoginRequest.getPhoneNumber().isEmpty()){
            if(!tutorRepository.existsByPhoneNumber(tutorLoginRequest.getPhoneNumber())) {
                throw new NotAcceptableStatusException("Unauthenticated.");
            }
//            authentication = authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(
//                            tutorLoginRequest.getPhoneNumber(),
//                            tutorLoginRequest.getPassword()
//                    )
//            );

            authenticationToken.setAuthenticated(true);
        }

//        SecurityContextHolder.getContext().setAuthentication(authentication);

        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        updateLastLogin(tutor);

        return new TutorAuthResponse(token, tutorResponse);
    }


    public TutorAuthResponse logoutTutor(String id) {
        Tutor tutor = new Tutor();
        TutorResponse tutorResponse =  getTutorResponseFromTutor(tutor);
        String token = "";
        SecurityContextHolder.clearContext();
        return new TutorAuthResponse(token, tutorResponse);
    }

    public Optional<Tutor> findByEmail(String email) {
        return tutorRepository.findByEmail(email);
    }

    private TutorResponse getTutorResponseFromTutor(Tutor tutor) {
        TutorResponse tutorResponse = new TutorResponse();
        try {
            BeanUtils.copyProperties(tutorResponse, tutor);
        } catch (Exception exception) {
            LOGGER.error("Error copying tutor properties");
        }
        return tutorResponse;
    }

    private void updateLastLogin(Tutor tutor) {
        tutor.setLastLogin(LocalDateTime.now());
        tutorRepository.save(tutor);
    }
}


