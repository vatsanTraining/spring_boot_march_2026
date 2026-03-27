package org.training;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

	
	@Bean
	BCryptPasswordEncoder encoder() {
		
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	UserDetailsService userDetails(BCryptPasswordEncoder encoder) {
		
		UserDetails adminUser = User.builder()
				              .username("india")
				              .password(encoder.encode("delhi"))
				              .roles("ADMIN")
				              .build();
		
		
		
		UserDetails guestUser = User.builder()
	              .username("bhutan")
	              .password(encoder.encode("thimpu"))
	              .roles("GUEST")
	              .build();;
		
		
		return new InMemoryUserDetailsManager(adminUser,guestUser);
	}
	
	
	@Bean
	SecurityFilterChain  filterChain(HttpSecurity http) throws Exception{
		
		http.csrf(csrf -> csrf.disable())
		 .authorizeHttpRequests(
				 auth -> auth.requestMatchers("/api/v1/auth/**","/swagger-ui/**","/actuator/**").permitAll()
				 .anyRequest().authenticated())
		         .httpBasic(Customizer.withDefaults());
		
		return http.build();
	}
}
