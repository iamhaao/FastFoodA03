
package Controller.Admin;

import DAO.AccountDB;
import DAO.OrderDB;
import DAO.OrderDetailsDB;
import DAO.OrderManageDB;
import DAO.SendEmail;
import Models.Account;
import Models.OrderManage;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;


public class ManageOrderServlet extends HttpServlet {

    
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        OrderManageDB omdb=new OrderManageDB();
        List<OrderManage> list=omdb.getAll();
        request.setAttribute("manageOrder", list);
        request.getRequestDispatcher("ManagerOrder.jsp").forward(request, response);       
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idOrder = request.getParameter("id");
        OrderDB odb = new OrderDB();
        AccountDB adb=new AccountDB();
        SendEmail sent=new SendEmail();
         OrderDetailsDB odtdb = new OrderDetailsDB();
        Account acc=adb.getAccountByOrderID(idOrder);
        odb.updateStatus(3, idOrder);
        odtdb.updateCancel(idOrder);
        boolean cancelOrder=sent.CancelOrder(acc.getEmail());
        OrderManageDB omdb=new OrderManageDB();
        List<OrderManage> list=omdb.getAll();
        request.setAttribute("manageOrder", list);
        request.getRequestDispatcher("ManagerOrder.jsp").forward(request, response);   
    }
}
