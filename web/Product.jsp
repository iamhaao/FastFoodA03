<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/includes/header.jsp" %>
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css" integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
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

    <div class="more-product  w-[95%] lg:w-[95%] mx-auto mb-25">
        <div class="grid grid-cols-1  md:grid-cols-2 gap-4 lg:grid-cols-4 gap-2">
            <c:forEach items="${requestScope.products}" var="p">
                <c:if test="${p.quantity==1}">
                    <div class="lh-product-card">
                        <div class="h-[330px] bg-[url(${p.image})] bg-cover bg-no-repeat bg-center">
                            <a href="addcart?id=${p.idProduct}" alt="BestSeller1">
                                <div class="w-full h-full hover:bg-gray-900 hover:bg-opacity-10 after::transition-all a:ease-in-out
                                     after:duration-500
                                     relative group">
                                    <div class="absolute bg-white w-11/12 bottom-4 text-center left-1/2 -translate-x-1/2 text-[13px]  text-gray-900 tracking-wider py-4 px-8 text-sm font-semibold hover:cursor-pointer
                                         hover:bg-opacity-40">
                                        ADD TO CART
                                    </div>
                                </div>
                            </a>
                        </div>
                        <div class="text-center my-8">
                            <a href="preview?id=${p.idProduct}" alt="prodcut-name">
                                <div class="text-xl mb-3 hover:text-orange-600">${p.name}</div>
                            </a>
                            <div class="price ">
                                <span class="ml-2 text-gray-400 ">${p.price}VND</span>
                            </div>
                        </div>
                    </div>
                </c:if>
            </c:forEach>
        </div>


                <ul class="pagination mb-sm-0">                 
                    <c:forEach begin="1" end="${endPage}" var="i">
                        <c:if test="${i eq 1}">
                        <li class="page-item disabled">
                            <a href="products?nameSearch&choose=0&index=${i}">
                                <i class="mdi mdi-chevron-left"></i>
                            </a>
                        </li>
                    </c:if>
                        <li class="page-item"><a href="products?nameSearch&choose=0&index=${i}" class="page-link">${i}</a></li>
                        
                   <c:if test="${i eq endPage}">
                    <li class="paginatio-item">
                        <a href="products?nameSearch&choose=0&index=${i}">
                          <i class="mdi mdi-chevron-right"></i>
                        </a>
                    </li>
                </c:if>
                   </c:forEach>
                    <li class="page-item">
                        <a href="#" class="page-link"></a>
                    </li>
                </ul>

    </div>
</main>
<%@include file="/includes/footer.jsp" %>

