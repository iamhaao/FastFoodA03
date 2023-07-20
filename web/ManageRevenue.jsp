<%-- 
    Document   : ManageRevenue
    Created on : Jun 19, 2023, 7:19:02 PM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="./includes/header.jsp" %>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
<style >
    .month_revenue{
        margin: 0 auto 0 auto;
        padding: 10px 0 0 0;

        background-color: #fff;
        display: flex;


    }


    .month-revenue__item{
        align-self: flex-end;
        width: 60px;
        margin-left: 80px;
        color: #333;
        text-align: center;
        animation: growth ease-in 0.5s;

    }
    .dropbtn {
        padding: 0 20px;
        border-radius: 5px;
        background-color: #d1e7dd;
        color: #333;
        padding: 16px;
        font-size: 16px;
        border: 0.5px solid #3e8e41;
        cursor: pointer;
        font-weight: bold;
        margin-bottom: 20px;
        font-family: serif;

    }

    .dropdown {
        position: relative;
        display: inline-block;

    }

    .dropdown-content {
        display: none;
        position: absolute;
        background-color: #f9f9f9;
        min-width: 160px;
        box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
        z-index: 1;
        font-weight: bold;
    }

    .dropdown-content a {
        color: black;
        padding: 12px 16px;
        text-decoration: none;
        display: block;
    }

    .dropdown-content a:hover {
        background-color: #f1f1f1 ;
    }

    .dropdown:hover .dropdown-content {
        display: block;
    }

    .dropdown:hover .dropbtn {
        background-color: #3e8e41;
        color: white
    }
    .body__category{
        font-family: serif;
        background-color: #fff;
        border: 1px solid rgb(234, 220, 220);
        box-shadow:0 3px 8px rgb(241, 214, 214);
        padding: 0;




    }
    .body__category-title{
        font-family: serif;

        color: #333;
        font-size: 19px;
        padding: 20px 0px 20px 10px ;
        position: relative;

    }

    .body__category-list{
        font-family: serif;


        list-style: none;
        margin: 0;
        padding: 0;

    }
    .body__category-item{
        padding:  20px 0px 20px 15px;
        margin: 0;
        border-top: 0.05px solid  rgb(236, 230, 230);
        /* box-shadow:  var(--box-shadow); */


    }
    .body__category-link{
        position: relative;
        text-decoration: none;
        font-size: 1.3rem;
        color: #333;
        font-weight: 500;
        left: 0;
        transition: right linear 0.1s;

    }
    .body-report{
        /*background-color: ;*/
        padding-top: 30px;
        border: 1px solid rgb(234, 220, 220);
        box-shadow: 0 3px 8px rgb(241, 214, 214);
    }
    .note-item{
        display: flex;
        justify-content: center;
        padding-right: 10px;
    }
</style>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">

