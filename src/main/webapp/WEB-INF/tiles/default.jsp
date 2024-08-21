<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="title" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>사이트 제목</title>
    <!-- Page Header -->
    <tiles:insertAttribute name="header"/>
    <style>
        .header {
            background-color: red;
            height: 150px;
        }

        .contents {
            background-color: green;
            height: 500px;
        }

        .footer {
            background-color: blue;
            height: 100px;
        }
    </style>
    <link href="/sb-admin-2/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="/sb-admin-2/css/sb-admin-2.min.css" rel="stylesheet">
</head>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">


    <title:insertAttribute name="sidebar"/>
    <div id="content-wrapper" class="d-flex flex-column">
        <!-- Page Contents -->
        <tiles:insertAttribute name="body"/>

        <!-- Page Footer -->
        <tiles:insertAttribute name="footer"/>

    </div>
    <!-- End of Content Wrapper -->

</div>
<!-- End of Page Wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>
<tiles:insertAttribute name="logout_modal"/>
<tiles:insertAttribute name="bootstrap"/>
<%--<script src="/sb-admin-2/vendor/jquery/jquery.min.js"></script>--%>
<%--<script src="/sb-admin-2/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>--%>

<%--<!-- Core plugin JavaScript-->--%>
<%--<script src="/sb-admin-2/vendor/jquery-easing/jquery.easing.min.js"></script>--%>

<%--<!-- Custom scripts for all pages-->--%>
<%--<script src="/sb-admin-2/js/sb-admin-2.min.js"></script>--%>

<%--<!-- Page level plugins -->--%>
<%--<script src="/sb-admin-2/vendor/chart.js/Chart.min.js"></script>--%>

<%--<!-- Page level custom scripts -->--%>
<%--<script src="/sb-admin-2/js/demo/chart-area-demo.js"></script>--%>
<%--<script src="/sb-admin-2/js/demo/chart-pie-demo.js"></script>--%>
</body>
</html>