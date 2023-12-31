//package africa.breej.africa.breej.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
////    @Autowired
////    private UserService userService;
////
////    @Autowired
////    private CustomUserDetailsService customUserDetailsService;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                    .antMatchers("/api/v1/auth/**").permitAll() // Allow access to sign up endpoint without authentication
//                .antMatchers("/api/v1/user/**")
//                .permitAll()
//                    .anyRequest().permitAll();
//
//        // Disable CSRF protection for simplicity (you may want to enable it in production)
//        http.csrf().disable();
//    }
//
////    @Override
////    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
////        authenticationManagerBuilder
////                .userDetailsService(customUserDetailsService)
////                .passwordEncoder(passwordEncoder());
////        authenticationManagerBuilder.inMemoryAuthentication().withUser("admin").password("$2a$10$XF0aLlwHEDRbybTIqAiVleEAOA8OL9eVUrL1lQQ7bo67DQuV32hdS").roles("USER");
////    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
////    @Override
////    @Bean
////    public AuthenticationManager authenticationManagerBean() throws Exception {
////        return super.authenticationManagerBean();
////    }
//}