<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
<script src="/js/bootstrap.bundle.min.js"></script>
<body>
<div class="card-body">
    <form action="/todo/register" method="post">
        <div class="input-group mb-3">
            <span class="input-group-text"> Title :</span>
            <input type="text" name="title" class="form-control" placeholder="Title">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text"> Date :</span>
            <input type="date" name="dueDate" value="2024-08-14" class="form-control" placeholder="dueDate">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text"> Writer :</span>
            <input type="text" name="writer" class="form-control" placeholder="Writer">
        </div>
        <div class="my-4">
            <div class="float-end">
            <button type="submit" class="btn btn-primary">등록</button>
                <button type="reset" class="btn btn-secondary">취소</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
