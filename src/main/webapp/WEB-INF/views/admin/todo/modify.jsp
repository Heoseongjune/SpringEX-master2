<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<body>
<div class="card-body">
    <form action="/admin/todo/modify" method="post">
        <div class="input-group mb-3">
            <span class="input-group-text">번호</span>
            <input type="text" name="tno" class="from-control" value="${dto.tno}" readonly>
        </div>
        <div class="input-group- mb-3">
            <span class="input-group-text">제목</span>
            <input type="text" name="title" class="form-control" value="${dto.title}">
        </div>
        <div class="input-group- mb-3">
            <span class="input-group-text">작성일자</span>
            <input type="date" name="dueDate" class="form-control" value="${dto.dueDate}">
        </div>
        <div class="input-group- mb-3">
            <span class="input-group-text">작성자</span>
            <input type="text" name="writer" class="form-control" value="${dto.writer}">
        </div>
        <div class="form-check">
            <label class="form-check-label">
                Finished &nbsp;
            </label>
            <input type="checkbox" name="finished" ${dto.finished?"checked":""} class="form-check-input">
        </div>
        <div class="my-4">
            <div class="float-end">
                <button class="btn btn-primary" type="button">수정</button>
                <button class="btn btn-danger" type="button">삭제</button>
                <button class="btn btn-secondary" type="button">목록보기</button>
            </div>
        </div>
        <input type="hidden" name="page" value="${pageRequestDTO.page}">
        <input type="hidden" name="size" value="${pageRequestDTO.size}">
    </form>
</div>
<script>
    const formObj = document.querySelector("form")
    document.querySelector(".btn-primary").addEventListener("click",
        (e) => {
            e.preventDefault()
            e.stopPropagation()
            formObj.action = "/admin/todo/modify"
            formObj.method = "post"
            formObj.submit();
        }, false)

    document.querySelector(".btn-secondary").addEventListener("click",
        (e) => {
            self.location = "/admin/todo/list?${pageRequestDTO.link}";
        }, false)
    document.querySelector(".btn-danger").addEventListener("click",
        (e) => {
            e.preventDefault()
            e.stopPropagation()//역으로 전파를 못하게함.
            formObj.action = "/admin/todo/remove?${pageRequestDTO.link}"
            formObj.method = "post"
            formObj.submit();
        }, false)


    const serverValiResult = {}
    <c:forEach items="${errors}" var = "error">
    serverValiResult['${error.getField()}'] = '${error.defaultMessage}'
    </c:forEach>
    console.log(serverValiResult)
    let errorMessages = "";
    for (const field in serverValiResult) {
        if (serverValiResult.hasOwnProperty(field)) {
            errorMessages += field + ":" + serverValiResult[field] + "\n"
            <%--errorMessages +='${field} : ${serverValidResult[field]}\n'--%>
        }
    }
    if (errorMessages) {
        alert("검증 에러들: \n" + errorMessages)
    }

</script>
</body>
</html>
