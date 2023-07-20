/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Admin;

import DAO.RevenueDB;
import Models.Product;
import Models.Revenue;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class ManageRevenueServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            RevenueDB rdb = new RevenueDB();
            HttpSession session = request.getSession();

            int storeID = Integer.parseInt(request.getParameter("storeID"));
            String year = request.getParameter("year");
            double persent = 50;
            if (storeID == 0) {
                List<Revenue> revenuesStore1 = rdb.getAllRevenue(1, year);
                List<Revenue> revenuesStore2 = rdb.getAllRevenue(2, year);
                List<Revenue> revenuesStore3 = rdb.getAllRevenue(3, year);
                request.setAttribute("revenuesStore1", revenuesStore1);
                request.setAttribute("revenuesStore2", revenuesStore2);
                request.setAttribute("revenuesStore3", revenuesStore3);
                List<Product> listBSP = rdb.bestPRevenueY();

                List<Revenue> revenues1 = rdb.getAllRevenueAllStrore(year);
                List<Revenue> revenuesStoreAllAv = rdb.getAllAvRevenueYear(year);
                request.setAttribute("revenuesStoreAllAv", revenuesStoreAllAv);
                request.setAttribute("revenues1", revenues1);
                                request.setAttribute("listBSP", listBSP);

            } else {

                List<Revenue> revenues1 = rdb.getAllRevenue(storeID, year);
                List<Product> listBSP = rdb.bestPRevenue(storeID, year);

                request.setAttribute("revenues1", revenues1);
                request.setAttribute("listBSP", listBSP);

            }

            request.setAttribute("persent", persent);
            request.setAttribute("activeStore", storeID);

            List<Revenue> listRYear = rdb.getAllRevenueYear();
            request.setAttribute("listRevenueYear", listRYear);

            session.setAttribute("yearActive", year);

            request.getRequestDispatcher("ManageRevenue.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
