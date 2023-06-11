package vkr.chebanuk.diplom.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        //only ADMIN can go to /ui/user/list
        http
                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/ui/user/list").hasRole("ADMIN")
                .requestMatchers("/auth/login", "/auth/registration", "/error", "/auth/process-registration", "/css/**", "/js/**", "/images/**").permitAll()
                .requestMatchers("/ui/**").authenticated()
                .requestMatchers("/home", "/user-details").authenticated()
                .requestMatchers("/user/**").authenticated()
                .and()
                .formLogin().loginPage("/auth/login").loginProcessingUrl("/process-login")
                .defaultSuccessUrl("/ui/user/list", true)
                .failureUrl("/auth/login?error")
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/auth/login");
        return http.build();
    }

/*    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }*/

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
