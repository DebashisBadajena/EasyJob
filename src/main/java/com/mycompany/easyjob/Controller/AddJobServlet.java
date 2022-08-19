/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.easyjob.Controller;

import com.mycompany.easyjob.Controller.dao.JobDAO;
import com.mycompany.easyjob.Controller.entity.JobTable;
import com.mycompany.easyjob.Controller.entity.UserTable;
import com.mycompany.easyjob.Controller.hibernate.SessionFactoryProvider;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Deb
 */
@WebServlet(name = "AddJobServlet", urlPatterns = {"/AddJobServlet"})
public class AddJobServlet extends HttpServlet {

   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
      response.setContentType("text/html;charset=UTF-8");
      try ( PrintWriter out = response.getWriter()) {

         HttpSession httpSession = request.getSession();
         UserTable userTable = (UserTable) httpSession.getAttribute("currentUser");

         /* TODO output your page here. You may use following sample code.*/
         String titel = request.getParameter("titel");
         String experience = request.getParameter("experience");
         String Qualification = request.getParameter("qualification");
         String Company = request.getParameter("company");
         String description = request.getParameter("description");
         String otherMailID=request.getParameter("othermailId");
         
         
         String userMailId = userTable.getEmail_id();

         String JobId = (String) JobDAO.getJobId(userTable.getUser_name());
         String time = (String) JobDAO.getTime();
         String date = (String) JobDAO.getDate();

         if (titel.isEmpty() || experience.isEmpty() || Qualification.isEmpty() || Company.isEmpty() || description.isEmpty() ||otherMailID.isEmpty()) {
            httpSession.setAttribute("error", "All Fields are required");
            response.sendRedirect("AddJob.jsp");

         } else {


            Session hibernateSession = null;
            try {
               
               JobTable job=new JobTable(JobId, userMailId, time, date, titel, experience, Qualification, description, Company, otherMailID);
               
               hibernateSession = SessionFactoryProvider.getFactory().openSession();
               Transaction transaction = hibernateSession.beginTransaction();

                hibernateSession.save(job);

               transaction.commit();

               //sucess message forwarding to sign up page
               httpSession.setAttribute("success", "Post added Sucessfully ...");
               response.sendRedirect("UserDashBoard.jsp");


            } catch (Exception e) {
               e.printStackTrace();
            } finally {
               hibernateSession.close();

            }

         }

      }
   }

   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
      processRequest(request, response);
   }

   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
      processRequest(request, response);
   }

   @Override
   public String getServletInfo() {
      return "Short description";
   }// </editor-fold>

}
