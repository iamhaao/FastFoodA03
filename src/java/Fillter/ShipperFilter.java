/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Fillter;

import Models.Account;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import java.io.IOException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author ACER NITRO
 */
@WebFilter("/shipperFillter")
public class ShipperFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest httpRequest = (HttpServletRequest) request;
    HttpServletResponse httpResponse = (HttpServletResponse) response;
 HttpSession session = httpRequest.getSession(false);
    Account acc= (Account) session.getAttribute("acc");
    // Check if the user is logged in by checking the session
    boolean isLoggedIn = (session != null && acc.getIdRole()==3);

     if (isLoggedIn) {
        // User is logged in, allow the request to proceed
        chain.doFilter(request, response);
    } else {
        // User is not logged in, redirect to the login page
        httpResponse.sendRedirect(httpRequest.getContextPath() + "/Error.jsp");
    }
}


}
