<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="./includes/header.jsp" %>
<body>
    <c:set value="${sessionScope.acc}" var="acc" ></c:set>
    <section class="vh-100" style="background-color:  #ffffff;">
        <div class="container h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-xl-9">
                    <p class="text-danger">${requestScope.alert}</p>
                    <form action="applyJob"  enctype='multipart/form-data' method="POST"> 
                        <div class="card" style="border-radius: 15px;">
                            <div class="card-body">

                                <div class="row align-items-center pt-4 pb-3">
                                    <div class="col-md-3 ps-5">

                                        <h6 class="mb-0">Username</h6>

                                    </div>
                                    <div class="col-md-9 pe-5">

                                        <input type="text" name="username" value="${acc.username}" class="form-control form-control-lg" />
                                        <input type="hidden" name="idAccount" value="${acc.idAccount}"/>  
                                    </div>
                                </div>

                                <hr class="mx-n3">

                                <div class="row align-items-center py-3">
                                    <div class="col-md-3 ps-5">

                                        <h6 class="mb-0">Email address</h6>

                                    </div>
                                    <div class="col-md-9 pe-5">

                                        <input type="email" class="form-control form-control-lg" value="${acc.email}" name="email" placeholder="example@example.com" />

                                    </div>
                                </div>

                                <hr class="mx-n3">

                                <div class="row align-items-center py-3">
                                    <div class="col-md-3 ps-5">

                                        <h6 class="mb-0">Upload CV</h6>

                                    </div>
                                    <div class="col-md-9 pe-5">

                                        <input class="form-control form-control-lg " id="formFileLg" type="file" name="cv" />
                                        <div class="small text-muted mt-2">Upload your CV/Resume or any other relevant file. Max file
                                            size 50 MB</div>

                                    </div>
                                </div>

                                <hr class="mx-n3">

                                <div class="px-5 py-4">
                                    <button type="submit" class="btn btn-primary bg-primary btn-lg">Send application</button>
                                </div>
                                </form>
                            </div>
                        </div>

                </div>

            </div>
        </div>
    </section>
</body>

<%@include file="./includes/footer.jsp" %>