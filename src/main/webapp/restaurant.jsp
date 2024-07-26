<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page  import = "com.tap.model.Restaurant,java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>

		<style>
        .restaurant-container {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-between;
            background-color: #FFFFFF;
           // border: 2px solid ; 
            padding: 20px; 
        }
        .restaurant {
            width: 30%; 
            margin-bottom: 20px;
            box-sizing: border-box;
            background-color: #f0f0f0; 
           // border: 1px solid ; 
            padding: 10px; 
            border-radius: 10px;
        }
        
        .restaurant img{
        	width: 300px; 
   		    height: 200px;
   		    margin-left: 10px;
   		    border-radius:20px;
        }
        
        .input-group{
        	display: flex;
            justify-content: space-between;
            align-items: center;
            gap: 10px; 
            background-color: #f2f2f2;
        	border-radius: 5px;
        }
        .signin,.signUp{
        	padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            border: none;
            cursor: pointer;
            border-radius: 5px;
        }
         .welcome-text {
            /* Add your desired styles for the welcome text here */
            font-size: 18px;
            font-weight: bold;
            text-align:center;
            margin:0 auto;
            color: #333;
            margin-bottom: 20px; /* Add some space below */
     	   	background-color: #f7f7f7; /* Background color for welcome text */
       		padding: 10px; /* Add padding to the welcome text */
      	 	border-radius: 5px;
        }
        
        .restaurant p {
   			margin-top: 1px; /* Adjust the margin as needed */
		}
    </style>
		
		
</head>
<body>		
		<div class="input-group">
			<span class="welcome-text"><h2>Welcome to ANU Foods</h2></span>
			<div>
			<a href="login.jsp"><input class="signin" type="submit" value="Sign In" name="singin"></a>
        	<a href="signUp.jsp"><input class="signUp" type="submit" value="Sign Up" name="singup"></a>
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