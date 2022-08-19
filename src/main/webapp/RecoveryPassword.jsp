<%-- 
    Document   : RecoveryPassword
    Created on : 11-Jul-2022, 6:45:04 PM
    Author     : Deb
--%>
<%
   HttpSession httpSession = request.getSession();

   UserTable ut = (UserTable) httpSession.getAttribute("RecoveryUser");
   if (ut == null) {

      session.setAttribute("error", "Unauthorized access !");
      response.sendRedirect("log_in.jsp");

      return;
   }

%>

<%@page import="com.mycompany.easyjob.Controller.entity.UserTable"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/login.css" />

        <title>Recovery Password Page</title>
    </head>
    <body>

        <div class="nav-div">
            <nav>
                <a href="MainController?name=home"
                   ><h1 class="logo">EASY<span style="color: #fc2718">JOB</span></h1></a
                >

                <div>
                    <ul>

                        <a class="login" href="MainController?name=logIn">Log In</a>
                    </ul>
                </div>
            </nav>
        </div>


        <section>
            <div class="container" >
                <div class="log-in-div">
                    <h1>Set Password</h1>

                    <!--form-->
                    <form action="MainController?name=changePasswordProcess" method="post">
                        <div class="user-name">
                            <h3>New Password</h3>
                            <input class="input" type="password" name="password" required placeholder="New Password">
                        </div>
                        <div class="user-name">
                            <h3>Confirm Password</h3>
                            <input class="input" type="password"  name="confirmPassword" required placeholder="Confirm Password">
                        </div>

                        <div class="button">
                            <input  type="submit" value="Submit">          
                        </div>
                    </form>
                     <div style="color:#fc2718;text-align: center;margin: 10px">
                        <%  String error = (String) request.getAttribute("ERROR");
                           if (error != null) {%>
                        <p> <%= error%> </p>

                        <%}
                        %>
                    </div>
                    
                </div>


            </div>
        </section>



    </body>
</html>
