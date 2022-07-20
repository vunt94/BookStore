<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Payment</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--===============================================================================================-->
    <link rel="icon" type="image/png" href="images/icons/favicon.png"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="fonts/iconic/css/material-design-iconic-font.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="fonts/linearicons-v1.0.0/icon-font.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/perfect-scrollbar/perfect-scrollbar.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="css/util.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <!--===============================================================================================-->
</head>
<body class="animsition">

<!-- Header -->
<%@include file="/WEB-INF/views/layout/header.jsp"%>

<!-- breadcrumb -->
<section class="sec-product-detail bg0 p-t-65 p-b-60">
<div class="container">
    <div class="bread-crumb flex-w p-l-25 p-r-15 p-t-30 p-lr-0-lg">
        <a href="index.html" class="stext-109 cl8 hov-cl1 trans-04">
            Cart
            <i class="fa fa-angle-right m-l-9 m-r-10" aria-hidden="true"></i>
        </a>

        <span class="stext-109 cl4">
        Payment
			</span>
    </div>
</div>

<!-- shipment -->
    <div class="container">
        <div class="">
            <div class="">
                <div class="m-l-25 m-r--38 m-lr-0-xl">
                    <div class="wrap-table-shopping-cart">
                        <table class="table-shopping-cart">
                            <tr class="table_head">
                                <th class="column-1">
                                    Shipment
                                </th>
                            </tr>

                            <tr class="table_row" style="padding-bottom: 20px; height: 80px;">
                                <td class="column-1"><b>Name</b></td>
                                <td class="column-2"><b>Address</b></td>
                                <td class="column-3"><b>Phone number</b></td>
                            </tr>
                                <tr class="table_row" style="padding-bottom: 20px; height: 80px;">
                                    <td class="column-1" style="margin-left: 15px">${account.userName}</td>
                                    <c:if test="${shipment == null}">
                                        <td class="column-2"><input name="shipping-address" type="text" style="border: solid"/></td>
                                    </c:if>
                                    <c:if test="${shipment != null}">
                                        <td class="column-2">${shipment.shippingAddress}</td>
                                    </c:if>
                                    <td class="column-3">${account.phoneNumber}</td>
                                </tr>
                        </table>
                    </div>

                </div>
            </div>
        </div>
    </div>
