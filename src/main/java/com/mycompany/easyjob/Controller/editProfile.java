/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.easyjob.Controller;

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
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Deb
 */
@WebServlet(name = "editProfile", urlPatterns = {"/editProfile"})
public class editProfile extends HttpServlet {

   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
      response.setContentType("text/html;charset=UTF-8");

      try ( PrintWriter out = response.getWriter()) {
         /* TODO output your page here. You may use following sample code. */

         Session hibernetSession = null;
         Transaction tx = null;
         HttpSession session = request.getSession();
         UserTable userTable = (UserTable) session.getAttribute("currentUser");

         String name = request.getParameter("user_name");
         String Ocupation = request.getParameter("occupation");
         String Company = request.getParameter("company");
         String mailId = request.getParameter("mail-id");
         String about = request.getParameter("about");
         String userId = userTable.getEmail_id();
         
         

         if (name == null || name.isBlank() || name.isEmpty()) {

            String error = "Name can't be empty !";
            request.setAttribute("empty", error);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("EditProfile.jsp");
            requestDispatcher.forward(request, response);
            return;
         }

         try {
            hibernetSession = SessionFactoryProvider.getFactory().openSession();
            tx = hibernetSession.beginTransaction();
            String q = "update UserTable set user_name=: userName, occupation=:occupation, Company=: company,"
                    + " other_mailId=: mailId ,aboutUser=:about   where email_id=: id ";

            Query query = hibernetSession.createQuery(q);
            query.setParameter("id", userId);
            query.setParameter("userName", name);
            query.setParameter("occupation", Ocupation);
            query.setParameter("company", Company);
            query.setParameter("mailId", mailId);
            query.setParameter("about", about);
            query.executeUpdate();
            tx.commit();

            System.out.println("saved sucessfully");
            session.setAttribute("success", "Profile Updated Sucessfully..");
            response.sendRedirect("UserProfile.jsp");

         } catch (Exception e) {
            e.printStackTrace();
         } finally {
            hibernetSession.close();
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
