package Fillter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFillter implements Filter {

   @Override
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest httpRequest = (HttpServletRequest) request;
    HttpServletResponse httpResponse = (HttpServletResponse) response;

    // Check if the user is logged in by checking the session
    HttpSession session = httpRequest.getSession(false);
    boolean isLoggedIn = (session != null && session.getAttribute("acc") != null);

    if (isLoggedIn) {
        // User is logged in, allow the request to proceed
        chain.doFilter(request, response);
    } else {
        // User is not logged in, redirect to the login page
        httpResponse.sendRedirect(httpRequest.getContextPath() + "/Login.jsp");
    }
}

    // Other Filter interface methods (init() and destroy()) can be left empty
    // or implemented as needed.
}