/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.easyjob.Controller;

import com.mycompany.easyjob.Controller.dao.UserDAO;
import com.mycompany.easyjob.Controller.entity.UserTable;
import com.mycompany.easyjob.Controller.hibernate.SessionFactoryProvider;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "RecoveryPasswordServlet", urlPatterns = {"/RecoveryPasswordServlet"})
public class RecoveryPasswordServlet extends HttpServlet {

   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
      response.setContentType("text/html;charset=UTF-8");
      try ( PrintWriter out = response.getWriter()) {
         UserDAO ud = new UserDAO(SessionFactoryProvider.getFactory());
         HttpSession httpSession = request.getSession();

         String MailId = request.getParameter("emailId");
         String RecoveryAnswer = request.getParameter("recoveryAnswer");

         httpSession.setAttribute("currentUserId", MailId);

         if (RecoveryAnswer != null) {
            String id = (String) httpSession.getAttribute("currentUserId");

            UserTable uTable = ud.getUserByEmailIdAndAnswer(id, RecoveryAnswer);
            if (uTable != null) {

               httpSession.setAttribute("RecoveryUser", uTable);
               response.sendRedirect("RecoveryPassword.jsp");

            }else{
              httpSession.setAttribute("error", "Matching not found !");
            response.sendRedirect("ForgetPassword.jsp");
            
            }

         } else if (!MailId.isEmpty()) {

            UserTable ut = ud.getUser(MailId);

            if (ut != null) {
               String question = ut.getQuestion();
               request.setAttribute("RecoveryQuestion", question);
               request.setAttribute("RecoveryMailId", MailId);
               RequestDispatcher requestDispatcher = request.getRequestDispatcher("ForgetPassword.jsp");
               requestDispatcher.forward(request, response);
            } else {
               String error = "Invalid MailId";
               request.setAttribute("ERROR", error);
               RequestDispatcher requestDispatcher = request.getRequestDispatcher("ForgetPassword.jsp");
               requestDispatcher.forward(request, response);

            }

         } else {

            String error = "All fields are required";
            request.setAttribute("ERROR", error);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("ForgetPassword.jsp");
            requestDispatcher.forward(request, response);

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
