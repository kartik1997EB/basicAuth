package com.api.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Service;

@Service
public class CustumAuthenticationEntryPoint implements AuthenticationEntryPoint{

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		System.out.println("in custum--------------------------> ");
		response.getWriter().write("failure");
		 HttpSession session = request.getSession(true);
//	        if(!auth.isAuthenticated()) {
//	        	session.invalidate();
//	        	System.out.println("invalidate");
//	        }else
	        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
	        session.invalidate();
		authException.printStackTrace();
		
	}

}
