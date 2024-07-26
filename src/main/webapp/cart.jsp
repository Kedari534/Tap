<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.tap.model.CartCreator" %>
    <%@ page import="com.tap.model.CartItem" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="cart.css">
</head>
<body>
	<div class="cart-container">
	
		<h2>Your Shopping Cart </h2>
		<%
		CartCreator cartCreator = (CartCreator) session.getAttribute("cartCreator");
		if(session.getAttribute("userId") !=null) {
		int userId=(int)session.getAttribute("userId");
		session.setAttribute("userId", userId);
		  }
		if (cartCreator != null && !cartCreator.getAll().isEmpty()) {
			float total = 0;
			int restaurantId = 0;
			int menuId = 0;
			

			for (CartItem item : cartCreator.getAll().values()) {
				total += item.getPrice() * item.getQuantity();
				restaurantId = item.getRestaurantId();
		%>
		<div class="cart-item">
			<img class="cart-image" src="<%=item.getImagePath()%>"
				alt="Product Image">
			<div class="cart-details">
				<h4 class="cart-name"><%=item.getName()%></h4>
				<div class="form">
					<form action="CallServletCart10" method="post">
						<input type="hidden" name="name" value="<%=item.getName()%>">
						<input type="hidden" name="imagepath"
							value="<%=item.getImagePath()%>"> <input type="hidden"
							name="menuId" value="<%=item.getMenuId()%>"> <input
							type="hidden" name="restaurantId"
							value="<%=item.getRestaurantId()%>"> <input
							type="hidden" name="price" value="<%=item.getPrice()%>">
						<input type="hidden" name="quantity" value="1">
						<button type="submit">+</button>
						<input type="text" name="userInput"
							value="<%=item.getQuantity()%>" readonly>


					</form>
					<form action="CallServletCart2" method="post">
						<input type="hidden" name="name" value="<%=item.getName()%>">
						<input type="hidden" name="imagepath"
							value="<%=item.getImagePath()%>"> <input type="hidden"
							name="menuId" value="<%=item.getMenuId()%>"> <input
							type="hidden" name="restaurantId"
							value="<%=item.getRestaurantId()%>"> <input
							type="hidden" name="price" value="<%=item.getPrice()%>">
						<input type="hidden" name="quantity" value="-1">
						<button type="submit">-</button>

					</form>
					<p class="cart-price">
						Price: &#8377;
						<%=item.getPrice() * item.getQuantity()%></p>
					<a href="CallServletCart3?menuId=<%=item.getMenuId()%>">remove</a>

				</div>
			</div>
		</div>

		<%
		}
		%>
		<div class="add">
			<a href="MenuServlet?restaurantId=<%=restaurantId%>">Add more</a>
		</div>
		<div class="cart-total">
			Total: &#8377;
			<%=total%>
			<%
			if (cartCreator != null) {

				session.setAttribute("cartCreator", cartCreator);
				session.setAttribute("total", total);
				session.setAttribute("restaurantId", restaurantId);
			}
			%>
		</div>
		<br>
		<form action="CheckoutServlet" method="post">
			<button type="submit" class="checkout">Checkout</button>
		</form>
		<%
		} else {
		%>
		<p>No items in your cart.</p>
		<%
		}
		%>
	</div>

</body>
</html>