<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*" %>
<%@include file="/includes/header.jsp" %>
<main class="mt-[80px]">
    <c:forEach var="order" items="${requestScope.listByShipper}">
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
                        <c:if test="${order.method==2}" ><p>Payment PayPal<br></c:if>
                            Total: $   ${order.price} 

                        <c:if test="${order.status==0 && order.method==0}"><p><span class="badge bg-danger rounded-pill">NOT PAID</span></p></c:if>
                        <c:if test="${order.status==0 && order.method==1}"><p><span class="badge bg-success rounded-pill">PAID</span></p></c:if>
                        <c:if test="${order.status==0 && order.method==2}"><p><span class="badge bg-success rounded-pill">PAID</span></p></c:if>
                        <c:if test="${order.status==1 && order.method==0}"><p><span class="badge bg-danger rounded-pill">NOT PAID</span></p></c:if>
                        <c:if test="${order.status==1 && order.method==1}"><p><span class="badge bg-success rounded-pill">PAID</span></p></c:if>
                        <c:if test="${order.status==1 && order.method==2}"><p><span class="badge bg-success rounded-pill">PAID</span></p></c:if>
                        <c:if test="${order.status==5}"><span class="badge bg-success rounded-pill">PAID</span></p></c:if>
                        <c:if test="${order.status==2}"><p><span class="badge bg-success rounded-pill">PAID</span></p></c:if>

                        </div>
                        <div class="col-lg-1">
                            <p>Status
                        <c:if test="${order.status==0}"><span class="badge bg-warning rounded-pill">UNCONFIRM</span></p></c:if>
                        <c:if test="${order.status==1}"><span class="badge bg-info rounded-pill">SHIPPING</span></p></c:if>
                        <c:if test="${order.status==2}"><span class="badge bg-success rounded-pill">DONE</span></p></c:if>
                        <c:if test="${order.status==3}"><span class="badge bg-danger rounded-pill">CANCELLED</span></p></c:if>
                        <c:if test="${order.status==5}"><span class="badge bg-success rounded-pill">DONE</span></p></c:if>
                        </div>
                        <div class="col-lg-4">
                            <h3 class="h6">Billing address</h3>
                            <address>
                                <strong>Name:${order.name}</strong><br>
                            Address:${order.address}<br>
                            <abbr title="Phone">Phone:</abbr> ${order.phone}
                        </address>
                    </div>
                    <div class="col-lg">
                        <a class="mx-16" href="inforOrder?id=${order.idOrder}"><svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-6 h-6">
                            <path stroke-linecap="round" stroke-linejoin="round" d="M21 21l-5.197-5.197m0 0A7.5 7.5 0 105.196 5.196a7.5 7.5 0 0010.607 10.607z" />
                            </svg>
                        </a>
                    </div>
                    <div class="col-lg-2">
                        <c:if test="${order.status==1}">                       
                            <h3 class="h6">Update Status Order</h3>
                            <form action="changeStatusOrder">
                                <input type="text" hidden="hidden" name="id" value="${order.idOrder}">
                                <select class="border rounded" name="status">
                                    <option value="5">DONE</option>
                                    <option value="3">CANCELLED</option>
                                </select>
                                <input type="hidden" name="role" value="3">
                                <input class=" text-white border p-2 rounded bg-primary" type="submit" value="Save" />
                            </form>
                        </c:if>
                    </div>

                </div>
            </div>

        </div><!-- comment -->

    </main>
</c:forEach>
<%@include file="/includes/footer.jsp" %>