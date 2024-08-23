<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<body>
<div class="card-body">
    <form action="/admin/member/modify" method="post">
        <div class="input-group mb-3">
            <span class="input-group-text">NO</span>
            <input type="text" name="tno" class="from-control" value="${dto.tno}" readonly>
        </div>
        <div class="input-group- mb-3">
            <span class="input-group-text">아이디</span>
            <input type="text" name="mid" class="form-control" value="${dto.mid}" readonly>
        </div>
        <div class="input-group- mb-3">
            <span class="input-group-text">비밀번호</span>
            <input type="text" name="mpw" class="form-control" value="${dto.mpw}" >
        </div>
        <div class="input-group- mb-3">
            <span class="input-group-text">이름</span>
            <input type="text" name="mname" class="form-control" value="${dto.mname}" >
        </div>
        <div class="input-group- mb-3">
            <span class="input-group-text">휴대폰번호</span>
            <input type="text" name="phoneNumber" class="form-control" value="${dto.phoneNumber}" >
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
            formObj.action = "/admin/member/modify"
            formObj.method = "post"
            formObj.submit();
        }, false)

    document.querySelector(".btn-secondary").addEventListener("click",
        (e) => {
            self.location = "/admin/member/list?${pageRequestDTO.link}";
        }, false)
    document.querySelector(".btn-danger").addEventListener("click",
        (e) => {
            e.preventDefault()
            e.stopPropagation()//역으로 전파를 못하게함.
            formObj.action = "/admin/member/remove?${pageRequestDTO.link}"
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
