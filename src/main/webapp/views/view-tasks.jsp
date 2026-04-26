<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
 <link rel="stylesheet" href="/css/style.css">
</head>
<body>

<h2>Your Tasks</h2>

<table border="1">
    <tr>
        <th>Task Name</th>
        <th>Date</th>
        <th>Time</th>
    </tr>

    <c:forEach var="t" items="${tasks}">
        <tr>
            <td>${t.taskName}</td>
            <td>${t.date}</td>
            <td>${t.time}</td>
        </tr>
    </c:forEach>

</table>

<br>
<a href="dashboard">Back</a>

</body>
</html>