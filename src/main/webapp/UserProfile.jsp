<%-- 
    Document   : UserProfile
    Created on : 23-Jun-2022, 5:49:18 PM
    Author     : Deb
--%>


<%@page import="com.mycompany.easyjob.Controller.entity.ShortlistedApplicatiionTable"%>
<%@page import="com.mycompany.easyjob.Controller.dao.ShortlistDAO"%>
<%@page import="com.mycompany.easyjob.Controller.dao.UserDAO"%>
<%@page import="com.mycompany.easyjob.Controller.entity.ApplicationTable"%>
<%@page import="com.mycompany.easyjob.Controller.dao.ApplicationDAO"%>
<%@page import="java.util.ListIterator"%>
<%@page import="java.util.List"%>
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


<%
   String Company;
   String about;
   String mailId;
   String UserId = userTable.getEmail_id();
   UserDAO UDAO = new UserDAO(SessionFactoryProvider.getFactory());
   UserTable UTable = UDAO.getUser(UserId);

   if (UTable.getCompany() == null) {
      Company = "Company not mentioned";

   } else {
      Company = UTable.getCompany();
   }

   if (UTable.getAboutUser() == null) {
      about = "";

   } else {
      about = UTable.getAboutUser();
   }

   if (UTable.getOther_mailId() == null) {
      mailId = "";

   } else {
      mailId = UTable.getOther_mailId();
   }

   //user mail id for user identy perposes
   JobDAO jobDAO = new JobDAO(SessionFactoryProvider.getFactory());
   List<JobTable> jobList = jobDAO.getJobById(UserId);
   ApplicationDAO applicationDAO = new ApplicationDAO(SessionFactoryProvider.getFactory());
   List<ApplicationTable> applicationList = applicationDAO.getAppliedJobByUserId(UserId);

   int postNo = jobList.size();
   int shortlistNO;

   ShortlistDAO sDAO = new ShortlistDAO(SessionFactoryProvider.getFactory());
   List<ShortlistedApplicatiionTable> shortList = sDAO.getShortlistTable(UserId);
   shortlistNO = shortList.size();
