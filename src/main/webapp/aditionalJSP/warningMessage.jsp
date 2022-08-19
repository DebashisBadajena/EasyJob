<%-- 
    Document   : warningMessage
    Created on : 16-Jul-2022, 7:42:30 PM
    Author     : Deb
--%>

<%

   String warnMsg = (String) session.getAttribute("warning");

   if (warnMsg != null) {

   %> 
   <div
                style="
                color: aliceblue;
                display: flex;
                justify-content: center;
                background-color: orange;
                margin: 10px 250px;
                border-radius: 5px;
                "
                >
                <p style="padding: 10px"><%= warnMsg %></p>

            </div>
   
<%
      session.removeAttribute("warning");
     
                    
   }

%>