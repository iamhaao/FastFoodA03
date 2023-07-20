/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Authentication;

import DAO.AccountDB;
import DAO.CartDB;
import DAO.CartDetailDB;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Form;
import DAO.Constants;
import DAO.JobDB;
import DAO.OrderDB;
import DAO.ProductDB;
import DAO.SendEmail;
import Models.Account;
import Models.Cart;
import Models.Cart1;
import Models.GoogleUserDto;
import Models.JobApply;
import Models.Order;
import Models.Product;
import jakarta.servlet.http.HttpSession;
import static java.util.Collections.list;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author LENOVO
 */
@WebServlet(name = "LoginGoogleHandler", urlPatterns = {"/LoginGoogleHandler"})
public class LoginGoogleHandler extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        AccountDB adb = new AccountDB();
        OrderDB odb = new OrderDB();
        ProductDB pdb = new ProductDB();
        String code = request.getParameter("code");
        String accessToken = getToken(code);
        GoogleUserDto user = getUserInfo(accessToken);
        String email = user.getEmail();
        String takeUseNameFromEmail = user.getEmail();
        String[] words = takeUseNameFromEmail.split("@");
        String userName = words[0];
        CartDetailDB cdtdb = new CartDetailDB();
        List<Cart> list = null;
        System.out.println(userName);
        System.out.println(email);

        Account acctakeEmail = adb.getAccountByEmail(email);
        SendEmail sm = new SendEmail();
        //////////////////          
        if (acctakeEmail.getEmail() == null) {
            Account acc = new Account(1, userName, null, null, email, null, null, 2, "./images/defaultAvt.jpg", 1, 1);
            //Sua lai them add 1 tai khoan them nhieu truong 
            adb.addAccountLoginWithGoogle(acc);
//                        session.setAttribute("user", acctakeEmail);
            session.setAttribute("acc", acc);
            session.setAttribute("user", acc);
            boolean test = sm.CreateAccount(acc);

//            session.setAttribute("user", acc);
            session.setAttribute("acc", acc);
            request.getRequestDispatcher("index.jsp").forward(request, response);
//            session.setMaxInactiveInterval(12000);
//            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            if (acctakeEmail.getIdRole() == 1) {
                JobDB jdb = new JobDB();
                List<JobApply> listJob = jdb.getJob();
                int sizeJob = listJob.size();
                session.setAttribute("listJob", listJob);
                session.setAttribute("sizeJob", sizeJob);
                List<Order> listOrderConfirm = odb.getListConfirm();
                int sizeConfirm = listOrderConfirm.size();
                session.setAttribute("sizeConfirm", sizeConfirm);
                session.setAttribute("listConfirm", listOrderConfirm);
            } else if (acctakeEmail.getIdRole() == 3) {
                List<Order> list1 = odb.listOrderNotDone();
                int count1 = list1.size();
                session.setAttribute("sizeShipper", count1);
                session.setAttribute("listOrder", list1);
            }
            CartDB cdb = new CartDB();
            Cart1 cart = cdb.checkCart(acctakeEmail.getIdAccount());
            session.setAttribute("cartID", cart);
            if (cart != null) {
                list = cdtdb.getCart(cart.getIdCart());
                int size = list.size();
                session.setAttribute("size", size);
                session.setAttribute("cart_list", list);
            } else {
                Cart1 newCart = new Cart1(RandomStringUtils.randomAlphanumeric(6), acctakeEmail.getIdAccount());
                cdb.addNewCart(newCart);
                Cart1 cart1 = cdb.checkCart(acctakeEmail.getIdAccount());
                session.setAttribute("cart_list", list);
                session.setAttribute("cartID", cart1);
            }
            session.setAttribute("acc", acctakeEmail);
            session.setAttribute("user", acctakeEmail);

            session.setMaxInactiveInterval(12000);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

//                Account acc = adb.getAccountByEmail(email);
    }

    public static String getToken(String code) throws ClientProtocolException, IOException {
        // call api to get token
        String response = Request.Post(Constants.GOOGLE_LINK_GET_TOKEN)
                .bodyForm(Form.form().add("client_id", Constants.GOOGLE_CLIENT_ID)
                        .add("client_secret", Constants.GOOGLE_CLIENT_SECRET)
                        .add("redirect_uri", Constants.GOOGLE_REDIRECT_URI).add("code", code)
                        .add("grant_type", Constants.GOOGLE_GRANT_TYPE).build())
                .execute().returnContent().asString();

        JsonObject jobj = new Gson().fromJson(response, JsonObject.class);
        String accessToken = jobj.get("access_token").toString().replaceAll("\"", "");
        return accessToken;
    }

    public static GoogleUserDto getUserInfo(final String accessToken) throws ClientProtocolException, IOException {
        String link = Constants.GOOGLE_LINK_GET_USER_INFO + accessToken;
        String response = Request.Get(link).execute().returnContent().asString();

        GoogleUserDto googlePojo = new Gson().fromJson(response, GoogleUserDto.class);

        return googlePojo;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the +
    // sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
