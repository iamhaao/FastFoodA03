package Authentication;

import DAO.AccountDB;
import Models.Account;
import Models.Validation;
import java.io.IOException;
;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



public class ChangePasswordServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String pass = request.getParameter("pass");
        String newpass = request.getParameter("newpass");
        String confirm = request.getParameter("confirm");
        AccountDB adb = new AccountDB();
        Account acc = adb.getAccountByUsername(username);
        if (acc.getPassword().equals(pass)) {
            if(!Validation.validatePassword(newpass)||!Validation.validatePassword(confirm) ){
                request.setAttribute("alert", "New Password or ConfirmPass is not grather than 6 character");
                request.setAttribute("acc", acc);
                request.getRequestDispatcher("EditProfile.jsp").forward(request, response);
            }
           else if (confirm.equals(newpass)) {
                adb.updatePass(username, newpass);
                request.setAttribute("alert", "Change passs success full!");
                Account acc1 = adb.getAccountByUsername(username);
                request.setAttribute("acc", acc1);
                request.getRequestDispatcher("EditProfile.jsp").forward(request, response);
            } else {
               request.setAttribute("acc", acc);
                request.setAttribute("alert", "New password is not equals with confirm password!");
                request.getRequestDispatcher("EditProfile.jsp").forward(request, response);
            }

        } else {
            request.setAttribute("acc", acc);
            request.setAttribute("alert", "Your current passsword incorrect!");
            request.getRequestDispatcher("EditProfile.jsp").forward(request, response);
        }

    }
;

}
