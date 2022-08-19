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
@WebServlet(name = "ChangePasswordServlet", urlPatterns = {"/ChangePasswordServlet"})
public class ChangePasswordServlet extends HttpServlet {

   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
      response.setContentType("text/html;charset=UTF-8");
      try ( PrintWriter out = response.getWriter()) {

         HttpSession httpSession = request.getSession();
         UserTable ut = (UserTable) httpSession.getAttribute("RecoveryUser");
         String id = ut.getEmail_id();
         String Password = request.getParameter("password");
         String ConfirmPassword = request.getParameter("confirmPassword");

         if (Password.isEmpty() || ConfirmPassword.isEmpty()) {

            System.out.println("password empty");
            String error = "All fields arerequired .";
            request.setAttribute("ERROR", error);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("RecoveryPassword.jsp");
            requestDispatcher.forward(request, response);

         } else {
            if (Password.equals(ConfirmPassword)) {

               UserDAO ud = new UserDAO(SessionFactoryProvider.getFactory());
               ud.updatePassword(id, Password);

               httpSession.setAttribute("success", "Password Updated Sucessfully..");
               response.sendRedirect("log_in.jsp");

            } else {
               String error = "Password and Confirm-Password are not same.";
               request.setAttribute("ERROR", error);
               RequestDispatcher requestDispatcher = request.getRequestDispatcher("RecoveryPassword.jsp");
               requestDispatcher.forward(request, response);

            }

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
