var listCart = null;


function updateCart(event) {
    event.preventDefault();
    var listId = new Array();
    var listQuantity = new Array();
    $('.num-product').each(function(){
        listId.push($(this).attr('id'));
        listQuantity.push($(this).attr('name'));
    })
    ajaxUpdateCart(listId, listQuantity);
    $('#clickToCheckout').addClass('show').removeClass('hid');
}

function ajaxUpdateCart(listId, listQuantity) {
    $.ajax({
        type : "POST",
        url : "updateCart",
        data : {listId : listId,
                listQuantity : listQuantity},
        success : function(result) {
            if (result.status == "success") {
                alert("The number of products you want to buy exceeds the quantity in stock!\n" +
                    "The amount of that product will be returned the maximum amount that you can buy in the cart");
            }
            var totalMoney = 0;
            var price = 0;
            var quantity = 0;
            $('.table-shopping-cart').contents().remove();
            $(".table-shopping-cart").append(`<tr class="table_head">
                                <th class="column-1">Product</th>
                                <th class="column-2"></th>
                                <th class="column-3">Price</th>
                                <th class="column-4">Quantity</th>
                                <th class="column-5">Total</th>
                            </tr>`);
            $.each(result.data,
                function (i, cart) {
                    $(".table-shopping-cart").append(`
                        <tr class="table_row">

                            <td class="column-1">
                                <div class="how-itemcart1">
                                    <img src="images/book/${cart.image}" alt="IMG">
                                </div>
                            </td>
                            <td class="column-2">${cart.name}</td>
                            <td class="column-3">$${cart.price}</td>
                            <td class="column-4">
                                <div class="wrap-num-product flex-w m-l-auto m-r-0">
                                    <div onclick="updatePrice(${cart.productId}, ${cart.price}, 'down')" class="btn-num-product-down cl8 hov-btn3 trans-04 flex-c-m">
                                        <i class="fs-16 zmdi zmdi-minus"></i>
                                    </div>
    
                                    <input id="${cart.productId}" class="mtext-104 cl3 txt-center num-product" type="number" name="${cart.quantity}" value="${cart.quantity}">
    
                                    <div onclick="updatePrice(${cart.productId}, ${cart.price}, 'up')" class="btn-num-product-up cl8 hov-btn3 trans-04 flex-c-m">
                                        <i class="fs-16 zmdi zmdi-plus"></i>
                                    </div>
                                </div>
                            </td>
                            <td
                                  id="totalPrice-${cart.productId}"  class="column-5">$${cart.price * cart.quantity}
                            </td>
                        </tr>`);


                    listCart = JSON.parse(JSON.stringify(result.data[i]));
                    price = listCart.price;
                    quantity = listCart.quantity;
                    totalMoney += price * quantity;
                });
            console.log(totalMoney);
            $('#totalMoney').html("$" + totalMoney);
            // var graphElem = document.querySelector('.icon-favorite-header-noti');
            // graphElem.setAttribute('data-favorite-noti', result.data.length);
        },
        error : function(e) {
            alert("Error!")
            console.log("ERROR: ", e);
        }
    });
}