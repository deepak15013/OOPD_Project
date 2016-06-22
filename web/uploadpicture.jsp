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
    <title>Upload Profile Picture</title>
</head>
<body>

<form method="post" action="uploadpictureservlet"
      enctype="multipart/form-data" >

    Select your image: <input type="file" name="picturefile" size="50" />

    <br/>

    <input type="submit" value="Upload File"/>

</form>

</body>
</html>
