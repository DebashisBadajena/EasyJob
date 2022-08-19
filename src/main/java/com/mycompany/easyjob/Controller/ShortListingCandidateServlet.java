/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.easyjob.Controller;

import com.mycompany.easyjob.Controller.dao.ApplicationDAO;
import com.mycompany.easyjob.Controller.dao.ShortlistDAO;
import com.mycompany.easyjob.Controller.entity.ApplicationTable;
import com.mycompany.easyjob.Controller.entity.ShortlistedApplicatiionTable;
import com.mycompany.easyjob.Controller.hibernate.SessionFactoryProvider;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "ShortListingCandidateServlet", urlPatterns = {"/ShortListingCandidateServlet"})
public class ShortListingCandidateServlet extends HttpServlet {

   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
      response.setContentType("text/html;charset=UTF-8");
      try ( PrintWriter out = response.getWriter()) {

         HttpSession httpSession = request.getSession();
         Session hibernateSession = null;

         String candidateId = request.getParameter("candidateId");
         String JobId = request.getParameter("jobId");
         String SelectionTime = ApplicationDAO.getTime();
         String SelectionDate = ApplicationDAO.getApplyDate();
         
         
         try {
            

            
            ShortlistedApplicatiionTable st = new ShortlistedApplicatiionTable(JobId, candidateId, SelectionTime, SelectionDate);

            hibernateSession = SessionFactoryProvider.getFactory().openSession();
            Transaction transaction = hibernateSession.beginTransaction();

            hibernateSession.save(st);

            transaction.commit();

            //Job Id forwarding to post Job Details page
              httpSession.setAttribute("Jobid", JobId);
               response.sendRedirect("PostJobDetails.jsp");
               
             

               
                             

         } 
         catch (Exception e) {
            e.printStackTrace();
         } 
         finally {
            hibernateSession.close();
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
