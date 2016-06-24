<%@ page import="in.deepaksood.servlet.UploadPictureServlet" %>
<%@ page import="javax.xml.crypto.Data" %>
<%@ page import="in.deepaksood.databasehelper.DatabaseHelper" %><%--
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

</head>
<body>

    <header class="header">
        <div class="container">
            <img class="profile-image img-responsive pull-left" src="assets/images/pic.jpg" />
            <div class="profile-content pull-left">

                <%

                %>

                <h1 class="name">Deepak Sood</h1>
            </div>
            <form method="post" action="logoutservlet">
                <button type="submit" class="btn btn-cta-primary pull-right" ><i class="fa fa-paper-plane"></i> Log out</button>
            </form>
        </div>
    </header>

    <div id="notification">
        notification <br>
        area
    </div>

    <div id="friendlist">
        friend <br>
        list
    </div>

    <div id="section" align="center">

        <textarea id="textarea" title="status" placeholder="Post today's status" form="poststatusform"></textarea>
        <form action="poststatusservlet" method="post" id="poststatusform">
            <input type="submit" value="Post Status">
        </form>

    </div>

    <div id="wall" align="center">

    </div>

</body>
</html>
