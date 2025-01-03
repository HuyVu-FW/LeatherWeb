package huyvu.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


@Configuration
@EnableMethodSecurity
public class SecurityConfig {
    private String[] PUBLIC_URLS_GET = {"category/"};
    private String[] PUBLIC_URLS_POST= {"catecogy/","auth/register/", "auth/login/"};
    @Bean
    public SecurityFilterChain securityFilterChain(final HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)



                .cors(cors -> cors.configurationSource(request -> {
                    CorsConfiguration corsConfig = new CorsConfiguration();
                    corsConfig.addAllowedOrigin("http://localhost:3000"); // Replace with your frontend URL
                    corsConfig.addAllowedMethod("*"); // Allow all HTTP methods
                    corsConfig.addAllowedHeader("*"); // Allow all headers
                    corsConfig.setAllowCredentials(true); // Allow cookies
                    return corsConfig;
                }))
                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers(HttpMethod.POST,"auth/register/").permitAll()
                        .requestMatchers(HttpMethod.POST,PUBLIC_URLS_POST).permitAll()

                        .requestMatchers(PUBLIC_URLS_GET).permitAll()

                        .anyRequest().authenticated()
                );
        return http.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
