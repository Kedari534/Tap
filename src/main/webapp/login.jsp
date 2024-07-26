<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Login-In Page</title>
	 <style>
        body {
            font-family: TimesNewRoman, sans-serif;
            background-color: #FF533A;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            background-color: orange;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        .container h2 {
        	margin-top: 0;
            font-size: 24px;
            text-align: center;
        }

        .login-form {
            display: flex;
            flex-direction: column;
        }

        .login-form label {
            margin-bottom: 5px;
        }

        .login-form input[type="text"],
        .login-form input[type="password"] {
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        .login-form input[type="submit"] {
            background-color: red;
            color: GoldenRod;
            border: none;
            border-radius: 4px;
            padding: 10px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .login-form input[type="submit"]:hover {
            background-color: yello;
        }
    </style>
</head>
<body>
	<div class="container">
		<h2>Log-In</h2>
		<form class="login-form" action="CallingLoginServlet1">
			<table>
				<tr>
				<td><label for="username">USERNAME</label></td>
				<td><input type="text" name="username" id="username" placeholder="enter name"></td>
				</tr>
				<tr>
				<td><label for="password">PASSWORD</label></td>
				<td><input type="password" name="password" id="password" placeholder="enter password" ></td>
				</tr>
			</table>
			<input type="submit" value="Login">
		</form>
		<p>Don't have an account <a href="signUp.jsp">click here</a></p>
	</div>
	
</body>
</html>