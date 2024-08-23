<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<body>
<div class="card-body">
    <div class="input-group mb-3">
        <span class="input-group-text">NO</span>
        <input type="text" name="no" class="from-control" value="${dto.tno}" readonly>
    </div>
    <div class="input-group- mb-3">
        <span class="input-group-text">아이디</span>
        <input type="text" name="mid" class="form-control" value="${dto.mid}" readonly>
    </div>
    <div class="input-group- mb-3">
        <span class="input-group-text">비밀번호</span>
        <input type="text" name="mpw" class="form-control" value="${dto.mpw}" readonly>
    </div>
    <div class="input-group- mb-3">
        <span class="input-group-text">이름</span>
        <input type="text" name="mname" class="form-control" value="${dto.mname}" readonly>
    </div>
    <div class="input-group- mb-3">
        <span class="input-group-text">휴대폰번호</span>
        <input type="text" name="mname" class="form-control" value="${dto.phoneNumber}" readonly>
    </div>
    <div class="my-4">
        <div class="float-end">
            <button class="btn btn-primary" type="button">수정</button>
            <button class="btn btn-secondary" type="button">목록보기</button>
        </div>
    </div>
</div>
<script>

    document.querySelector(".btn-primary").addEventListener("click",
        (e) => {
            self.location = "/admin/member/modify?tno=${dto.tno}&${pageRequestDTO.link}"

        }, false)

    document.querySelector(".btn-secondary").addEventListener("click",
        (e) => {
            self.location = "/admin/member/list?${pageRequestDTO.link}";
        }, false)


</script>
</body>
</html>
