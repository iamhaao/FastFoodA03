package Controller.User;

import DAO.OrderDB;
import DAO.OrderDetailsDB;
import DAO.OrderManageDB;
import Models.Account;
import Models.OrderManage;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

public class CancelOrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        OrderDetailsDB odtdb = new OrderDetailsDB();
        Account acc = (Account) session.getAttribute("acc");
        String idOrder = request.getParameter("id");
        OrderDB odb = new OrderDB();
        odb.updateStatus(6, idOrder);
        odtdb.updateCancel(idOrder);
        OrderManageDB omndb = new OrderManageDB();
        List<OrderManage> historys = omndb.getOrderByUser(acc.getIdAccount());
        request.setAttribute("history", historys);
        request.getRequestDispatcher("BuyHistory.jsp").forward(request, response);
    }

}
