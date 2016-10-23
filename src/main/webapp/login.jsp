<%-- 
    Document   : login.jsp
    Created on : Sep 28, 2014, 12:04:14 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <script>
        function validateForm() {
    var x = document.forms["myForm"]["username"].value;
    var y = document.forms["myForm"]["password"].value;
    if (x == null || x == ""||y == null || y == "") {
        alert("Username and password must be filled out");
        return false;
        }
    }
        </script>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Instagrim</title>
        <link rel="stylesheet" type="text/css" href="Styles.css" />
    </head>
    <body>
        <header>
        <h1><a href ="/Instagrim">InstaGrim</a> </h1>
        <h2>Log Into Your InstaGrim World!</h2>
        </header>
        <article>
            <h3>Login</h3>
            <body>
            <form name="myForm" method="POST"  action="Login" onsubmit="return validateForm()">
                <ul>
                    <li>Username <input type="text" name="username"></li>
                    <li>Password <input type="password" name="password"></li>
                </ul>
                <br/>
                <input type="submit" value="Login"> 
            </form>

        </article>
        <footer>
            <ul>
                <li class="footer"><a href="/Instagrim">Home</a></li> 
            </ul>
        </footer>
    </body>
    
</html>
