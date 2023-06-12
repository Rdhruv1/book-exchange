<jsp:useBean id='errorBean' scope='request' class='com.thinking.machines.hr.beans.ErrorBean' />
<!DOCTYPE HTML>
<html lang='en'>
<head>
<title>Book Exchange</title>
<link rel='stylesheet' type='text/css' href='/styletwo/css/styles.css'>
</head>
<body>
<!-- Main container starts here -->
<div class='main-container'>
<!--header starts here -->
<div class='header'>
<img src='/styletwo/images/logo.png' class='logo'>
<div class='brand-name'> Book Exchange</div>
</div> <!-- header ends here -->
<div class='content'>
<div class='loginForm'>
<form action='/bookExchange/Registration.jsp' method='post'>
<table border='0'>
<tr>
<td colspan='2' align='center'>
<span class='error'>
${errorBean.error}
</span>
</td>
</tr>
<tr>
<td>Username</td>
<td><input type='text' name='username' id='username' maxlength='15'></td>
</tr>
<tr>
<td>Password</td>
<td><input type='password' name='password' id='password' maxlength='15'></td>
</tr>
<tr>
<td>Confirm Password</td>
<td><input type='password' name='confirmPassword' id='comfirmPassword' maxlength='15'></td>
</tr>
<tr>
<td>Name</td>
<td><input type='text' name='name' id='name' maxlength='15'></td>
</tr>
<tr>
<td>City</td>
<td><input type='text' name='city' id='city' maxlength='15'></td>
</tr>
<tr>
<td>Mobile Number</td>
<td><input type='text' name='mobileNumber' id='mobileNumber' maxlength='15'></td>
</tr>
<tr>
<td colspan='2' align='center'>
<button type='submit'>Login</button>
</td>
</tr>
</table>

</div> <!-- content-section ends here -->
<!-- footer starts here -->
<div class='footer'>
&copy; Book Exchange 2022
</div>
<!-- footer ends here -->
</div>  <!-- Main container ends here -->
</body>
</html>
