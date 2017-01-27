<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Data</title>
</head>
<style>
div.ex {
	text-align: right width:300px;
	padding: 10px;
	border: 5px solid grey;
	margin: 0px
}
</style>
<body>
	<h1>Registration Form</h1>
	<div class="ex">
		<form action="RegistrationController" method="post">
			<table style="with: 50%">
				<tr>
					<td>First Name</td>
					<td><input type="text" name="fname" /></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><input type="text" name="lname" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="text" name="pass" /></td>
				</tr>
				<tr>
					<td>Conform Password</td>
					<td><input type="text" name="cpass" /></td>
				</tr>
				<tr>
	       <td align="right">Select the File : </td>
	       <td>
		       <input name="file" type="file" id="file">
		   <td>
	   </tr>
				
			</table>
			<input type="submit" value="register" />
		</form>
	</div>
</body>
</html>