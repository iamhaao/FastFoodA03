
package Controller.Admin;

import DAO.AccountDB;
import Models.Account;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;


public class ManageAccountServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       AccountDB adb=new AccountDB();
       List<Account> list=adb.getAll();
       int size=list.size();
       request.setAttribute("size", size);
       request.setAttribute("listAcc", list);
       request.getRequestDispatcher("ManagerAccount.jsp").forward(request, response);
    };

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
}
