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
<h1> Book updation Page </h1>
<!--JSP for Publisher addition/updation in Database--> 

 <form action="<%= request.getContextPath() %>/PublisherServlet" method="post">
   <table style="with: 80%">
    <tr>
     <td>Publisher Name</td>
     <td><input type="text" name="pub_name" /></td>
    </tr>
    <tr>
     <td>Publisher ID</td>
     <td><input type="text" name="pub_id" /></td>
    </tr>
    <tr>
     <td>Publisher Address</td>
     <td><input type="text" name="pub_address" /></td>
    </tr>
    </table>
   <input type="submit" value="Add Publisher" />
   <input type="submit" value="Update Publisher" />
  </form>
</div>
</body>
</html>