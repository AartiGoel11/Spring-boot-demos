<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function  validate()
{  var s1= document.form[0].uname.value;
var s2=document.form[0].upass.value;
	if(s1.length==0 || s2.length==0)
		{
		alert("Incorrect values.")
		return false;
		}
	return true;
	}


</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
</head>
<body>
<h3 align="center" ><font color="blue">Please Enter the details below :</font></h3>
<form action="registerDB.jsp" method="post" >
<table align="center" bgcolor="wheat">
<tr><td>UserName : </td><td><input type="text" name="uname"></td></tr>
<tr><td>Password :</td><td><input type="password" name="upass"></td></tr>
<tr><td><input type="submit" value="Submit"></td><td><input type="reset" value="Clear"></td></tr>

</table>
</form>
</body>
</html>