/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.easyjob.Controller;

import com.mycompany.easyjob.Controller.dao.ApplicationDAO;
import com.mycompany.easyjob.Controller.dao.JobDAO;
import com.mycompany.easyjob.Controller.dao.ShortlistDAO;
import com.mycompany.easyjob.Controller.hibernate.SessionFactoryProvider;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Deb
 */
@WebServlet(name = "DeleteJobServlet", urlPatterns = {"/DeleteJobServlet"})
public class DeleteJobServlet extends HttpServlet {

   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
      response.setContentType("text/html;charset=UTF-8");

      String JobID = (String) request.getParameter("id");
      try ( PrintWriter out = response.getWriter()) {
         /* TODO output your page here. You may use following sample code. */
         HttpSession session = request.getSession();
         try {

            // delete job from JobTable from Database
            JobDAO jd = new JobDAO(SessionFactoryProvider.getFactory());
            jd.deleteJobByJobId(JobID);

            //delete job from applicationTable
            ApplicationDAO ad = new ApplicationDAO(SessionFactoryProvider.getFactory());
            ad.deleteJobByJobId(JobID);

            //delete job from shortlistedTable
            ShortlistDAO sd = new ShortlistDAO(SessionFactoryProvider.getFactory());
            sd.deleteJobByJobId(JobID);

            session.setAttribute("success", "One Job Deleteded Sucessfully..");
            response.sendRedirect("UserProfile.jsp");

         } catch (Exception e) {
            e.printStackTrace();
            
            session.setAttribute("error", "Oops ! Try Again Later");
            response.sendRedirect("UserProfile.jsp");

         } finally {
            
            
         }

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
