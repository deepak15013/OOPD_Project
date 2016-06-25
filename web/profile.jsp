<%@ page import="in.deepaksood.databasehelper.DatabaseHelper" %><%--
  Created by IntelliJ IDEA.
  User: deepaksood619
  Date: 25/6/16
  Time: 11:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html >
<head>
    <meta charset="UTF-8">
    <title>Profile view</title>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link  rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Roboto" />


    <link rel="stylesheet" href="css/normalizeprofile.css">


    <link rel="stylesheet" href="css/styleprofile.css">

</head>

<body>

<!-- this is the markup. you can change the details (your own name, your own avatar etc.) but don’t change the basic structure! -->

<aside class="profile-card">

    <header>

        <%
            String name = (String) request.getAttribute("NAME");
            String email = (String) request.getAttribute("EMAIL");
            String dob = (String) request.getAttribute("DOB");
            String gender = (String) request.getAttribute("GENDER");

            String[] temp = email.split("\\.");
            String fileName = temp[0]+".jpg";
        %>

        <!-- here’s the avatar -->
        <img src="/profilepics/<%out.println(fileName);%>" />

        <!-- the username -->
        <h1><% out.println(name); %></h1>

        <!-- and role or location -->
        <h2><% out.println(email); %></h2>
        <h4><% out.println(dob); %></h4>
        <h4><% out.println(gender); %></h4>

    <%
        String userEmail = (String) request.getSession().getAttribute("USER_EMAIL");
        if(userEmail.equalsIgnoreCase(email)) {
            out.println("<h2>");
            out.println("Hey! Its your Profile!");
            out.println("<h2>");
        } else {
            String query = "SELECT * FROM friendlist WHERE email=\""+userEmail+"\" AND friendemail=\""+email+"\"";
            Boolean exists = DatabaseHelper.shared().checkIfExists(query);
            if(exists) {

                out.println("<form method=\"post\" action=\"unfriendservlet\">");
                out.println("<input type=\"submit\" value=\"Unfriend\">");
                out.println("<input type=\"hidden\" name=\"TO_EMAIL\" value=\""+email+"\">");
                out.println("</form>");

            } else {
                query = "SELECT * FROM friendrequest WHERE fromemail=\""+userEmail+"\" AND toemail=\""+email+"\"";
                exists = DatabaseHelper.shared().checkIfExists(query);
                if(exists) {
                    out.println("<h2>");
                    out.println("Friend request sent");
                    out.println("<h2>");
                }
                else {
                    out.println("<form method=\"post\" action=\"sendfriendrequest\">");
                    out.println("<input type=\"submit\" value=\"Send Friend Request\">");
                    out.println("<input type=\"hidden\" name=\"TO_EMAIL\" value=\""+email+"\">");
                    out.println("</form>");
                }
            }
        }
    %>

    </header>

</aside>
<!-- that’s all folks! -->

</body>
</html>

