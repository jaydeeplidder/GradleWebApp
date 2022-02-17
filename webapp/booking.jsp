<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="booking.css" />
</head>
<body class="bookingbody">
	<jsp:include page="sidebar.jsp"></jsp:include>
	<div class="content">
		<div class="flex-div">
			<div class="name-content">
				<h1 class="logo">Book Your Trip</h1>
				<p style="color: blue">
					Please fill the details <span style="color: red">MakeMyTrip</span>
				</p>
			</div>
			<form action="<%=request.getContextPath()%>/booking" method="post">
				<input type="text" name="username"
					value=<%=(String)session.getAttribute("user") %> required>
				<input type="date" name="date" required> <select
					name="location" required>
					<option value="Mumbai">Mumbai</option>
					<option value="Goa">Goa</option>
					<option value="Delhi">Delhi</option>
					<option value="Chennai">Chennai</option>
					<option value="Punjab">Punjab</option>
				</select> <select name="hotel" required>
					<option value="Sahara Star">Sahara Star</option>
					<option value="JW Marriot">JW Marriot</option>
					<option value="The Lalit">The Lalit</option>
					<option value="Sunshine">Sunshine</option>
					<option value="Taj">Taj</option>
				</select> <input type="number" name="stay" placeholder="No of Stay" required>
				<input type="number" name="guest" placeholder="No of Guest" required>
				<button class="create-account">Book</button>
			</form>
		</div>
	</div>
</body>
</html>