<div class="container" style="margin-bottom: 40px">

    <div class="row">
        <div class="col-12 col-md-2 ">
            <div class="body__category">
                <h3 class="body__category-title">
                    CATEGORY STORE
                </h3>
                <ul class="body__category-list">
                    <li class="body__category-item">
                        <a href="ManageRevenue?storeID=1&year=${sessionScope.yearActive}" class="body__category-link body__category-link--active  ${activeStore == 1 ? "text-danger":""}">

                            Store Da Nang

                        </a>
                    </li>
                    <li class="body__category-item">
                        <a href="ManageRevenue?storeID=2&year=${sessionScope.yearActive}" class="body__category-link body__category-link--active  ${activeStore == 2 ? "text-danger":""}">

                            Store Ha Noi

                        </a>
                    </li><!-- comment -->
                    <li class="body__category-item">
                        <a href="ManageRevenue?storeID=3&year=${sessionScope.yearActive}" class="body__category-link body__category-link--active  ${activeStore == 3 ? "text-danger":""}">

                            Store Ho Chi Minh

                        </a>
                    </li>

                    <li class="body__category-item">
                        <a href="ManageRevenue?storeID=0&year=${sessionScope.yearActive}" class="body__category-link body__category-link--active  ${activeStore == 0 ? "text-danger":""}">

                            All store

                        </a>
                    </li><!-- comment -->



                </ul>

            </div>

        </div>
        <div class="col-12 col-md-10">

            <div class="body-report" >
                <div class="dropdown ml-7" style="">
                    <button class="dropbtn">Year
                        <i class="fa-solid fa-chevron-down m-1"></i><!-- comment --></button>
                    <div class="dropdown-content">
                        <c:forEach items="${listRevenueYear}" var="r">
                            <a href="ManageRevenue?storeID=1&year=${r.year}">Year ${r.year}</a>

                        </c:forEach>

                    </div>
                </div>
                <div class="row">
                    <div class="col-12 col-md-12">
                        <div class="container m-1" >

                            <h1 style="font-family: serif; font-weight: 600; font-size: 28px; padding-bottom: 10px">Monthly revenue report</h1>
                            <h4 style="font-family: serif; font-size: 18px; padding-bottom: 30px; opacity: 0.8;">Revenue is constantly updated according to orders</h4>
                            <h1 class="note" style="display: flex; justify-content: center">
                                <c:if test="${activeStore == 1}">
                                    <div class="note-item">
                                        <p class="text-center"style="width: 50px; height: 20px; background-color: red; "></p>
                                        <span style="font-family: serif; font-weight: 600; padding-left: 10px"> Store Da Nang</>
                                    </div>
                                </c:if>
                                <c:if test="${activeStore == 2}">
                                    <div class="note-item">
                                        <p class="text-center"style="width: 50px; height: 20px; background-color: purple; "></p>
                                        <span style="font-family: serif; font-weight: 600; padding-left: 10px"> Store Ha Noi</>
                                    </div>
                                </c:if>
                                <c:if test="${activeStore == 3}">
                                    <div class="note-item">
                                        <p class="text-center"style="width: 50px; height: 20px; background-color: blue; "></p>
                                        <span style="font-family: serif; font-weight: 600; padding-left: 10px"> Store Ho Chi Minh</>
                                    </div>
                                </c:if> 
                                <c:if test="${activeStore == 0}">
                                    <div class="note-item">
                                        <p class="text-center"style="width: 50px; height: 20px; background-color: red; "></p>
                                        <span style="font-family: serif; font-weight: 600; padding-left: 10px"> Store Da Nang</>
                                    </div>
                                    <div class="note-item">
                                        <p class="text-center"style="width: 50px; height: 20px; background-color: purple; "></p>
                                        <span style="font-family: serif; font-weight: 600; padding-left: 10px"> Store Ha Noi</>
                                    </div>
                                    <div class="note-item">
                                        <p class="text-center"style="width: 50px; height: 20px; background-color: blue; "></p>
                                        <span style="font-family: serif; font-weight: 600; padding-left: 10px"> Store Ho Chi Minh</>
                                    </div>
                                    <div class="note-item">
                                        <p class="text-center"style="width: 50px; height: 20px; background-color: green; "></p>
                                        <span style="font-family: serif; font-weight: 600; padding-left: 10px">Average</>
                                    </div>
                                </c:if> 

                            </h1>

                            <canvas id="myChart" style="width: 100%; margin-bottom: 50px "></canvas>


                            <div class="row">
                                <div class="col-12 col-md-8">
                                     <h4 style="font-family: serif; font-size: 18px; padding-bottom: 30px; opacity: 0.8;">Revenue is constantly updated according to orders</h4>

                                    <table class="table" style=" font-family: serif" >
                                        <thead>
                                            <tr class="table-success">
                                                <th class="text-center" scope="col">Month</th>
                                                <th  class="text-center" scope="col">Total times order</th>
                                                <th class="text-center" scope="col">Total revenue</th>

                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:if test="${activeStore == 1}">
                                                <c:forEach items="${revenues1}" var="r">

                                                    <tr>
                                                        <th class="text-center month-revenue">${r.month}</th>
                                                        <td class="text-center ">${r.totalTimesOrder}</td>
                                                        <td class="text-center totalStore1-revenue">${r.totalRevenueMonth}</td>

                                                    </tr>
                                                </c:forEach>
                                            </c:if>
                                            <c:if test="${activeStore == 2}">
                                                <c:forEach items="${revenues1}" var="r">

                                                    <tr>
                                                        <th class="text-center month-revenue">${r.month}</th>
                                                        <td class="text-center ">${r.totalTimesOrder}</td>
                                                        <td class="text-center totalStore2-revenue">${r.totalRevenueMonth}</td>

                                                    </tr>
                                                </c:forEach>
                                            </c:if>
                                            <c:if test="${activeStore == 3}">


                                                <c:forEach items="${revenues1}" var="r">

                                                    <tr>
                                                        <th class="text-center month-revenue">${r.month}</th>
                                                        <td class="text-center ">${r.totalTimesOrder}</td>
                                                        <td class="text-center totalStore3-revenue">${r.totalRevenueMonth}</td>

                                                    </tr>
                                                </c:forEach>
                                            </c:if>
                                            <c:if test="${activeStore == 0}">
                                                <c:forEach items="${revenues1}" var="r">

                                                    <tr>
                                                        <th class="text-center ">${r.month}</th>
                                                        <td class="text-center ">${r.totalTimesOrder}</td>
                                                        <td class="text-center ">${r.totalRevenueMonth}</td>

                                                    </tr>
                                                </c:forEach>
                                                <c:forEach items="${revenuesStoreAllAv}" var="r">

                                                    <tr class="hidden">
                                                        <th class="text-center ">${r.month}</th>
                                                        <td class="text-center ">${r.totalTimesOrder}</td>
                                                        <td class="text-center totalStoreAv-revenue">${r.totalRevenueMonth}</td>

                                                    </tr>
                                                </c:forEach>
                                                <c:forEach items="${revenuesStore1}" var="r">

                                                    <tr class="hidden">
                                                        <th class="text-center month-revenue">${r.month}</th>
                                                        <td class="text-center ">${r.totalTimesOrder}</td>
                                                        <td class="text-center totalStore1-revenue">${r.totalRevenueMonth}</td>

                                                    </tr>
                                                </c:forEach>
                                                <c:forEach items="${revenuesStore2}" var="r">

                                                    <tr class="hidden">
                                                        <th class="text-center ">${r.month}</th>
                                                        <td class="text-center ">${r.totalTimesOrder}</td>
                                                        <td class="text-center totalStore2-revenue">${r.totalRevenueMonth}</td>

                                                    </tr>
                                                </c:forEach>                               
                                                <c:forEach items="${revenuesStore3}" var="r">

                                                    <tr class="hidden">
                                                        <th class="text-center ">${r.month}</th>
                                                        <td class="text-center ">${r.totalTimesOrder}</td>
                                                        <td class="text-center totalStore3-revenue">${r.totalRevenueMonth}</td>

                                                    </tr>

                                                </c:forEach> 
                                                <c:forEach items="${listRevenueYear}" var="r">
                                                    <tr>
                                                        <th class="text-center  bg-success text-white">Year ${r.year}</th>
                                                        <td class="text-center ">${r.totalTimesOrder}</td>

                                                        <td class="text-center ">${r.totalRevenueMonth}</td>

                                                    </tr>

                                                </c:forEach>

                                            </c:if>

                                        </tbody>
                                    </table>
                                </div>
                                <div class="col-12 col-md-4">
                                    <div class="container m-1" >

                                        <h4 style="font-family: serif; font-size: 18px; padding-bottom: 30px; opacity: 0.8;">Top selling products</h4>

                                        <!--<canvas id="myChartPQ" style="width: 100%; margin-bottom: 50px "></canvas>-->





                                        <table class="table" style=" font-family: serif" >
                                            <thead>
                                                <tr class="table-success">
                                                    <th class="text-center" scope="col">NameP</th>
                                                    <th  class="text-center" scope="col">TotalQ</th>
                                                    <th class="text-center" scope="col">TotalR</th>

                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:if test="${activeStore == 1}">
                                                    <c:forEach items="${listBSP}" var="p">

                                                        <tr>
                                                            <th class="text-center name-product">${p.name}</th>
                                                            <td class="text-center quantity-product">${p.quantity}</td>
                                                            <td class="text-center totalStore1-revenue">${p.price}</td>

                                                        </tr>
                                                    </c:forEach>
                                                </c:if>
                                                <c:if test="${activeStore == 2}">
                                                    <c:forEach items="${listBSP}" var="p">

                                                        <tr>
                                                            <th class="text-center name-product">${p.name}</th>
                                                            <td class="text-center quantity-product">${p.quantity}</td>
                                                            <td class="text-center totalStore1-revenue">${p.price}</td>

                                                        </tr>
                                                    </c:forEach>
                                                </c:if>
                                                <c:if test="${activeStore == 3}">


                                                    <c:forEach items="${listBSP}" var="p">

                                                        <tr>
                                                            <th class="text-center name-product">${p.name}</th>
                                                            <td class="text-center quantity-product">${p.quantity}</td>
                                                            <td class="text-center totalStore1-revenue">${p.price}</td>

                                                        </tr>
                                                    </c:forEach>
                                                </c:if>
                                                <c:if test="${activeStore == 0}">
                                                    <c:forEach items="${listBSP}" var="p">

                                                        <tr>
                                                            <th class="text-center name-product">${p.name}</th>
                                                            <td class="text-center quantity-product">${p.quantity}</td>
                                                            <td class="text-center totalStore1-revenue">${p.price}</td>

                                                        </tr>
                                                    </c:forEach>

                                                </c:if>

                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>

                </div>

            </div>


        </div>

    </div>



