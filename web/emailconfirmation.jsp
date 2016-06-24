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

<%
    String message = (String) request.getAttribute("ERROR_MESSAGE");
    if(message != null && !message.equals("")) {
        out.println("<center>");
        out.println(message);
        out.println("</center>");
    }
    else {
        out.println("<center>");
        out.println("Please wait for otp. It would take some time to deliver.");
        out.println("</center>");
    }

%>

<div style="text-align: center;">
    <form method="post" action="emailconfirmationservlet">

        <input type="number" placeholder="Enter otp" name="txt_otp">

        <input type="submit" value="Next"/>

    </form>
</div>

</body>
</html>
