<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="login.css" />
</head>
<body>

    <div class="content">
      <div class="flex-div">
        <div class="name-content">
          <h1 class="logo">MakeMyTrip</h1>
          <p >Welcome to <span style="color: red">MakeMyTrip</span></p>
        </div>
        <form action="<%=request.getContextPath()%>/login" method="post">
            <input type="text" name="username" placeholder="Please enter the username" required />
            <input type="password" name="password" placeholder="Password" required>
            <button class="login">Log In</button>
            <a href="#">Forgot Password ?</a>
            <hr>
            <a  href="signup.jsp" style="color: white;"><input type="button" class="create-account" value="Create New Account"></a>
        	</form>
      </div>
    </div>
  

	
</body>
</html>