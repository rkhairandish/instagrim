<%-- 
    Document   : UsersPics
    Created on : Sep 25, 2016, 23:37:44 PM
    Author     : Ramesh Khairandish
--%>

<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="uk.ac.dundee.computing.aec.instagrim.stores.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Instagrim</title>
        <link rel="stylesheet" type="text/css" href="/Instagrim/Styles.css" />
    </head>
    <body>
        <header>
        
        <h1><a href ="/Instagrim">InstaGrim</a> </h1>
        <h2>Your InstaGrim World!</h2>
        </header>
        
        <nav>
            <ul>
                <li class="nav"><a href="/Instagrim/upload">Upload</a></li>
                <li class="nav"><a href="/Instagrim/profile">Profile</a></li>
                <li class="nav"><a href="/Instagrim/Images/majed">Sample Images</a></li>
                <li class="nav"><a href="/Instagrim/Signout">Sign Out</a></li>
            </ul>
        </nav>
            
        <a href="/Instagrim/Image/<%=p.getSUUID()%>" ><img src="/Instagrim/Thumb/<%=p.getSUUID()%>"></a><br/><%

                look up html tag for texboxes add here 
        %>
        </article>
        <footer>
            <ul>
                <li class="footer"><a href="/Instagrim">Home</a></li>
            </ul>
        </footer>
    </body>
</html>
