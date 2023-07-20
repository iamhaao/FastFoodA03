package Controller.User;

import DAO.CartDB;
import DAO.CartDetailDB;
import Models.Account;
import Models.Cart;
import Models.Cart1;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class AddCartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 List<Cart> listCart = new ArrayList<>();
        CartDB cdb = new CartDB();
        CartDetailDB cdtdb = new CartDetailDB();
        int id = Integer.parseInt(request.getParameter("id"));
        Cart c = new Cart();
        c.setIdProduct(id);
        c.setQuantityProduct(1);
        HttpSession session = request.getSession();
        Account acc = (Account) session.getAttribute("acc");
        ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart_list");
        Cart1 cart1 = (Cart1) session.getAttribute("cartID");
        if (cart_list == null) {
            listCart.add(c);
            cdtdb.addCartDetail(cart1.getIdCart(), c.getIdProduct(), c.getQuantityProduct());
            session.setAttribute("cart_list", listCart);
            response.sendRedirect("products?nameSearch&choose=0");
        } else {
            boolean exist = false;
            listCart=cart_list;
            for (Cart cart : listCart) {
                if (cart.getIdProduct() == id) {
                    exist = true;
                    cart.setQuantityProduct(cart.getQuantityProduct() + 1);
                    cdtdb.updateQuantity(cart1.getIdCart(), cart.getIdProduct(), cart.getQuantityProduct());
                    session.removeAttribute("cart_list");
                    session.setAttribute("cart_list", listCart);
                    int size = listCart.size();
                    session.setAttribute("size", size);
                    response.sendRedirect("products?nameSearch&choose=0");
//                    request.setAttribute("alert", "PRODUCT IS EXIST IN YOUR CART !!!");
//                    request.getRequestDispatcher("Error.jsp").forward(request, response);
//                    break;
                }
            }
            if (!exist) {
                listCart.add(c);
                cdtdb.addCartDetail(cart1.getIdCart(), c.getIdProduct(), c.getQuantityProduct());
                session.removeAttribute("cart_list");
                session.setAttribute("cart_list", listCart);
                response.sendRedirect("products?nameSearch&choose=0");
            }
        }
        int size = listCart.size();
        session.setAttribute("size", size);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