<!-- Shoping Cart -->
<form class="bg0 p-t-75 p-b-85">
    <div class="container">
        <div class="row">
            <div class="col-lg-10 col-xl-7 m-lr-auto m-b-50">
                <div class="m-l-25 m-r--38 m-lr-0-xl">
                    <div class="wrap-table-shopping-cart">
                        <table class="table-shopping-cart">
                            <tr class="table_head">
                                <th class="column-1">Product</th>
                                <th class="column-2"></th>
                                <th class="column-3">Price</th>
                                <th class="column-4">Quantity</th>
                                <th class="column-5">Total</th>
                            </tr>
                            <c:forEach items="${orderDetails}" var="orderDetail">
                                <tr class="table_row">
                                    <td class="column-1">
                                        <div class="how-itemcart1">
                                            <img src="images/book/${productByOrder.get(orderDetail).image}" alt="IMG">
                                        </div>
                                    </td>
                                        <%--                                    <td class="column-2">${product.getID()}</td>--%>
                                        <%--                                    <td class="column-3">${item.getProductID()}</td>--%>
                                    <td class="column-2">${productByOrder.get(orderDetail).name}</td>
                                    <td class="column-3">
                                        $${productByOrder.get(orderDetail).price}</td>
                                    <td class="column-4">${orderDetail.quantity}</td>
                                    <td class="column-5">
                                        $${orderDetail.subPrice}</td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>

                    <div class="flex-w flex-sb-m bor15 p-t-18 p-b-15 p-lr-40 p-lr-15-sm">
                        <div class="flex-w flex-m m-r-20 m-tb-5">
                            <div>
                                Note:
                            </div>
                            <c:if test="${order == null}">
                                <input class="stext-104 cl2 plh4 size-333 bor13 p-lr-20 m-r-10 m-tb-5" type="text" name="order-note" placeholder="Note to seller...">
                            </c:if>
                            <c:if test="${order != null}">
                                ${order.note}
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-sm-10 col-lg-7 col-xl-5 m-lr-auto m-b-50">
                <div class="bor10 p-lr-40 p-t-30 p-b-40 m-l-63 m-r-40 m-lr-0-xl p-lr-15-sm">
                    <h4 class="mtext-109 cl2 p-b-30">
                        Payment Totals
                    </h4>
                    <div class="">
                        <div class="size-208 w-full-ssm">
								<span class="stext-110 cl2">
									Ship type:
								</span>
                        </div>

                        <div class="">
                            <p class="stext-111 cl6 p-t-2">
                            </p>

                            <div class="">


                                <div class="rs1-select2 rs2-select2 bor8 bg0 m-b-12 m-t-9">
                                    <c:if test="${shipment == null}">
                                        <select class="js-select2" name="shipping-type">
                                            <option>Select a type ship...</option>
                                            <option value="0">Standrad delivery</option>
                                            <option value="1">Express delivery</option>
                                        </select>
                                    </c:if>
                                    <div class="dropDownSelect2"></div>
                                    <c:if test="${shipment != null}">
                                        ${shipment.shippingType == 0 ? "Standrad delivery" : "Express delivery"}
                                    </c:if>
                                </div>

                                <div class="flex-w flex-t bor12 p-b-13">
                                    <div class="size-208">
								<span class="stext-110 cl2">
									Ship cost:
								</span>
                                    </div>

                                    <div class="size-209">
								<span class="mtext-110 cl2">
									$${shipment == null ? (shipment.shippingType == 0 ? 300 : 900) : shipment.shippingCost}
								</span>
                                    </div>
                                    <div class="flex-w">
                                        <div class="flex-c-m stext-101 cl2 size-115 bg8 bor13 hov-btn3 p-lr-15 trans-04 pointer">
                                            Update Totals
                                        </div>
                                    </div>
                                </div>


                            </div>
                        </div>
                    </div>

                    <div class="flex-w flex-t p-t-27 p-b-33">
                        <div class="size-208">
								<span class="mtext-101 cl2">
									Total:
								</span>
                                <span class="mtext-110 cl2">
									$${totalPrice}
								</span>
                        </div>
                    </div>

                    <c:if test="${order == null}">
                        <button class="flex-c-m stext-101 cl0 size-116 bg3 bor14 hov-btn3 p-lr-15 trans-04 pointer"
                                type="submit"
                                formaction="/payment-add"
                                formmethod="post">
                            Proceed to Checkout
                        </button>
                    </c:if>
                    <c:if test="${order != null}">
                        <input type="hidden" name="id" value="${order.id}">
                        <button class="flex-c-m stext-101 cl0 size-116 bg3 bor14 hov-btn3 p-lr-15 trans-04 pointer"
                                type="submit"
                                formaction="/payment-delete"
                                style="background-color: red"
                                formmethod="post">
                            Delete order
                        </button>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</form>

</section>


<!-- Footer -->
<%@include file="/WEB-INF/views/layout/footer.jsp" %>

<!-- Back to top -->
<div class="btn-back-to-top" id="myBtn">
		<span class="symbol-btn-back-to-top">
			<i class="zmdi zmdi-chevron-up"></i>
		</span>
</div>

<!--===============================================================================================-->
<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/bootstrap/js/popper.js"></script>
<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/select2/select2.min.js"></script>
<script>
    $(".js-select2").each(function(){
        $(this).select2({
            minimumResultsForSearch: 20,
            dropdownParent: $(this).next('.dropDownSelect2')
        });
    })
</script>
<!--===============================================================================================-->
<script src="vendor/MagnificPopup/jquery.magnific-popup.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/perfect-scrollbar/perfect-scrollbar.min.js"></script>
<script>
    $('.js-pscroll').each(function(){
        $(this).css('position','relative');
        $(this).css('overflow','hidden');
        var ps = new PerfectScrollbar(this, {
            wheelSpeed: 1,
            scrollingThreshold: 1000,
            wheelPropagation: false,
        });

        $(window).on('resize', function(){
            ps.update();
        })
    });
</script>
<!--===============================================================================================-->
<script src="js/main.js"></script>

</body>
</html>