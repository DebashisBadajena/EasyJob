<%-- 
    Document   : sign_up
    Created on : 02-Jun-2022, 9:58:17 PM
    Author     : Deb
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="CSS/sign_up.css" />
        <title>Sign-up</title>
    </head>
    <body>
        <div class="nav-div">
            <nav>
                <a href="MainController?name=home"
                   ><h1 class="logo">EASY<span style="color: #fc2718">JOB</span></h1></a
                >

                <div>
                    <ul>
                        <li><a href="MainController?name=allJobs">All Jobs</a></li>
                        <li><a href="MainController?name=home">Services</a></li>
                        <li><a href="MainController?name=home">About Us</a></li>
                        <li><a href="MainController?name=home">Contact Us</a></li>
                        <a class="login" href="MainController?name=logIn">Log In</a>
                    </ul>
                </div>
            </nav>
        </div>
        <div class="sucess-message">
            <%@include  file="aditionalJSP/SucessMessage.jsp"  %>

        </div>
        <section>


            <div class="container" >


                <div class="old-user">
                    <h1>Already have <span style="color: #fc2718;">an</span> account ? </h1>
                    <div class="login-button">
                        <a href="MainController?name=logIn">Log In</a>

                    </div>

                </div>
                <div class="sign-up-div">
                    <h1>Sign Up</h1>

                    <!--form-->
                    <form action="MainController?name=registration" method="post">
                        <div class="user-name">
                            <h3>Name</h3>
                            <input class="input" type="text" name="userName" placeholder="Enter Name" required>
                        </div>
                        <div class="user-name">
                            <h3>Occupation</h3>
                            <input type="text" class="input" name="occupation" placeholder="Enter your job" required>
                        </div>
                        <div class="user-name">
                            <h3>Mail Id</h3>
                            <input type="email" class="input" name="mailId" placeholder="mail Id" required>
                        </div>
                        <div class="user-name">
                            <h3>Passwords</h3>
                            <input type="password" class="input" name="password" placeholder="Enter Password" required>
                        </div>
                        <div class="user-name">
                            <h3>Confirm Password</h3>
                            <input type="password" class="input" name="reEnter" placeholder="Confirm Password" required>
                        </div>

                        <div class="user-name">
                            <h3>Gender</h3>
                            <input class="radio" type="radio" name="gender" value="male" required>&nbsp;Male &nbsp;&nbsp; 
                            <input class="radio" type="radio" name="gender" value="female" required> &nbsp;Female &nbsp;&nbsp;
                            <input class="radio" type="radio" name="gender" value="other" require>&nbsp;Other &nbsp;&nbsp;
                        </div>
                        <div class="user-name">
                            <h3>Recovery Question</h3>
                            <select style="width: 99%;
                                    padding: 5px 2px;
                                    border-radius: 10px;
                                    background-color: rgb(207, 207, 207);" name="question" >
                                <option value="What city were you born in?">What city were you born in?</option>
                                <option value="What is your oldest sibling’s middle name?">What is your oldest sibling’s middle name?</option>
                                <option value="What was the first concert you attended?">What was the first concert you attended?</option>
                                <option value="What was the make and model of your first car?">What was the make and model of your first car?</option>
                            </select>
                            <input style="margin-top: 10px" type="text" class="input" name="answer" placeholder="Answer...">
                        </div>





                        <div class="button">
                            <input type="submit" value="Register">
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
