<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Sign-Up page</title>
	   <style>
        body {
            font-family: timesnewroman, sans-serif;
            margin: 0;
            padding: 0;
            background-color: pink;
        }
        .container {
            width: 50%;
            margin: 0 auto;
            padding: 20px;
            background-color: orange;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin-top: 50px;
        }
        h2 {
            text-align: center;
        }
        table {
            width: 100%;
        }
        table td {
            padding: 10px;
        }
        input[type="text"], input[type="email"], input[type="password"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            width: 100%;
            padding: 10px;
            margin-top: 10px;
            background-color: red;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
	<h2>Sign-Up Page</h2>
	<div class="container">
		<form action="CallingSignUpServlet" >
			<table>
				<tr>
				<td><label for="name">Name</label></td>
				<td><input type="text" id="name" name="name" placeholder="ex:jackson"></td>
				</tr>
				<tr>
				<td><label for="email">Email</label></td>
				<td><input type="email" id="email" name="email" placeholder="ex:john@gmail.com"></td>
				</tr>
				<tr>
				<td><label for="phone">Phone Number</label></td>
				<td><input type="number" id="phone" name="phone" placeholder="ex:995-590-7176"></td>
				</tr>
				<tr>
				<td><label for="username">UserName</label></td>
				<td><input type="text" id="username" name="username" placeholder="ex:john"></td>
				</tr>
				<tr>
				<td><label for="password">Password</label></td>
				<td><input type="password" id="password" name="password" placeholder="min 8 characters" ></td>
				</tr>
		</table>
		<input type="submit">
		</form>
	</div>
</body>
</html>