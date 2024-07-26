<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page  import = "com.tap.model.Restaurant,java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	
<style>
    .restaurant-container {
        display: flex;
        flex-wrap: wrap;
        justify-content: space-between;
        background-color: #FFFFFF;
        padding: 20px; 
    }
    .restaurant {
        width: 30%; 
        margin-bottom: 20px;
        box-sizing: border-box;
        background-color: #f0f0f0; 
        padding: 10px; 
        border-radius: 10px;
    }
    .restaurant img {
        width: 300px; 
        height: 200px;
        margin-left: 10px;
        border-radius: 20px;
    }
    .header-container {
        display: flex;
        align-items: center;
        justify-content: space-between;
        background-color: #f7f7f7;
        padding: 10px;
        border-radius: 5px;
        margin-bottom: 20px;
    }
    .welcome-text {
        font-size: 18px;
        font-weight: bold;
        color: #333;
    }
    .username {
        color: blue;
    }
    .button-container {
        display: flex;
        gap: 10px;
    }
    .button-container a {
        text-decoration: none;
        color: #333;
        font-weight: bold;
        padding: 10px 15px;
        background-color: #e7e7e7;
        border-radius: 5px;
    }
    .button-container a:hover {
        background-color: #ccc;
    }
    .restaurant p {
        margin-top: 1px;
    }
</style>
</head>
<body>

	<div class="header-container">
    <div class="welcome-text">
        <h2>Hello <span class="username"><%= session.getAttribute("username") %></span>, Welcome to ANU Foods</h2>
    </div>
    <div class="button-container">
        <a href="cart.jsp">View Cart</a>
        <a href="ANUfoods">Logout</a>
    </div>
</div>
	

	<div class="restaurant-container">
<%
	List<Restaurant> restaurantList=(List<Restaurant>)request.getAttribute("restaurants");
	for(Restaurant restaurant:restaurantList){

%>

<div class="restaurant">

	
	<a href="MenuServlet?restaurantId=<%= restaurant.getRestaurantId()%>"><img src="<%= restaurant.getImagePath() %> " alt="<%= restaurant.getName() %> Image" ></a>
	<h2><p> Restaurant: <%= restaurant.getName() %></p></h2>
	<p><B>&#9733;<%= restaurant.getRatings() %>  . <%= restaurant.getEta() %></B></p>
	<p> CuisineType: <%= restaurant.getCuisineType() %></p>
</div>
<%
	}
%>
</div>

</body>
</html>