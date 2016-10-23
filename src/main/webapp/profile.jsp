<%-- 
    Document   : profile
    Created on : 30-Sep-2016, 14:06:36
    Author     : Ramesh
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uk.ac.dundee.computing.aec.instagrim.stores.*" %>
<!DOCTYPE html>
<html>
    
    <head>
        <title>Instagrim</title>
        <link rel="stylesheet" type="text/css" href="/Instagrim/Styles.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <header>
            <h1><a href ="/Instagrim">InstaGrim</a> </h1>
            <h2>Your Profile!</h2>
        </header>
        <nav>
            <ul>

               
                <li><a href="/Instagrim/Upload">Change Profile Picture</a></li>
                    <%
                        
                        LoggedIn lg = (LoggedIn) session.getAttribute("LoggedIn");
                        if (lg != null) {
                            String UserName = lg.getUsername();
                            String Email = lg.getEmail();
                            if (lg.getlogedin()) {
                    %>

                <li><a href="/Instagrim/Images/<%=lg.getUsername()%>">Your Images</a></li>
                    <%}
                            }else{
                                %>
                 <li><a href="/Instagrim/Register">Register</a></li>
                <li><a href="/Instagrim/login">Login</a></li>
                <li><a href="/Instagrim/SignOut">Sign Out</a></li>
                <%                   
                    }%>
            </ul>
        </nav>
            
           
        <footer>
            <ul>
                <li class="footer"><a href="/Instagrim">Home</a></li>
                <li>&COPY; Andy Cobley & Ramesh Khairandish!</li>
                <li>Username: <%=lg.getUsername()%></li>
                <li>Email: <%=lg.getEmail()%></li>
            </ul>
                        <%
                        if (lg != null) {
                            if (lg.getlogedin()&&lg.gotuserpic) {
                                String pic=(String)session.getAttribute("userprofilepic");
                %>
                            <img src="/Instagrim/Image/<%=pic%>" width="300">
                            <%}}%>
        </footer>
    </body>
</html>

