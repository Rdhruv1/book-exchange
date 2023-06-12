<%@taglib uri='WEB-INF/mytags/tmtags.tld' prefix='tm' %>
<tm:Guard>
<jsp:forward page='/LoginForm.jsp' />
</tm:Guard>
<!DOCTYPE HTML>
<html lang='en'>
<head>
<title>HR Application</title>
<link rel='stylesheet' type='text/css' href='/styletwo/css/styles.css'>
</head>
<body>
<!-- Main container starts here -->
<div class='main-container'>
<!--header starts here -->
<div class='header'>
<img src='/styletwo/images/logo.png' class='logo'>
<div class='brand-name'> Thinking Machines</div>
<div class='username'>
<img src='/styletwo/images/user.png' />
${username}&nbsp;
<a href='/styletwo/logout'>Logout</a>
</div>
</div> <!-- header ends here -->
<div class='content-left-panel'>


<tm:If condition='${module==DESIGNATION}'>
<!-- in case of Designation Page -->
<b>Designations</b><br>
<a href='/styletwo/Employees.jsp'>Employees</a><br><br>
<a href='/styletwo/index.jsp'>Home</a>
</tm:If>

<tm:If condition='${module==HOME}'>
<!-- in case of Home Page -->
<a href='/styletwo/Designations.jsp'>Designations</a><br>
<a href='/styletwo/Employees.jsp'>Employees</a><br>
</tm:If>


<tm:If condition='${module==EMPLOYEE}'>
<!-- in case of Employee Page -->
<a href='/styletwo/Designations.jsp'>Designations</a><br>
<b>Employees</b><br><br>
<a href='/styletwo/index.jsp'>Home</a>
</tm:If>
</div>

<!-- left panel ends here -->
<!-- right panel starts here -->
<div class='content-right-panel'>
