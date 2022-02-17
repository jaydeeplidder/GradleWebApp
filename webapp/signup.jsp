<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="signup.css" />
</head>
<body>
	
<div align="Center" class="welcome">
			<h2 style="font-style: italic; color: white">
				Welcome to <span style="color: red; font-style: italic;">MakeMyTrip</span>
				SignUp Page 
			</h2>
			</div>
<div class="content">

      <div class="flex-div">
        <div class="name-content">
          <h1 class="logo">MakeMyTrip</h1>
          <p >Please SignUp to <span style="color: red">MakeMyTrip</span></p>
        </div>
	<form name="valid" action="<%=request.getContextPath()%>/register"
		method="post">
		 <input type="text" name="username" placeholder="Please enter your username" required />
         <input type="password" name="password" placeholder="Password" required>
			<input type="email" name="email" placeholder="Please enter your email" required>
			<input type="text" name="phoneno" placeholder="phoneno" required>
			<input type="text" name="location" placeholder="location" required>
			<input type="text" name="pincode" placeholder="Pincode" required>
				<a  href='<%=request.getContextPath()%>/index.jsp' style="text-decoration: none">Back to Login</a>
			
				<input class="create-account" type="submit" value="Submit" name="signup">
				
	</form>
	</div>
	</div>

</body>
</html>