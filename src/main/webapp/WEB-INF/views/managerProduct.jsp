<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<html>
<head>
    <title>Manager product</title>
    <base href="/">
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
    <link href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700' rel='stylesheet' type='text/css'>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

    <link rel="stylesheet" href="css/managerProduct.css">
    <!--============================================================-->
</head>
<body>
<%@include file="layout/managerHeader.jsp" %>
<div class="container__content">
    <div class="content__form">
        <table class="table">
            <thead class="thead-primary">
            <tr>
                <th class="text-center">Product Name</th>
                <th class="text-center">Amount</th>
                <th class="text-center">Price</th>
                <th class="text-center">Image</th>
                <th class="text-center">Author</th>
                <th class="text-center">Publisher</th>
                <th class="text-center">Action</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach items="${products.content}" var="product">
                <tr>
                    <td class="text-center"> ${product.name} </td>
                    <td class="text-center"> ${product.amount} </td>
                    <td class="text-center"> ${product.price} </td>
                    <td class="text-center"> <img src="images/book/${product.image}" alt="IMG-PRODUCT" style="width: 30%"> </td>
                    <td class="text-center"> ${product.author} </td>
                    <td class="text-center"> ${product.publisher} </td>
                    <td>
                        <a href="/viewEditProduct/${product.ID}" class="btn-outline-primary mr-2" style="color: #117a8b">&#9998;Edit</a>
                        <br/>
                        <a href="/deleteProduct/${product.ID}" onclick=" ConfirmDelete()" class="btn-outline-primary mr-2" style="color: #117a8b" >&#x2718;Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <nav aria-label="Page navigation example">
            <ul class="pagination">
                <c:forEach items="${pageNumbers}" var="pageNumber">
                    <li class="page-item ${pageNumber == products.number + 1 ? "active" : ""}"><a class="page-link" href="/managerProduct?page=${pageNumber}&size=${products.size}">${pageNumber}</a></li>
                </c:forEach>
            </ul>
        </nav>
    </div>
</div>

<%@include file="layout/footer.jsp" %>
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
<script>
    function ConfirmDelete() {
        confirm("Do you wanna delete product!");
    }
</script>
</body>
</html>