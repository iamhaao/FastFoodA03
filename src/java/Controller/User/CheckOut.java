package Controller.User;

import DAO.AccountDB;
import DAO.CartDB;
import DAO.CartDetailDB;
import DAO.OrderDB;
import DAO.OrderDetailsDB;
import DAO.ProductDB;
import DAO.SendEmail;
import DAO.StoreDB;
import Models.Account;
import Models.Cart;
import Models.Cart1;
import Models.Order;
import Models.OrderDetails;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.RandomStringUtils;

public class CheckOut extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        StoreDB sdb = new StoreDB();
        AccountDB adb = new AccountDB();
        int payment = Integer.parseInt(request.getParameter("payment"));
        ArrayList<Cart> listCart = (ArrayList<Cart>) session.getAttribute("cartProducts");
        Account acc = (Account) session.getAttribute("acc");
        Double total = (Double) session.getAttribute("total");
        OrderDB odb = new OrderDB();
        CartDB cdb = new CartDB();
        Cart1 cart1 = (Cart1) session.getAttribute("cartID");
        CartDetailDB cdtdb = new CartDetailDB();
        Order order = getOrder(request, response);
        ProductDB pdb = new ProductDB();
        SendEmail sm = new SendEmail();
        int idStore = (int) session.getAttribute("storeID");
        boolean quantityExceeded = false;
        if (listCart != null && acc != null) {
            for (Cart c : listCart) {
                int quantiyInWeareHouse = pdb.quantityProductOfStore(idStore, c.getIdProduct());
                if (c.getQuantityProduct() > quantiyInWeareHouse) {
                    request.setAttribute("alertOrder", "Products are available of " + c.getName() + "in the  stock only" + quantiyInWeareHouse + "products left");
                    request.getRequestDispatcher("Cart.jsp").forward(request, response);
                    quantityExceeded = true;
                    break;
                }
            }
        }
        if(!quantityExceeded){
        switch (payment) {
            case 0:
                if (listCart != null && acc != null) {
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
                    boolean send = sm.CheckOut(order.getIdOrder(), acc.getEmail());
                    request.setAttribute("alert", "Bạn đã đặt hàng thành công!!! ");
                    response.sendRedirect("Success.jsp");
                    int size = listCart.size();
                    session.setAttribute("size", size);

                } else {
                    if (acc == null) {
                        response.sendRedirect("Login.jsp");
                    } else {
                        response.sendRedirect("Product.jsp");
                    }
                }
                break;
            case 1:
                if (!quantityExceeded) {
                    request.getRequestDispatcher("vnpayajax").forward(request, response);
                } else {

                }
                break;
            case 2:
                if (!quantityExceeded) {
                            session.setAttribute("price_paypal",(Math.ceil((double) total / 23650)));

                    request.getRequestDispatcher("Paypal_pay.jsp").forward(request, response);
                } else {

                }
                  
                break;
        }
        }

    }

    private Order getOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String address = request.getParameter("address");
        int payment = Integer.parseInt(request.getParameter("payment"));
        String Store = request.getParameter("store");
        int idStore;
        switch (Store) {
            case "126 Nguyễn Văn Linh, Vĩnh Trung, Thanh Khê, Đà Nẵng 550000, Việt Nam":
                idStore = 1;
                break;
            case "136 Trần Hưng Đạo, Cửa Nam, Hoàn Kiếm, Hà Nội, Việt Nam":
                idStore = 2;
                break;
            case "283 Đ. Trần Hưng Đạo, Phường Cô Giang, Quận 1, Thành phố Hồ Chí Minh, Việt Nam":
                idStore = 3;
                break;
            default:
                throw new AssertionError();
        }
        Account acc = (Account) session.getAttribute("acc");
        Double total = (Double) session.getAttribute("total");
        String idOrder = RandomStringUtils.randomAlphanumeric(6);
        session.setAttribute("storeID", idStore);
        session.setAttribute("orderId", idOrder);
        Order order = new Order(idOrder, acc.getIdAccount(), formatter.format(date), total, idStore, address, 0, 0, payment);
        session.setAttribute("order", order);
        return order;
    }

}
