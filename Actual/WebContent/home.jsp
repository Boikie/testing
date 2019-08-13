<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display</title>
<style>
table#nat{
	width: 50%;
	background-color: #c48ec5;
}
</style>
</head>
<body>  
<% 
	String FullName =  request.getParameter("FullName");
	String Username = request.getParameter("Username");
	String Age = request.getParameter("Age");
	String MobileNUmber = request.getParameter("MobileNumber");
	String City = request.getParameter("City");
	String Address = request.getParameter("Address");
	String Password = request.getParameter("Password");
%>
<table id ="nat">
<tr>
	<td>Full Name</td>
	<td><%= FullName %></td>
</tr>
<tr>
	<td>User Name</td>
	<td><%= Username %></td>
</tr>
<tr>
	<td>Address</td>
	<td><%= Age %></td>
</tr>
<tr>
	<td>Mobile Number</td>
	<td><%= MobileNUmber %></td>
</tr>
<tr>
	<td>City</td>
	<td><%= City %></td>
</tr>
<tr>
	<td>Address</td>
	<td><%= Address %></td>
</tr>
<tr>
	<td>Password</td>
	<td><%= Password %></td>
</tr>
</table>
<br>
use " <i> select * from registered; </i> " in mysql client to verify it.
</body>
</html>