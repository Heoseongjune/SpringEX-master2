<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>

<html lang="en">

<head>
    <title>병원관리 업무용</title>
    <jsp:include page="layout/admin-common.jsp"/>

</head>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

    <!-- Sidebar -->
    <jsp:include page="layout/admin-sidebar.jsp"/>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="member"></div>
        <jsp:include page="member_list.jsp"/>
        <!-- End of Main Content -->

        <!-- Footer -->
        <jsp:include page="layout/admin-footer.jsp"/>
        <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

</div>
<!-- End of Page Wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>

<!-- Logout Modal-->
<jsp:include page="layout/admin-logout_modal.jsp"/>

<!-- Bootstrap core JavaScript-->
<jsp:include page="layout/admin-bootstrap.jsp"/>

</body>

</html>