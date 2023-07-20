package Controller.Admin;

import DAO.CatogeryDB;
import DAO.ProductDB;
import Models.Catogery;
import Models.Product;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5)
@WebServlet(name = "ManageProduct", urlPatterns = {"/manageProduct"})
public class ManageProduct extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductDB pdb = new ProductDB();
        List<Product> listProduct = pdb.getAll();
        CatogeryDB cdb = new CatogeryDB();
        List<Catogery> listCtg = cdb.getAll();
        int size = listProduct.size();
        request.setAttribute("size", size);
        request.setAttribute("listCatogery", listCtg);
        request.setAttribute("listProducts", listProduct);
        request.getRequestDispatcher("ManagerProduct.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        switch (action) {
            case "create":
                createProduct(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            case "getProduct":
                getProduct(request, response);
                break;
            case "update":
                update(request, response);
                break;
        }

    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String name = request.getParameter("name");
        int catogery = Integer.parseInt(request.getParameter("catogery"));
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String description = request.getParameter("description");
        String image = "./images/" + uploadImage("image", request);
        Product p = new Product(1, name, description, price, image, catogery, quantity, formatter.format(date));
        ProductDB pdb = new ProductDB();
        pdb.addProduct(p);
        response.sendRedirect("manageProduct");
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("idProduct"));
        ProductDB pdb = new ProductDB();
        pdb.deleteProduct(id);
        response.sendRedirect("manageProduct");
    }

    private String uploadImage(String param, HttpServletRequest request) throws IOException, ServletException {
        String uploadPath = getServletContext().getRealPath("") + File.separator + "images";
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        String filename;

        Part part = request.getPart(param);
        filename = part.getSubmittedFileName();
        if (filename.isEmpty()) {
            return null;
        }
        String uniname = UUID.randomUUID() + "_" + part;
        part.write(uploadPath + File.separator + uniname);
        return uniname;
    }

    private void getProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("idProduct"));
        ProductDB pdb = new ProductDB();
        CatogeryDB cdb = new CatogeryDB();
        Product p = pdb.getProductByID(id);
        List<Catogery> listCatogery = cdb.getAll();
        request.setAttribute("listCatogery", listCatogery);
        request.setAttribute("product", p);
        request.getRequestDispatcher("UpdateProduct.jsp").forward(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        int id = Integer.parseInt(request.getParameter("updateId"));
        int idCatogery = Integer.parseInt(request.getParameter("catogery"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String description = request.getParameter("description");
        String image = "./images/" + uploadImage("image", request);
        ProductDB pdb = new ProductDB();
        Product p = new Product(id, name, description, price, image, idCatogery, quantity, formatter.format(date));
        pdb.updateProduct(p);
        response.sendRedirect("manageProduct");

    }
;

}
