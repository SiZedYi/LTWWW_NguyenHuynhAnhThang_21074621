package com.example.thang.bai01;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class LoggingFilter implements Filter {
    // Code này sẽ check xem request đến từ đâu khi filter
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("Request received at: " + request.getRemoteAddr());
        chain.doFilter(request, response);
    }
}
