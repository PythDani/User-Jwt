package com.app.shops.users;
//package com.shopsusers;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.SecurityFilterChain;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//
//
//@EnableWebSecurity
//public class SecurityConfig {
//	
//	@SuppressWarnings("deprecation")
//	@Bean
//	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		
//		http.authorizeRequests().anyRequest().authenticated()
//		.and()
//		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//		.and()
//		.oauth2Login(oauth2Login -> oauth2Login.loginPage("/oauth2/authorization/users-client"))
//		.oauth2Client(withDefaults());
//		
//		return http.build();
//	}
//
//}
