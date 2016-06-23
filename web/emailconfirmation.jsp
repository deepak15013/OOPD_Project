<%--
  Created by IntelliJ IDEA.
  User: deepaksood619
  Date: 23/6/16
  Time: 8:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Email Confirmation</title>
</head>
<body>

    <form method="post" action="emailconfirmationservlet">

        <input type="text" placeholder="Enter otp" name="txt_otp">

        <input type="submit" value="Next"/>

    </form>

</body>
</html>
