<%@include file="./includes/header.jsp" %>
<link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Amatic+SC:400,700&display=swap" rel="stylesheet">

<link rel="stylesheet" href="css/open-iconic-bootstrap.min.css">
<link rel="stylesheet" href="css/animate.css">
<link rel="stylesheet" href="css/bootstrap.min.css">


<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesheet" href="css/owl.theme.default.min.css">
<link rel="stylesheet" href="css/magnific-popup.css">

<link rel="stylesheet" href="css/aos.css">

<link rel="stylesheet" href="css/ionicons.min.css">

<link rel="stylesheet" href="css/bootstrap-datepicker.css">
<link rel="stylesheet" href="css/jquery.timepicker.css">


<link rel="stylesheet" href="css/flaticon.css">
<link rel="stylesheet" href="css/icomoon.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="css/style.css">
<main>
    <div class="">
        <div class="basis-1/6  flex flex-row my-16 max-h-11 mr-10 justify-center items-center">
            <div class="tittle text-gray-900 text-xl basis-2/6 text-left justify-start ">
                <h1>${requestScope.type.nameType}</h1> 
            </div>
            <div class="basis-3/6 row height d-flex justify-content-center align-items-center">
            </div>

            <div class="fillte basis-2/6 ml-8 text-right justify-end items-end">
                <form style="width:100%;margin-left: -496px;" action="products" method="get">

                    <input style="width:100%;float: left;" type="search" Placeholder="Search" name="nameSearch"/>
                    <i style="position: absolute;margin: 0.9% 0 0 -3.5%;" class="fa-solid fa-camera"></i>

                    <button style=" position: absolute; margin: 0 0 0 -1px; border: 1px solid #000; padding: 8px 26px; background: #000; color: #fff; "><i class="fa-solid fa-magnifying-glass"></i></button>
                    <select style="position:absolute; margin-left: 300px;" class="border-8px" name="choose" id="">
                        <option value="0">All product</option>
                        <c:forEach items="${requestScope.categorys}" var="c" >
                            <option value="${c.idCatory}">${c.name}</option>
                        </c:forEach>
                    </select>
                    <input style="position: absolute; margin: 0px 0px 0px 432px;border: 1px solid #000;padding: 8px 10px; background:#000;color:#fff;" type="submit" value="Search" />

                </form>
            </div>
        </div>
    </div>
    <div class="row">
        <c:forEach items="${requestScope.products}" var="p">
            <c:if test="${p.quantity==1}">
                <div class="col-md-6 col-lg-3 ftco-animate">
                    <div class="product">
                        <a href="#" class="img-prod"><img class="img-fluid" src="${p.image}" alt="Colorlib Template">
                            <div class="overlay"></div>
                        </a>
                        <div class="text py-3 pb-4 px-3 text-center">
                            <h3><a href="#">${p.name}</a></h3>
                            <div class="d-flex">
                                <div class="pricing">
                                    <p class="price"><span>${p.price}VND</span></p>
                                </div>
                            </div>
                            <div class="bottom-area d-flex px-3">
                                <div class="m-auto d-flex">
                                    <a href="preview?id=${p.idProduct}" class="add-to-cart d-flex justify-content-center align-items-center text-center">
                                        <span><i class="ion-ios-menu"></i></span>
                                    </a>
                                    <a href="addcart?id=${p.idProduct}" class="buy-now d-flex justify-content-center align-items-center mx-1">
                                        <span><i class="ion-ios-cart"></i></span>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:if>
        </c:forEach>
    </div>

    <div class="row mt-5">
        <div class="col text-center">
            <div class="block-27">
                <ul>
                    <li><a href="#">&lt;</a></li>
                        <c:forEach begin="1" end="${endPage}" var="i">
                        <li><a href="products?nameSearch&choose=0&index=${i}">${i}</a></li>
                        </c:forEach>
                    <li><a href="#">&gt;</a></li>
                </ul>
            </div>
        </div>
    </div>

</main>




<script src="js/jquery.min.js"></script>
<script src="js/jquery-migrate-3.0.1.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.easing.1.3.js"></script>
<script src="js/jquery.waypoints.min.js"></script>
<script src="js/jquery.stellar.min.js"></script>
<script src="js/owl.carousel.min.js"></script>
<script src="js/jquery.magnific-popup.min.js"></script>
<script src="js/aos.js"></script>
<script src="js/jquery.animateNumber.min.js"></script>
<script src="js/bootstrap-datepicker.js"></script>
<script src="js/scrollax.min.js"></script>
<script
src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
<script src="js/google-map.js"></script>
<script src="js/main.js"></script>
<%@include file="./includes/footer.jsp" %>