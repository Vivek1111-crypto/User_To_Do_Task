<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
 <link rel="stylesheet" href="/css/style.css">
</head>
<body>

<h2>User Registration</h2>

<form action="register" method="post">
    Name: <input type="text" name="name"/><br><br>
    Email: <input type="text" name="email"/><br><br>
    Password: <input type="password" name="password"/><br><br>
    Gender: 
    <input type="radio" name="gender" value="Male"/> Male
    <input type="radio" name="gender" value="Female"/> Female<br><br>
    Phone: <input type="text" name="phone"/><br><br>

    <button type="submit">Register</button>
</form>

<p style="color:red;">${msg}</p>

<a href="login">Already have account? Login</a>

</body>
</html>