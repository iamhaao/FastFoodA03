<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*" %>
<%@include file="/includes/header.jsp" %>
<main>
    <h3 class="text-gray-900">${requestScope.alert}</h3>
    <link rel="stylesheet" href="./css/styleCart.css"/>
    <div id="cart" class="section-p1">
        <table>
            <thead>
                <tr>
                    <td>No</td>
                    <td>Image</td>
                    <td>Name</td>
                    <td>Price</td>
                    <td>Quantity</td>
                    <td>Subtotal</td>
                    <td>Remove</td>
                </tr>
            </thead>

            <tbody>
                <c:set var="tt" value="0" />
                <c:forEach items="${sessionScope.cartProducts}" var="p">
                    <c:set var="tt" value="${tt+1}" />
                    <tr>
                    <tr>
                        <td>${tt}</td>
                        <td ><img src="${p.image}" alt=""></td>
                        <td>${p.name}</td>
                        <td>${p.price}</td>

                        <td>
                            <button><a href="processCart?action=dec&id=${p.idProduct}">-</a></button>
                            <input class="input-qty" max="10" min="1" name="" type="number" value="${p.quantityProduct}">
                            <button><a href="processCart?action=inc&id=${p.idProduct}">+</a></button>
                        </td>
                        <td>${(p.quantityProduct*p.price)}</td>
                        <td><a href="remove?id=${p.idProduct}">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
                                <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
                                <path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
                                </svg>
                            </a></td>
                    </tr>
                </c:forEach>

            </tbody>
        </table>
    </div>
                <h5 class="text-danger">${requestScope.alertOrder}</h5>

    <div id="buy-more">
        <button ><a href="products?nameSearch&choose=0">BUY MORE</a></button>
    </div>

    <div id="cart-add" class="section-p1">
        <div id="coupon">


            <h3>Apply Coupon</h3>
            <div>
                <input type="text" placeholder="Enter your Coupon">
                <button class="normal">Apply</button>
            </div>
        </div>

        <div id="subtotal">
            <h3>Cart Totals</h3>
            <table>
                <tr>
                    <td>Cart Subtotal</td>
                    <td>${sessionScope.size}  </td>
                </tr>

                <tr>
                    <td>Shipping</td>
                    <td>${sessionScope.ship}</td>
                </tr>
                <tr>
                    <td>DISCOUNT</td>
                    <td>${sessionScope.discount}</td>
                </tr>
                <tr>
                    <td><strong>Total</strong></td>
                    <td><strong>${sessionScope.total}</strong></td>
                </tr>

            </table>

            <button class="normal"><a href="payment">PAYMENT</a></button>
        </div>
    </div>
</main>
<%@include file="/includes/footer.jsp" %>