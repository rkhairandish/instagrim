<%-- 
    Document   : register.jsp
    Created on : Sep 25, 2016, 23:37:44 PM
    Author     : Ramesh Khairandish 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Instagrim</title>
        <link rel="stylesheet" type="text/css" href="Styles.css" />
    </head>
    <body>
        <header>
        <h1><a href =index.jsp>InstaGrim</a> </h1>
        <h2>Register To Join InstaGrim World! </h2>
        </header>
        <nav>
            <ul>
            </ul>
        </nav>
       
        <article>
            <h3>Please enter details to register as user</h3>
            <form method="POST"  action="Register">
                <ul>
                    <li>Username <input type="text" name="username"></li>
                    <li>First Name <input type="text" name="first_name"></li>
                    <li>Last Name <input type="text" name="last_name"></li>
                     <li>Email <input type="text" name="email"></li>
                    <li>Password <input type="password" name="password"></li>
                    
                </ul>
                <br/>
                <input type="submit" value="Register"> 
            </form>

        </article>
        <footer>
            <ul>
                <li class="footer"><a href="/Instagrim">Home</a></li>
            </ul>
        </footer>
    </body>
</html>
