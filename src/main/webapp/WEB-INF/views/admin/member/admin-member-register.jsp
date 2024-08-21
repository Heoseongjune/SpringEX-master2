<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="card-body">
    <form action="/todo/register" method="post">
        <div class="input-group mb-3">
            <span class="input-group-text"> ID :</span>
            <input type="text" name="title" class="form-control" placeholder="아이디">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text"> 비밀번호 :</span>
            <input type="password" name="password" class="form-control" placeholder="dueDate" id="password" >
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text"> 비밀번호 :</span>
            <input type="password" name="password" class="form-control" placeholder="dueDate" id="repassword" >
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text"> 이름 :</span>
            <input type="text" name="mname" class="form-control" placeholder="이름">
        </div>
        <div class="my-4">
            <div class="float-end">
            <button type="submit" class="btn btn-primary">등록</button>
                <button type="reset" class="btn btn-secondary">취소</button>
            </div>
        </div>
    </form>

    <script>
        const serverValiResult = {}
        <c:forEach items="${errors}" var = "error">
        serverValiResult['${error.getField()}'] = '${error.defaultMessage}'
        </c:forEach>
        console.log(serverValiResult)
        let errorMessages = "";
        for(const field in serverValiResult){
            if(serverValiResult.hasOwnProperty(field)){
                errorMessages +=field+":"+serverValiResult[field]+"\n"
                <%--errorMessages +='${field} : ${serverValidResult[field]}\n'--%>
            }
        }
        if(errorMessages){
        alert("검증 에러들: \n"+errorMessages)
        }


    </script>
</div>
</body>
</html>
