package com.demo.session;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;

@WebFilter("/welcome")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Optional: code to run once when filter is created
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession(false);
        boolean loggedIn = (session != null && session.getAttribute("username") != null);

        System.out.println("🚪 Filter triggered!");

        if (loggedIn) {
            System.out.println("✅ User is logged in. Allowing access.");
            chain.doFilter(request, response);
        } else {
            System.out.println("❌ User not logged in. Redirecting to login page.");
            res.sendRedirect("index.jsp");
        }
    }

    @Override
    public void destroy() {
        // Optional: cleanup code
    }
}
