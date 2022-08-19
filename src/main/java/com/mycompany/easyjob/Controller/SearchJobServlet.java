/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.easyjob.Controller;

import com.mycompany.easyjob.Controller.dao.JobDAO;
import com.mycompany.easyjob.Controller.entity.JobTable;
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

/**
 *
 * @author Deb
 */
@WebServlet(name = "SearchJobServlet", urlPatterns = {"/SearchJobServlet"})
public class SearchJobServlet extends HttpServlet {

   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
      response.setContentType("text/html;charset=UTF-8");
      try ( PrintWriter out = response.getWriter()) {
         HttpSession httpSession = request.getSession();

         String titel = (String) request.getParameter("searchInput");
         if (titel.isEmpty()) {
            response.sendRedirect("UserDashBoard.jsp");

         } else {

            JobDAO jdao = new JobDAO(SessionFactoryProvider.getFactory());
            List<JobTable> list = jdao.getJobByTitel(titel);

            if (!list.isEmpty()) {
               System.out.println("before post reasult" + list);
               request.setAttribute("searchReasult", list);
               RequestDispatcher requestDispatcher = request
                       .getRequestDispatcher("UserDashBoard.jsp");
               requestDispatcher.forward(request, response);

            } else {

               httpSession.setAttribute("warning", "No such reasult found. Try with anothe one..");
               response.sendRedirect("UserDashBoard.jsp");

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
