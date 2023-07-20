<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="./includes/header.jsp" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/boxicons/2.1.0/css/boxicons.min.css" integrity="sha512-pVCM5+SN2+qwj36KonHToF2p1oIvoU3bsqxphdOIWMYmgr4ZqD3t5DjKvvetKhXGc/ZG5REYTT6ltKfExEei/Q==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/MaterialDesign-Webfont/5.3.45/css/materialdesignicons.css" integrity="sha256-NAxhqDvtY0l4xn+YVa6WjAcmd94NNfttjNsDmNatFVc=" crossorigin="anonymous" />
<link rel="stylesheet" href="css/styleManageAccount.css"/>

<div class="container">
    <div class="row align-items-center">
        <div class="col-md-6">
            <div class="mb-3">
                <h5 class="card-title">Account List <span class="text-muted fw-normal ms-2">${requestScope.size}</span></h5>
            </div>
        </div>
        <div class="col-md-6">
            <div class="d-flex flex-wrap align-items-center justify-content-end gap-2 mb-3">
                <div>
                    <ul class="nav nav-pills">
                        <li class="nav-item">
                            <a href="#" class="nav-link" data-bs-toggle="tooltip" data-bs-placement="top" title="List"><i class="bx bx-list-ul"></i></a>
                        </li>
                        <li class="nav-item">
                            <a aria-current="page" href="#" class="router-link-active router-link-exact-active nav-link active" data-bs-toggle="tooltip" data-bs-placement="top" title="Grid"><i class="bx bx-grid-alt"></i></a>
                        </li>
                    </ul>
                </div>

                <div class="dropdown float-end">
                    <a class="text-muted dropdown-toggle font-size-16" href="#" role="button" data-bs-toggle="dropdown" aria-haspopup="true"><i class="bx bx-dots-horizontal-rounded"></i></a>
                    <div class="dropdown-menu dropdown-menu-end"><a class="dropdown-item" href="#">Edit</a><a class="dropdown-item" href="#">Action</a><a class="dropdown-item" href="#">Remove</a></div>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <c:forEach var="acc" items="${requestScope.listAcc}" >
            <div class="col-xl-3 col-sm-6">
                <div class="card">
                    <div class="card-body">
                        <div class="dropdown float-end">
                            <a class="text-muted dropdown-toggle font-size-16" href="#" data-bs-toggle="dropdown" aria-haspopup="true"><i class="bx bx-dots-horizontal-rounded"></i></a>
                            <div class="dropdown-menu dropdown-menu-end">
                                <a class="dropdown-item" href="#">Edit</a>
                                <a class="dropdown-item" href="#">Action</a>
                                <a class="dropdown-item" href="#">Remove</a></div>
                        </div>
                        <div class="d-flex align-items-center">
                            <div><img src="${acc.avatar}" alt="" class="avatar-md rounded-circle img-thumbnail" /></div>
                            <div class="flex-1 ms-3">
                                <h5 class="font-size-16 mb-1"><a href="#" class="text-dark">${acc.name}</a></h5>
                                <c:if test="${acc.idRole==1}"> <span class="badge badge-soft-success mb-0">ADMIN</span></c:if>
                                <c:if test="${acc.idRole==2}"> <span class="badge bg-soft-primary mb-0">USER</span></c:if>
                                <c:if test="${acc.idRole==3}"> <span class="badge badge-soft-danger mb-0">SHIPPER</span></c:if>
                                </div>
                            </div>
                            <div class="mt-3 pt-1">
                                <p class="text-muted mb-0"><i class="mdi mdi-phone font-size-15 align-middle pe-2 text-primary"></i>${acc.phone}</p>
                            <p class="text-muted mb-0 mt-2"><i class="mdi mdi-email font-size-15 align-middle pe-2 text-primary"></i> ${acc.email}</p>
                            <p class="text-muted mb-0 mt-2"><i class="mdi mdi-google-maps font-size-15 align-middle pe-2 text-primary"></i>${acc.address}</p>
                            </div >
                            <c:if test="${acc.idRole!=1}">
                            <c:if test="${acc.idRole!=1 && acc.idRole!=3}"> <p class="text-danger mb-0 mt-2"><i class=" mdi mdi-food font-size-15 align-middle pe-2 text-primary"></i>Loyal Customer: Level ${acc.royal}</p></c:if>
                            
                            <div class=" row d-flex  gap-2 pt-4">
                                <div class="col-sm-4 d-flex"> <c:if test="${acc.active==1}"><a href="profile?id=${acc.username}" class="d-flex"> <i class="bx bx-user me-1"></i> <h6 class="d-flex">Acvtive</h6></a></div>
                                <div class="col-sm-4">
                                    <form action="block"  method="get">
                                        <input type="hidden" name="id" value="${acc.username}">
                                        <input type="hidden" name="action" value="block">
                                        <button class="mb-4" type="submit"><svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-6 h-6">
                                            <path stroke-linecap="round" stroke-linejoin="round" d="M18.364 18.364A9 9 0 005.636 5.636m12.728 12.728A9 9 0 015.636 5.636m12.728 12.728L5.636 5.636" />
                                            </svg></button>
                                    </form>
                                </div>
                            </c:if>
                            <c:if test="${acc.active==0}"><a href="profile?id=${acc.username}" class="d-flex"> <i class="bx bx-user me-1"></i> <h6 class="d-flex">Inacvtive</h6></a></div>
                                <div class="col-sm-4"> <form action="block" method="get">
                                    <input type="hidden" name="id" value="${acc.username}">
                                    <input type="hidden" name="action" value="unblock">
                                    <button class="mb-4" type="submit"><svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-6 h-6">
                                        <path stroke-linecap="round" stroke-linejoin="round" d="M18.364 18.364A9 9 0 005.636 5.636m12.728 12.728A9 9 0 015.636 5.636m12.728 12.728L5.636 5.636" />
                                        </svg></button>
                                </form>
                            </div>
                            </c:if>
                            
                    </div>
                            </c:if>
                </div>
            </div>
        </div>
    </c:forEach>
</div>
<div class="row g-0 align-items-center pb-4">

    <div class="col-sm-6">
        <div class="float-sm-end">
            <ul class="pagination mb-sm-0">
                <li class="page-item disabled">
                    <a href="#" class="page-link"><i class="mdi mdi-chevron-left"></i></a>
                </li>
                <li class="page-item active"><a href="#" class="page-link">1</a></li>
                <li class="page-item"><a href="#" class="page-link">2</a></li>
                <li class="page-item"><a href="#" class="page-link">3</a></li>
                <li class="page-item"><a href="#" class="page-link">4</a></li>
                <li class="page-item"><a href="#" class="page-link">5</a></li>
                <li class="page-item">
                    <a href="#" class="page-link"><i class="mdi mdi-chevron-right"></i></a>
                </li>
            </ul>
        </div>
    </div>
</div>
<script src="./js/popper.min.js"></script>
<%@include file="../includes/footer.jsp" %>
