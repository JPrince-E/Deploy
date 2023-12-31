//package africa.breej.africa.breej.security;
//
//
//import africa.breej.africa.breej.model.auth.User;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//import java.util.Map;
////import org.springframework.security.oauth2.core.user.OAuth2User;
//
//public class UserPrincipal implements /*OAuth2User,*/ UserDetails {
//    private String id;
//    private String email;
//    private String phoneNumber;
//    private String password;
//    private Map<String, Object> attributes;
//
//    public UserPrincipal(String id, String email, String phoneNumber, String password /*Collection<? extends GrantedAuthority> authorities*/) {
//        this.id = id;
//        this.email = email;
//        this.phoneNumber = phoneNumber;
//        this.password = password;
//    }
//
//    public static UserPrincipal create(User user) {
//
//        return new UserPrincipal(
//                user.getId(),
//                user.getEmail(),
//                user.getPhoneNumber(),
//                user.getPassword()
//        );
//    }
//
//    public static UserPrincipal create(User user, Map<String, Object> attributes) {
//        UserPrincipal userPrincipal = UserPrincipal.create(user);
//        userPrincipal.setAttributes(attributes);
//        return userPrincipal;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return email;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }
//
////    @Override
//    public Map<String, Object> getAttributes() {
//        return attributes;
//    }
//
//    public void setAttributes(Map<String, Object> attributes) {
//        this.attributes = attributes;
//    }
//
////    @Override
//    public String getName() {
//        return String.valueOf(id);
//    }
//}
