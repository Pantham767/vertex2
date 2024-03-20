package com.project.Vertex.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.project.Vertex.serviceImpl.CustomSuccessHandler;
import com.project.Vertex.serviceImpl.CustomUserDetailService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	CustomUserDetailService customUserDetailService;
	
	@Autowired
	CustomSuccessHandler customSuccessHandler;

	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		
	}
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		
		http.csrf(c -> c.disable())
		.authorizeHttpRequests(request -> request.requestMatchers("/admin-page")
				.hasAuthority("ADMIN").requestMatchers("/employee-page").hasAuthority("EMPLOYEE")
				.requestMatchers( "/css/**").permitAll()
				.requestMatchers( "/images/**").permitAll()
				.requestMatchers("/forgot-password").permitAll()
				.requestMatchers("/password-request").permitAll()
				.requestMatchers("/password").permitAll()
				.requestMatchers("/reset-password").permitAll().anyRequest()
				.authenticated())
		
		.formLogin(form -> form.loginPage("/home").loginProcessingUrl("/home").successHandler(customSuccessHandler)
				.permitAll())
		
		.logout(form -> form.invalidateHttpSession(true).clearAuthentication(true)
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/login?logout").permitAll());
		
		
		return http.build();
		
	}
	/*@Autowired
	public void ConfigureAction(AuthenticationManagerBuilder auth)throws Exception{
		auth.userDetailsService(customUserDetailService).passwordEncoder(passwordEncoder());
	}*/
}

