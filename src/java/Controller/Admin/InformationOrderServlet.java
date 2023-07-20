package Controller.Admin;



import DAO.AccountDB;
import DAO.OrderDB;
import DAO.OrderDetailsDB;
import DAO.ProductDB;
import Models.Account;
import Models.Order;
import Models.OrderDetails;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;



public class InformationOrderServlet extends HttpServlet {

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        OrderDetailsDB odtdb=new OrderDetailsDB();
        ProductDB pdb=new ProductDB();
        OrderDB odb=new OrderDB();  
        AccountDB adb=new AccountDB();
        String idOrder=request.getParameter("id");
        Order o=odb.getOrder(idOrder);
        List<OrderDetails> list=odtdb.listDetails(idOrder);    
        Account acc=adb.getAccountByOrderID(idOrder);
        request.setAttribute("order", o);
        request.setAttribute("list", list);
        request.setAttribute("acc", acc);
        request.getRequestDispatcher("InformationOrder.jsp").forward(request, response);
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
