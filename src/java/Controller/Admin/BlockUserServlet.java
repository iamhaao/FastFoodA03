package Controller.Admin;

import DAO.AccountDB;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BlockUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("id");
        String action = request.getParameter("action");
        AccountDB adb = new AccountDB();
        switch (action) {
            case "block":
                adb.block(username);
                response.sendRedirect("manageAccount");
                break;
            case "unblock":
                adb.unblock(username);
                response.sendRedirect("manageAccount");
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
