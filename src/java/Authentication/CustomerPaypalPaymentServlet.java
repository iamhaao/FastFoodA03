/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Authentication;

import Controller.User.CheckOut;
import DAO.AccountDB;
import DAO.CartDB;
import DAO.CartDetailDB;
import DAO.OrderDB;
import DAO.OrderDetailsDB;
import DAO.SendEmail;
import Models.Account;
import Models.Cart;
import Models.Cart1;
import Models.Order;
import Models.OrderDetails;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
@WebServlet(name = "CustomerPaypalPaymentServlet", urlPatterns = {"/CustomerPaypalPaymentServlet"})
public class CustomerPaypalPaymentServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
                 HttpSession session = request.getSession();
            Order order = (Order) session.getAttribute("order");
            ArrayList<Cart> listCart = (ArrayList<Cart>) session.getAttribute("cartProducts");
            Account acc = (Account) session.getAttribute("acc");
            Double total = (Double) session.getAttribute("total");
            OrderDB odb = new OrderDB();
            CartDB cdb = new CartDB();
            SendEmail sm = new SendEmail();
            Cart1 cart1 = (Cart1) session.getAttribute("cartID");
            CartDetailDB cdtdb = new CartDetailDB();
            try {
                odb.insertOrder(order);
            } catch (SQLException ex) {
                Logger.getLogger(CheckOut.class.getName()).log(Level.SEVERE, null, ex);
            }
            for (Cart c : listCart) {
                OrderDetails orderDetails = new OrderDetails();
                orderDetails.setIdOrder(order.getIdOrder());
                orderDetails.setIdProduct(c.getIdProduct());
                orderDetails.quantityProduct(c.getQuantityProduct());
                orderDetails.setPriceDetails(c.getPrice() * c.getQuantityProduct());
                OrderDetailsDB detailsdb = new OrderDetailsDB();
                boolean result = detailsdb.insertOrderDetails(orderDetails);
                if (!result) {
                    break;
                }
            }
            listCart.clear();
            cdtdb.deleteAll(cart1.getIdCart());
            session.removeAttribute("cart_list");
            AccountDB adb = new AccountDB();
            double totalOrder = odb.getTotalOrder(acc.getIdAccount());
            int royal = 0;
            double discount = 0;
            if (totalOrder < 500000) {
                royal = 1;
            } else if (totalOrder > 500000 && totalOrder < 2000000) {
                royal = 2;
            } else if (totalOrder > 2000000 && totalOrder < 5000000) {
                royal = 3;
            } else if (totalOrder > 5000000) {
                royal = 4;
            }
            acc.setRoyal(royal);
            adb.updateRoyal(acc.getIdAccount(), acc.getRoyal());
            request.setAttribute("alert", "Your order has been successfully placed, the product will be delivered to you quickly. Check your email for details.");
            boolean send = sm.CheckOut(order.getIdOrder(), acc.getEmail());
            int size = listCart.size();
            session.setAttribute("size", size);
            request.getRequestDispatcher("Success.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
