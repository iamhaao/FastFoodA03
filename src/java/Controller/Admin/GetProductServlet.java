/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Admin;

import DAO.ProductDB;
import Models.Product;
import java.io.IOException;
import java.io.PrintWriter;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class GetProductServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Gson gson = new Gson();
        ProductDB pdb=new ProductDB();
        int id=Integer.parseInt(request.getParameter("id"));
        Product p=pdb.getProductByID(id);
        String ps = gson.toJson(p);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
    }




}
