<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/includes/header.jsp" %>
<link href="./css/ggmap.css" rel="stylesheet" />
<body class="bg-light ">

    <div class="container mb-5">

        <body class="bg-light">

            <div class="container">

                <div class="row">
                    <div class="col-md-4 order-md-2 mb-4">
                        <h4 class="d-flex justify-content-between align-items-center mb-3">
                            <span class="text-muted">Your cart</span>
                            <span class="" >${sessionScope.size}</span>
                        </h4>
                        <ul class="list-group mb-3">
                            <c:forEach items="${sessionScope.cartProducts}" var="cart">
                                <li class="list-group-item d-flex justify-content-between lh-condensed">          
                                    <div>
                                        <h6 class="my-0">${cart.name}</h6>
                                        <small class="text-muted">Quantity : ${cart.quantityProduct}</small>
                                    </div> 
                                    <span class="text-muted">${cart.price}VND</span>
                                </li>
                            </c:forEach>

                            <li class="list-group-item d-flex justify-content-between">
                                <span>Total (VND)</span>
                                <strong>${sessionScope.total}</strong>
                            </li>
                        </ul>
                    </div>

                    <div class="col-md-8 order-md-1">
                        <h4 class="mb-3">Billing </h4>

                        <div class="row">
                            <div class="col-md mb-3">
                                <label for="lastName">Name</label>
                                <input type="text" class="form-control" id="lastName" placeholder="" value="${sessionScope.acc.name}" required>
                                <div class="invalid-feedback">
                                    Valid last name is required.
                                </div>
                            </div>
                        </div>

                        <div class="mb-3">
                            <label for="username">Username</label>
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text">@</span>
                                </div>
                                <input type="text" class="form-control" id="username" placeholder="Username" value="${sessionScope.acc.username}" required>
                                <div class="invalid-feedback" style="width: 100%;">
                                    Your username is required.
                                </div>
                            </div>
                        </div>


                        <div class="mb-3">
                            <label for="email">Email <span class="text-muted">(Optional)</span></label>
                            <input type="email" class="form-control" id="email" value="${sessionScope.acc.email}" placeholder="you@example.com">
                            <div class="invalid-feedback">
                                Please enter a valid email address for shipping updates.
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md mb-3">
                                <label for="lastName">Phone</label>
                                <input type="text" class="form-control" id="lastName" placeholder="" value="${sessionScope.acc.phone}" required>
                                <div class="invalid-feedback">

                                </div>
                            </div>
                        </div>
                        <form action="checkout">


                            <div class="row">
                                <div class="col-md-5 mb-3">
                                    <label for="zip">Delivery Address</label>
                                    <input type="text" id="to" placeholder="Address Shipping" class="form-control" name="address" value="${sessionScope.acc.address}" >
                                </div>
                                <div class="col-md-4 mb-3">
                                    <label for="state">Choose a store near you</label>
                                    <select class="custom-select d-block w-100" name="store" id="from" required>
                                        <c:forEach items="${requestScope.stores}" var="st">
                                            <option value="${st.address}">${st.name}</option>        
                                        </c:forEach>
                                    </select>
                                    <div class="invalid-feedback">
                                        Please provide a valid state.
                                    </div>

                                </div>
                                <div class="col-md-3 mt-3">
                                    <div class="form-group">
                                        <button class="btn btn-success btn-lg" onclick="calcRoute();">Search Address</button>
                                    </div>
                                </div>
                            </div>
                            <div class="container">
                                <div id="output"></div>

                                <div class="container-fluid row">
                                    <div class="col-sm-12" id="googleMap">

                                    </div>
                                </div>
                            </div>

                    </div>
                </div>
                <hr class="mb-4">
                <div class="custom-control custom-checkbox">

                    <h4 class="mb-3">Payment</h4>

                    <div class="d-block my-3">
                        <div class="custom-control custom-radio d-flex">
                            <input id="debit" name="payment" type="radio" value="0" class="custom-control-input" required>
                            <span class="mx-2"> <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-6 h-6">
                                <path stroke-linecap="round" stroke-linejoin="round" d="M2.25 18.75a60.07 60.07 0 0115.797 2.101c.727.198 1.453-.342 1.453-1.096V18.75M3.75 4.5v.75A.75.75 0 013 6h-.75m0 0v-.375c0-.621.504-1.125 1.125-1.125H20.25M2.25 6v9m18-10.5v.75c0 .414.336.75.75.75h.75m-1.5-1.5h.375c.621 0 1.125.504 1.125 1.125v9.75c0 .621-.504 1.125-1.125 1.125h-.375m1.5-1.5H21a.75.75 0 00-.75.75v.75m0 0H3.75m0 0h-.375a1.125 1.125 0 01-1.125-1.125V15m1.5 1.5v-.75A.75.75 0 003 15h-.75M15 10.5a3 3 0 11-6 0 3 3 0 016 0zm3 0h.008v.008H18V10.5zm-12 0h.008v.008H6V10.5z" />
                                </svg>
                            </span>

                            <label class="custom-control-label" for="debit">Pay after recieve</label>
                        </div>
                        <div class="custom-control custom-radio d-flex">
                            <input id="credit" name="payment" type="radio" value="1" class="custom-control-input" checked required>
                            <span class="mx-2"><svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-6 h-6">
                                <path stroke-linecap="round" stroke-linejoin="round" d="M2.25 8.25h19.5M2.25 9h19.5m-16.5 5.25h6m-6 2.25h3m-3.75 3h15a2.25 2.25 0 002.25-2.25V6.75A2.25 2.25 0 0019.5 4.5h-15a2.25 2.25 0 00-2.25 2.25v10.5A2.25 2.25 0 004.5 19.5z" />
                                </svg>

                            </span>
                            <label class="custom-control-label" for="credit">Credit card</label>
                        </div>
                        <div class="custom-control custom-radio d-flex">
                            <input id="paypal" name="payment" type="radio" value="2" class="custom-control-input" checked required>
                            <span class="mx-2"><svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-6 h-6">
                                <path stroke-linecap="round" stroke-linejoin="round" d="M2.25 8.25h19.5M2.25 9h19.5m-16.5 5.25h6m-6 2.25h3m-3.75 3h15a2.25 2.25 0 002.25-2.25V6.75A2.25 2.25 0 0019.5 4.5h-15a2.25 2.25 0 00-2.25 2.25v10.5A2.25 2.25 0 004.5 19.5z" />
                                </svg>

                            </span>
                            <label class="custom-control-label" for="credit">Paypal pay</label>
                        </div>  

                    </div>
                </div>  
                <a  href="index.jsp"class="btn btn-success bg-danger" type="submit">Cancel</a>
                <button class="btn btn-success bg-success" type="submit">Confirm</button>
                </form>
            </div>
    </div>
</div>
</body>

<%@include file="/includes/footer.jsp" %>
<script
src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAMo1YG3amcpf-EbK3c70f_YX3T6VJG7Bs&libraries=places"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="./js/GGMapApi.js">
</script>
</div>