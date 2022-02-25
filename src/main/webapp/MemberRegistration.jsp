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
<!--JSP for Book updation in Database--> 

 <form action="<%= request.getContextPath() %>/MemberServlet" method="post">
   <table style="with: 80%">
    <tr>
     <td>Name</td>
     <td><input type="text" name="name" /></td>
    </tr>
    <tr>
     <td>Member ID</td>
     <td><input type="text" name="id" /></td>
    </tr>
    <tr>
     <td>Address</td>
     <td><input type="text" name="address" /></td>
    </tr>
    <tr>
     <td>Type</td>
     <td><input type="text" name="type" /></td>
    </tr>
    <tr>
     <td>Member Date</td>
     <td><input type="text" name="memberdate" /></td>
    </tr>
    <tr>
     <td>Expiry Date</td>
     <td><input type="text" name="expirydate" /></td>
    </tr>
    </table>
   <input type="submit" value="Add Member" />
  </form>
</div>
</body>
</html>