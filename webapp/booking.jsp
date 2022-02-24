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
				<input type="date" name="date" required> 
				<select
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
				<input  type="number"  onkeyup="addFormField(); return false;" name="guest" placeholder="No of Guest"  id="guest"  min="1" max="9"required>
				
						<span id="divTxt"></span>
				<button class="create-account">Book</button>
					
  				<input type="hidden" id="id" value="1">
  			
 			 
		<hr style="font-style:italic;">
			</form>
	
		</div>
	
	</div>
	
	<script>
	 let id = document.getElementById("id").value;
	
	
	 
	function addFormField() {
		 let guestNo =document.getElementById("guest").value;
		 var key = event.keyCode || event.charCode;
	      if( key == 8 ){
	    	  for (let i = 1; i <=id; i++) {
					 $("#row"+i).remove();
					}
					id=1;
					 document.getElementById("id").value = id;
	      }
	      
		for(let i=1;i<=guestNo;i++){
		  $("#divTxt").append(
		    "<span id='row" +id +  "' style='width:auto;'><hr  style='color:black; height:10px'> <input type='text' name='guest" + id + "'  value='Guest"+id+"' readonly><br><input type='text' size='20' name='firstname"+id+"' placeholder='Enter the  firstname '  id='txt" +
		      id +
		      "' required><input type='text' size='20' name='lastname"+id+"'  placeholder='Enter the  lastname ' id='txt" +
		      id +
		      "' required><br><select name='gender"+id+"' required><option value='male'>Male</option><option value='female'>Female</option></select><br><input type='number' size='20' name='age"+id+"'  placeholder='age' id='txt" +
		      id +
		      "' required><br><a href='#' onClick='removeFormField(\"#row" +
		      id +
		      "\"); return false;'>Remove</a><hr></span>"
		  );

		  id = id - 1 + 2;
		  document.getElementById("id").value = id;
		}
		}

		function removeFormField(id) {
		  $(id).remove();
		 
		}

	



	</script>
</body>
</html>