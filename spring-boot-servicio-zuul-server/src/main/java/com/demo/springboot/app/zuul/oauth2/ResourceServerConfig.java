package com.demo.springboot.app.zuul.oauth2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.tokenStore(tokenStore());
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/api/security/oauth/**")
		.permitAll()
		.antMatchers(HttpMethod.GET, "/api/user/avatar").permitAll()
		.antMatchers(HttpMethod.GET, "/api/user/avatar/{id}").hasAnyRole("ADMIN", "USER")
		.antMatchers(HttpMethod.POST, "/api/user/avatar" ).hasAnyRole("ADMIN", "USER")
		.antMatchers(HttpMethod.PUT, "/api/user/avatar/{id}" ).hasAnyRole("ADMIN", "USER")
		.antMatchers(HttpMethod.DELETE, "/api/user/avatar/{id}").hasAnyRole("ADMIN")
		.anyRequest().authenticated();
	}
	
	@Bean
	public JwtTokenStore tokenStore() {

		return new JwtTokenStore(accessTokenConverter());
	}

	/*
	 * To transform token with the data that we want to store
	 *
	 * 
	 */
	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {

		JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
		tokenConverter.setSigningKey("some_secret_code_aeiou");

		return tokenConverter;
	}

	
	

}
