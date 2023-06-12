<jsp:useBean id='userBean' scope='session' class='com.thinking.machines.hr.beans.UserBean' />
<html>
<head>
<title>Using JavaBeans in JSP</title>

<script src='jquery/jquery.js'></script>
<script>
$(document).ready(function(){
$.getJSON("http://localhost:8080/bookExchange/service",
function(data){
var dpt=' ';
$.each(data,function(key,value){
dpt+='<tr>';
dpt+='<td>' + value.username + '</td>';
dpt+='<td>' +value.book + '</td>';
dpt+='<td>' +value.name + '</td>';
dpt+='<td>' +value.city + '</td>';
dpt+='<td>' +value.mobileNumber + '</td>';
dpt +='</tr>';
});
$('#table').append(dpt);
});
});
</script>


</head>
<body>
<center>
<h2>Using JavaBeans in JSP</h2>
Username<jsp:getProperty name='userBean' property='username' /><br>
Name<jsp:getProperty name='userBean' property='name' /><br>
Mobile Number<jsp:getProperty name='userBean' property='mobileNumber' /><br>
City <jsp:getProperty name='userBean' property='city' /><br>
</center>

<table id='table' border='2'>
<tr>
<th>Username</th>
<th>Book</th>
<th>Name</th>
<th>City</th>
<th>Mobile Number</th>
</tr>
</table>



<a href='/bookExchange/DonateForm.jsp'>Donate</a><br><br>
<a href='/bookExchange/RecieveForm.jsp'>Recieve</a><br><br>
</body>
</html>