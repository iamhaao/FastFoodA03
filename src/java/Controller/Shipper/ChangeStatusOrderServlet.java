package Controller.Shipper;

import DAO.OrderDB;
import DAO.OrderDetailsDB;
import DAO.OrderManageDB;
import Models.Account;
import Models.OrderManage;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

public class ChangeStatusOrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        int status = Integer.parseInt(request.getParameter("status"));
        int role = Integer.parseInt(request.getParameter("role"));
        OrderDB odb = new OrderDB();
        OrderDetailsDB odtdb = new OrderDetailsDB();
        odb.updateStatus(status, id);
        if (status == 3) {
            odtdb.updateCancel(id);
        }
        switch (role) {
            case 1:
                request.getRequestDispatcher("manageOrder").forward(request, response);
                break;
            case 3:

                OrderManageDB omdb = new OrderManageDB();
                HttpSession session = request.getSession();
                Account acc = (Account) session.getAttribute("acc");
                List<OrderManage> listOrder = omdb.getOrderByShipper(acc.getIdAccount());
                request.setAttribute("listByShipper", listOrder);
                request.getRequestDispatcher("ManageDelivery.jsp").forward(request, response);
                break;
            default:
                throw new AssertionError();
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
