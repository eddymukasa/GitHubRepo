<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
header {
	background-color: black;
	color: white;
	text-align: center;
	padding: 5px;
}

section {
	float: left;
	padding: 10px;
}

footer {
	background-color: black;
	color: white;
	clear: both;
	text-align: center;
	padding: 5px;
}

label,input {
	display: block;
}

label {
	margin-bottom: 20px;
}
</style>
</head>

<body>

	<header>
	<h1>CRIBZ ONLINE BOOKING</h1>
	</header>



	<section>
	<h1>REGISTER</h1>

	<p>
		<b>Please complete the form below inorder to carry out your
			booking.</b>
	<form>
		<div id="maim">

			<label> First name: <input type="text" name="firstname">
				Last name: <input type="text" name="lastname">
			</label> <label> Phone number: <input type="text" name="phone">
				Email: <input type="text" name="email">
			</label> <label> Password: <input type="password" name="pwd">
				Confirm Password: <input type="password" name="pwd2">
			</label> <br />
			<div>
				<input type="submit" value="Register"><br />
				<br />
			</div>
		</div>
	</form>
	</section>

	<footer> Copyright © Cribz Entertainment </footer>

</body>
</html>