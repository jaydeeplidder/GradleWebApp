<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page language="java" import="in.sts.webappgradle.dao.BookingDao"%>
<%@ page language="java" import="javax.servlet.http.HttpSession"%>
<%@ page language="java" import="java.util.ArrayList"%>
<%@ page language="java" import="in.sts.webappgradle.model.Booking"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="checkbooking.css" />

</head>
<body class="checkbody">
	<jsp:include page="sidebar.jsp"></jsp:include>
	<table>
		<tr>
			<th>Username</th>
			<th>Date</th>
			<th>Location</th>
			<th>Hotel</th>
			<th>Stays</th>
			<th>Guest</th>

		</tr>
		<%
		ArrayList<Booking> bookingDetailsList = (ArrayList<Booking>)session.getAttribute("bookingDetailsList");
		
		
		
		for (Booking booking : bookingDetailsList) {
		%>
		<tr>
			<td><%=booking.getUsername()%></td>
			<td><%=booking.getDate()%></td>
			<td><%=booking.getLocation()%></td>
			<td><%=booking.getHotel()%></td>
			<td><%=booking.getStay()%></td>
			<td><%=booking.getGuest()%></td>
		<tr>
			<%
			}
			%>
		
	</table>


</body>
</html>


