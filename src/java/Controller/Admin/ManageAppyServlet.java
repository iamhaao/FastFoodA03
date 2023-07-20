package Controller.Admin;

import DAO.JobDB;
import Models.JobApply;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

public class ManageAppyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        JobDB jdb=new JobDB();
        List<JobApply> listJob = jdb.getJob();
         session.setAttribute("listJob",listJob); 
        request.getRequestDispatcher("ManageJob.jsp").forward(request, response);
    }


}
