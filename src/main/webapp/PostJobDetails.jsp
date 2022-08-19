<%-- 
    Document   : PostJobDetails
    Created on : 29-Jun-2022, 5:01:28 PM
    Author     : Deb
--%>

<%@page import="com.mycompany.easyjob.Controller.entity.ShortlistedApplicatiionTable"%>
<%@page import="com.mycompany.easyjob.Controller.dao.ShortlistDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mycompany.easyjob.Controller.entity.JobTable"%>
<%@page import="com.mycompany.easyjob.Controller.dao.JobDAO"%>
<%@page import="com.mycompany.easyjob.Controller.dao.UserDAO"%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.easyjob.Controller.entity.ApplicationTable"%>
<%@page import="com.mycompany.easyjob.Controller.hibernate.SessionFactoryProvider"%>
<%@page import="com.mycompany.easyjob.Controller.dao.ApplicationDAO"%>
<%@page import="com.mycompany.easyjob.Controller.entity.UserTable"%>
<%

   UserTable userTable = (UserTable) session.getAttribute("currentUser");
   if (userTable == null) {
      session.setAttribute("error", "Unauthorized access !");
      response.sendRedirect("log_in.jsp");

      return;
   }
%>
<%
   String id = (String) request.getParameter("id"); //job Id
   String JobId = (String) session.getAttribute("Jobid");
   List<ApplicationTable> applicantList = new ArrayList<>();
   JobTable jTable = null;
   String FinalJobId = null;

   ApplicationDAO aDAO = new ApplicationDAO(SessionFactoryProvider.getFactory());
   if (id != null) {

      FinalJobId = id;
   } else if (JobId != null) {
      FinalJobId = JobId;

   } else {
      session.setAttribute("error", "Incomplete access !");
      response.sendRedirect("UserProfile.jsp");

   }

   applicantList = aDAO.getApplicantByJobId(FinalJobId);

   JobDAO jDAO = new JobDAO(SessionFactoryProvider.getFactory());
   jTable = jDAO.getJobByJobId(FinalJobId);
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="components/common_css_js.jsp" %>
        <link rel="stylesheet" href="CSS/component_css.css"/>
        <link rel="stylesheet" href="CSS/postJobDetails.css"/>


        <title><%= jTable.getPost_titel()%> job details Page</title>
    </head>
    <body>


        <%@include file="components/navBar.jsp" %>

        <div class="card-post-details" >
            <div >
                <h4 class="post-name"><%= jTable.getPost_titel()%></h4>
            </div>
            <div class="post-info-div">
                <label >Experience :</label><h6><%= jTable.getExperience()%></h6>
            </div>
            <div class="post-info-div">
                <label >Company :</label><h6><%= jTable.getCompany()%> </h6>
            </div>
            <div class="post-info-div">
                <label >Qualification :</label><h6><%= jTable.getQualification()%></h6>
            </div>

            <label style="margin-left: 5px; ">About :</label> <br><p> <%= jTable.getPost_description()%> <br><br></p>

            <div style="display: flex" >    
                <label >&#9993; &nbsp;</label><p><%= jTable.getUser_mail_id()%> </p>
            </div>

            <div class="card-apply-time" style="justify-content: right">
                <h5 style="font-size: 10px">&#10049;&nbsp;<%= jTable.getPost_date()%>, <%= jTable.getPost_time()%></h5>
            </div>
            <div>
                <a class="post-job-details-delete" onclick="deleteJob()" >Delete</a>
            </div>

            
            
        </div>


        <!--            ------------------------------->
        <div style="  display: flex;
             justify-content: center;">

            <div style="
                 background-color: rgb(206, 206, 206);
                 width: 80%;
                 height: 2px; ">

            </div>

        </div>

        <div style="display: flex; color: #fc2718; justify-content: center; margin-top: 65px">
            <h3>Applicant</h3>
        </div>

        <% for (int list = applicantList.size() - 1; list >= 0; list--) {
              ApplicationTable applicationTable = applicantList.get(list);
              UserDAO uDAO = new UserDAO(SessionFactoryProvider.getFactory());
              UserTable uTable = uDAO.getUser((String) applicationTable.getUserId());
              String SelectedCandidate = uTable.getEmail_id();


        %>



        <div class="applicant-div">

            <div class="applicant-profile">
                <div class="applicant-profile-pic">
                    <img src="https://bestprofilepictures.com/wp-content/uploads/2021/04/Awesome-Profile-Pic.jpg"
                         alt="" height="40px" width="40px">
                </div>
                <div class="aplicant-name">
                    <h4><%= uTable.getUser_name()%></h4>
                    <h6><%= uTable.getOccupation()%></h6>

                </div>
            </div>

            <div class="applicant-info-div">

                <div class="applicant-info">
                    <label >Qualification :</label><h6><%= applicationTable.getApplicantQualification()%></h6>
                </div>
                <div class="applicant-info">
                    <label >Experience :</label><h6><%= applicationTable.getApplicantExperience()%></h6>
                </div>

                <div class="about">
                    <label >Description: </label><br>
                    <p> <%= applicationTable.getApplicantDescription()%></p>
                </div>



            </div>

            <div class="applicant-select-button">

                <%
                   ShortlistDAO sDAO = new ShortlistDAO(SessionFactoryProvider.getFactory());
                   List<ShortlistedApplicatiionTable> slist = sDAO.getShortListTAbleByJobIdAndCandidateiD(FinalJobId, SelectedCandidate);
                   ShortlistDAO sdao = new ShortlistDAO(SessionFactoryProvider.getFactory());

                   if (slist.isEmpty()) {
                %>
                <a href="MainController?name=shortlistCandidate&jobId=<%= FinalJobId%>&candidateId=<%= uTable.getEmail_id()%>">Select</a>
                <% }else{
                %>
                <p style="color: #fc2718">Candidate already selected</p>
                <% }
                %>
                <h6><%= applicationTable.getApplyDate()%>, <%= applicationTable.getApplyTime()%></h6>
            </div>
        </div>



        <%   }
        %>

        <script>
                    
        function deleteJob(){
            let msg="Once you press ok, the job will be permanently deleted. You can't retrieve it later.";
            
            if(confirm(msg) == true){
                window.console.log("hello world");
            document.location.href="MainController?name=deleteJob&id=".concat("<%= FinalJobId %>" );
            
            }else{}
            
            
        }
        
        
        
        
        
        </script>
        
        
    </body>
</html>
