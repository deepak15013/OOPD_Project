<%--
  Created by IntelliJ IDEA.
  User: deepaksood619
  Date: 24/6/16
  Time: 3:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add personal details</title>
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

<form action="savepersonaldetails" method="post">

    <h1>New User Registration</h1>

    <fieldset>
        <legend><span class="number">1</span>Your basic info</legend>
        <label for="first_name">First name:</label>
        <input type="text" id="first_name" name="first_name">

        <label for="last_name">Last name:</label>
        <input type="text" id="last_name" name="last_name">

        <label for="dob">Date of birth</label>
        <input type="date" id="dob" name="dob">

        <label>Gender:</label>
        <input type="radio" id="male" value="male" name="gender"><label for="male" class="light">Male</label><br>
        <input type="radio" id="female" value="female" name="gender"><label for="female" class="light">Female</label><br>
        <input type="radio" id="other" value="other" name="gender"><label for="other" class="light">Other</label>
    </fieldset>

    <br>
    <button type="submit">Next</button>
</form>

</body>
</body>
</html>
