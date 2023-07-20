package Authentication;

import DAO.AccountDB;
import Models.Account;
import static Models.Validation.validateEmail;
import static Models.Validation.validatePassword;
import static Models.Validation.validatePhoneNumber;
import static Models.Validation.validateUsername;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SignUpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = (String) request.getParameter("name");
        String username = (String) request.getParameter("username");
        String email = (String) request.getParameter("email");
        String phone = (String) request.getParameter("phone");
        String password = (String) request.getParameter("password");
        String birthday_raw = request.getParameter("birthday");
        String avatar = "./images/defaultAvt.jpg";
        Date birthday = null;
        
        try {
            birthday = new SimpleDateFormat("yyyy-MM-dd").parse(birthday_raw);
        } catch (ParseException ex) {
            System.out.println(ex);
        }
        String address = request.getParameter("address");
//        int role = Integer.parseInt(request.getParameter("role"));
        AccountDB adb = new AccountDB();
        if (adb.checkSignUp(username) == true) {
            request.setAttribute("alert", "Username already exists. Please try another user name");
            request.getRequestDispatcher("SignUp.jsp").forward(request, response);
        } else if(adb.isAccountByEmail(email)){
            request.setAttribute("alert", "Email is exist. Please input another Email");
            request.getRequestDispatcher("SignUp.jsp").forward(request, response);
        }else {
            if (!validateUsername(username)) {
                request.setAttribute("alert", "Username is required gratherthan 3 character");
                request.getRequestDispatcher("SignUp.jsp").forward(request, response);
            }else
            if (!validateEmail(email)) {
                request.setAttribute("alert", "Email is required");
                request.getRequestDispatcher("SignUp.jsp").forward(request, response);
            }else
            if  (!validatePhoneNumber(phone)) {
                request.setAttribute("alert", "Phone is required 10 digit ");
                request.getRequestDispatcher("SignUp.jsp").forward(request, response);
            }else
            if (!validatePassword(password)) {
                request.setAttribute("alert", "Pass is required grather than 6 character ");
                request.getRequestDispatcher("SignUp.jsp").forward(request, response);
            }else{
            Account acc = new Account(1, username, password, name, email, address, phone, 1, avatar, 1,1);
            adb.addAccount(acc);
            request.setAttribute("alert", "You have successfully registered, Login now");
            request.getRequestDispatcher("SignUp.jsp").forward(request, response);
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
