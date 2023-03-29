<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edit Selected Book</title>
</head>
<body>
<form:form method="post" modelAttribute="book">
    <form:hidden path="id"/>
    TYPE<form:input path="type"/><form:errors path="type"/>
    ISBN<form:input path="isbn"/><form:errors path="isbn"/>
    PUBLISHER<form:input path="publisher"/><form:errors path="publisher"/>
    TITLE<form:input path="title"/><form:errors path="title"/>
    AUTHOR<form:input path="author"/><form:errors path="author"/>
    <input type="submit">
</form:form>
</body>
</html>
