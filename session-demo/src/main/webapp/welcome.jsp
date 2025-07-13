<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
    <h2>Welcome, ${username}!</h2>
    <a href="logout">Logout</a>
</body>
</html>
 --%>
 
 <!--  below is added after Filter and Listener-->
 
 <%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Welcome</title>
    <script>
        setTimeout(function() {
            window.location.href = 'logout';
        }, 10000);
    </script>
</head>
<body>
    <h2>Welcome, ${username}!</h2>
    <a href="logout">Logout</a>
</body>
</html>
 