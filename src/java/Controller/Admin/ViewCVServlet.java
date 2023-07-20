package Controller.Admin;

import Controller.User.ApplyJobServlet;
import DAO.AccountDB;
import DAO.JobDB;
import DAO.SendEmail;
import Models.Account;
import Models.JobApply;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ViewCVServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idAccount = Integer.parseInt(request.getParameter("idAccount"));
        JobDB jdb = new JobDB();
        JobApply j = jdb.getJobByAccount(idAccount);
        request.setAttribute("cv", j);
        request.getRequestDispatcher("CVDetail.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AccountDB adb = new AccountDB();
        JobDB jdb = new JobDB();
        SendEmail sm = new SendEmail();
        int idAccount = Integer.parseInt(request.getParameter("idAccount"));
        int status = Integer.parseInt(request.getParameter("status"));
        String email = request.getParameter("email");
        switch (status) {
            case 1:
                adb.setRole(idAccount, 3);
                jdb.deleteApp(idAccount);
                boolean result= sm.ApplySuccess(email);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
            case 0:
                jdb.deleteApp(idAccount);
                sm.ApplyFailed(email);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;

        }
    }

}