</div>
<script>
    var monthElement = document.getElementsByClassName("month-revenue");
    var totalStore1Element = document.getElementsByClassName("totalStore1-revenue");
    var totalStore2Element = document.getElementsByClassName("totalStore2-revenue");
    var totalStore3Element = document.getElementsByClassName("totalStore3-revenue");
    var totalStoreAllAVElement = document.getElementsByClassName("totalStoreAv-revenue");





    var arr = [];
    var arr1 = [];
    var arr2 = [];
    var arr3 = [];
    var arrAv = [];



    for (let i = 0; i < monthElement.length; i++) {
        arr.push(monthElement[i].innerText);
    }
    for (let i = 0; i < totalStore1Element.length; i++) {
        arr1.push(totalStore1Element[i].innerText);
    }
    for (let i = 0; i < totalStore2Element.length; i++) {
        arr2.push(totalStore2Element[i].innerText);
    }
    for (let i = 0; i < totalStore3Element.length; i++) {
        arr3.push(totalStore3Element[i].innerText);
    }
    for (let i = 0; i < totalStoreAllAVElement.length; i++) {
        arrAv.push(totalStoreAllAVElement[i].innerText);
    }
    console.log(totalStore2Element);
    const xValues = arr;

    new Chart("myChart", {
        type: "line",
        data: {
            labels: xValues,
            datasets: [
                {
                    data: arr1,
                    borderColor: "red",
                    fill: false,
                },
                {
                    data: arr2,
                    borderColor: "purple",
                    fill: false,
                },
                {
                    data: arr3,
                    borderColor: "blue",
                    fill: false,
                },
                {
                    data: arrAv,
                    borderColor: "green",
                    fill: false,
                }
            ],
        },
        options: {
            legend: {display: false},
        },
    });

    var nameElement = document.getElementsByClassName("name-product");
    var quantityElement = document.getElementsByClassName("quantity-product");





//
//    var arrPQ = [];
//    var arrPQ1 = [];
//
//
//
//    for (let i = 0; i < nameElement.length; i++) {
//        arrPQ.push(nameElement[i].innerText);
//    }
//    for (let i = 0; i < quantityElement.length; i++) {
//        arrPQ1.push(quantityElement[i].innerText);
//    }
//    var xValues = arrPQ;
//    var yValues = arrPQ1;
//    var barColors = ["red", "green", "blue", "orange", "brown", "DarkGreen", "DarkRed", "blue", "DarkSlateBlue", "DeepPink", "Fuchsia", "Indigo", "LightCoral", "LightSlateGrey", "Maroon", "Navy", "OliveDrab", "Purple", "SpringGreen", "Yellow"];
//
//    new Chart("myChartPQ", {
//        type: "bar",
//        data: {
//            labels: xValues,
//            datasets: [{
//                    backgroundColor: barColors,
//                    data: yValues
//                }]
//        },
//        options: {
//            legend: {display: false},
//            title: {
//                display: true,
//                text: "Manage product quantity"
//            }
//        }
//    });
</script>

<%@include file="./includes/footer.jsp" %>
