
package Controller;

import DAO.StoreDB;
import Models.Cart;
import Models.Store;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;


public class PaymentServlet extends HttpServlet {

   
 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        StoreDB sdb=new StoreDB();
        List<Store> listStore=sdb.getAllStore();
        HttpSession session=request.getSession();
        request.setAttribute("stores", listStore);
        request.getRequestDispatcher("Payment.jsp").forward(request, response);     
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