%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=userTable.getUser_name()%> Profile Page</title>
        <%@include file="components/common_css_js.jsp" %>
        <link rel="stylesheet" href="CSS/component_css.css"/>
        <link rel="stylesheet" href="CSS/userProfile.css"/>
        <link rel="stylesheet" href="CSS/userProfileNavTab.css"/>
        <link rel="stylesheet" href="CSS/jobcard.css"/>

        <style>

            #card:hover{
                background-color: rgb(27, 27, 27);
                transition: 0.5s;

            }

        </style>

    </head>
    <body>
        <%@include file="components/navBar.jsp" %>
        <%@include  file="aditionalJSP/SucessMessage.jsp"  %>

        <div class="user-profile-container">

            <div class="user-profile">

                <div class="user-profile-picture-div">
                    <img src="https://as1.ftcdn.net/v2/jpg/03/46/83/96/1000_F_346839683_6nAPzbhpSkIpb8pmAwufkC7c5eD7wYws.jpg" 
                         alt="Avatar" width="250" height="250">


                </div>
                <div class="user-profile-information">

                    <div class="user-name">
                        <h1><%= UTable.getUser_name()%></h1>
                    </div>
                    <div class="user-post-details">
                        <p><%= postNo%><span style="font-weight: bold; color: #fc2718;padding-left: 5px;">posts</span></p>
                        <p><%= shortlistNO%> <span style="font-weight: bold; color: #fc2718;padding-left: 5px;">shortlisted</span></p>
                    </div>

                    <div class="user-details">

                        <h4><%= Company%></h4>

                        <p><%= UTable.getOccupation()%></p>
                        <div class="about-user-div">
                            <p> <%= about%></p>

                        </div>

                        <%
                           if (mailId.isEmpty()) {
                           } else {
                        %>
                        <p style="color:aliceblue;"><span style="color: rgb(135, 135, 135);">&#9993;</span><%= mailId%></p>

                        <%

                           }
                        %>


                        <a href="MainController?name=editProfile">

                            <button class="edit-button" >Edit</button>
                        </a>

                    </div>


                </div>


            </div>

        </div>

        <!-- nav Tab-->

        <div class="wrapper">
            <input type="radio" name="slider" checked id="application">
            <input type="radio" name="slider" id="shortlist">
            <input type="radio" name="slider" id="posts">

            <nav>
                <label for="application" class="application">Application</label>
                <label for="shortlist" class="shortlist">Shortlist</label>
                <label for="posts" class="posts">Posts</label>

                <div class="slider"></div>
            </nav>
            <section>
                <div class="content content-1">

                    <!--  Application Block-->

                    <%
                       for (int ab = applicationList.size() - 1; ab >= 0; ab--) {
                          ApplicationTable aT = applicationList.get(ab);//ApplicationInfo

                          JobTable jobTable = jobDAO.getJobByJobId(aT.getJobId());//JobInfo
                          String name = null;
                          UserDAO userDAO = new UserDAO(SessionFactoryProvider.getFactory());
                          UserTable utforApplication = userDAO.getUser(jobTable.getUser_mail_id());//userInfo

                    %>


                    <div class="card-div">

                        <div class="card">

                            <div class="card-user-profile">

                                <div class="card-profile-pic">
                                    <img src="https://as1.ftcdn.net/v2/jpg/03/46/83/96/1000_F_346839683_6nAPzbhpSkIpb8pmAwufkC7c5eD7wYws.jpg" 
                                         width="40" height="40"" alt="">
                                </div>
                                <div class="card-user-details">
                                    <h3><%= utforApplication.getUser_name()%></h3>
                                    <h5><%= utforApplication.getOccupation()%></h5>
                                    <h6><%= jobTable.getPost_date()%>&nbsp;<%= jobTable.getPost_time()%></h6>
                                </div>

                            </div>

                            <div class="card-post-details">
                                <div>
                                    <h4><%= jobTable.getPost_titel()%></h4>
                                </div>
                                <div>
                                    <label >Experience :</label><h6><%= jobTable.getExperience()%></h6>
                                </div>
                                <div>
                                    <label >Company :</label><h6><%= jobTable.getCompany()%></h6>
                                </div>
                                <div>
                                    <label >Qualification :</label><h6><%= jobTable.getQualification()%></h6>
                                </div>

                                <label style="margin-left: 5px; ">About :</label> <br><p> <%= jobTable.getPost_description()%><br><br></p>



                                <div>    
                                    <label >&#9993; &nbsp;</label><a> <%= jobTable.getOther_Mail_id()%></a> 
                                </div>


                            </div>

                            <div class="card-apply-time">
                                <!--   <div class="apply">
                                                                     MainController?name=applyJob&jobId=?&userId=? 
                                                                    <a href="" style="
                                                                       text-decoration: none;
                                                                       color: black;">Apply</a>
                                                                </div>-->
                                <div class="time" style="width: 100%">
                                    <h5 >Requested on <%= aT.getApplyDate()%> ,&nbsp; <%= aT.getApplyTime()%>  </h5>
                                </div>

                            </div>


                        </div>


                    </div>

                    <%
                       }
                    %>


                </div>
                <div class="content content-2">
                    <!--Shortlist block-->

                    <%
                       for (int sl = shortList.size() - 1; sl >= 0; sl--) {
                          ShortlistedApplicatiionTable SLAtable = shortList.get(sl);//shortlisted table info of candidate
                          String applicantJobId = SLAtable.getJobId();
                          JobTable jt = jobDAO.getJobByJobId(applicantJobId); //candicate shortlisted job info by candidate Id
                          UserTable Utable = UDAO.getUser((String) jt.getUser_mail_id());


                    %>


                    <div class="card-div">

                        <div class="card">

                            <div class="card-user-profile">

                                <div class="card-profile-pic">
                                    <img src="https://as1.ftcdn.net/v2/jpg/03/46/83/96/1000_F_346839683_6nAPzbhpSkIpb8pmAwufkC7c5eD7wYws.jpg" 
                                         width="40" height="40"" alt="">
                                </div>
                                <div class="card-user-details">
                                    <h3><%= Utable.getUser_name()%></h3>
                                    <h5><%= Utable.getOccupation()%></h5>
                                    <h6><%= jt.getPost_date()%>, <%= jt.getPost_time()%></h6>
                                </div>

                            </div>

                            <div class="card-post-details">
                                <div>
                                    <h4><%= jt.getPost_titel()%></h4>
                                </div>
                                <div>
                                    <label >Experience :</label><h6><%= jt.getExperience()%></h6>
                                </div>
                                <div>
                                    <label >Company :</label><h6><%= jt.getCompany()%></h6>
                                </div>
                                <div>
                                    <label >Qualification :</label><h6><%= jt.getQualification()%></h6>
                                </div>

                                <label style="margin-left: 5px; ">About :</label> <br><p><%= jt.getPost_description()%> <br><br></p>



                                <div>    
                                    <label >&#9993; &nbsp;</label><a><%= jt.getOther_Mail_id()%></a> 
                                </div>


                            </div>

                            <div class="card-apply-time">

                                <div class="time" style="width: 100%">
                                    <h5 >Selected on <%= jt.getPost_date()%>, <%= jt.getPost_time()%> </h5>
                                </div>

                            </div>


                        </div>


                    </div>

                    <% }
                    %>

                </div>
                <div class="content content-3">     
                    <!--  post block-->

                    <%
                       for (int i = jobList.size() - 1; i >= 0; i--) {
                          JobTable j = jobList.get(i);

                    %>

                    <a href="MainController?name=editJob&id=<%= j.getJob_id()%>"
                       style="text-decoration: none; color: rgb(206, 206 ,206)">
                        <div id="card" class="card-post-details" style="margin: 25px;
                             padding: 15px;
                             border-radius:10px;

                             " >

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
                                <label >&#9993; &nbsp;</label><a><%= j.getUser_mail_id()%><//a>
                            </div>


                            <div class="card-apply-time" style="justify-content: right">
                                <h5 style="font-size: 10px">&#10049;&nbsp;<%= j.getPost_date()%>, <%= j.getPost_time()%></h5>



                            </div>
                        </div>
                    </a>

                    <div style="  display: flex;
                         justify-content: center;">

                        <div style="
                             background-color: rgb(206, 206, 206);
                             width: 80%;
                             height: 1px; ">

                        </div>

                    </div>


                    <%
                       }
                    %>

                </div>


        </div>


    </div>



</div>

</section>
</div>         

</body>
</html>
