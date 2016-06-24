<%--
  Created by IntelliJ IDEA.
  User: deepaksood619
  Date: 22/6/16
  Time: 11:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Information Upload</title>
    <link rel="stylesheet" href="css/normalizeSignup.css">
    <link rel="stylesheet" href="css/styleSignup.css">
</head>
<body>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Registration</title>
    <link rel="stylesheet" href="css/normalize.css">
    <link href='http://fonts.googleapis.com/css?family=Nunito:400,300' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="css/main.css">
</head>
<body>

<form action="uploadpictureservlet" method="post" enctype="multipart/form-data">

    <h1>Upload picture</h1>

    <fieldset>
        <legend><span class="number">1</span>Upload picture</legend>
        Select your image: <input type="file" name="picturefile" id="picturefile" size="50" />

    </fieldset>
    <br>
    <button type="submit">Register</button>
</form>

</body>
</body>
</html>