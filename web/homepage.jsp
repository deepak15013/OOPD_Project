<%@ page import="in.deepaksood.servlet.UploadPictureServlet" %>
<%@ page import="in.deepaksood.databasehelper.DatabaseHelper" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: deepaksood619
  Date: 24/6/16
  Time: 9:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Homepage</title>

    <link rel="stylesheet" href="css/homepagestyle.css">

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Responsive HTML5 Website Landing Page for Developers">
    <meta name="author" content="Xiaoying Riley at 3rd Wave Media">
    <link rel="shortcut icon" href="favicon.ico">
    <link href='http://fonts.googleapis.com/css?family=Lato:300,400,300italic,400italic' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
    <!-- Global CSS -->
    <link rel="stylesheet" href="assets/plugins/bootstrap/css/bootstrap.min.css">
    <!-- Plugins CSS -->
    <link rel="stylesheet" href="assets/plugins/font-awesome/css/font-awesome.css">

    <!-- github calendar css -->
    <link rel="stylesheet" href="assets/plugins/github-calendar/dist/github-calendar.css"
    />
    <!-- github acitivity css -->
    <link rel="stylesheet" href="assets/plugins/github-activity/src/github-activity.css">
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/octicons/2.0.2/octicons.min.css">

    <!-- Theme CSS -->
    <link id="theme-style" rel="stylesheet" href="assets/css/styles.css">

    <link rel="stylesheet" href="css/w3.css">

    <script type="text/javascript" src="JS/jquery-1.4.2.min.js"></script>
    <script src="JS/jquery.autocomplete.js"></script>

    <script>
        jQuery(function(){
            $("#search").autocomplete("list.jsp");
        });
    </script>

</head>
<body>

<%
    String message = (String) request.getAttribute("ERROR_MESSAGE");
    if(message != null && !message.equals("")) {
        out.println("<center>");
        out.println(message);
        out.println("</center>");
    }
%>


<header class="header">
        <div class="container">

            <%
                out.println("<img class=\"profile-image img-responsive pull-left\"");
                String imgName = (String) request.getSession().getAttribute("USER_EMAIL");
                String filename = imgName.split("\\.")[0] + ".jpg";
                System.out.println("fileName: "+filename);
                out.println("src=\"profilepics/"+filename+"\" />");

            %>

            <div class="profile-content pull-left">

                <%
                    String sqlQuery = "SELECT firstname, lastname FROM users WHERE email=\""+request.getSession().getAttribute("USER_EMAIL")+"\"";
                    String name = DatabaseHelper.shared().getName(sqlQuery);

                    if(name != null) {
                        out.println("<h1 class=\"name\">");
                        out.println(name);
                        out.println("</h1>");
                    }

                %>
            </div>

            <div id="searchbox">
                <form method="get" action="profileviewservlet">
                    <input type="text" placeholder="search for a friend" id="search" name="search">
                    <input type="submit" value="Search">
                </form>
            </div>

            <form method="post" action="logoutservlet">
                <button type="submit" class="btn btn-cta-primary pull-right" ><i class="fa fa-paper-plane"></i> Log out</button>
            </form>
        </div>
    </header>

    <div id="notification">

        <%
            String friendRequestQuery = "SELECT fromemail FROM friendrequest WHERE toemail=\""+request.getSession().getAttribute("USER_EMAIL")+"\"";
            ArrayList<String> requesterEmail = DatabaseHelper.shared().executeSelect(friendRequestQuery);
            if(requesterEmail != null) {
                for(String string : requesterEmail) {

                    String[] temp = string.split("\\.");
                    String image = temp[0]+".jpg";

                    out.println("<div class=\"w3-card-4\">");
                    out.println("<header class=\"w3-container w3-center\">");
                    out.println("<h4>");
                    out.println("Friend Request");
                    out.println("<br>");
                    out.println(string);
                    out.println("</h4");
                    out.println("</header>");
                    out.println("<img src=\"profilepics/"+image+"\" alt=\"Avatar\" style=\"width:80%\">");
                    out.println("<div class=\"w3-container\">");
                    out.println("<form method=\"post\" action=\"friendrequesthandler\">");
                    out.println("<button type=\"submit\" name=\"accept\" class=\"w3-btn w3-green\">Accept</button>");
                    out.println("<button type=\"submit\" name=\"decline\" class=\"w3-btn w3-red\">Decline</button>");
                    out.println("<input type=\"hidden\" name=\"ACCEPT_EMAIL\" value=\""+string+"\">");
                    out.println("</form>");
                    out.println("</div>");
                    out.println("</div>");
                    out.println("<br>");
                }

                if(requesterEmail.size() == 0) {
                    out.println("No Friend Request");
                }

            }
            else {
                out.println("No Friend Request");
            }
        %>
    </div>

    <div id="friendlist">

        <h4>Friend List</h4>

        <%
            String friendListQuery = "SELECT friendemail FROM friendlist WHERE email=\""+request.getSession().getAttribute("USER_EMAIL")+"\"";
            ArrayList<String> friendsEmail = DatabaseHelper.shared().executeSelect(friendListQuery);
            if(friendsEmail != null) {
                for(String string : friendsEmail) {

                    String[] temp = string.split("\\.");
                    String image = temp[0]+".jpg";

                    out.println("<div class=\"w3-card-4\">");
                    out.println("<header class=\"w3-container w3-center\">");
                    out.println("<h4>");
                    out.println("Friend Request");
                    out.println("<br>");
                    out.println(string);
                    out.println("</h4");
                    out.println("</header>");
                    out.println("<img src=\"profilepics/"+image+"\" alt=\"Avatar\" style=\"width:80%\">");
                    out.println("<div class=\"w3-container\">");
                    out.println("<button class=\"w3-btn w3-green\">View Profile</button>");
                    out.println("</div>");
                    out.println("</div>");
                    out.println("<br>");
                }

                if(friendsEmail.size() == 0) {
                    out.println("Its lonely in here");
                }

            }
            else {
                out.println("Its lonely in here");
            }
        %>

    </div>

    <div id="section" align="center">

        <form action="poststatusservlet" method="post">
            <textarea id="textarea" title="status" placeholder="Post today's status" name="poststatus"></textarea>
            <input type="submit" value="Post Status">
        </form>

    </div>

    <div id="wall" align="center">

    </div>

</body>
</html>
