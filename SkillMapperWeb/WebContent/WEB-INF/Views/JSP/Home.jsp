<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*" %>
<%@taglib uri="/WEB-INF/Views/JSP/mytags.tld" prefix="m" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

	<SCRIPT language=Javascript>
       <!--
       function isNumberKey(evt)
       {
          var charCode = (evt.which) ? evt.which : evt.keyCode;
          if (charCode != 46 && charCode > 31 && (charCode < 48 || charCode > 57))
             return false;

          return true;
       }
       //-->
    </SCRIPT>
    
<title>Employee Registration...</title>

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#datepicker1" ).datepicker();
  } );
  
  $( function() {
	    $( "#datepicker2" ).datepicker();
	  } );
  </script>
  
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
</head>
<body>

	<m:today/>



	<form action="register"  method="post">
		<div>
			<h3 align="center"> Employee Registration Form </h3>
		</div>

		<div>
			<table>
				<tr>
					<td>
						Employee Code:
					</td>
					<td>
						<input  type=text name="code" maxlength="5" onkeypress="return isNumberKey(event)">
					</td>
				</tr>
	
				<tr>
					<td>
						Employee Name:
					</td>
					<td>
						<input type=text name="name">
					</td>
				</tr>

				<tr>
					<td>
						Designation:
					</td>
					<td>
						<input type=text name="desgn">
					</td>
				</tr>
			
				<tr>
					<td>
						Gender:
					</td>
					<td>
						<select name="gender" id="Gen" style="width: 80px;">
  							<option value="Male">Male</option>
  							<option value="Female">Female</option>
						</select>
					</td>
				</tr>
	
				<tr>
					<td>
						City:
					</td>
					<td>
						<input type=text name="city">
					</td>
				</tr>
		
				<tr>
					<td>
						Contact No:
					</td>
					<td>
						<input type=text name="contact" maxlength="10" onkeypress="return isNumberKey(event)">
					</td>
				</tr>

				<tr>
					<td>
						Email:
					</td>
					<td>
						<input type=text name="email" />
					</td>
				</tr>
	
				<tr>
					<td>
						Date Of Joining(dd/mm/yyyy)
					</td>
					<td>
						<input type="text" name="dateofjoining" id="datepicker1"/>
					</td>
				</tr>
	
				<tr>
					<td>
						Date Of Birth(dd/mm/yyyy)
					</td>
					<td>
						<input type="text" name="dateofbirth" id="datepicker2"/>
					</td>
				</tr>
	
				<tr>
					<td>
						Password
					</td>
					<td>
						<input type=password name="password">
					</td>
				</tr>
	
			<tr>
				<td>
					Confirm Password
				</td>
				<td>
					<input type=password name="confirmpassword">
				</td>
			</tr>
	
			<tr>
				<td>
					Role
				</td>
				<td>
					<input type=text name="role">
				</td>
			</tr>
	
			<tr>
				<td>
				
				</td>
				<td>
					<input type=submit value="Register">
				</td>
			</tr>
	</table>
	</div>
</form>
</body>
</html>