<%@taglib prefix="my" uri="/WEB-INF/tlds/customtaglid" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
    <c:set var="p" value="${requestScope.p}"/>
    <section class="ftco-section">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 mb-5 ftco-animate">
                    <a href="#" class="image-popup"><img src="${p.image}" class="img-fluid"
                                                         alt="Colorlib Template"></a>
                </div>
                <div class="col-lg-6 product-details pl-md-5 ftco-animate">
                    <h3>${p.name}</h3>
                    <div class="rating d-flex">
                        <p class="text-left mr-4">
                        <div><my:Rating min="0" max="5" num="${avgRating}"/></div>
                        </p>
                        <br>
                        <p class="text-left mr-4">
                            <a href="#" class="mr-2" style="color: #000;">${requestScope.review}<span style="color: #bbb;">Rating</span></a>
                        </p>
                        <p class="text-left">
                            <a href="#" class="mr-2" style="color: #000;">500 <span style="color: #bbb;">Sold</span></a>
                        </p>
                    </div>
                    <p class="price"><span>$ ${p.price} VND</span></p>
                    <p>${p.description}
                    </p>

                    <p><a href="addcart?id=${p.idProduct}" class="btn btn-black py-3 px-5">Add to Cart</a></p>
                </div>
            </div>
        </div>
    </section>
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/stylePreview2.css"/>
    <section class="content-item" id="comments">
        <div class="container">   
            <div class="row">
                <div class="col-sm-8">   

                    <c:if test="${sessionScope.acc.idAccount != null}">
                        <c:if test="${sessionScope.checkToFeedBack == 1}">
                            <form action="feedback" method="GET">
                                <h3 class="pull-left">New Comment</h3>

                                <button type="submit" class="btn btn-normal bg-danger text-white pull-right">Submit</button>
                                <fieldset>
                                    <div class="row">
                                        <div class="col-sm-3 col-lg-2 hidden-xs">
                                            <img class="img-responsive" src="${sessionScope.acc.avatar}" alt="">
                                        </div>
                                        <div class="form-group col-xs-12 col-sm-9 col-lg-10">
                                            <input value="${p.idProduct}" name="idProduct" class="text-white">
                                            <div class="star-rating">
                                                <span class="fa fa-star-o" data-rating="1"></span>
                                                <span class="fa fa-star-o" data-rating="2"></span>
                                                <span class="fa fa-star-o" data-rating="3"></span>
                                                <span class="fa fa-star-o" data-rating="4"></span>
                                                <span class="fa fa-star-o" data-rating="5"></span>
                                                <input type="hidden" name="whatever1" class="rating-value" value="5">
                                            </div>
                                            <textarea name="comment" class="form-control" id="message" placeholder="Your message" required=""></textarea>

                                        </div>
                                    </div>  	
                                </fieldset>

                            </form>
                        </c:if>   

                    </c:if>

                    <h3>Comments:</h3>


                    <c:forEach items="${listFb}" var="fb">

                        <div class="media">

                            <a class="pull-left" href="#"><img class="media-object" src="${fb.avatar}" alt=""></a>
                            <div class="media-body">
                                <h6>${fb.name}</h6>
                                <div><my:Rating min="0" max="5" num="${fb.rating}"/></div>
                                <p>${fb.script}</p>
                                <ul class="list-unstyled list-inline media-detail pull-left">
                                    <li><i class="fa fa-calendar"></i>${fb.date}</li>
                                </ul>

                            </div>

                        </div>

                    </c:forEach>
                    <!-- COMMENT 4 - END -->

                </div>
            </div>
    </section>
    <script>
        var $star_rating = $('.star-rating .fa');

        var SetRatingStar = function () {
            return $star_rating.each(function () {
                if (parseInt($star_rating.siblings('input.rating-value').val()) >= parseInt($(this).data('rating'))) {
                    return $(this).removeClass('fa-star-o').addClass('fa-star');
                } else {
                    return $(this).removeClass('fa-star').addClass('fa-star-o');
                }
            });
        };

        $star_rating.on('click', function () {
            $star_rating.siblings('input.rating-value').val($(this).data('rating'));
            return SetRatingStar();
        });

        SetRatingStar();
        $(document).ready(function () {

        });
    </script>


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