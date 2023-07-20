package Controller;

import DAO.AccountDB;
import Models.Account;
import static Models.Validation.validateEmail;
import static Models.Validation.validatePhoneNumber;
import static Models.Validation.validateUsername;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;

public class UpdateProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("user");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        HttpSession session = request.getSession();
        AccountDB adb = new AccountDB();
        Account c = (Account) session.getAttribute("acc");
        String pass = request.getParameter("password");
        if (!validateEmail(email)) {
            request.setAttribute("alert", "Email is required");
            request.getRequestDispatcher("EditProfile.jsp").forward(request, response);
        } else if (!validatePhoneNumber(phone)) {
            request.setAttribute("alert", "Phone is required 10 digit ");
            request.getRequestDispatcher("EditProfile.jsp").forward(request, response);
        } else {
            Account acc = new Account(c.getIdAccount(), user, pass, name, email, address, phone, c.getIdRole(), c.getAvatar(), 1,1);
            adb.updateCustomer(acc);
            session.removeAttribute("acc");
            Account acc1 = adb.getAccountByUsername(user);
            session.setAttribute("acc", acc1);
            request.setAttribute("alert", "Update Profile Successfull !!!!");
            request.getRequestDispatcher("EditProfile.jsp").forward(request, response);
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
