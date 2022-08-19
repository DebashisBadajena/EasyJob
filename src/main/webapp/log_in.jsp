<%-- 
    Document   : log_in
    Created on : 08-Jun-2022, 8:58:30 PM
    Author     : Deb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="CSS/login.css" />
        <title>LogIn</title>
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
        
        
        
        <!--errormessage-->
        
        <div class="sucess-message">
            <%@include  file="aditionalJSP/errorMessage.jsp"  %>
        </div>
        <div class="sucess-message">
            <%@include  file="aditionalJSP/SucessMessage.jsp"  %>
        </div>
            

        <section>
            <div class="container" >
                <div class="log-in-div">
                    <h1>LogIn</h1>

                    <!--form-->
                    <form action="MainController?name=loginProcess" method="post">
                        <div class="user-name">
                            <h3>Email Id</h3>
                            <input class="input" type="email" name="email_id" required placeholder="Enter Email Id.">
                        </div>
                        <div class="user-name">
                            <h3>Password</h3>
                            <input class="input" type="password"  name="password" required placeholder="Enter Password">
                        </div>

                        <div class="button">
                            <input  type="submit" value="Log In">          
                        </div>
                    </form>
                </div>
                <div class="old-user">
                    <h5>New to <span style="color: #fc2718;">EasyJob</span>?</h5>
                    <h5>&nbsp;<a href="MainController?name=signUp"> Create</a> an Account.</h5>
                </div> 
                <a style="text-decoration: none;
                   color: blueviolet;
                   margin-top: 10px;
                   " href="MainController?name=forgewtPassword" target="_blank"><h5>Forget Password ?</h5></a>
    
                
            </div>
        </section>
    </body>
</html>
