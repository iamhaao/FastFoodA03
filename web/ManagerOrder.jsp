<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*" %>
<%@include file="/includes/header.jsp" %>
<main class="mt-[80px]">
    <c:forEach var="order" items="${requestScope.manageOrder}">
        <div class="card mb-4">

            <div class="card-body">
                <div class="row ml-auto">
                    <div class="col-lg-2"> 
                        <p>Order ID: #${order.idOrder}</p> <br><!-- comment -->
                        <p>Date : ${order.date}</p>
                    </div>
                    <div class="col-lg-2">
                        <h3 class="h6">Payment Method</h3>
                        <c:if test="${order.method==0}" ><p>Payment Cash <br></c:if>
                        <c:if test="${order.method==1}" ><p>Payment Credit Card <br></c:if>
                        <c:if test="${order.method==2}" ><p>Payment PayPal <br></c:if>
                            Total: $   ${order.price} 

                            <c:if test="${order.status==0 && order.method==0}"><span class="badge bg-danger rounded-pill">NOT PAID</span></p></c:if>
                        <c:if test="${order.status==0 && order.method==1}"><span class="badge bg-success rounded-pill">PAID</span></p></c:if>
                        <c:if test="${order.status==0 && order.method==2}"><span class="badge bg-success rounded-pill">PAID</span></p></c:if>

                        <c:if test="${order.status==1 && order.method==0}"><span class="badge bg-danger rounded-pill">NOT PAID</span></p></c:if>
                        <c:if test="${order.status==1 && order.method==1}"><span class="badge bg-success rounded-pill">PAID</span></p></c:if>
                        <c:if test="${order.status==4 && order.method==1}"><span class="badge bg-success rounded-pill">PAID</span></p></c:if>

                        <c:if test="${order.status==1 && order.method==2}"><span class="badge bg-success rounded-pill">PAID</span></p></c:if>
                        <c:if test="${order.status==4 && order.method==2}"><span class="badge bg-success rounded-pill">PAID</span></p></c:if>
                        <c:if test="${order.status==4 && order.method==0}"><span class="badge bg-danger rounded-pill">NOT PAID</span></p></c:if>
                        <c:if test="${order.status==5}"><span class="badge bg-success rounded-pill">PAID</span></p></c:if>
                        <c:if test="${order.status==2}"><span class="badge bg-success rounded-pill">PAID</span></p></c:if>


                        </div>
                        <div class="col-lg-1">
                            <p>Status
                            <c:if test="${order.status==0}"><span class="badge bg-warning rounded-pill">UNCONFIRM</span></p></c:if>
                        <c:if test="${order.status==1}"><span class="badge bg-info rounded-pill">SHIPPING</span></p></c:if>
                        <c:if test="${order.status==2}"><span class="badge bg-success rounded-pill">DONE</span></p></c:if>
                        <c:if test="${order.status==3}"><span class="badge bg-danger rounded-pill">CANCELLED</span></p></c:if>
                        <c:if test="${order.status==4}"><span class="badge bg-secondary rounded-pill">PREPARING</span></p></c:if>
                        <c:if test="${order.status==5&&order.method==2}"><span class="badge bg-success rounded-pill">DONE</span></p></c:if>
                        <c:if test="${order.status==5&&order.method!=2}"><span class="badge bg-primary rounded-pill">SHIPPING SUCCESS</span></p></c:if>
                        <c:if test="${order.status==6}"><span class="badge bg-primary rounded-pill">Confirm Cancel</span></p></c:if>
                        </div>
                        <div class="col-lg-3 ml-3">
                            <h3 class="h6">Billing address</h3>
                            <address>
                                <strong>Name:${order.name}</strong><br>
                            Address:${order.address}<br>
                            <abbr title="Phone">Phone:</abbr> ${order.phone}
                        </address>
                    </div>
                    <c:if test="${order.status==5 &&order.method!=2}">
                        <div class="col-lg-1">
                            <form action="changeStatusOrder">
                                <input type="hidden" name="id" value="${order.idOrder}">
                                <input type="hidden" name="status" value="2">
                                <input type="hidden" name="role" value="1">
                                <input class=" text-white border p-2 rounded bg-primary mt-3" type="submit" value="Done" >
                            </form>
                        </div>
                    </c:if>
                    <c:if test="${order.status==6}">
                        <div class="col-lg-1">
                            <form action="manageOrder" method="post">
                                <input type="hidden" name="id" value="${order.idOrder}">
                                <input type="hidden" name="status" value="2">
                                <input type="hidden" name="role" value="1">
                                <input class=" text-white border p-2 rounded bg-primary mt-3" type="submit" value="Accept" >
                            </form>
                        </div>
                    </c:if>
                    <div class="col-lg-2">
                        <h3 class="h6">Shipper Information</h3>
                        <address>
                            <strong>Name:${order.shipper}</strong><br>
                            <strong>User name: ${order.idShipper}</strong> 
                        </address>
                    </div>
                    <div class="col-lg">
                        <a class="mx-16" href="inforOrder?id=${order.idOrder}"><svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-6 h-6">
                            <path stroke-linecap="round" stroke-linejoin="round" d="M21 21l-5.197-5.197m0 0A7.5 7.5 0 105.196 5.196a7.5 7.5 0 0010.607 10.607z" />
                            </svg>
                        </a>
                    </div>                   

                </div>
            </div>

        </div><!-- comment -->

    </main>
</c:forEach>
<%@include file="/includes/footer.jsp" %>