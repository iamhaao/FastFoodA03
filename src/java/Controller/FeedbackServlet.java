/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.FeedbackDB;
import DAO.ProductDB;
import Models.Account;
import Models.Feedback;
import Models.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author LENOVO
 */
@WebServlet(name = "FeedbackServlet", urlPatterns = {"/feedback"})
public class FeedbackServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("idProduct"));
        String comment = request.getParameter("comment");
        int whatever1 = Integer.parseInt(request.getParameter("whatever1"));
        HttpSession session = request.getSession();
        ProductDB pdb=new ProductDB();
        Product p=pdb.getProductByID(id);
        FeedbackDB fdb= new FeedbackDB();
        Account a = (Account)session.getAttribute("acc");
        
       
        
        int idAcc = a.getIdAccount();
        Feedback fb = new Feedback(idAcc, id ,comment,whatever1);
        fdb.addFeedback(fb);
        List<Feedback> listFb = fdb.getAllFeedback(id);
         int avgRating = fdb.avgRating(id);
        request.setAttribute("avgRating", avgRating);
        request.setAttribute("listFb", listFb);
        request.setAttribute("p", p);
         request.setAttribute("whatever1",whatever1 );
        request.getRequestDispatcher("PreviewProduct1.jsp").forward(request, response);
        
        
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }



}
