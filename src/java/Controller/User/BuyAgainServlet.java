package Controller.User;

import DAO.CartDB;
import DAO.CartDetailDB;
import DAO.OrderDetailsDB;
import Models.Account;
import Models.Cart;
import Models.Cart1;
import Models.OrderDetails;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;

//sua
public class BuyAgainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      String orderID=request.getParameter("id");
        OrderDetailsDB odtdb=new OrderDetailsDB();
        HttpSession session=request.getSession();
        CartDetailDB cdtdb=new CartDetailDB();
        CartDB cartdb=new CartDB();
        Account acc=(Account) session.getAttribute("acc");
        Cart1 idCart=cartdb.checkCart(acc.getIdAccount());
        ArrayList<Cart> cart_list =(ArrayList<Cart>) cdtdb.getCart(idCart.getIdCart());
        ArrayList<Cart> listBuyAgain=odtdb.getBuyAgain(orderID);
         Cart1 cart1=(Cart1) session.getAttribute("cartID");
        for (Cart cart : listBuyAgain) {
            cart_list.add(cart);
            cdtdb.addCartDetail(cart1.toString(), cart.getIdProduct(), cart.getQuantityProduct());
        }
        session.removeAttribute("cart_list");
        session.setAttribute("cart_list", cart_list);
        int size=cart_list.size();
        session.setAttribute("size", size);
        request.getRequestDispatcher("cart").forward(request, response);
    }

}
