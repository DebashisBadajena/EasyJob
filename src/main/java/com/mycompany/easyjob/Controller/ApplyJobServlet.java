/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.easyjob.Controller;

import com.mycompany.easyjob.Controller.dao.ApplicationDAO;
import com.mycompany.easyjob.Controller.dao.JobDAO;
import com.mycompany.easyjob.Controller.entity.ApplicationTable;
import com.mycompany.easyjob.Controller.entity.JobTable;
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
@WebServlet(name = "ApplyJobServlet", urlPatterns = {"/ApplyJobServlet"})
public class ApplyJobServlet extends HttpServlet {

   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
      response.setContentType("text/html;charset=UTF-8");
      try ( PrintWriter out = response.getWriter()) {
         HttpSession httpSession = request.getSession();

         String jobId = request.getParameter("jobId");
         String userId = request.getParameter("userId");
         String applyDate = ApplicationDAO.getApplyDate();
         String applyTime = ApplicationDAO.getTime();
         String Quaslification=request.getParameter("qualification");
         String Experience=request.getParameter("experience");
         String Description=request.getParameter("description");
         
         
         
         Session hibernetSession = null;
         try {

//            JobDAO jDao=new JobDAO(SessionFactoryProvider.getFactory());
//            JobTable jTable=jDao.getJobByJobId(jobId);
//            String Qualificationn=jTable.getQualification();
//            String experience=jTable.getExperience();
//            
//  
//            
//            experience=experience.replaceAll("[^\\d]"," " );
//            experience=experience.trim();
//            
            
            
            
            
            
            
            hibernetSession = SessionFactoryProvider.getFactory().openSession();
            ApplicationTable applicationTable = 
              new ApplicationTable(jobId, userId, applyDate, applyTime, Quaslification, Experience, Description);
            Transaction transaction = hibernetSession.beginTransaction();

            hibernetSession.save(applicationTable);

            transaction.commit();

            //sucess message forwarding to sign up page
                    
            httpSession.setAttribute(jobId, "Application sent  Sucessfully ...");
            response.sendRedirect("UserDashBoard.jsp");

         } catch (Exception e) {
            e.printStackTrace();
         } finally {
            hibernetSession.close();
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
