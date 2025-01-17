package com.login.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	JwtAuthFilter authFilter;
	
	@Autowired
	UserDetailsService service;
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider()
	{
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
		provider.setPasswordEncoder(encoder);
		provider.setUserDetailsService(service);
		return provider;
	}
	
	public AuthenticationManager getAuthenticationManager(AuthenticationConfiguration config)throws Exception
	{
		return config.getAuthenticationManager();
	}
	
	
	@Bean
	public SecurityFilterChain authorize(HttpSecurity httpSecurity) throws Exception
	{
		httpSecurity.csrf(csrf->csrf.disable()).authorizeHttpRequests(auth->{
			auth
			.requestMatchers("").permitAll()
			.requestMatchers("").hasRole("ADMIN")
			.anyRequest().authenticated();
			})
		    .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class);
		
		return httpSecurity.build();
	}
	
	
	
	
	
	

}
