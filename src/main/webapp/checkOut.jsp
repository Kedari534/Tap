<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.tap.model.CartItem" %>
    <%@ page import="java.util.Collection" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order confirmation</title>
<style>
    @charset "UTF-8";

    body {
        background: #FDFCCD;
    }

    .order-summary {
        width: 80%;
        max-width: 700px;
        margin: 2rem auto;
        padding: 1rem;
        background-color: #fff;
        border-radius: 10px;
        box-shadow: 0 2px 15px rgba(0, 0, 0, 0.1);
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    }

    h2 {
        text-align: center;
        color: #333;
        margin-bottom: 1rem;
    }

    .cart-item {
        display: flex;
        align-items: center;
        justify-content: space-between;
        margin-bottom: 1rem;
        padding-bottom: 1rem;
        border-bottom: 1px solid #e1e1e1;
    }

    .cart-details {
        flex: 1;
        padding: 0 1.5rem;
        display: flex;
        flex-direction: column;
    }

    .cart-name {
        font-size: 1.2rem;
        color: #AF0000;
        margin: 0;
    }

    .cart-price {
        color: #666;
        margin-top: 0.5rem;
    }

    .checkout {
        display: block;
        width: max-content;
        margin: 1rem auto;
        text-align: center;
        background-color: #AF0000;
        color: white;
        padding: 0.5rem 2rem;
        border-radius: 0.25rem;
        font-weight: bold;
    }

    .checkout:hover {
        background-color: #AF0000;
    }

    p {
        text-align: center;
        color: #888;
    }
</style>
</head>
<body>
<div class="order-summary">
    <h2>Order Confirmation</h2>
    <p><strong>Thank you, <%=request.getAttribute("username")%>!</strong></p>
    <p>Your order has been placed successfully.</p>
    
    <h3>Items Ordered:</h3>
    <ul>
        <% 
        for (CartItem item : (Collection<CartItem>) request.getAttribute("cartItems")) {
            out.println("<li>" + item.getName() + " - Quantity: " + item.getQuantity() + "</li>");
        }
        %>
    </ul>
    
    <a href="restaurantHomepage1">Back to Home</a>
</div>

</body>
</html>