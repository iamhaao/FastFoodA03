<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*" %>
<%@include file="/includes/header.jsp" %>
<body>

    <c:set var="job" value="${requestScope.cv}" />
    <div class="row mb-5 justify-content-center">
        <iframe class=" col-sm-8 "  src="${job.cv}" width="800" height="800"></iframe>
    </div>
    <div class="row d-flex justify-content-center mb-5">
        <div class="col-sm-1 mx-5 ">
        <form class="col-sm-1 mx-5" action="viewCV" method="POST">
            <input type="hidden" value="${cv.idAccount}" name="idAccount">
            <input type="hidden" value="${cv.email}" name="email">
            <input type="hidden" value="0" name="status">
            <button class="bg-danger bg-success text-white p-2 border rounded-10" type="submit" value="Cancel">Cancel</button>
        </form>
            </div>
            <div class="col-sm-1 mx-5 ">
        <form  action="viewCV" method="POST">
            <input type="hidden" value="${cv.idAccount}" name="idAccount">
            <input type="hidden" value="${cv.email}" name="email">
            <input type="hidden" value="1" name="status">
            <button class="bg-success text-white p-2 border rounded-10" type="submit" >Accept</button>
        </form>
            </div>
    </div>
</body>
<%@include file="/includes/footer.jsp" %>
