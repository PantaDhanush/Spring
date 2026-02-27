package com.example.SecurityPractice.config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
//Browser / Postman
//   ↓
//Servlet Container (Tomcat)
//   ↓
//Servlet Filters   ← LoggingFilter runs HERE
//   ↓
//DispatcherServlet
//   ↓
//Controller (@RestController)
import java.io.IOException;
@Component
public class LoggingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        System.out.println("Incoming request: " + request.getRequestURI());
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
