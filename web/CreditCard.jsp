<%-- 
    Document   : CreditCart
    Created on : Jun 9, 2023, 1:44:10 AM
    Author     : ACER NITRO
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PAYMENT CREDITCARD </title>
        <link rel="stylesheet" href="./css/styleCreditCard.css"/>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>
    <body>
       <div class="card mt-50 mb-50">
            <div class="card-title mx-auto">
                Payment by CreditCard
            </div>
            <div class="nav">
                <ul class="mx-auto">
                    <li class="active"><a href="#">Payment</a></li>
                </ul>
            </div>
           <form action="afterPayment">
                <span id="card-header">Saved cards:</span>
                <c:forEach items="${requestScope.listCredit}" var="credit">
                <div class="row row-1">
                    <div class="col-1"><input class="mt-3"  type="radio"></div>
                    
                    <div class="col-2"><img  class="img-fluid" src="https://img.icons8.com/color/48/000000/visa.png"/></div>
                    <div class="col-5" >
                        <input type="text" readonly="" placeholder="${credit.name}">
                        <input type="text" readonly="" placeholder="${credit.number}">
                    </div>
                    <div class="col-3 d-flex justify-content-center">
                        <a href="#">Remove card</a>
                    </div>
                </div>
                </c:forEach>
                <span id="card-header">Add new card:</span>
                <div class="row-1">
                    <div class="row row-2">
                        <span id="card-inner">Card holder name</span>
                    </div>
                    <div class="row row-2">
                        <input type="text" name="cardName" placeholder="Your Name">
                    </div>
                </div>
                <div class="row three">
                    <div class="col-7">
                        <div class="row-1">
                            <div class="row row-2">
                                <span id="card-inner">Card number</span>
                            </div>
                            <div class="row row-2">
                                <input type="text"  name="cardNumber" placeholder="xxxx-xxxx-xxxx">
                            </div>
                        </div>
                    </div>
                    <div class="col-2">
                        <input type="text" name="cardExp" placeholder="Exp. date">
                    </div>
                    <div class="col-2">
                        <input type="text" name="cvv" placeholder="CVV">
                    </div>
                </div>
                <button type="submit" class="btn d-flex mx-auto"><b>Add card</b></button>
            </form>
        </div>
    </body>
</html>
