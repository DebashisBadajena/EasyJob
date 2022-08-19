<%-- 
    Document   : ForgetPassword
    Created on : 09-Jul-2022, 10:50:19 AM
    Author     : Deb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/login.css" />
        <title>Forget Password Page</title>
    </head>
    <body>

        <div class="nav-div">
            <nav>
                <a href="MainController?name=home"><h1 class="logo">EASY<span style="color: #fc2718">JOB</span></h1></a>

                <div>
                    <ul>
                        <li><a href="">All Jobs</a></li>
                        <li><a href="">Services</a></li>
                        <li><a href="">About Us</a></li>
                        <li><a href="">Contact Us</a></li>
                        <a class="login" href="MainController?name=signup">Sign Up</a>
                    </ul>
                </div>
            </nav>
        </div>

        <%@include  file="aditionalJSP/errorMessage.jsp"  %>





        <section>
            <div class="container" >
                <div class="log-in-div">
                    <h1>Forget Password</h1>

                    <!--form-->
                    <form action="MainController?name=PasswordRecoveryProcess" method="post">
                        
               
                        

                        <%
                           String question = (String)request.getAttribute("RecoveryQuestion");

                           if (question == null) {
                        %>

                        <div class="user-name">
                            <h3>Email Id</h3>
                            <input class="input" type="email" name="emailId" required placeholder="Enter Email Id.">
                        </div>
                        
                        <% }else{ %>
                        
                        <div class="user-name" style="margin-top: 45px">
                            <p style="font-size: small;
                               margin: 10px;
                               "><%= question %></p>
                            <input type="hidden" name="emailId" value="<%=  (String)request.getAttribute("RecoveryMailId")  %>" >
                            <input class="input"  type="text" name="recoveryAnswer" >


                        </div>

                        <%  }
                        %>


                        <div class="button">
                            <input  type="submit" value="Next">          
                        </div>
                        
                         <div style="color:#fc2718;text-align: center;margin: 10px">
                        <%  String error = (String) request.getAttribute("ERROR");
                           if (error != null) {%>
                        <p> <%= error%> </p>

                        <%}
                        %>
                    </div>
                        
                    </form>
                </div>
                <div class="old-user">
                    <h5>New to <span style="color: #fc2718;">EasyJob</span>?</h5>
                    <h5>&nbsp;<a href="MainController?name=signUp"> Create</a> an Account.</h5>
                </div> 

            </div>
        </section>





    </body>
</html>
