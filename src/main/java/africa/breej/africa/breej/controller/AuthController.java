//package africa.breej.africa.breej.controller;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("api/v1/auth")
//public class AuthController {
////    AuthService authService;
//
////    private AuthenticationManager authenticationManager;
////
////    private TokenProvider tokenProvider;
////
////    private PasswordEncoder passwordEncoder;
//
////    @Autowired
////    public AuthController(AuthService authService) {
////        this.authService = authService;
////    }
//
////    @PostMapping("/signup")
////    public ResponseEntity<?> registerUser(@RequestBody SignUpRequest signUpRequest) {
////
////        URI location = authService.registerUser(signUpRequest);
////
////        LoginRequest loginRequest = new LoginRequest();
////        if(!StringUtil.isBlank(loginRequest.getEmail()))
////            loginRequest.setEmail(signUpRequest.getEmail());
////        loginRequest.setPhoneNumber(signUpRequest.getPhoneNumber());
////        loginRequest.setPassword(signUpRequest.getPassword());
////        AuthResponse authResponse = authService.authenticateUser(loginRequest);
////
////        return ResponseEntity.created(location)
////                .body(new Response(true, true,"User registered successfully", authResponse));
////    }
////
////    @PostMapping("/login")
////    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
////        AuthResponse authResponse = authService.authenticateUser(loginRequest);
////        return ResponseEntity.ok(authResponse);
////    }
////
////    @GetMapping("/logout")
////    public ResponseEntity<?> logout(@CurrentUser UserPrincipal userPrincipal) {
////        AuthResponse authResponse = authService.logoutUser(userPrincipal.getId());
////        return ResponseEntity.ok(authResponse);
////    }
//
//    @GetMapping("/hello")
//    public String sayHello() {
//        return "Hello, World!";
//    }
//}
