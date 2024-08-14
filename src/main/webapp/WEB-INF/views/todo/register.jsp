<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/todo/register" method="post">
    <div>
        Title : <input type="text" name="title">
    </div>
    <div>
        DueDate : <input type="date" name="dueDate" value="2024-08-14">
    </div>
    <div>
        Writer : <input type="text" name="writer">
    </div>
    <div>
        <button type="submit">등록</button>
    </div>
</form>
</body>
</html>
