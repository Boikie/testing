<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>joined now </title>

<link href="all.css" rel="stylesheet" type="text/css"/>

</head>
<body>
<%
String id = request.getParameter("userId");
String driverName = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String dbName = "logindemo";
String userId = "root";
String password = "";

try {
Class.forName(driverName);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}

Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<h3 align="center">ALL REGISTERED USER'S INFORMATION</h3><br><br><br>
<table id="customers">
<tr>

</tr>
<tr>
<tr>
    <th>Full Name</th>
    <th>Username</th>
    <th>Age</th>
    <th>Mobile Number</th>
    <th>City</th>
    <th>Address</th>
    <th>Password</th>
</tr>
<%
try{ 
connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
statement=connection.createStatement();
String sql ="SELECT * FROM registered";

resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr >

<td><%=resultSet.getString("FullName") %></td>
<td><%=resultSet.getString("Username") %></td>
<td><%=resultSet.getInt("Age") %></td>
<td><%=resultSet.getString("MobileNumber") %></td>
<td><%=resultSet.getString("City") %></td>
<td><%=resultSet.getString("Address") %></td>
<td><%=resultSet.getString("Password") %></td>

</tr>

<% 
}

} catch (Exception e) {
e.printStackTrace();
}
%>
</table>
</body>
</html>