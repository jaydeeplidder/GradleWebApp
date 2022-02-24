<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page language="java" import="javax.servlet.http.HttpSession"%>
<%@ page language="java" import="java.util.ArrayList"%>
<%@ page language="java" import="in.sts.webappgradle.model.Users"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="userprofile.css" />
</head>
<body class="userbody">

<jsp:include page="sidebar.jsp"></jsp:include>
	<table>
		<tr>
			<th>FirstName</th>
			<th>LastName</th>
				<th>Age</th>
				<th>Email</th>
			<th>Phoneno</th>
			<th>Location</th>
			
			<th>Pincode</th>
		<th>Action</th>

		</tr>
		<%
		ArrayList<Users> usersDetailsList = (ArrayList<Users>)session.getAttribute("userdetails");
		
		
		
		for (Users users : usersDetailsList) {
		%>
		<tr>
			<td><%=users.getFirstname()%></td>
			<td><%=users.getLastname()%></td>
			<td><%=users.getAge()%></td>
			<td><%=users.getEmail()%></td>
			<td><%=users.getPhoneno()%></td>
			<td><%=users.getLocation()%></td>
			<td><%=users.getPincode()%></td>
			<td><button type="button" class="btn btn-outline-danger" data-toggle="modal" data-target="#exampleModalCenter">Edit</button></td>
		<tr>
		
		
	</table>
	
<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
 <form name="valid" action="<%=request.getContextPath()%>/updateUser"
		method="post">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">FirstName</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true"></span>
        </button>
      </div>
      <div class="modal-body">
      <input type="text" name="firstname" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default" value=<%=users.getFirstname()%>>
      </div>
      <div class="modal-header">
      <h5 class="modal-title" id="exampleModalLongTitle">LastName</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true"></span>
        </button>
      </div>
      <div class="modal-body">
       <input type="text" name="lastname" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default" value=<%=users.getLastname()%>>
      </div>
      <div class="modal-header">
      <h5 class="modal-title" id="exampleModalLongTitle">Age</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true"></span>
        </button>
      </div>
      <div class="modal-body">
        <input type="number" name="age"  class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default" value=<%=users.getAge()%>>
      </div>
      <div class="modal-header">
      <h5 class="modal-title" id="exampleModalLongTitle">Email</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true"></span>
        </button>
      </div>
      <div class="modal-body">
        <input type="email" name="email"  class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default" value=<%=users.getEmail()%>>
      </div>
      <div class="modal-header">
      <h5 class="modal-title" id="exampleModalLongTitle">Phoneno</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true"></span>
        </button>
      </div>
      <div class="modal-body">
        <input type="number" name="phoneno"  class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default" value=<%=users.getPhoneno()%>>
      </div>
      <div class="modal-header">
      <h5 class="modal-title" id="exampleModalLongTitle">Location</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true"></span>
        </button>
      </div>
      <div class="modal-body">
       <input type="text" name="location"  class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default" value=<%=users.getLocation()%>>
      </div>
      <div class="modal-header">
      <h5 class="modal-title" id="exampleModalLongTitle">Pincode</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true"></span>
        </button>
      </div>
      <div class="modal-body">
       <input type="number" name="pincode"  class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default" value=<%=users.getPincode()%>>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-primary" >Save changes</button>
      </div>
    </div>
  </div>
  </form>
</div>
	<%
			}
			%>
</body>
</html>