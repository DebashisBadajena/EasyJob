<%-- 
    Document   : SucessMessage
    Created on : 18-Jun-2022, 7:32:56 PM
    Author     : Deb
--%>

<%

   String msg = (String) session.getAttribute("success");

   if (msg != null) {

   %> 
   <div
                style="
                color: aliceblue;
                display: flex;
                justify-content: center;
                background-color: #36d100;
                margin: 10px 250px;
                border-radius: 5px;
                "
                >
                <p style="padding: 10px"><%= msg %></p>

            </div>
   
<%
      session.removeAttribute("success");
     
                    
   }

%>