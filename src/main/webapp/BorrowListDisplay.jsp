<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Borrow List</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body {font-family: "Lato", sans-serif}
.mySlides {display: none}
</style>

</head>
<body>
<!-- Navbar -->
<div class="w3-top">
  <div class="w3-bar w3-black w3-card">
    <a class="w3-bar-item w3-button w3-padding-large w3-hide-medium w3-hide-large w3-right" href="javascript:void(0)" onclick="myFunction()" title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a>
    <a href="index.jsp" class="w3-bar-item w3-button w3-padding-large">HOME</a>
    <a href="Book.jsp"  class="w3-bar-item w3-button w3-padding-large w3-hide-small">Issue Book</a>
    <a href="BookRegistration.jsp" class="w3-bar-item w3-button w3-padding-large w3-hide-small">Add Book</a>
    <a href="UpdateBook.jsp" class="w3-bar-item w3-button w3-padding-large w3-hide-small">Update Book</a>
    <a href="DeleteBook.jsp" class="w3-bar-item w3-button w3-padding-large w3-hide-small">Delete Book</a>   
  </div>
</div><br><br><br>
		<h2 align="center">
			<font><strong>Display Borrow Book List</strong></font>
		</h2>
		<table align="center" cellpadding="5" cellspacing="5" border="1">
			<tr>

			</tr>
			<tr bgcolor="#f58e0f">
				<td><b>Book ID</b></td>
				<td><b>Book Title</b></td>
				<td><b>Issue Date</b></td>
				<td><b>Due Date</b></td>
				<td><b>Returned Date</b></td>
				<td><b>Member ID</b></td>
				<td><b>Member Name</b></td>
			</tr>
	<%! int i; %> 
      <%-- retrieving JSON data from the servlet --%>
	  <% for ( i = 0; i < 2; i++){%>
            <tr bgcolor="#f5f50f">

				<td><%=request.getAttribute("bookId" + i)%></td>
				<td><%=request.getAttribute("bookTitle" + i)%></td>
				<td><%=request.getAttribute("issueId" + i)%></td>
				<td><%=request.getAttribute("dueDate" + i)%></td>
				<td><%=request.getAttribute("returnedDate" + i)%></td>
				<td><%=request.getAttribute("membId" + i)%></td>
				<td><%=request.getAttribute("membName" + i)%></td>
			</tr>
      <%}%>
      </table>
</body>
</html>