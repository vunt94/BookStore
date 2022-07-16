GET: $(document).ready(
    function () {
        var flag = true;
        // GET REQUEST
        $("#wishlistIcon").click(function (event) {
            event.preventDefault();
            if (flag) {
                ajaxGet();
            }

        });

        // DO GET
        function ajaxGet() {
            $.ajax({
                type: "GET",
                url: "getWishlist",
                success: function (result) {
                    if (result.status == "success") {
                        // $('.js-panel-cart').addClass('show-header-cart');
                        $.each(result.data,
                            function (i, product) {
                                document.getElementById("header-cart__content").innerHTML +=
                                    `<div class="header-cart-content flex-w disable-scroll">
                                    <ul class="header-cart-wrapitem w-full">
                                    <li class="header-cart-item flex-w flex-t m-b-12">
                                    
                                    <div onclick="deleteItem(event, ${product.id})"  id="deleteFromWishlist" class="header-cart-item-img">
                                     
                                    <img src="images/book/${product.image}" alt="IMG">
                                    </div>
                                    
                                    <div class="header-cart-item-txt p-t-8">
                                    <a href="#" class="header-cart-item-name m-b-18 hov-cl1 trans-04">
                                    ${product.name}
                                    </a>                                  
                                    <span class="header-cart-item-info">
                                    ${product.price}$
                                    </span>
                                    </div>
                                    </li>
                                    </ul>
                                    </div>`;
                            });
                        flag = false;
                        console.log("Success: ", result);
                    } else {
                        $("#getResultDiv").html("<strong>Error</strong>");
                        console.log("Fail: ", result);
                    }
                },
                error: function (e) {
                    $("#getResultDiv").html("<strong>Error</strong>");
                    console.log("ERROR: ", e);
                }
            });
        }
    })

function deleteItem(event, id) {
    //Prevent the form from submitting via the browser.
    event.preventDefault();
    ajaxPost(id);
}

function ajaxPost(id) {
    $.ajax({
        type : "POST",
        url : "deleteProductInWishlist",
        data : {'id' : id},
        success : function(result) {
            if (result.status == "success") {
                $('#header-cart__content').contents().remove();
                $.each(result.data,
                    function (i, product) {
                        document.getElementById("header-cart__content").innerHTML +=
                            `<div class="header-cart-content flex-w disable-scroll">
                                    <ul class="header-cart-wrapitem w-full">
                                    <li class="header-cart-item flex-w flex-t m-b-12">

                                    <div onclick="deleteItem(event, ${product.id})" id="deleteFromWishlist" class="header-cart-item-img">
                                    <img src="images/book/${product.image}" alt="IMG">
                                    </div>

                                    <div class="header-cart-item-txt p-t-8">
                                    <a href="#" class="header-cart-item-name m-b-18 hov-cl1 trans-04">
                                    ${product.name}
                                    </a>
                                    <span class="header-cart-item-info">
                                    ${product.price}$
                                    </span>
                                    </div>
                                    </li>
                                    </ul>
                                    </div>`;
                    });
                var graphElem = document.querySelector('.icon-favorite-header-noti');
                graphElem.setAttribute('data-favorite-noti', result.data.length);
            } else {
                $("#postResultDiv").html("<strong>Error</strong>");
            }
            console.log(result);
        },
        error : function(e) {
            alert("Error!")
            console.log("ERROR: ", e);
        }
    });

}

function addToWishlist(event, id) {
    event.preventDefault();
    addProductToWishlist(id);
}

function addProductToWishlist(id) {
    $.ajax({
        type : "POST",
        url : "addProductToWishlist",
        data : {'id' : id},
        success : function(result) {
            if (result.status == "success") {
                $('#header-cart__content').contents().remove();
                console.log(result.data.length)
                $.each(result.data,
                    function (i, product) {
                        document.getElementById("header-cart__content").innerHTML +=
                            `<div class="header-cart-content flex-w disable-scroll">
                                    <ul class="header-cart-wrapitem w-full">
                                    <li class="header-cart-item flex-w flex-t m-b-12">

                                    <div onclick="deleteItem(event, ${product.id})" id="deleteFromWishlist" class="header-cart-item-img">
                                    <img src="images/book/${product.image}" alt="IMG">
                                    </div>

                                    <div class="header-cart-item-txt p-t-8">
                                    <a href="#" class="header-cart-item-name m-b-18 hov-cl1 trans-04">
                                    ${product.name}
                                    </a>
                                    <span class="header-cart-item-info">
                                    ${product.price}$
                                    </span>
                                    </div>
                                    </li>
                                    </ul>
                                    </div>`;
                    });
                var graphElem = document.querySelector('.icon-favorite-header-noti');
                graphElem.setAttribute('data-favorite-noti', result.data.length);
            } else {
                $("#postResultDiv").html("<strong>Error</strong>");
            }
            console.log(result);
        },
        error : function(e) {
            alert("Error!")
            console.log("ERROR: ", e);
        }
    });
}
