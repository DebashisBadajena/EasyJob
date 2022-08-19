/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.easyjob.Controller;

import com.mycompany.easyjob.Controller.dao.UserDAO;
import com.mycompany.easyjob.Controller.entity.UserTable;
import com.mycompany.easyjob.Controller.hibernate.SessionFactoryProvider;
import java.io.IOException;
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
@WebServlet(name = "registrationServlet", urlPatterns = {"/registrationServlet"})
public class registrationServlet extends HttpServlet {

   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
      response.setContentType("text/html");

      //request object from sign_up.jsp
      String userName = request.getParameter("userName");
      String occupation = request.getParameter("occupation");
      String mailId = request.getParameter("mailId");
      String password = request.getParameter("password");
      String confirmPassword = request.getParameter("reEnter");
      String gender = request.getParameter("gender");
      String Question = request.getParameter("question");
      String answer = request.getParameter("answer");

      //PrintWriter out=response.getWriter();
      // out.print(userName+occupation+mailId+password+confirmPassword+gender);
      UserDAO userDAO = new UserDAO(SessionFactoryProvider.getFactory());
      UserTable ut = userDAO.getUser(mailId);

      if (userName.isEmpty() || occupation.isEmpty() || mailId.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || gender.isEmpty() || Question.isEmpty() || answer.isEmpty()) {

         String error = "All fields are required";
         request.setAttribute("ERROR", error);
         RequestDispatcher requestDispatcher = request.getRequestDispatcher("sign_up.jsp");
         requestDispatcher.forward(request, response);
      } else {

         if (ut != null) {

            String error = "Email address already exist. Try with another one.";
            request.setAttribute("ERROR", error);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("sign_up.jsp");
            requestDispatcher.forward(request, response);

         } else {

            if (password.equals(confirmPassword)) {

               try {
                  UserTable userTable = new UserTable(userName, mailId, occupation, gender, password, Question, answer);
                  Session hibernateSession = SessionFactoryProvider.getFactory().openSession();
                  System.out.println(hibernateSession);
                  Transaction transaction = hibernateSession.beginTransaction();

                  int id = (int) hibernateSession.save(userTable);

                  transaction.commit();
                  hibernateSession.close();

                  //sucess message forwarding to sign up page
                  HttpSession httpSession = request.getSession();
                  httpSession.setAttribute("success", "Registration Sucessfull. Go to Log In Page");
                  response.sendRedirect("sign_up.jsp");

               } catch (Exception e) {
                  e.printStackTrace();
               }

            } else {
               String error = "Password & Confirm Password are not same.";
               request.setAttribute("ERROR", error);
               RequestDispatcher requestDispatcher = request.getRequestDispatcher("sign_up.jsp");
               requestDispatcher.forward(request, response);

            }

         }

      }

   }

   @Override
   public String getServletInfo() {
      return "Short description";
   }// </editor-fold>

}
