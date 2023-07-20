
package Controller.Shipper;

import DAO.OrderDB;
import Models.Account;
import Models.Order;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

public class DeliveryServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session=request.getSession();
        String id=request.getParameter("id");
        Account acc=(Account) session.getAttribute("acc");
        OrderDB odb=new OrderDB();
        odb.updateOrder(id,acc.getIdAccount());      
        List<Order> list=odb.listOrderNotDone();
        int count1=list.size();
        session.setAttribute("sizeShipper", count1);
        session.setAttribute("listOrder", list);
        request.getRequestDispatcher("Delivery.jsp").forward(request, response);      
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
