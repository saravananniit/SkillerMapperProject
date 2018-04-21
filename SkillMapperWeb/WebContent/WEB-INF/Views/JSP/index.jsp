<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>NIIT Skill Mapper</title>
	</head>

	<body>
	
	<h3 align="center"> 
					<font face="verdana" color="green">
							Welcome to Skill Mapper
					</font> 
					</h3><br/><br/><br/>
		<table>
		
				<tr>
				<td>
				
		<form action="search.do" method="post">
				<Center>
				<input type=submit value="Registration" width="500" height="500" align="middle"> </Center>
		</form>
		</td>
		</tr>
		<tr>
		<td>
		<form action="apple.do" method="post">
				<Center>
				Search :
					<input  type=text name="code" maxlength="10"/ >
				
			
				<input type=submit value="Search" width="500" height="500" align="middle"> </Center>
		</form>
		</td>
		</tr>
		
		<tr>
		<td>
		<form action="skills.do" method="post">
				<Center>
		HR Display :
					
				<input type=submit value="HR display" width="500" height="500" align="middle"> </Center>
		</form>
		</td>
		</tr>
		
		
		</table>
		
	</body>
</html>