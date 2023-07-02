//package africa.breej.africa.breej.controller;
//
//import africa.breej.africa.breej.payload.Response;
//import africa.breej.africa.breej.payload.auth.tutorauth.TutorAuthResponse;
//import africa.breej.africa.breej.payload.auth.tutorauth.TutorLoginRequest;
//import africa.breej.africa.breej.payload.auth.tutorauth.TutorSignUpRequest;
//import africa.breej.africa.breej.security.CurrentUser;
//import africa.breej.africa.breej.security.TokenProvider;
//import africa.breej.africa.breej.security.UserPrincipal;
//import africa.breej.africa.breej.service.auth.TutorAuthService;
//import africa.breej.africa.breej.util.StringUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.*;
//
//import java.net.URI;
//
//@RestController
//@RequestMapping("api/v1/auth")
//public class TutorAuthController {
//    TutorAuthService tutorAuthService;
//
//    private AuthenticationManager authenticationManager;
//
//    private TokenProvider tokenProvider;
//
//    private PasswordEncoder passwordEncoder;
//
//    @Autowired
//    public TutorAuthController(TutorAuthService tutorAuthService) {
//        this.tutorAuthService = tutorAuthService;
//    }
//
//    @PostMapping("/tutor-signup")
//    public ResponseEntity<?> registerTutor(@RequestBody TutorSignUpRequest tutorSignUpRequest) {
//
//        URI location = tutorAuthService.registerTutor(tutorSignUpRequest);
//
//        TutorLoginRequest tutorLoginRequest = new TutorLoginRequest();
//        if(!StringUtil.isBlank(tutorLoginRequest.getEmail()))
//            tutorLoginRequest.setEmail(tutorSignUpRequest.getEmail());
//        tutorLoginRequest.setPhoneNumber(tutorSignUpRequest.getPhoneNumber());
//        tutorLoginRequest.setPassword(tutorSignUpRequest.getPassword());
//        TutorAuthResponse tutorAuthResponse = tutorAuthService.authenticateTutor(tutorLoginRequest);
//
//        return ResponseEntity.created(location)
//                .body(new Response(true, true,"Tutor registered successfully", tutorAuthResponse));
//    }
//
//    @PostMapping("/tutor-login")
//    public ResponseEntity<?> loginTutor(@RequestBody TutorLoginRequest tutorLoginRequest) {
//        TutorAuthResponse tutorAuthResponse = tutorAuthService.authenticateTutor(tutorLoginRequest);
//        return ResponseEntity.ok(tutorAuthResponse);
//    }
//
//    @GetMapping("/tutor-logout")
//    public ResponseEntity<?> logout(@CurrentUser UserPrincipal userPrincipal) {
//        TutorAuthResponse tutorAuthResponse = tutorAuthService.logoutTutor(userPrincipal.getId());
//        return ResponseEntity.ok(tutorAuthResponse);
//    }
//}
