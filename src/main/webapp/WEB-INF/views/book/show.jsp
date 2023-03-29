<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Show Book Info</title>
</head>
<body>
<p>ID: ${book.id}</p>
<p>AUTHOR: ${book.author}</p>
<p>TITLE: ${book.title}</p>
<p>ISBN: ${book.isbn}</p>
<p>PUBLISHER: ${book.publisher}</p>
<p>TYPE: ${book.type}</p>
</body>
</html>
