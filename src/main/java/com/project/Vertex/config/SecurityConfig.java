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

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class SecurityConfig implements WebMvcConfigurer {

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
				.authorizeHttpRequests(request -> request.requestMatchers("/main")
						.hasAuthority("admin").requestMatchers("/usersuccess").hasAuthority("user")
						.requestMatchers( "/css/**").permitAll()
						.requestMatchers("/forgot-password").permitAll()
						.requestMatchers("/password-request").permitAll()
						.requestMatchers("/images/**").permitAll()
						.requestMatchers("/").permitAll()
						.requestMatchers("/password").permitAll()
						.requestMatchers("/saveRegister").permitAll()
						.requestMatchers("/reset-password").permitAll().anyRequest()
						.authenticated())

				.formLogin(form -> form.loginPage("/").loginProcessingUrl("/loginVerification").successHandler(customSuccessHandler)
						.permitAll())

				.logout(form -> form.invalidateHttpSession(true).clearAuthentication(true)
						.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
						.logoutSuccessUrl("/login?logout").permitAll());


		return http.build();

	}



	@Autowired
	public void ConfigureAction(AuthenticationManagerBuilder auth)throws Exception{
		auth.userDetailsService(customUserDetailService).passwordEncoder(passwordEncoder());
	}

	/*@Autowired
	public void ConfigureAction(AuthenticationManagerBuilder auth)throws Exception{
		auth.userDetailsService(customUserDetailService).passwordEncoder(passwordEncoder());
	}*/
}


