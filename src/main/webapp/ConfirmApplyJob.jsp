<%-- 
    Document   : ConfirmApplyJob
    Created on : 30-Jun-2022, 8:42:34 AM
    Author     : Deb
--%>


<%@page import="com.mycompany.easyjob.Controller.dao.UserDAO"%>
<%@page import="com.mycompany.easyjob.Controller.entity.JobTable"%>
<%@page import="com.mycompany.easyjob.Controller.hibernate.SessionFactoryProvider"%>
<%@page import="com.mycompany.easyjob.Controller.dao.JobDAO"%>
<%@page import="com.mycompany.easyjob.Controller.entity.UserTable"%>
<%

   UserTable userTable = (UserTable) session.getAttribute("currentUser");
   if (userTable == null) {
      session.setAttribute("error", "Unauthorized access !");
      response.sendRedirect("log_in.jsp");

      return;
   }


%>

<%      String applicantId = request.getParameter("userId");
        String JobId = request.getParameter("jobId");
        String JobProviderId;
        
        JobDAO jDAO=new JobDAO(SessionFactoryProvider.getFactory());
        JobTable jTable=jDAO.getJobByJobId(JobId);
        JobProviderId=jTable.getUser_mail_id();
        
        UserDAO uDAO=new UserDAO(SessionFactoryProvider.getFactory());
        UserTable uTable=uDAO.getUser(JobProviderId);

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="components/common_css_js.jsp" %>
        <link rel="stylesheet" href="CSS/component_css.css"/>
        <link rel="stylesheet" href="CSS/jobcard.css"/>
        <link rel="stylesheet" href="CSS/ConfirmApply.css"/>


        <title>Confirm Application</title>
    </head>
    <body>
        <%@include file="components/navBar.jsp" %>

        <div class="card-div">

            <div class="card"  style="width: 85%" >

                <div class="card-user-profile">

                    <div class="card-profile-pic">
                        <img src="https://as1.ftcdn.net/v2/jpg/03/46/83/96/1000_F_346839683_6nAPzbhpSkIpb8pmAwufkC7c5eD7wYws.jpg" 
                             width="40" height="40"" alt="">
                    </div>
                    <div class="card-user-details">
                        <h3><%=  uTable.getUser_name() %></h3>
                        <h5><%=  uTable.getOccupation() %></h5>
                        <h6><%=  jTable.getPost_date() %></h6>
                    </div>

                </div>

                <div class="card-post-details">
                    <div>
                        <h4><%=  jTable.getPost_titel() %></h4>
                    </div>
                    <div>
                        <label >Experience :</label><h6><%=  jTable.getExperience() %></h6>
                    </div>
                    <div>
                        <label >Company :</label><h6><%=  jTable.getCompany() %></h6>
                    </div>
                    <div>
                        <label >Qualification :</label><h6><%=  jTable.getQualification() %></h6>
                    </div>

                    <label style="margin-left: 5px; ">About :</label> <br><p><%=  jTable.getPost_description() %> <br><br></p>

                    <div>    
                        <label >&#9993; &nbsp;</label><a><%=  jTable.getOther_Mail_id() %></a>
                    </div>


                </div>

                <div class="card-apply-time">

                    <div class="time" style="width: 100%">
                        <h5 >&#10049;<%=  jTable.getPost_time() %></h5>
                    </div>

                </div>


            </div>


        </div>

        <!--applicant confirmation-->



        <div class="confirm-form-div">
            <form action="MainController?name=confirmApply&jobId=<%= JobId  %>&userId=<%= applicantId  %>" method="post">

                <div class="form-qul-exp">
                    <div>
                        <label>Qualification :</label><input type="text" name="qualification" required>
                    </div>

                    <div>
                        <label>Experience :</label><input type="text" name="experience" required>
                    </div>

                </div>


                <div class="description">
                    <label>Description :</label>
                </div>
                <textarea style="color:aliceblue;
                          background-color:#1f1e1e;
                          border-radius: 10px;
                          padding: 10px;
                          " name="description" id="" cols="80" rows="10"  required></textarea>
                <div class="confirm-apply-button">
                    <input  type="submit" value="Apply">
                </div>

            </form>



        </div>

    </body>
</html>
