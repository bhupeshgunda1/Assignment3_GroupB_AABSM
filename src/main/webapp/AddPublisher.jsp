<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Publisher Insertion</title>

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
    <a href="UpdatePublisher.jsp" class="w3-bar-item w3-button w3-padding-large w3-hide-small">Update Publisher</a>   
  </div>
</div>
<br><br>
<div align="center">
<h1> Add Publisher  </h1>
<!--JSP for adding publisher in Database--> 

 <form action="<%= request.getContextPath() %>/PublisherServ" method="post">
   <table style="with: 80%">
    <tr>
     <td>Publisher ID</td>
     <td><input type="text" name="pub_id"/></td>
    </tr>
    <tr>
     <td>Publisher Address</td>
     <td><input type="text" name="pub_address" /></td>
    </tr>
    <tr>
     <td>Publisher Name</td>
     <td><input type="text" name="pub_name" /></td>
    </tr>
    </table>
    <input type="submit" name="action" value="Add Publisher" />
  </form>
</div>
</body>
</html>