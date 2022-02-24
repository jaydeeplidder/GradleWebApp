<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="signup.css" />
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css" />
</head>
<body class="signup">
	
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
		 <input type="text" name="firstname" placeholder="Please enter your firstname" required />
		 <input type="text" name="lastname" placeholder="Please enter your lastname" required />
		 <input type="number" name="age" placeholder="Please enter your age" required />
       <span>
            <input style="width: 93%" type="password" name="password" placeholder="Password"  id="password" required>
            <i  style="margin-left: -30px" class="bi bi-eye-slash" id="togglePassword"></i>
  	</span>
			<input type="email" name="email" placeholder="Please enter your email" required>
			<input type="text" name="phoneno" placeholder="phoneno" required>
			<input type="text" name="location" placeholder="location" required>
			<input type="text" name="pincode" placeholder="Pincode" required>
				<a href='<%=request.getContextPath()%>/index.jsp' style="text-decoration: none">Back to Login</a>
				<input class="create-account" type="submit" value="Submit" name="signup">
				
	</form>
	</div>
	</div>
  <script>
        const togglePassword = document.querySelector("#togglePassword");
        const password = document.querySelector("#password");

        togglePassword.addEventListener("click", function () {
            // toggle the type attribute
            const type = password.getAttribute("type") === "password" ? "text" : "password";
            password.setAttribute("type", type);
            
            // toggle the icon
            this.classList.toggle("bi-eye");
        });

  
    </script>
</body>
</html>