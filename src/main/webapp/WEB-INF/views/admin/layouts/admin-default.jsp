<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>

<html lang="en">

<head>
    <title>병원관리 업무용</title>
    <tiles:insertAttribute name="admin-common"/>

</head>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

    <!-- Sidebar -->
    <tiles:insertAttribute name="admin-sidebar"/>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <tiles:insertAttribute name="admin-body"/>
        <!-- End of Main Content -->

        <!-- Footer -->
        <tiles:insertAttribute name="admin-footer"/>
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
<tiles:insertAttribute name="admin-logout-modal"/>

<!-- Bootstrap core JavaScript-->
<tiles:insertAttribute name="admin-bootstrap"/>

</body>

</html>