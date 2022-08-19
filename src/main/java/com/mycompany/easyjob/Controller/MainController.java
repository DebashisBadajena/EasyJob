package com.mycompany.easyjob.Controller;

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
@WebServlet(value = "/MainController")
public class MainController extends HttpServlet {

   HttpSession session = null;

   @Override
   public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

      String postButtonName = request.getParameter("name");
//      System.out.println("this is post method1" + postButtonName);
      
      
      if (postButtonName.equalsIgnoreCase("registration")) {
         RequestDispatcher requestDispatcher = request
                 .getRequestDispatcher("registrationServlet");
         requestDispatcher.forward(request, response);
      } else if (postButtonName.equalsIgnoreCase("loginprocess")) {

         RequestDispatcher requestDispatcher = request
                 .getRequestDispatcher("/LogInServlet");
         requestDispatcher.forward(request, response);

      }
      else if (postButtonName.equalsIgnoreCase("submitjob")) {

         RequestDispatcher requestDispatcher = request
                 .getRequestDispatcher("/AddJobServlet"); //AddJobServlet.java
         requestDispatcher.forward(request, response);
      }
      else if (postButtonName.equalsIgnoreCase("saveProfile")) {

         RequestDispatcher requestDispatcher = request
                 .getRequestDispatcher("/editProfile"); //AddJobServlet.java
         requestDispatcher.forward(request, response);
      }
      else if (postButtonName.equalsIgnoreCase("confirmApply")) {

         RequestDispatcher requestDispatcher = request
                 .getRequestDispatcher("/ApplyJobServlet"); //ApplyJobServlet.java (Confirm Application)
         requestDispatcher.forward(request, response);
      }
      else if (postButtonName.equalsIgnoreCase("PasswordRecoveryProcess")) {
         RequestDispatcher requestDispatcher = request
                 .getRequestDispatcher("RecoveryPasswordServlet");
         requestDispatcher.forward(request, response);

      }
      else if (postButtonName.equalsIgnoreCase("changePasswordProcess")) {
         RequestDispatcher requestDispatcher = request
                 .getRequestDispatcher("ChangePasswordServlet");
         requestDispatcher.forward(request, response);

      }
        else if (postButtonName.equalsIgnoreCase("searchJob")) {
         RequestDispatcher requestDispatcher = request
                 .getRequestDispatcher("SearchJobServlet");
         requestDispatcher.forward(request, response);

      }

   }

   @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      String buttonName = request.getParameter("name");

      if (buttonName.equalsIgnoreCase("applyJob")) {
         RequestDispatcher requestDispatcher = request
                 .getRequestDispatcher("ConfirmApplyJob.jsp");
         requestDispatcher.forward(request, response);

      } else if (buttonName.equalsIgnoreCase("editProfile")) {
         RequestDispatcher requestDispatcher = request
                 .getRequestDispatcher("/EditProfile.jsp");
         requestDispatcher.forward(request, response);

      } else if (buttonName.equalsIgnoreCase("home")) {
         session = request.getSession();
//         currentUser is the key of  user stored in session
         session.removeAttribute("currentUser");
         RequestDispatcher requestDispatcher = request
                 .getRequestDispatcher("/index.jsp");
         requestDispatcher.forward(request, response);

      } else if (buttonName.equalsIgnoreCase("login")) {
          session = request.getSession();
//         currentUser is the key of  user stored in session
         session.removeAttribute("currentUser");
         RequestDispatcher requestDispatcher = request
                 .getRequestDispatcher("/log_in.jsp");
         requestDispatcher.forward(request, response);

      } else if (buttonName.equalsIgnoreCase("signup")) {
          session = request.getSession();
//         currentUser is the key of  user stored in session
         session.removeAttribute("currentUser");
         RequestDispatcher requestDispatcher = request
                 .getRequestDispatcher("/sign_up.jsp");
         requestDispatcher.forward(request, response);

      } else if (buttonName.equalsIgnoreCase("logout")) {
         RequestDispatcher requestDispatcher = request
                 .getRequestDispatcher("LogOutServlet");
         requestDispatcher.forward(request, response);

      } else if (buttonName.equalsIgnoreCase("addjob")) {
         RequestDispatcher requestDispatcher = request
                 .getRequestDispatcher("AddJob.jsp");
         requestDispatcher.forward(request, response);

      }else if (buttonName.equalsIgnoreCase("cancelpost")) {
         RequestDispatcher requestDispatcher = request
                 .getRequestDispatcher("UserDashBoard.jsp");
         requestDispatcher.forward(request, response);

      }else if (buttonName.equalsIgnoreCase("userProfile")) {
         RequestDispatcher requestDispatcher = request
                 .getRequestDispatcher("UserProfile.jsp");
         requestDispatcher.forward(request, response);

      }else if (buttonName.equalsIgnoreCase("editprofile")) {
         RequestDispatcher requestDispatcher = request
                 .getRequestDispatcher("EditProfile.jsp");
         requestDispatcher.forward(request, response);

      }else if (buttonName.equalsIgnoreCase("editProfilePicture")) {
         RequestDispatcher requestDispatcher = request
                 .getRequestDispatcher("EditProfilePicture");
         requestDispatcher.forward(request, response);

      }
      else if (buttonName.equalsIgnoreCase("canceleditProfile")) {
         RequestDispatcher requestDispatcher = request
                 .getRequestDispatcher("UserProfile.jsp");
         requestDispatcher.forward(request, response);

      }
      else if (buttonName.equalsIgnoreCase("editJob")) {
         RequestDispatcher requestDispatcher = request
                 .getRequestDispatcher("PostJobDetails.jsp");
         requestDispatcher.forward(request, response);

      }
      else if (buttonName.equalsIgnoreCase("dashBoard")) {
         RequestDispatcher requestDispatcher = request
                 .getRequestDispatcher("UserDashBoard.jsp");
         requestDispatcher.forward(request, response);

      }
      else if (buttonName.equalsIgnoreCase("shortlistCandidate")) {
         RequestDispatcher requestDispatcher = request
                 .getRequestDispatcher("ShortListingCandidateServlet");
         requestDispatcher.forward(request, response);

      }
      else if (buttonName.equalsIgnoreCase("deleteJob")) {
         RequestDispatcher requestDispatcher = request
                 .getRequestDispatcher("DeleteJobServlet");
         requestDispatcher.forward(request, response);

      }
      else if (buttonName.equalsIgnoreCase("forgewtPassword")) {
         RequestDispatcher requestDispatcher = request
                 .getRequestDispatcher("ForgetPassword.jsp");
         requestDispatcher.forward(request, response);

      }
    
      

   }
}
