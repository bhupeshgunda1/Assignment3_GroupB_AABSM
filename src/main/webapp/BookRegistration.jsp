<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Insertion</title>

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
    <a href="UpdateBook.jsp" class="w3-bar-item w3-button w3-padding-large w3-hide-small">Update Book</a>
    <a href="DeleteBook.jsp" class="w3-bar-item w3-button w3-padding-large w3-hide-small">Delete Book</a>
       
  </div>
</div>
<br><br>
<div align="center">
<h1> Add Book  </h1>
<!--JSP for Book updation in Database--> 

 <form action="<%= request.getContextPath() %>/BookServ" method="post">
   <table style="with: 80%">
    <tr>
     <td>Book ID</td>
     <td><input type="text" name="bookid"/></td>
    </tr>
    <tr>
     <td>Title</td>
     <td><input type="text" name="title" /></td>
    </tr>
    <tr>
     <td>Author</td>
     <td><input type="text" name="author" /></td>
    </tr>
    <tr>
     <td>Price</td>
     <td><input type="text" name="price" /></td>
    </tr>
    <tr>
     <td>Available</td>
     <td><input type="text" name="available" /></td>
    </tr>
    
    </table>
    <input type="submit" name="action" value="Add Book" />
  </form>
</div>
</body>
</html>