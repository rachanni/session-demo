/*
 * 
 * package com.demo.session;
 * 
 * import java.io.*; import javax.servlet.*; import
 * javax.servlet.annotation.WebServlet; import javax.servlet.http.*;
 * 
 * @WebServlet("/welcome") public class WelcomeServlet extends HttpServlet {
 * protected void doGet(HttpServletRequest request, HttpServletResponse
 * response) throws ServletException, IOException {
 * 
 * HttpSession session = request.getSession(false);
 * 
 * if (session != null && session.getAttribute("username") != null) { String
 * username = (String) session.getAttribute("username");
 * request.setAttribute("username", username); RequestDispatcher rd =
 * request.getRequestDispatcher("welcome.jsp"); rd.forward(request, response); }
 * else {
 * 
 * // response.sendRedirect("index.jsp");
 * 
 * RequestDispatcher rd = request.getRequestDispatcher("sessionExpired.jsp");
 * rd.forward(request, response);
 * 
 * 
 * } } }
 */


// below is added after Filter and Listener

package com.demo.session;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute("username") != null) {
            String username = (String) session.getAttribute("username");
            request.setAttribute("username", username);
            RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("sessionExpired.jsp");
            rd.forward(request, response);
        }
    }
}
