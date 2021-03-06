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
    <a href="DeleteBook.jsp" class="w3-bar-item w3-button w3-padding-large w3-hide-small">Delete Book</a>   
  	<a href="Borrow.jsp" class="w3-bar-item w3-button w3-padding-large w3-hide-small">Borrow List</a>
  </div>
</div>


<div align="center"> <br>
<h1> Borrow List </h1>
<!--JSP for Book updation in Database--> 

 <form action="<%= request.getContextPath() %>/BookServ" method="post">
 	<h3>Please click on the button below to display the Borrow List</h3>
 	<input type="submit" name="action" value="Borrow List" />
 </form>
</div>
</body>
</html>