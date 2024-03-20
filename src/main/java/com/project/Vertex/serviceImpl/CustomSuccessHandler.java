package com.project.Vertex.serviceImpl;

import java.io.IOException;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class CustomSuccessHandler implements AuthenticationSuccessHandler {
	
	private static final Logger LOGGER = Logger.getLogger(CustomSuccessHandler.class.getName());

	
	@Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
		// Retrieve authorities (roles) of the authenticated user
	    Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

	    // Check if any authority matches the specified roles
	    boolean isAdmin = authorities.stream().anyMatch(a -> a.getAuthority().equals("admin"));
	    boolean isUser = authorities.stream().anyMatch(a -> a.getAuthority().equals("user"));

	    // Redirect based on the user's role
	    if (isAdmin) {
	        response.sendRedirect("/main");
	    } else if (isUser) {
	        response.sendRedirect("/index1");
	    } else {
	        // If no specific role is found, log an error and redirect to an error page
	        LOGGER.log(Level.SEVERE, "No matching role found for user: " + authentication.getName());
	        response.sendRedirect("/error");
	    }

	}
}
