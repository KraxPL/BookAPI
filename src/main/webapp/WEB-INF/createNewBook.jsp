<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create new book</title>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/books/">
    ISBN<input type="text" name="isbn"><br>
    Title<input type="text" name="title"><br>
    Author<input type="text" name="author"><br>
    Publisher<input type="text" name="publisher"><br>
    Type<input type="text" name="bookTopic"><br>
    <input type="submit">

</form>
</body>
</html>