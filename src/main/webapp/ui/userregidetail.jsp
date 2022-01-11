<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/uregidetails.css">
</head>
<body>

<img src="/images/signIn.jpg" style="width:100%">
	<div class="center">
		<form name="SignIn" action="/registeruser">
			<label for="name"> <strong>Name </strong></label>
			<input type="text" id="nameId" name="uname" placeholder="enter username" > 
			<br>
			<br>
			<label for="pass"> <strong>Password </strong></label>
			<input type="password" id="pass" name="upassword" placeholder="enter password">
			<br>
			<br>
			<label for="name"><strong> Email </strong> </label>
			<input type="text" id="cpass" name="uemail"  placeholder="enter Email Id" > 
			<br>
			<br>
			<label for="name"><strong> Mobile </strong> </label>
			<input type="text" id="mob" name="umobno"  placeholder="enter 10 digit no" > 
			<br>
			<br>
			<input type="submit">
		</form> 
		
			
	</div>
			
</body>
</html>