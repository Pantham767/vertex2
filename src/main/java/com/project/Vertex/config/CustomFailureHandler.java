package com.project.Vertex.config;

import java.io.IOException;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomFailureHandler extends SimpleUrlAuthenticationFailureHandler {
	
	@Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        super.onAuthenticationFailure(request, response, exception);
        // Logging authentication failure
        System.out.println("Authentication failed for user: " + request.getParameter("email"));
        System.out.println("Reason: " + exception.getMessage());
    }
}
