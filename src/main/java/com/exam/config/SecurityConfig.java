package com.exam.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.exam.services.impl.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig 
{
	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;
	
	@Autowired
	private JwtAuthenticationEntryPoint unauthorizedHandler;
	
   @Autowired
   private UserDetailsServiceImpl userDetailsService;
   
   @Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
	{
	   http
	       .csrf().disable()
	       .cors().disable()
	       .authorizeHttpRequests()
	       .requestMatchers("/generate-token","/user/").permitAll()
	       .requestMatchers(HttpMethod.OPTIONS).permitAll()
	       .anyRequest().authenticated()
	       .and()
	       .exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
	       .and()
	       .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	   
	   http
	       .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
	   
		return http.build();
	}
   
   @Bean
	 DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
	}
	
	@Bean
	AuthenticationManager authenticationManagerBean(AuthenticationConfiguration configuration)throws Exception
	{
		return configuration.getAuthenticationManager();
	}
	
	
	@Bean
	 BCryptPasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
}
