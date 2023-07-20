<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="includes/header.jsp" %>
<main>
    <link rel="stylesheet" href="css/styleDelivery.css"/>
    <div class="container mt-5">
        <div class="d-flex justify-content-center row">
            <div class="col-md-10">
                <div class="rounded">
                    <div class="table-responsive table-borderless">
                        <table class="table">
                            <thead>
                                <tr>

                                    <th>OrderID</th>
                                   <th>Acount ID</th>
                                    <th>Total</th>
                                    <th>Created At</th>
                                    <th>Transport</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <c:forEach var="o" items="${sessionScope.listOrder}">
                                <tbody class="table-body">
                                    <tr class="cell-1">

                                        <td>#${o.idOrder}</td>
                                        <td>${o.idAccount}</td>
                                        <td>${o.price}VND</td>
                                        <td>${o.date}</td>
                                        <td >
                                            <a class="" href="delivery?id=${o.idOrder}"><svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="w-6 h-6">
                                                    <path stroke-linecap="round" stroke-linejoin="round" d="M8.25 18.75a1.5 1.5 0 01-3 0m3 0a1.5 1.5 0 00-3 0m3 0h6m-9 0H3.375a1.125 1.125 0 01-1.125-1.125V14.25m17.25 4.5a1.5 1.5 0 01-3 0m3 0a1.5 1.5 0 00-3 0m3 0h1.125c.621 0 1.129-.504 1.09-1.124a17.902 17.902 0 00-3.213-9.193 2.056 2.056 0 00-1.58-.86H14.25M16.5 18.75h-2.25m0-11.177v-.958c0-.568-.422-1.048-.987-1.106a48.554 48.554 0 00-10.026 0 1.106 1.106 0 00-.987 1.106v7.635m12-6.677v6.677m0 4.5v-4.5m0 0h-12" />
                                                </svg>

                                            </a>
                                        </td>
                                                    <td><a href="inforOrder?id=${o.idOrder}"><i class="fa fa-ellipsis-h text-black-50"></i></a></td>
                                    </tr>
                                </c:forEach>

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>
<%@include file="/includes/footer.jsp" %>