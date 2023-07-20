
package Controller.Shipper;

import DAO.OrderDB;
import DAO.OrderManageDB;
import Models.Account;
import Models.Order;
import Models.OrderManage;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;


public class ManageDeliveryServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id=Integer.parseInt( request.getParameter("id")) ;
        OrderManageDB omdb=new OrderManageDB();
        List<OrderManage> listOrder=omdb.getOrderByShipper(id);
        request.setAttribute("listByShipper", listOrder);
        request.getRequestDispatcher("ManageDelivery.jsp").forward(request, response);
        
       
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
