<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div align="center">
<h1> Book Creation Page </h1>
<!--JSP for Book updation in Database--> 

 <form action="<%= request.getContextPath() %>/BookServ" method="post">
   <table style="with: 80%">
    <tr>
     <td>Book ID</td>
     <td><input type="text" name="bookid" /></td>
    </tr>
    <tr>
     <td>Author</td>
     <td><input type="text" name="author" /></td>
    </tr>
    <tr>
     <td>Title</td>
     <td><input type="text" name="title" /></td>
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
   <input type="submit" value="Insert Book" />
  </form>
</div>
</body>
</html>