<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="home.css" />
</head>
<body class="homebody">
	<jsp:include page="sidebar.jsp"></jsp:include>

	<div align="Center">
		<h2 style="font-style: italic;">
			Welcome <span
				style="color: White; font-style: italic; text-transform: uppercase;"><%=(String)session.getAttribute("user")%></span>!
			to <span style="color: red; font-style: italic;">MakeMyTrip</span>
			Website
		</h2>
		<br> <br>
	</div>
</body>
</html>