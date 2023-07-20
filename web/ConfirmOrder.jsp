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
                                    <th>ID Account</th>
                                    <th>Total</th>
                                    <th>Created At</th>
                                    <th>Confirm</th>
                                    <th>Detail</th>
                                </tr>
                            </thead>
                            <c:forEach var="o" items="${sessionScope.listConfirm}">
                                <tbody class="table-body">
                                    <tr class="cell-1">

                                        <td>#${o.idOrder}</td>
                                        <td>${o.idAccount}</td>
                                        <td>${o.price}VND</td>
                                        <td>${o.date}</td>
                                        <td >
                                            <form action="confirmOrder">
                                                <input type="text" hidden="hidden" name="id" value="${o.idOrder}">
                                                <select class="border rounded" name="status">
                                                    <option value="4">Confirm</option>
                                                    <option value="3">Refuse</option>
                                                </select>
                                                <input class=" text-white border p-2 rounded bg-primary" type="submit" value="Save" />
                                            </form>

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