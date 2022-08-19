<%-- 
    Document   : errorMessage
    Created on : 19-Jun-2022, 1:47:49 PM
    Author     : Deb
--%>

<%

   String Errormsg = (String) session.getAttribute("error");

   if (Errormsg != null) {

   %> 
   <div 
       style="
        color: aliceblue;
        display: flex;
        justify-content: center;
        background-color: #fc2718;
        margin: 10px 250px;
        border-radius: 5px;">
                <p style="padding: 10px"><%= Errormsg %></p>

            </div>
   
<%
      session.removeAttribute("error");
     
                    
   }

%>
