<jsp:useBean id='bookBean' scope='request' class='com.thinking.machines.hr.beans.BookBean'/>
<jsp:useBean id='userBean' scope='session' class='com.thinking.machines.hr.beans.UserBean'/>
<jsp:useBean id='errorBean' scope='request' class='com.thinking.machines.hr.beans.ErrorBean' />
<!DOCTYPE HTML>
<html lang='en'>
<head>
<title>Book Exchange</title>
<script scr='/bookExchange/js/Donate.js'></script>
<link rel='stylesheet' type='text/css' href='/styletwo/css/styles.css'>
</head>
<body>
<!-- Main container starts here -->
<div class='main-container'>
<!--header starts here -->
<div class='header'>
<img src='/styleone/images/logo.png' class='logo'>
<div class='brand-name'> Thinking Machines</div>
</div> <!-- header ends here -->
<div class='content'>
<!-- left panel starts here -->
<div class='content-left-panel'>
<b> Designations</b><br>
<a href='/styletwo/Employees.jsp'>Employees</a><br><br>
<a href='/styletwo/index.html'>Home</a>
</div>
<!-- left panel ends here -->
<!-- right panel starts here -->
<div class='content-right-panel'>
<h2>Donate Book</h1>
<span class='error'>
<jsp:getProperty name='errorBean' property='error' />
</span>
<form method='post' action='/bookExchange/Donate.jsp' onsubmit='return validateForm(this)'>
<input type='text' id='city' name='city' value='${userBean.city}'>
<input type='text' id='username' name='username' value='${userBean.username}'>
<input type='text' id='name' name='city' value='${userBean.city}'>
<input type='text' id='mobileNumber' name='mobileNumber' value='${userBean.mobileNumber}'>
Username : <jsp:getProperty name='userBean' property='username' /><br>
City <jsp:getProperty name='userBean' property='city' /><br>
Book Name<input type='text' name='book' id='book' maxlength='50'><br>
<span id='errorSection' class='error'></span><br>
<button type='submit'>Donate</button>
<button type='Button' onclick='cancelAddition()'>Cancel</button>
</form>
</div>
<!-- right panel ends here -->
</div> <!-- content-section ends here -->
<!-- footer starts here -->
<div class='footer'>
&copy; Book Exchange 2022
</div>
<!-- footer ends here -->
</div>  <!-- Main container ends here -->
<form method='post' id='cancelAdditionForm' action='styletwo/Designations.jsp'>
</form>
</body>
</html>