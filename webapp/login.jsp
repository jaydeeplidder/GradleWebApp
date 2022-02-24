<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="login.css" />
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css" />
<script type="text/javascript">
        function preventBack() { window.history.forward(); }
        setTimeout("preventBack()", 0);
        window.onunload = function () { null };
    </script>
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
           <span>
            <input style="width: 100%" type="password" name="password" placeholder="Password"  id="password" required>
            <i  style="margin-left: -30px" class="bi bi-eye-slash" id="togglePassword"></i>
  	</span>
            <button class="login">Log In</button>
            <a href="#">Forgot Password ?</a>
            <hr>
            <a  href="signup.jsp" style="color: white;"><input type="button" class="create-account" value="Create New Account"></a>
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