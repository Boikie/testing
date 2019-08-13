<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<link rel="stylesheet" href="regis.css" />
<title>Student Registration Form</title>

</head>
<body>



<form action="ConnectUpload" method="post">

		<a href="home.html"><i style="height: 24px" class="fa fa-home"></i></a>


		<br /> <u><h3 align="center">UPLOADING  A  BOOK</h3></u> <br />
		<br />

		<table align="center" cellpadding="10">


			<tr>
				<td>Book Name</td>
				<td><input type="text" name="Name" /></td>
			</tr>

			<tr>
				<td>Genre</td>
				<td><input type="text" name="Genre" /></td>
			</tr>

			<tr>
				<td>Publisher</td>
				<td><input type="text" name="Publisher" /></td>
			</tr>

			<tr>
				<td>ISBN</td>
				<td><input type="text" name="ISBN"  /><td>
			</tr>


			<tr>
				<td>Author</td>
				<td><input type="text" name="Author" /></td>
			</tr>

			<tr>
				<td>Edition<br /> 
				<td><input name="Edition" type="text"></td>
			</tr>
			
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Submit"> <input type="reset" value="Reset">
				</td>
			</tr>
			


		</table>

	</form>



</body>
</html>