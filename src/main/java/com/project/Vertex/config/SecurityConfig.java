package com.project.Vertex.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.project.Vertex.entity.Register;
import com.project.Vertex.repository.RegisterRepository;
import com.project.Vertex.serviceImpl.CustomSuccessHandler;
import com.project.Vertex.serviceImpl.CustomUserDetailService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	CustomUserDetailService customUserDetailService;
	
	@Autowired
	CustomSuccessHandler customSuccessHandler;

	 @Autowired
	    private RegisterRepository registerRepo;

	    @Bean
	    public BCryptPasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

	    @Bean
	    public DaoAuthenticationProvider authenticationProvider() {
	        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	        authProvider.setUserDetailsService(userDetailsService()); // set custom UserDetailsService
	        authProvider.setPasswordEncoder(passwordEncoder());
	        return authProvider;
	    }

	    @Bean
	    public UserDetailsService userDetailsService() {
	        return email -> {
	            Register user = registerRepo.findByEmail(email);
	            if (user == null) {
	                throw new UsernameNotFoundException("User not found with email: " + email);
	            }
	            System.out.println(email);
	            System.out.println(user.getPassword());
	            return org.springframework.security.core.userdetails.User.withUsername(user.getEmail())
	                    .password(user.getPassword())
	                    .roles("user") // You can set roles based on your logic
	                    .build();
	        };
	    }

		
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		
		http
		.authorizeHttpRequests(request -> request.requestMatchers("/main").hasRole("admin")
				.requestMatchers("/index1").hasRole("user")
				.requestMatchers( "/css/**").permitAll()
				.requestMatchers( "/images/**").permitAll()
				.requestMatchers("/forgot-password").permitAll()
				.requestMatchers("/password-request").permitAll()
				.requestMatchers("/password").permitAll()
				.requestMatchers("/").permitAll()//HomePage Permission to allow All
				.requestMatchers("/saveRegister").permitAll()
				.requestMatchers("/reset-password").permitAll().anyRequest()
				.authenticated())
		
		.formLogin(form -> form.loginPage("/")
		.loginProcessingUrl("/authenticateTheUser")
		.successHandler(customSuccessHandler)
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


