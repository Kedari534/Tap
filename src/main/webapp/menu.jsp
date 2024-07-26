<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import = "com.tap.model.Menu, java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Restaurant Menu</title>
	<style>
		 body {
     	   	font-family: Arial, sans-serif;
        	background-color: #f5f5f5; /* Light gray background */
        	margin: 0;
        	padding: 0;
    	}
		.menu-container {
			margin-left:20%;
			margin-right:20%;
            display: flex;
            flex-direction: column; /* Stack menus vertically */
            gap: 20px; /* Add spacing between menus */
        }
        
   		.menu {
            width: 100%; /* Occupy the entire width */
            padding: 10px;
            background-color: #fff;
            border-radius:10px;
         //   display: block;
         	box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }    
		.menu p{
			margin:5px 0;
		}
		.add-button {
			display:flex;
			align-items:center;
        	margin-top: 10px;
        	margin-right: 10px;
    	}
   		.menus{
    		display:flex;
    		justify-content:space-between;
    	}
    	.img img {
    		margin-top:10px;
            max-width: 100px; /* Set the maximum width for the image */
            height: auto; /* Maintain aspect ratio */
    	}
    	h2 {
       		color: #333; /* Dark gray */
    	}

    	b {
        	color: #007bff; /* Blue */
    	}

  		button {
        	background-color: #007bff; /* Blue */
        	color: #fff; /* White text */
        	border: none;
        	padding: 10px 20px;
        	border-radius: 5px;
        	cursor: pointer;
        	transition: background-color 0.3s ease;
    	}
    	 
     	button:hover {
        	background-color: #0056b3; /* Darker blue on hover */
     	}
</style>
</head>
<body>
<div class="menu-container">

<%
int quantity=1;

	List<Menu> list=(List<Menu>) request.getAttribute("menus");
	session.setAttribute("menulist",list);
	for(Menu menu:list){
		
%>
<div class="menu">
	<div class="menus">
		<div class="list">
		<h2><b><%= menu.getName() %></b></h2>
		<p>Price :<%= menu.getPrice() %></p>
		<p>Description :<%= menu.getDescription() %></p>
		<p>Ratings :<%= menu.getRatings() %> </p>
		</div>
		
		<div class="img"> 
		<img src="<%= menu.getImagePath() %>" alt="<%= menu.getName()%> Image">
		</div>
	</div>
		<div>
		<form action="CallServletCart" method="GET">
    <input type="number" name="quantity" value="1" > <!-- Ensure there's a reasonable default and minimum -->
    <input type="hidden" name="menuId" value="<%= menu.getMenuId() %>"> <!-- Hidden field for menuId -->
    <button type="submit">Add to Cart</button>
</form>
</div>
</div>
<%
	}
%>

</div>

</body>
</html>