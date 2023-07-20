package Controller;

import DAO.CartDB;
import DAO.CartDetailDB;
import Models.Cart;
import Models.Cart1;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;

public class RemoveCartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CartDB cdb=new CartDB();
        CartDetailDB cdtdb=new CartDetailDB();
        String id1 = request.getParameter("id");
        if (id1 != null) {
            int id=Integer.parseInt(id1);
            HttpSession session = request.getSession();
            ArrayList<Cart> listCart = (ArrayList<Cart>) session.getAttribute("cart_list");
            Cart1  cart=(Cart1) session.getAttribute("cartID");
            if (listCart != null) {
                for (Cart p : listCart) {
                    if (p.getIdProduct()==id) {
                        listCart.remove(listCart.indexOf(p));
                        cdtdb.deleteProduct(cart.getIdCart(),p.getIdProduct());
                        break;
                    }
                }
                
                int size = listCart.size();
                session.setAttribute("size", size);
                response.sendRedirect("cart");
            } else {
                session.removeAttribute("cart_list"); // Remove the entire cart list
                int size = 0;
                session.setAttribute("size", size);
                response.sendRedirect("cart");
            }
        } else {
            response.sendRedirect("cart");

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
