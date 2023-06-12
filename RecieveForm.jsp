<jsp:useBean id='errorBean' scope='request' class='com.thinking.machines.hr.beans.ErrorBean' />
<jsp:useBean id='userBean' scope='request' class='com.thinking.machines.hr.beans.UserBean' />
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
<form action='/bookExchange/RecieveInfo.jsp' method='post'>
<table border='0'>
<tr>
<td colspan='2' align='center'>
<span class='error'>
${errorBean.error}
</span>
</td>
</tr>
<tr>
<td>Enter Book You Want</td>
<td><input type='text' name='book' id='book' maxlength='15'></td>
</tr>
<tr>
<tr>
<td colspan='2' align='center'>
<button type='submit'>Search</button>
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
