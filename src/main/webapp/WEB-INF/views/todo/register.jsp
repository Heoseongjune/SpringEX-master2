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
            <span class="input-group-text"> Title :</span>
            <input type="text" name="title" class="form-control" placeholder="Title">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text"> Date :</span>
            <input type="date" name="dueDate" class="form-control" placeholder="dueDate" id="dueDate" value="${today}">
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

        function setTodayDate(){
// 현재 날짜와 시간을 포함한 Date 객체 생성
            const today = new Date();

// 년, 월, 일 추출
            const year = today.getFullYear();
            const month = String(today.getMonth() + 1).padStart(2, '0');  // 월은 0부터 시작하므로 +1
            const day = String(today.getDate()).padStart(2, '0');

// 원하는 형식으로 출력
            const formattedDate = `${year}-${month}-${day}`;

            console.log(formattedDate);  // 예: 2024-08-19

            document.getElementById('dueDate').value=formattedDate;
        }
    </script>
</div>
</body>
</html>
