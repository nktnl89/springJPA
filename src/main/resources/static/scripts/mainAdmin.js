let productArrayCategory = [];

window.onload = function() {
    $(".saveChanges").click(function() {saveChangesOnClick(this)});
    $(".deleteProduct").click(function() {deleteProductOnClick(this)});
}

$(".orders").click(function (event) {
    createPopupForOrders();
});

function createPopupForOrders(){
    $("<div>", {class: "createProductPopup"}).appendTo($("body"));
    $("<div>", {class: "createProductPopupContent"}).appendTo(".createProductPopup");
    $("<div>", {class: "newProductHeader"}).appendTo(".createProductPopupContent");
    $("<div>", {class: "headline", text: "Заказы:"}).appendTo(".newProductHeader");
    $("<div>", {class: "closeButton", text: "[X]"}).appendTo(".newProductHeader");
    $(".closeButton").click(function() {$(".createProductPopup").remove()});

    createOrdersElement(document.querySelector(".createProductPopupContent"))
}

function createOrderElement(order, parentNode) {
    $("<div>", {class: "order"+order.id, text: "Заказ №"+order.id+"; Пользователь: "+order.basket.user.login+"; "+order.orderDateTime+"; Сумма: "+order.basket.sum+"; Скидка: "+order.basket.discountSum}).appendTo(parentNode);
    order.basket.productList.forEach(function(product, i, data) {
        $("<div>", {class: "orderProduct"+i, text: product.text+" "+product.price}).appendTo(document.querySelector(".order"+order.id));
    });
}

function createOrdersElement(parentNode) {
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "products/orders",
        data: null,
        dataType: "json",
        cache: false,
        timeout: 600000,
        success: function (data) {
            data.forEach(function(order, i, data) {
                createOrderElement(order, parentNode);
            });
        }
    });
}