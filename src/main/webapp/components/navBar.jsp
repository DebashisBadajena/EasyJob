<%-- 
    Document   : navBar
    Created on : 20-Jun-2022, 3:18:41 PM
    Author     : Deb
--%>

<%@page import="com.mycompany.easyjob.Controller.entity.UserTable"%>
<%
   UserTable navUser=(UserTable)session.getAttribute("currentUser");

%>

  <div class="user_nav_bar_div">
        <nav class="user_nav_bar">
            <a href="MainController?name=dashBoard" style="text-decoration: none">
                <h1 class="logo_link" >EASY<span style="color: #fc2718">JOB</span></h1></a>

            <div class="search_div" >
                <form clsaa="search_form" action="MainController?name=searchJob" method="post">
                    <input class="search_field" name="searchInput" type="text" placeholder="search here.." >
                <input class="search_button" type="submit" value="&#10137">
              </form>
            </div>
            
            <div >
              <a class="post_job_button" href="MainController?name=addJob">
                Add Post
              </a>
            </div>

            <div class="user_profile_div">
                <p >Welcome &nbsp;
                    <a style="text-decoration: none;
                       color: rgb(206, 206, 206);" href="MainController?name=userProfile">
                        
                    <span  style="font-weight: bold;">
                        
                        <%= navUser.getUser_name() %> 
                    
                    </span> 
                    </a>
                
                </p>
                <a style="text-decoration: none" href="MainController?name=userProfile">
                    
              <img  class="profile_pic" 
                    
                    src="https://as1.ftcdn.net/v2/jpg/03/46/83/96/1000_F_346839683_6nAPzbhpSkIpb8pmAwufkC7c5eD7wYws.jpg"
                   width="40" height="40">
                    
                </a>
              <a class="log_out" href="MainController?name=logout">Log out</a>

            </div>


        </nav>

    </div>
                        
                        