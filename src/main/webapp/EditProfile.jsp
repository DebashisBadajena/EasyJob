<%-- 
    Document   : EditProfile
    Created on : 26-Jun-2022, 3:55:50 PM
    Author     : Deb
--%>

<%@page import="com.mycompany.easyjob.Controller.hibernate.SessionFactoryProvider"%>
<%@page import="com.mycompany.easyjob.Controller.dao.UserDAO"%>
<%@page import="com.mycompany.easyjob.Controller.entity.UserTable"%> 
<%

   UserTable userTable = (UserTable) session.getAttribute("currentUser");
   if (userTable == null) {
      session.setAttribute("error", "Unauthorized access !");
      response.sendRedirect("log_in.jsp");

      return;
   }


%>

<%   UserDAO uDudao = new UserDAO(SessionFactoryProvider.getFactory());
   UserTable ut = uDudao.getUser(userTable.getEmail_id());

   String userName = ut.getUser_name();
   String Occupation = ut.getOccupation();
   String company = ut.getCompany();
   String mailId = ut.getOther_mailId();
   String about = ut.getAboutUser();
   if (userName == null) {
      userName = "";
   }
   if (Occupation == null) {
      Occupation = "";
   }
   if (company == null) {
      company = "";
   }
   if (mailId == null) {
      mailId = "";
   }
   if (about == null) {
      about = "";
   }

   String er = (String) request.getAttribute("empty");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>edit profile Page</title>
        <%@include file="components/common_css_js.jsp" %>
        <link rel="stylesheet" href="CSS/component_css.css"/>
        <link rel="stylesheet" href="CSS/editProfile.css"/>
        <script type="text/javascript" src="js/additionalJs.js"></script>
    </head>
    <body>
        <%@include file="components/navBar.jsp" %>


        <div class="edit-profile">
            <div class="edit-profile-form">
                <div>
                    <h2>Edit Profile</h2>
                </div>
                <div class="form" >
                    <div class="form-profile-img">
                        <img id="preview-img"  src="https://as1.ftcdn.net/v2/jpg/03/46/83/96/1000_F_346839683_6nAPzbhpSkIpb8pmAwufkC7c5eD7wYws.jpg"
                             width="200" height="200">              
                    </div>
                    <form method="post" action="MainController?name=saveProfile">
                        <div class="form-row">
                            <input type="file" id="input-icon" name="input-profile-pic" accept="image/*" onchange="showImage(event)"
                                   style="display: none;
                                   border: none" >
                            <label style="font-weight: bold;
                                   padding-left:60%;
                                   font-size: 25px;
                                   text-decoration: underline;"
                                   for="input-icon">&#9998;</label>

                        </div>

                        <div class="form-row">
                            <label> Name :</label><input name="user_name" type="text"  value="<%= userName%> ">
                        </div>

                        <div>
                            <%
                               if (er != null) {
                            %>

                            <p style="color: #fc2718;
                               text-align: center;
                               padding: 0;
                               margin: 0" ><%=  er%></p>

                            <%
                               }
                            %>
                        </div>

                        <div class="form-row">
                            <label> Occupation :</label><input name="occupation" type="text" value="<%= Occupation%>">

                        </div>


                        <div class="form-row">
                            <label> Company :</label><input name="company" type="text" value="<%= company%>">
                        </div>
                        <div class="form-row">
                            <label> Mail-Id :</label><input name="mail-id" type="email" value="<%= mailId%>">
                        </div>
                        <div class="form-row">
                            <label> About :</label><br><textarea name="about" id="" cols="30" rows="10" maxlength="1500" ><%= about%> </textarea>
                        </div>
                        <div class="save-button">
                            <input type="submit" value="Save">   
                            <a href="MainController?name=cancelEditProfile" style="text-decoration: none;"><p>Cancel</p> </a>
                        </div>

                    </form>
                </div>
            </div>
        </div>

        <script>





        </script>

    </body>
</html>
