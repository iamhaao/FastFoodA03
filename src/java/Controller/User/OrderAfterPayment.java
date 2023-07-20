package Controller.User;

import DAO.AccountDB;
import DAO.CartDB;
import DAO.CartDetailDB;
//import DAO.CreditCardDB;
import DAO.OrderDB;
import DAO.OrderDetailsDB;
import DAO.SendEmail;
import Models.Account;
import Models.Cart;
import Models.Cart1;
//import Models.CreditCard;
import Models.Order;
import Models.OrderDetails;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderAfterPayment extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if ("00".equals(request.getParameter("vnp_TransactionStatus"))) {
            HttpSession session = request.getSession();
            Order order = (Order) session.getAttribute("order");
            ArrayList<Cart> listCart = (ArrayList<Cart>) session.getAttribute("cartProducts");
            Account acc = (Account) session.getAttribute("acc");
            Double total = (Double) session.getAttribute("total");
            OrderDB odb = new OrderDB();
            CartDB cdb = new CartDB();
            SendEmail sm = new SendEmail();
            Cart1 cart1 = (Cart1) session.getAttribute("cartID");
            CartDetailDB cdtdb = new CartDetailDB();
            try {
                odb.insertOrder(order);
            } catch (SQLException ex) {
                Logger.getLogger(CheckOut.class.getName()).log(Level.SEVERE, null, ex);
            }
            for (Cart c : listCart) {
                OrderDetails orderDetails = new OrderDetails();
                orderDetails.setIdOrder(order.getIdOrder());
                orderDetails.setIdProduct(c.getIdProduct());
                orderDetails.quantityProduct(c.getQuantityProduct());
                orderDetails.setPriceDetails(c.getPrice() * c.getQuantityProduct());
                OrderDetailsDB detailsdb = new OrderDetailsDB();
                boolean result = detailsdb.insertOrderDetails(orderDetails);
                if (!result) {
                    break;
                }
            }
            listCart.clear();
            cdtdb.deleteAll(cart1.getIdCart());
            session.removeAttribute("cart_list");
            AccountDB adb = new AccountDB();
            double totalOrder = odb.getTotalOrder(acc.getIdAccount());
            int royal = 0;
            double discount = 0;
            if (totalOrder < 500000) {
                royal = 1;
            } else if (totalOrder > 500000 && totalOrder < 2000000) {
                royal = 2;
            } else if (totalOrder > 2000000 && totalOrder < 5000000) {
                royal = 3;
            } else if (totalOrder > 5000000) {
                royal = 4;
            }
            acc.setRoyal(royal);
            adb.updateRoyal(acc.getIdAccount(), acc.getRoyal());
            request.setAttribute("alert", "Your order has been successfully placed, the product will be delivered to you quickly. Check your email for details.");
            boolean send = sm.CheckOut(order.getIdOrder(), acc.getEmail());
            int size = listCart.size();
            session.setAttribute("size", size);
        } else {
            request.setAttribute("alert", "Your order has failed!!!");
        }
        request.getRequestDispatcher("Success.jsp").forward(request, response);
    }
}
