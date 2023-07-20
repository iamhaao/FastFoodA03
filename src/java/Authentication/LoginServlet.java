package Authentication;

import DAO.AccountDB;
import DAO.CartDB;
import DAO.CartDetailDB;
import DAO.JobDB;
import DAO.OrderDB;
import DAO.ProductDB;
import Models.Account;
import Models.Cart;
import Models.Cart1;
import Models.JobApply;
import Models.Order;
import Models.Product;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.RandomStringUtils;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        String remember = request.getParameter("rem");
        AccountDB adb = new AccountDB();
        HttpSession session = request.getSession();
        CartDB cdb = new CartDB();
        CartDetailDB cdtdb = new CartDetailDB();
        List<Cart> list = null;
        Account acc = null;
        ProductDB pdb = new ProductDB();
        Cookie cookieUser = new Cookie("cuser", user);
        Cookie cookiePass = new Cookie("cpass", pass);
        Cookie cookieRem = new Cookie("crem", remember);
        OrderDB odb = new OrderDB();
        if (adb.checkSignUp(user) == true) {
            try {
                acc = adb.getAccountByUsername(user);
            } catch (Exception e) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, e);
            }
            if (acc != null && acc.getPassword().equals(pass)) {
                if (acc.getActive() == 1) {

                    if (remember != null) {
                        cookieUser.setMaxAge(60 * 60 * 24);
                        cookiePass.setMaxAge(60 * 60 * 24);
                        cookieRem.setMaxAge(60 * 60 * 24);
                    } else {
                        cookieUser.setMaxAge(0);
                        cookiePass.setMaxAge(0);
                        cookieRem.setMaxAge(0);
                    }
                    response.addCookie(cookieUser);
                    response.addCookie(cookiePass);
                    response.addCookie(cookieRem);
                    if (acc.getIdRole() == 1) {
                        List<Order> listOrderConfirm = odb.getListConfirm();
                        int sizeConfirm = listOrderConfirm.size();
                        JobDB jdb = new JobDB();
                        List<JobApply> listJob = jdb.getJob();
                        int sizeJob=listJob.size();
                         session.setAttribute("listJob", listJob);
                          session.setAttribute("sizeJob", sizeJob);
                        session.setAttribute("sizeConfirm", sizeConfirm);
                        session.setAttribute("listConfirm", listOrderConfirm);
                    } else if (acc.getIdRole() == 3) {
                        List<Order> list1 = odb.listOrderNotDone();
                        int count1 = list1.size();
                        session.setAttribute("sizeShipper", count1);
                        session.setAttribute("listOrder", list1);
                    }
                    Cart1 cart = cdb.checkCart(acc.getIdAccount());
                    session.setAttribute("cartID", cart);
                    if (cart != null) {
                        list = cdtdb.getCart(cart.getIdCart());
                        int size = list.size();
                        session.setAttribute("size", size);
                        session.setAttribute("cart_list", list);
                    } else {
                        Cart1 newCart = new Cart1(RandomStringUtils.randomAlphanumeric(6), acc.getIdAccount());
                        cdb.addNewCart(newCart);
                        Cart1 cart1 = cdb.checkCart(acc.getIdAccount());
                        session.setAttribute("cart_list", list);
                        session.setAttribute("cartID", cart1);
                    }
//            session.setAttribute("user", acc);
                    session.setAttribute("rem", remember);
                    session.setAttribute("acc", acc);
                    request.getRequestDispatcher("index.jsp").forward(request, response);

                } else {
                    request.setAttribute("alert", "Your Account has been blocked");
                    request.getRequestDispatcher("Login.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("alert", "username or password incorrect");
                request.getRequestDispatcher("Login.jsp").forward(request, response);

            }
        } else {
            request.setAttribute("alert", "username or password incorrect");
            request.getRequestDispatcher("Login.jsp").forward(request, response);

        }
    }

   

}
