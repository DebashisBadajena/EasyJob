<%-- 
    Document   : AddJob
    Created on : 21-Jun-2022, 3:43:31 PM
    Author     : Deb
--%>


<%@page import="com.mycompany.easyjob.Controller.entity.UserTable"%>
<!--checking for user authentation-->
<%

   UserTable userTableAtAddJob = (UserTable) session.getAttribute("currentUser");
   if (userTableAtAddJob == null) {
      session.setAttribute("error", "Unauthorized access !");
      response.sendRedirect("log_in.jsp");

      return;
   }


%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="components/common_css_js.jsp" %>
        <link rel="stylesheet" href="CSS/component_css.css"/>
        <<link rel="stylesheet" href="CSS/add_job_component.css"/>

        <title>Add Job Page</title>
    </head>
    <body>
        <%@include file="components/navBar.jsp" %>
        <%@include  file="aditionalJSP/errorMessage.jsp"  %>


        <div class="add_job_form">
            <div class="form_block">
                <H1>Create Post</H1>
                <div class="input_form_div">


                    <form class="input_form" action="MainController?name=submitJob" method="post">

                        <div class="titel">
                            <h3>Titel :</h3>
                            <input
                                class="input"
                                type="text"
                                name="titel"
                                placeholder="Enter titel"
                                required="required"
                                />
                        </div>
                        <div class="titel">
                            <h3>Experience :</h3>
                            <input
                                class="input"
                                type="text"
                                name="experience"
                                placeholder="Enter Experience"
                                required="required"
                                />
                        </div>
                        <div class="titel">
                            <h3>Qualification :</h3>
                            <input
                                class="input"
                                type="text"
                                name="qualification"
                                required="required"
                                placeholder="Enter Qualification"
                                />
                        </div>
                        <div class="titel">
                            <h3>Company :</h3>
                            <input
                                class="input"
                                required="required"
                                type="text"
                                name="company"
                                placeholder="Enter Company Name"
                                />
                        </div>
                        <div class="titel">
                            <h3>Mail Id :</h3>
                            <input
                                class="input"
                                required="required"
                                type="email"
                                name="othermailId"
                                placeholder="Enter Eamil id"
                                />
                        </div>
                        <div class="titel">
                            <h3>Description :</h3>
                            <textarea  style="height: 200px;"
                                       class="input"
                                       name="description">

                            </textarea>

                        </div>
                        <div class="form_button">
                            <input type="submit" value="Post" />
                            <a class="cancel" href="MainController?name=cancelPost">Cancel</a>
                        </div>
                    </form>
                </div>



            </div>

        </div>

    </body>
</html>
