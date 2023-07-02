//package africa.breej.africa.breej.security;
//
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//
//import java.util.Collection;
//
//public class JwtAuthenticationToken implements Authentication {
//
//    private String token;
//    private Collection<? extends GrantedAuthority> authorities;
//    private boolean isAuthenticated;
//
//    public JwtAuthenticationToken(String token) {
//        this.token = token;
//        this.isAuthenticated = false;
//    }
//
//    public JwtAuthenticationToken(String token, Collection<? extends GrantedAuthority> authorities) {
//        this.token = token;
//        this.authorities = authorities;
//        this.isAuthenticated = true;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return authorities;
//    }
//
//    @Override
//    public Object getCredentials() {
//        return null;
//    }
//
//    @Override
//    public Object getDetails() {
//        return null;
//    }
//
//    @Override
//    public Object getPrincipal() {
//        return null;
//    }
//
//    @Override
//    public boolean isAuthenticated() {
//        return isAuthenticated;
//    }
//
//    @Override
//    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
//        this.isAuthenticated = isAuthenticated;
//    }
//
//    @Override
//    public String getName() {
//        return null;
//    }
//
//    public String getToken() {
//        return token;
//    }
//}
