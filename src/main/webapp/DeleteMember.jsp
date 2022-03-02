<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Member</title>

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
    <a href="MemberRegistration.jsp" class="w3-bar-item w3-button w3-padding-large w3-hide-small">Add Member</a>
    <a href="UpdateMember.jsp" class="w3-bar-item w3-button w3-padding-large w3-hide-small">Update Member </a> 
  </div>
</div>
<br><br>
<div align="center">
<h1> Delete Member </h1>
<!--JSP for Book updation in Database--> 

 <form action="<%= request.getContextPath() %>/MemberServ" method="post">
   <table style="with: 80%">
    <tr>
     <td>Member ID</td>
     <td><input type="text" name="id" /></td>
    </tr>
    </table>
   <input type="submit" name = "action" value="Delete Member" />
  </form>
</div>
</body>
</html>