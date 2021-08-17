<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>For All</title>
</head>
<body>
Employees must wash hands!
<br><br>
<security:authorize access="hasRole('HR')">
<input type="button" value="HR" onclick="window.location.href = 'hr_info'">
Only HR
</security:authorize>
<br><br>
<security:authorize access="hasRole('Manager')">
<input type="button" value="Managers" onclick="window.location.href = 'manager_info'">
Only Managers
</security:authorize>
</body>
</html>