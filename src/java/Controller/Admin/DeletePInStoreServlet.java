/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Admin;

import DAO.ProductDB;
import Models.ProductInStore;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author ACER NITRO
 */
public class DeletePInStoreServlet extends HttpServlet {
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductDB pdb = new ProductDB();
        int storeID = Integer.parseInt(request.getParameter("storeID"));
        int productID = Integer.parseInt(request.getParameter("productID"));
        pdb.deleteProductInStore(productID,storeID);
        List<ProductInStore> productInStores = pdb.getAllPByStore(storeID, 1);
        request.setAttribute("productInStores", productInStores);
        request.getRequestDispatcher("ManagePInStore.jsp").forward(request, response);


    }

}
