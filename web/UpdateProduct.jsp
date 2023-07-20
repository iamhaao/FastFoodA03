<%-- 
    Document   : UpdateProduct
    Created on : Jun 14, 2023, 11:00:15 PM
    Author     : ACER NITRO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="includes/header.jsp" %>
<div class="">
    <c:set value="${requestScope.product}" var="p"></c:set>
        <div class="">
            <h5 class="">Update PRODUCT</h5>
        </div>
        <div class="">
            <div class="py-1">
                <form action="manageProduct" method="post" enctype="multipart/form-data">
                    <div class="row">
                        <div class="col">
                            <div class="row">
                                <div class="col">
                                    <div class="form-group">
                                        <label>Full Name Product</label>
                                        <input class="form-control border rounded" id="name" type="text" name="name" placeholder="Name Product" value="${p.name}" >
                                    <input type="hidden" name="updateId" id="updateId" value="${p.idProduct}">
                                    <input type="hidden" name="action" id="updateId" value="update">
                                </div>
                            </div>
                            <div class="col-sm-5 mt-4">
                                <div class="form-group">
                                    <label>Catogery</label>
                                    <select name="catogery" class="px-16 ml-4 border rounded" id="catogery ">
                                        <option value="${p.idCatory}">--Choose A Category of PRODUCT--</option>
                                        <c:forEach items="${requestScope.listCatogery}" var="c">
                                            <option value="${c.idCatory}">${c.name}</option>
                                        </c:forEach>
                                    </select>

                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-4">
                                <div class="form-group">
                                    <label>Price</label>
                                    <input name="price" id="price" class="form-control  border rounded" value="${p.price}" type="text" placeholder="price">
                                </div>
                            </div>
                            <div class="col-sm-4 ">
                                <div class="form-group">
                                    <label>Quantity</label>
                                    <input name="quantity" id="quantity" class="form-control  border rounded" value="${p.quantity}" type="text" placeholder="quantity">
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col mb-3">
                                <div class="form-group">
                                    <label>Description</label>
                                    <input name="description" value="${p.description}" id="description" class="form-control border rounded"  placeholder="Description for product">
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-8">
                                <label>Upload image</label> 
                                <input class="ml-8" type="file" id="image"  name="image" value="${p.image}" >
                            </div>
                        </div>

                    </div>
                </div>


                <div class="row">
                    <div class="col d-flex justify-content-end">
                        <button class="btn btn-primary bg-primary" type="submit">Save Changes</button>
                    </div>
                </div>
            </form>

        </div>
    </div>
</div>
<%@include file="includes/footer.jsp" %>
