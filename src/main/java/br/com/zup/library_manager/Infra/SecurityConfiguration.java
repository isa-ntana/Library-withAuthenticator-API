package br.com.zup.library_manager.Infra;

import br.com.zup.library_manager.Infra.JWT.JwtAuthenticationEntryPoint;
import br.com.zup.library_manager.Infra.JWT.JwtAuthenticationFilter;
import lombok.*;
import org.springframework.context.annotation.*;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.*;

@Component
@EnableMethodSecurity
@AllArgsConstructor
public class SecurityConfiguration {
        private UserDetailsService userDetailsService;
        private JwtAuthenticationEntryPoint authenticationEntryPoint;
        private JwtAuthenticationFilter authenticationFilter;

        @Bean
        public static PasswordEncoder passwordEncoder(){
            return new BCryptPasswordEncoder();
        }

        @Bean
        SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

            http.csrf(AbstractHttpConfigurer::disable)
                    .authorizeHttpRequests((authorize) -> {
                        authorize.requestMatchers("/api/auth/login").permitAll();
                        authorize.requestMatchers(HttpMethod.POST, "/user").permitAll();
                        authorize.requestMatchers(HttpMethod.OPTIONS, "/**").permitAll();


                    }).httpBasic(Customizer.withDefaults());

            http.exceptionHandling( exception -> exception
                    .authenticationEntryPoint(authenticationEntryPoint));

            http.addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);

            return http.build();
        }

        @Bean
        public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
            return configuration.getAuthenticationManager();
        }
    }

