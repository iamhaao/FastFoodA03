<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*" %>
<%@include file="/includes/header.jsp" %>
<main class="mt-[80px]">
    <c:forEach var="hs" items="${requestScope.history}">
        <div class="card mb-4">

            <div class="card-body">
                <div class="row ml-auto">
                    <div class="col-lg-3"> 
                        <p>Order ID:<a href="inforOrder?id=${hs.idOrder}"> #${hs.idOrder}</a></p> <br><!-- comment -->
                        <p>Date : ${hs.date}</p>
                    </div>
                    <div class="col-lg-2">
                        <h3 class="h6">Payment Method</h3>
                        <c:if test="${hs.method==0}" ><p>Payment Cash <br></c:if>
                        <c:if test="${hs.method==1}" ><p>Payment Credit Card <br></c:if>
                        <c:if test="${hs.method==2}" ><p>Payment PayPal <br></c:if>
                            Total: $   ${hs.price} 

                        <c:if test="${hs.status==0 && hs.method==0}"><p><span class="badge bg-danger rounded-pill">NOT PAID</span></p></c:if>
                        <c:if test="${hs.status==0 && hs.method==1}"><p><span class="badge bg-success rounded-pill">PAID</span></p></c:if>
                        <c:if test="${hs.status==0 && hs.method==2}"><p><span class="badge bg-success rounded-pill">PAID</span></p></c:if>
                        <c:if test="${hs.status==4 && hs.method==0}"><p><span class="badge bg-danger rounded-pill">NOT PAID</span></p></c:if>
                        <c:if test="${hs.status==4 && hs.method==1}"><p><span class="badge bg-success rounded-pill">PAID</span></p></c:if>
                        <c:if test="${hs.status==4 && hs.method==2}"><p><span class="badge bg-success rounded-pill">PAID</span></p></c:if>
                        <c:if test="${hs.status==1 && hs.method==0}"><p><span class="badge bg-danger rounded-pill">NOT PAID</span></p></c:if>
                        <c:if test="${hs.status==1 && hs.method==1}"><p><span class="badge bg-success rounded-pill">PAID</span></p></c:if>
                        <c:if test="${hs.status==1 && hs.method==2}"><p><span class="badge bg-success rounded-pill">PAID</span></p></c:if>

                        <c:if test="${hs.status==2}"><p><span class="badge bg-success rounded-pill">PAID</span></p></c:if>

                        </div>
                        <div class="col-lg-2">
                            <p>Status
                            <c:if test="${hs.status==0}"><span class="badge bg-warning rounded-pill">UNCONFIRM</span></p></c:if>
                        <c:if test="${hs.status==1}"><span class="badge bg-info rounded-pill">SHIPPING</span></p></c:if>
                        <c:if test="${hs.status==2}"><span class="badge bg-success rounded-pill">DONE</span></p></c:if>
                        <c:if test="${hs.status==3}"><span class="badge bg-danger rounded-pill">CANCELLED</span></p></c:if>
                        <c:if test="${hs.status==4}"><span class="badge bg-secondary rounded-pill">PREPARING</span></p></c:if>
                        <c:if test="${hs.status==5}"><span class="badge bg-success rounded-pill">DONE</span></p></c:if>
                        <c:if test="${hs.status==6}"><span class="badge bg-danger rounded-pill">BEING CANCELLED</span></p></c:if>
                        </div>
                        <div class="col-lg-3">
                            <h3 class="h6">Infor details</h3>
                            <address>
                                <strong>Name Store:${hs.store}</strong><br>
                            Shipper:${hs.shipper}<br>

                        </address>
                    </div>
                    <c:if test="${hs.status==2}">
                        <div class="col-lg-2  text-center">

                            <div class="d-flex">
                                <h6 class="mt-4">send feedback</h6>
                                <a class="mx-2" href="inforOrder?id=${hs.idOrder}"><p class="">
                                        <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-6 h-6">
                                        <path stroke-linecap="round" stroke-linejoin="round" d="M2.25 12.76c0 1.6 1.123 2.994 2.707 3.227 1.068.157 2.148.279 3.238.364.466.037.893.281 1.153.671L12 21l2.652-3.978c.26-.39.687-.634 1.153-.67 1.09-.086 2.17-.208 3.238-.365 1.584-.233 2.707-1.626 2.707-3.228V6.741c0-1.602-1.123-2.995-2.707-3.228A48.394 48.394 0 0012 3c-2.392 0-4.744.175-7.043.513C3.373 3.746 2.25 5.14 2.25 6.741v6.018z" />
                                        </svg>
                                </a>
                            </div>

                        </div>
                    </c:if>
                    <c:if test="${hs.status==4||hs.status==0}">
                        <div class="col-lg-2  text-center my-auto">
                            <form action="cancelOrder">
                                <input type="text" hidden="hidden" name="id" value="${hs.idOrder}">                            
                                <input class=" text-white border p-2 rounded bg-danger " type="submit" value="Cancel" />
                            </form>
                        </div>
                    </c:if>


                </div>
            </div>

        </div><!-- comment -->

    </main>
</c:forEach>
<%@include file="/includes/footer.jsp" %>