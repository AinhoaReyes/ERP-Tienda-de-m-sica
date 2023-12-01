package grupoB.erp.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import grupoB.erp.dao.UserDAO;
import grupoB.erp.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Autowired
    private UserService userService;

    @Bean
    public SecurityFilterChain configSecurityFilterChain (HttpSecurity http) throws Exception{
        http
        .authorizeHttpRequests((authorize) -> authorize
            .anyRequest().authenticated())
        .formLogin((form) -> form
            .loginPage("/login") //revisar error
            .defaultSuccessUrl("/index")
            .permitAll())
        .logout((logout) -> logout
            .permitAll()
            .deleteCookies("JSSESIONID")
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout")));
            
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(String email, String password) {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();        
        String hashPassword = encoder.encode(password);

        User user = userService.login(email, password);
    }

    /*

    @Bean
    public InMemoryUserDetailsManager userDetailsService(){
        UserDetails user = User.withUsername("user")
        .password(passwordEncoder().encode("user"))
        .roles("USER").build();

        //return new InMemoryUserDetailsManager(user, admin, employee);
    }
    */

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
