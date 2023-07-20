package Controller.User;

import DAO.JobDB;
import Models.JobApply;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5)
public class ApplyJobServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        JobDB jdb=new JobDB();
        int idAccount = Integer.parseInt(request.getParameter("idAccount"));
        boolean result=jdb.checkApply(idAccount);
        if(result==false){
        String uploadPath = "F:\\Summer 2023 ( Ki 5)\\SWP391\\fastfood\\web\\cv"; // Đường dẫn thư mục để lưu tệp PDF
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        
        String email = request.getParameter("email");
        Part filePart = request.getPart("cv");
        String fileName = UUID.randomUUID().toString() + ".pdf"; // Tạo tên tệp duy nhất
        String filePath = uploadPath + File.separator + fileName;
        filePart.write(filePath);
        String cv = "./cv/" + fileName;
        JobApply j = new JobApply(idAccount, email, cv, 0);
        jdb.AddJobApply(j);
        request.setAttribute("alert", "You have successfully submitted your application, please wait for the results from FastBites");
        request.getRequestDispatcher("RegisterShipperForm.jsp").forward(request, response);
        }else{
        request.setAttribute("alert", "You have already registered before and cannot register again");
        request.getRequestDispatcher("RegisterShipperForm.jsp").forward(request, response);
        }
    }
}
