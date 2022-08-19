<%-- 
    Document   : UserDashBoard
    Created on : 13-Jun-2022, 5:57:55 PM
    Author     : Deb
--%>

<%@page import="com.mycompany.easyjob.Controller.dao.ApplicationDAO"%>
<%@page import="com.mycompany.easyjob.Controller.entity.ApplicationTable"%>
<%@page import="com.mycompany.easyjob.Controller.dao.UserDAO"%>
<%@page import="java.util.ListIterator"%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.easyjob.Controller.entity.JobTable"%>
<%@page import="com.mycompany.easyjob.Controller.dao.JobDAO"%>
<%@page import="com.mycompany.easyjob.Controller.hibernate.SessionFactoryProvider"%>
<%@page import="com.mycompany.easyjob.Controller.entity.UserTable"%>
<%

   UserTable userTable = (UserTable) session.getAttribute("currentUser");
   if (userTable == null) {
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
        <title>User Dashboard Page</title>
        <%@include file="components/common_css_js.jsp" %>
        <link rel="stylesheet" href="CSS/component_css.css"/>
        <link rel="stylesheet" href="CSS/jobcard.css"/>


    </head>
    <body>
        <%@include file="components/navBar.jsp" %>
        <%@include  file="aditionalJSP/SucessMessage.jsp"  %>      
        <%@include  file="aditionalJSP/warningMessage.jsp"  %>      

        <%           JobDAO jobDAO = new JobDAO(SessionFactoryProvider.getFactory());
           List<JobTable> list = null;
           List<JobTable> list1 = (List<JobTable>) request.getAttribute("searchReasult");
           
           if(list1!=null){
          
           list=(List<JobTable>) request.getAttribute("searchReasult");
           
           }else{
           list = jobDAO.getJob();
           
           }
           



           List<ApplicationTable> aTable = null;
           System.out.println(list.size());
           String name = null;
           String JobId = null;

           UserDAO userDAO = new UserDAO(SessionFactoryProvider.getFactory());
           ApplicationDAO aDAO = new ApplicationDAO(SessionFactoryProvider.getFactory());

           for (int i = list.size() - 1; i >= 0; i--) {
              JobTable j = list.get(i);
              name = j.getUser_mail_id();
              JobId = j.getJob_id();
              UserTable u = userDAO.getUser(name);
              aTable = aDAO.getApplicationTableByJobIdAndUserId(JobId, name);

        %>

        <!--        job card-->

        <div class="card-div">

            <div class="card">

                <div class="card-user-profile">

                    <div class="card-profile-pic">
                        <img src="https://as1.ftcdn.net/v2/jpg/03/46/83/96/1000_F_346839683_6nAPzbhpSkIpb8pmAwufkC7c5eD7wYws.jpg" 
                             width="40" height="40"" alt="">
                    </div>
                    <div class="card-user-details">
                        <h3><%= u.getUser_name()%></h3>
                        <h5><%= u.getOccupation()%></h5>
                        <h6><%= j.getPost_date()%></h6>
                    </div>

                </div>

                <div class="card-post-details">
                    <div>
                        <h4><%= j.getPost_titel()%></h4>
                    </div>
                    <div>
                        <label >Experience :</label><h6><%= j.getExperience()%></h6>
                    </div>
                    <div>
                        <label >Company :</label><h6><%= j.getCompany()%></h6>
                    </div>
                    <div>
                        <label >Qualification :</label><h6><%= j.getQualification()%></h6>
                    </div>

                    <label style="margin-left: 5px; ">About :</label> <br><p> <%= j.getPost_description()%> <br><br></p>

                    <div>    
                        <label >&#9993; &nbsp;</label><a><%= j.getOther_Mail_id()%><//a>
                    </div>


                </div>

                <div class="card-apply-time">
                    <%
                       if (userTable.getEmail_id().equals(name)) {
                       } else {
                          if (aTable.isEmpty()) {

                    %>

                    <div class="apply">
                        <a href="MainController?name=applyJob&jobId=<%= j.getJob_id()%>&userId=<%= userTable.getEmail_id()%> " style="
                           text-decoration: none;
                           color: black;">Apply</a>
                    </div>




                    <%
                    } else {
                    %>  

                    <p style="color: #36d100;
                       width: 30%">Already Applyed</p>

                    <%
                       }
                    %>    
                    <%
                       }
                    %>    

                    <div class="time" style="width: 100%">
                        <h5 >&#10049; <%= j.getPost_time()%></h5>
                    </div>                  

                </div>



            </div>


        </div>
        <%
           }
        %>


    </body>
</html>
