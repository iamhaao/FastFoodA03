
package Controller.User;

import DAO.OrderManageDB;
import Models.OrderManage;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;


public class BuyHistoryServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        OrderManageDB omndb=new OrderManageDB();
        List<OrderManage> historys=omndb.getOrderByUser(id);
        request.setAttribute("history", historys);
        request.getRequestDispatcher("BuyHistory.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }

}
