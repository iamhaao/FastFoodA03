
package Controller;

import DAO.CartDetailDB;
import Models.Cart;
import Models.Cart1;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;


public class ProcessCartServlet extends HttpServlet {

   
    

        @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String action=request.getParameter("action");
       int id=Integer.parseInt(request.getParameter("id")) ;
        HttpSession session=request.getSession();
        Cart1 cart=(Cart1) session.getAttribute("cartID");
        CartDetailDB cdtdb=new CartDetailDB();
        ArrayList<Cart> listCart=(ArrayList<Cart>) session.getAttribute("cart_list");
        int count=0;
        if(action.equals("inc")){
           for (Cart p : listCart) {
               if(p.getIdProduct()==id){
                   int quantity=p.getQuantityProduct();
                   quantity++;
                   p.setQuantityProduct(quantity);
                   cdtdb.updateQuantity(cart.getIdCart(),p.getIdProduct(),p.getQuantityProduct());
                   response.sendRedirect("cart");
               }
           }
       }
       if(action.equals("dec")){
           for (Cart p : listCart) {
               if(p.getIdProduct()==id&&p.getQuantityProduct()>1){
                   int quantity=p.getQuantityProduct();
                   quantity--;
                   p.setQuantityProduct(quantity);
                   cdtdb.updateQuantity(cart.getIdCart(),p.getIdProduct(),p.getQuantityProduct());
                   break;
               } else{
                   listCart.remove(p);
                   cdtdb.deleteProduct(cart.getIdCart(),p.getIdProduct());
                   int size=listCart.size();
                   session.setAttribute("size", size);
                   break;
               }
           }
           response.sendRedirect("cart");
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
