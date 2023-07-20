<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="includes/header.jsp" %>
<main>
    <div class="my-24 text-center">
        <h1>ERROS</h1>
        <h1 class="text-danger">${requestScope.alert}</h1>
    </div >  
</main>


<%@include file="includes/footer.jsp" %>
