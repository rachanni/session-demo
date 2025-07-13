/*
 * package com.demo.session;
 * 
 * import java.io.*; import javax.servlet.*; import
 * javax.servlet.annotation.WebServlet; import javax.servlet.http.*;
 * 
 * @WebServlet("/login") public class LoginServlet extends HttpServlet {
 * protected void doPost(HttpServletRequest request, HttpServletResponse
 * response) throws ServletException, IOException {
 * 
 * String username = request.getParameter("username");
 * 
 * if (username != null && !username.trim().isEmpty()) { HttpSession session =
 * request.getSession(); // session.setMaxInactiveInterval(15 * 60); // 15
 * minutes session.setMaxInactiveInterval(10); // 10 seconly for tesing
 * session.setAttribute("username", username);
 * 
 * response.sendRedirect("welcome"); } else {
 * request.setAttribute("errorMessage", "Username cannot be empty.");
 * RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
 * rd.forward(request, response); } } }
 */

// below is added after Filter and Listener

package com.demo.session;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");

        if (username != null && !username.trim().isEmpty()) {
            HttpSession session = request.getSession(true);
            session.setMaxInactiveInterval(10); // 10 sec for testing
            session.setAttribute("username", username);
            response.sendRedirect("welcome");
        } else {
            request.setAttribute("errorMessage", "Username cannot be empty.");
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }
    }
}
