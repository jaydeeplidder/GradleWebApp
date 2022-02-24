<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <script type="text/javascript">
        function preventBack() { window.history.forward(); }
        setTimeout("preventBack()", 0);
        window.onunload = function () { null };
    </script>
</head>
<body>
<div align="Center">
			<h2 style="font-style: italic; color: white">
				Welcome to <span style="color: red; font-style: italic;">MakeMyTrip</span>
				 Website 
			</h2>
			</div>
			<jsp:include page="login.jsp"></jsp:include>
</body>
</html>