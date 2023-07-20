<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="./includes/header.jsp" %>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
<div class="container">
    <div class="row flex-lg-nowrap">

        <div class="row flex-lg-nowrap">
            <div class="col mb-3">
                <div class="e-panel card">
                    <div class="card-body">

                        <div class="e-table">
                            <div class="table-responsive table-lg mt-3">
                                <table class="table table-bordered">
                                    <thead>
                                        <tr>

                                        <th>Photo</th>
                                        <th class="max-width">Name</th>
                                        <th class="sortable">Date</th>
                                        <th >Status</th>
                                        <th>Actions</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${requestScope.listProducts}" var="p">
                                            <tr>

                                            <td class="align-middle text-center">
                                                <div class="bg-light d-inline-flex justify-content-center align-items-center align-top" style="width: 35px; height: 35px; border-radius: 3px;"><img src="${p.image}" alt="alt"/></div>
                                            </td>
                                            <td class="text-nowrap align-middle">${p.name}</td>
                                            <td class="text-nowrap align-middle"><span>${p.createdAt}</span></td>
                                            <c:if test="${p.quantity==1}"><td> Available</td> </c:if>
                                            <c:if test="${p.quantity==0}"> <td>UnAvailable</td> </c:if>
                                            <td class="text-center align-middle">
                                                <form action="manageProduct" method="post">
                                                <div class="btn-group align-top">
                                                    <input type="hidden" name="idProduct" value="${p.idProduct}">
                                                    <input type="hidden" name="action" value="getProduct">
                                                    <button class="btn btn-sm bg-secondary btn-outline-secondary badge" type="submit">Edit</button>
                                                    <button class="btn btn-sm bg-danger btn-outline-secondary badge" id="btnDelete" type="button" onclick="openDelete(${p.idProduct})" data-toggle="modal" data-id="${p.idProduct}" data-target="#modal-delete"><i class="fa fa-trash"></i></button>
                                                </div>
                                                </form>
                                            </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <div class="d-flex justify-content-center">
                                <ul class="pagination mt-3 mb-0">
                                    <li class="disabled page-item"><a href="#" class="page-link">‹</a></li>
                                    <li class="active page-item"><a href="#" class="page-link">1</a></li>
                                    <li class="page-item"><a href="#" class="page-link">2</a></li>
                                    <li class="page-item"><a href="#" class="page-link">3</a></li>
                                    <li class="page-item"><a href="#" class="page-link">4</a></li>
                                    <li class="page-item"><a href="#" class="page-link">5</a></li>
                                    <li class="page-item"><a href="#" class="page-link">›</a></li>
                                    <li class="page-item"><a href="#" class="page-link">»</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-12 col-lg-3 mb-3">
                <div class="card">
                    <div class="card-body">
                        <div class="text-center px-xl-3">
                            <button class="btn btn-success bg-success btn-block" type="button" data-toggle="modal" data-target="#user-form-modal">New Product</button>
                        </div>
                        <hr class="my-3">
                        <div class="e-navlist e-navlist--active-bold">
                            <ul class="nav">
                                <li class="nav-item active"><a href="" class="nav-link"><span>All</span>&nbsp;<small>/&nbsp;${requestScope.size}</small></a></li>

                            </ul>
                        </div>
                        <hr class="my-3">


                    </div>
                </div>
            </div>
        </div>

        <!-- User Form Modal -->
        <div class="modal fade" role="dialog" tabindex="-1" id="user-form-modal">
            <div class="modal-dialog modal-lg" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Create NEW PRODUCT</h5>
                        <button type="button" class="close" data-dismiss="modal">
                            <span aria-hidden="true">×</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="py-1">
                            <form action="manageProduct" method="post" enctype="multipart/form-data">
                                <div class="row">
                                    <div class="col">
                                        <div class="row">
                                            <div class="col">
                                                <input name="action" hidden value="create">
                                                <div class="form-group">
                                                    <label>Full Name Product</label>
                                                    <input class="form-control border rounded" type="text" name="name" placeholder="Name Product" >
                                                </div>
                                            </div>
                                            <div class="col-sm-5">
                                                <div class="form-group">
                                                    <label>Catogery</label>
                                                    <select name="catogery" class="px-16 ml-4 border rounded" id="id">
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
                                                    <input name="price" class="form-control  border rounded" type="text" placeholder="price">
                                                </div>
                                            </div>
                                            <div class="col-sm-4 ">
                                                <div class="form-group">
                                                    <label>Quantity</label>
                                                    <input name="quantity" class="form-control  border rounded" type="text" placeholder="quantity">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col mb-3">
                                                <div class="form-group">
                                                    <label>Description</label>
                                                    <textarea name="description" class="form-control border rounded" rows="5" placeholder="Description for product"></textarea>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-sm-8">
                                                <label>Upload image</label> 
                                                <input class="ml-8" type="file"  name="image" >
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
            </div>
        </div>
    </div>
        <div id="modal-delete" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="manageProduct" method="post">
                        <input type="hidden" name="action" value="delete"/>
                        <input type="hidden" name="idProduct" id="idProduct" value="">
                        <div class="modal-header">						
                            <h4 class="modal-title">Delete Product</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">					
                            <p>Are you sure you want to delete these Product?</p>
                            <p class="text-warning"><small>This action cannot be undone.</small></p>
                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                            <input type="submit" class="btn btn-danger bg-danger" value="Delete">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script >
function openDelete(productId) {
    document.getElementById('idProduct').value = productId;
  $('#modal-delete').modal('show');  
}

        </script>
<%@include file="./includes/footer.jsp" %>
