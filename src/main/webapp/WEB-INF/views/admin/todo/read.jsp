<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<body>
<div class="card-body">
    <div class="input-group mb-3">
        <span class="input-group-text">TNO</span>
        <input type="text" name="tno" class="from-control" value="${dto.tno}" readonly>
    </div>
    <div class="input-group- mb-3">
        <span class="input-group-text">Title</span>
        <input type="text" name="title" class="form-control" value="${dto.title}" readonly>
    </div>
    <div class="input-group- mb-3">
        <span class="input-group-text">DueDate</span>
        <input type="text" name="dueDate" class="form-control" value="${dto.dueDate}" readonly>
    </div>
    <div class="input-group- mb-3">
        <span class="input-group-text">Writer</span>
        <input type="text" name="writer" class="form-control" value="${dto.writer}" readonly>
    </div>
    <div class="form-check">
        <label class="form-check-label">
            Finished &nbsp;
        </label>
        <input type="checkbox" name="finished" ${dto.finished?"checked":""} disabled class="form-check-input">
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
            self.location = "/admin/todo/modify?tno=${dto.tno}&${pageRequestDTO.link}"

        }, false)

    document.querySelector(".btn-secondary").addEventListener("click",
        (e) => {
            self.location = "/admin/todo/list?${pageRequestDTO.link}";
        }, false)


</script>
</body>
</html>
