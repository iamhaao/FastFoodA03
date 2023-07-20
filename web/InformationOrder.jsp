<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*" %>
<%@include file="/includes/header.jsp" %>
<div class="container-fluid">

    <div class="container">
        <c:set value="${requestScope.acc}" var="acc"/>
        <c:set value="${requestScope.order}" var="order"/>
        <!-- Title -->
        <div class="d-flex justify-content-between align-items-center py-3">
            <h2 class="h5 mb-0"><a href="#" class="text-muted"></a> Order #${order.idOrder}</h2>
        </div>

        <!-- Main content -->
        <div class="row">
            <div class="col-lg-8 mx-auto">
                <!-- Details -->
                <div class="card mb-4">
                    <div class="card-body">
                        <div class="mb-3 d-flex justify-content-between">
                            <div>
                                <span class="me-3">${order.date}</span>
                                <span class="me-3">#${order.idOrder}</span>

                                <c:if test="${order.status==1}"><span class="badge rounded-pill bg-info">SHIPPING</span></c:if>
                                <c:if test="${order.status==0}"><span class="badge rounded-pill bg-warning">Unconfimred </span></c:if>
                                <c:if test="${order.status==2}"><span class="badge rounded-pill bg-success">DONE </span></c:if>
                                <c:if test="${order.status==3}"><span class="badge rounded-pill bg-danger">CANCELLED </span></c:if>
                                <c:if test="${order.status==4}"><span class="badge rounded-pill bg-secondary">PREPARING </span></c:if>
                                <c:if test="${order.status==5}"><span class="badge bg-success rounded-pill">DONE</span></p></c:if>
                                <c:if test="${order.status==6}"><span class="badge bg-success rounded-pill">BEING CANCEL</span></p></c:if>
                                </div>
                                <div class="d-flex">
                                <c:if test="${sessionScope.acc.idRole==2}">  <button class="bg-info border rounded px-2 text-light"><i class=""></i> <a href="buyAgain?id=${order.idOrder}">BUY AGAIN</a></button> </c:if> 
                                    <div class="dropdown">
                                        <button class="btn btn-link p-0 text-muted" type="button" data-bs-toggle="dropdown">
                                            <i class="bi bi-three-dots-vertical"></i>
                                        </button>
                                        <ul class="dropdown-menu dropdown-menu-end">
                                            <li><a class="dropdown-item" href="#"><i class="bi bi-pencil"></i> Edit</a></li>
                                            <li><a class="dropdown-item" href="#"><i class="bi bi-printer"></i> Print</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <table class="table table-borderless">
                                <tbody>
                                <c:forEach var="product" items="${requestScope.list}">
                                    <tr>
                                        <td>
                                            <div class="d-flex mb-2">
                                                <div class="flex-shrink-0">
                                                    <img src="${product.image}" alt="" width="35" class="img-fluid">
                                                </div>
                                                <div class="flex-lg-grow-1 ms-3">
                                                    <h6 class="small mb-0"><a href="preview?id=${product.idProduct}" class="text-reset">${product.name}</a></h6>

                                                </div>
                                            </div>
                                        </td>
                                        <td>Quantity : ${product.quantityProduct}</td>
                                        <td class="text-end"> $ ${product.quantityProduct*product.price}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                            <tfoot>
                                <!--              <tr>
                                                <td colspan="2">Subtotal</td>
                                                <td class="text-end"> </td>
                                              </tr>
                                              <tr>
                                                <td colspan="2">Shipping</td>
                                                <td class="text-end">$20.00</td>
                                              </tr>
                                              <tr>
                                                <td colspan="2">Discount (Code: NEWYEAR)</td>
                                                <td class="text-danger text-end">-$10.00</td>
                                              </tr>-->
                                <tr class="fw-bold">
                                    <td colspan="2">TOTAL</td>
                                    <td class="text-end">$ ${order.price}</td>
                                </tr>
                            </tfoot>
                        </table>
                    </div>
                </div>
                <!-- Payment -->
                <div class="card mb-4">
                    <div class="card-body">
                        <div class="row">
                            <div class="col-lg-6">
                                <h3 class="h6">Payment Method</h3>
                                <c:if test="${order.method==0}" ><p>Payment Cash <br></c:if>
                                <c:if test="${order.method==1}" ><p>Payment VNPAY <br></c:if>
                                <c:if test="${order.method==2}" ><p>PayPal <br></c:if>
                                    Total: $   ${order.price} 

                                    <c:if test="${order.status==0 && order.method==0}"><span class="badge bg-danger rounded-pill">NOT PAID</span></p></c:if>
                                <c:if test="${order.status==0 && order.method==1}"><span class="badge bg-success rounded-pill">PAID</span></p></c:if>
                                <c:if test="${order.status==1 && order.method==0}"><span class="badge bg-danger rounded-pill">NOT PAID</span></p></c:if>
                                <c:if test="${order.status==1 && order.method==1}"><span class="badge bg-success rounded-pill">PAID</span></p></c:if>
                                <c:if test="${order.status==2}"><span class="badge bg-success rounded-pill">PAID</span></p></c:if>
                                <c:if test="${order.status==4 && order.method==1}"><span class="badge bg-success rounded-pill">PAID</span></p></c:if>
                                <c:if test="${order.status==5}"><span class="badge bg-success rounded-pill">PAID</span></p></c:if>
                                </div>
                                <div class="col-lg-6">
                                    <h3 class="h6">Billing address</h3>
                                    <address>
                                        <strong>Name:${acc.name}</strong><br>
                                    Address:${order.address}<br>
                                    <abbr title="Phone">Phone:</abbr> ${acc.phone}
                                </address>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!--<<<<<<< HEAD
=======
</div>
>>>>>>> 28e225cec92b6aadb5248aa4c522742b73e7a184-->
<%@include file="/includes/footer.jsp" %>