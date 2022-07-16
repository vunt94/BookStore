<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<html>
<head>
    <title>Create product</title>
    <link rel="stylesheet" type="text/css" href="css/productStyle.css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--===============================================================================================-->
    <link rel="icon" type="image/png" href="/images/icons/favicon.png"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="fonts/iconic/css/material-design-iconic-font.min.css"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="fonts/linearicons-v1.0.0/icon-font.min.css"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/slick/slick.css"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/MagnificPopup/magnific-popup.css"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/perfect-scrollbar/perfect-scrollbar.css"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="css/util.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
    <!--============================================================-->
</head>
<body>
<%@include file="/WEB-INF/views/layout/header.jsp" %>
<%--<jsp:include page="./layout/headerComponent.jsp"></jsp:include>--%>
<div class="container__content">
    <c:if test="${addProductSuccess}">
        <div>Successfully added product ${savedProduct.name}</div>
    </c:if>
    <c:url var="add_product_url" value="/addProduct"/>
    <div class="content__form">


        <form onsubmit="return isValidForm()" action="${add_product_url}" method="post" modelAttribute="product">
            <div class="row">
                <div class="col-25">
                    <label>Product Name</label>
                </div>
                <div class="col-75">
                    <input type="text" path="name" id="name" name="name" required="" placeholder="Product name..">
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label>Amount</label>
                </div>
                <div class="col-75">
                    <input type="text" path="amount" id="amount" name="amount" required=""
                           placeholder="Product amount..">
                </div>
                <p id="amountError"></p>
            </div>
            <div class="row">
                <div class="col-25">
                    <label>Price</label>
                </div>
                <div class="col-75">
                    <input type="text" path="price" id="price" name="price" required="" placeholder="Product price..">
                </div>
                <p id="priceError"></p>
            </div>
            <div class="row">
                <div class="col-25">
                    <label>Category</label>
                </div>
                <div class="col-75">
                    <select class="custom-select tm-select-accounts" path="categoryId" id="categoryId"
                            name="categoryId">
                        <option selected="">Select category</option>
                        <option value="1">Story</option>
                        <option value="2">Novel</option>
                        <option value="3">Children's books</option>
                    </select>
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label for="description">Description</label>
                </div>
                <div class="col-75">
                <textarea id="description" path="description" name="description" required=""
                          placeholder="Write something about product.." style="height:200px"></textarea>
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label class="col-md-4 control-label" for="image">Image</label>
                </div>
                <div class="col-75">
                    <input id="image" path="image" name="image" required="" class="input-file" type="file">
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label>Author Name</label>
                </div>
                <div class="col-75">
                    <input type="text" id="author" path="author" name="author" required="" placeholder="Author name..">
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label>Publisher</label>
                </div>
                <div class="col-75">
                    <input type="text" path="publisher" id="publisher" required="" name="publisher">
                </div>
            </div>
            <div class="row f-l-end">
                <input type="submit" onclick="return myFunction()" value="Submit">
            </div>
        </form>
    </div>
</div>
<%@include file="/WEB-INF/views/layout/footer.jsp" %>
<script src="js/main.js"></script>
<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/bootstrap/js/popper.js"></script>
<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/select2/select2.min.js"></script>

<!--===============================================================================================-->
<script src="vendor/daterangepicker/moment.min.js"></script>
<script src="vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
<script src="vendor/slick/slick.min.js"></script>
<script src="js/slick-custom.js"></script>
<!--===============================================================================================-->
<script src="vendor/parallax100/parallax100.js"></script>

<!--===============================================================================================-->
<script src="vendor/MagnificPopup/jquery.magnific-popup.min.js"></script>

<!--===============================================================================================-->
<script src="vendor/isotope/isotope.pkgd.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/sweetalert/sweetalert.min.js"></script>

<!--===============================================================================================-->
<script src="vendor/perfect-scrollbar/perfect-scrollbar.min.js"></script>
<script>
    $('.js-pscroll').each(function () {
        $(this).css('position', 'relative');
        $(this).css('overflow', 'hidden');
        var ps = new PerfectScrollbar(this, {
            wheelSpeed: 1,
            scrollingThreshold: 1000,
            wheelPropagation: false,
        });

        $(window).on('resize', function () {
            ps.update();
        })
    });
</script>
<!--===============================================================================================-->
<script src="js/main.js"></script>


</body>
</html>