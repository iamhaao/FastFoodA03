<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="./includes/header.jsp" %>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>

<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">

<div class="container" style="margin-bottom: 40px; font-family: serif">

    <div class="row">
        <div class="col-12 col-md-3">
            <div class="body__category">
                <h3 class="body__category-title">
                    CATEGORY STORE
                </h3>
                <ul class="body__category-list">
                    <li class="body__category-item">
                        <a href="managePInStore?storeID=1" class="body__category-link body__category-link--active  ${activeStore == 1 ? "text-danger":""}">

                            Store Da Nang

                        </a>
                    </li>
                    <li class="body__category-item">
                        <a href="managePInStore?storeID=2" class="body__category-link body__category-link--active  ${activeStore == 2 ? "text-danger":""}">

                            Store Ha Noi

                        </a>
                    </li><!-- comment -->
                    <li class="body__category-item">
                        <a href="managePInStore?storeID=3" class="body__category-link body__category-link--active  ${activeStore == 3 ? "text-danger":""}">

                            Store Ho Chi Minh

                        </a>
                    </li>





                </ul>

            </div>

        </div>
        <div class="col-12 col-md-9">

            <div class="body-report" >
                <canvas id="myChart" style="width:100%; margin-bottom: 20px"></canvas>
                <div class="container" >
                    <div class="row">

                        <c:forEach items="${productInStores}" var="p">

                            <div class="col-6 col-md-6" style="box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);border-radius: 5px;margin-bottom: 20px;border: #ccc solid 0.5px">
                                <form action="updatePInStore" method="post">
                                    <div class="row">
                                        <input type="hidden" id="productID" name="productID" value="${p.productID}"><!-- comment -->
                                        <input type="hidden" id="storeID" name="storeID" value="${p.storeID}">


                                        <div class="col-6 col-md-4">
                                            <div class="text-center">
                                                <img src="${p.image}" style="width: 120px ; height: 120px" class="rounded" alt="...">
                                            </div>
                                        </div>
                                        <div class="col-6 col-md-8">
                                            <div>
                                                <div style="" class="">
                                                    <div class="row">
                                                        <div class="col-6 col-md-7">
                                                            <h1 style="margin: 0 10px 0 0;padding: 0; font-weight: 600; font-size: 16px ">Name Product</h1>

                                                        </div>
                                                        <div class="col-6 col-md-5">
                                                            <h1 style="margin: 0;padding: 3px 0 0 0" class="name-product">${p.nameProduct}</h1>

                                                        </div>
                                                    </div>



                                                </div>
                                                <div style="margin-top: 10px ">
                                                    <div class="row">
                                                        <div class="col-6 col-md-7">
                                                            <h1 style="font-weight: 600;font-size: 16px; padding-right: 60px;">Quantity</h1>
                                                        </div>
                                                        <div class="col-6 col-md-5">
                                                            <input name="quantityP" style="width: 80px; height: 30px;" type="text" value="${p.quantity}">
                                                            <h1 class="hidden quantity-product" style="margin: 0;padding: 3px 0 0 0" class="name-product">${p.quantity}</h1>

                                                        </div>
                                                    </div>



                                                </div>
                                                <div style="margin: 10px 10px 10px 0; float: right">
                                                    <button type="submit"class="btn btn-success" style="background-color: green">Update</button>
                                                    <a href="deletePInStore?storeID=${p.storeID}&productID=${p.productID}" class="btn btn-danger" style="background-color: red" >Delete</a>
                                                    <!-- comment -->
                                                </div>
                                            </div>
                                        </div>

                                    </div>
                                </form>


                            </div>
                        </c:forEach>



                    </div>
                </div>

            </div>



        </div>

    </div>

    <script>
        var nameElement = document.getElementsByClassName("name-product");
        var quantityElement = document.getElementsByClassName("quantity-product");






        var arr = [];
        var arr1 = [];



        for (let i = 0; i < nameElement.length; i++) {
            arr.push(nameElement[i].innerText);
        }
        for (let i = 0; i < quantityElement.length; i++) {
            arr1.push(quantityElement[i].innerText);
        }
        var xValues = arr;
        var yValues = arr1;
        var barColors = ["red", "green", "blue", "orange", "brown", "DarkGreen", "DarkRed", "blue", "DarkSlateBlue", "DeepPink", "Fuchsia", "Indigo", "LightCoral", "LightSlateGrey", "Maroon", "Navy", "OliveDrab", "Purple", "SpringGreen", "Yellow"];

        new Chart("myChart", {
            type: "bar",
            data: {
                labels: xValues,
                datasets: [{
                        backgroundColor: barColors,
                        data: yValues
                    }]
            },
            options: {
                legend: {display: false},
                title: {
                    display: true,
                    text: "Manage product quantity"
                }
            }
        });
    </script>

</div>


<%@include file="./includes/footer.jsp" %>