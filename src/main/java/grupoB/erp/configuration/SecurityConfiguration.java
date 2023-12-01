package grupoB.erp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
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
    public InMemoryUserDetailsManager userDetailsService(){
        UserDetails user = User.withUsername("user")
        .password(passwordEncoder().encode("user"))
        .roles("USER").build();

        UserDetails admin = User.withUsername("admin")
        .password(passwordEncoder().encode("admin"))
        .roles("ADMIN").build();

        UserDetails employee = User.withUsername("employee")
        .password(passwordEncoder().encode("employee"))
        .roles("EMPLOYEE").build();

        return new InMemoryUserDetailsManager(user, admin, employee);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
