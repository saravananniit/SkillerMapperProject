<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
table, th, td {
    border: 1px solid black;
}
</style>

<SCRIPT language=Javascript>       
       function setProVal(mVal)
       {
    	   document.getElementById("p1").value = mVal;
       }
</SCRIPT>
    
<title>Skill Update</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
</head>
<body>
<form action="update"  method="post">
		<div>
			<h3 align="center"> Skill Update... </h3>
		</div>

		<div>
			<table align="center">
				<tr>
					<td>
						Technical Skill Set :
					</td>
					<td>
						<input  type=text name="skSet" size="80" onblur="setProVal(10)"/>
					</td>
				</tr>
	
				<tr>
					<td>
						Certification:
					</td>
					<td>
						<input type=text name="cert" size="80" onblur="setProVal(20)"/>
					</td>
				</tr>

				<tr>
					<td>
						Teaching Experience (in Hours):
					</td>
					<td>
						<input type=text name="Texp" size="20" onblur="setProVal(30)"/>
					</td>
				</tr>
			
				<tr>
					<td>
						No. of Students Trained :
					</td>
					<td>
						<input type=text name="NStdT" size="20" onblur="setProVal(40)"/>
					</td>
				</tr>
	
				<tr>
					<td>
						Faculty Rating :
					</td>
					<td>
						<select name="fr" id="fr" style="width: 80px;">
  							<option value="1">1</option>
  							<option value="2">2</option>
  							<option value="3">3</option>
  							<option value="4">4</option>
  							<option value="5">5</option>
						</select>
					</td>
				</tr>
		
				<tr>
					<td>
						No. of Students Placed :
					</td>
					<td>
						<input type=text name="Nsplc" maxlength="10" />
					</td>
				</tr>

				<tr>
					<td>
						Total Experience (in Years):
					</td>
					<td>
						<input type=text name="yexp" />
					</td>
				</tr>
	
				<tr>
					<td>
						Languages Known :
					</td>
					<td>
						<input type=text name="lknow" />
					</td>
				</tr>
	
				<tr>
					<td>
						Placement % :
					</td>
					<td>
						<input type=text name="plcp" disabled="disabled" />
					</td>
				</tr>
	
				<tr>
					<td>
						Profile Update % :
					</td>
					<td>
						<progress id="p1" value="0" max="100">
						<span>0</span>%
						</progress>
					</td>
				</tr>
	
			
			<tr>
			<td/>
				<td>
					<input type=submit value="Update">
				</td>
			</tr>
	</table>
	</div>
</form>

</body>
</html>