<jsp:useBean id='errorBean' scope='request' class='com.thinking.machines.hr.beans.ErrorBean' />
<jsp:useBean id='searchBean' scope='request' class='com.thinking.machines.hr.beans.SearchBean' />
<html>
<head>
<title>Using JavaBeans in JSP</title>
<link rel='stylesheet' type='text/css' href='/styletwo/css/styles.css'>
<script src='jquery/jquery.js'></script>
<script>
$(document).ready(function(){
$.getJSON("http://localhost:8080/bookExchange/searchBook?book=<jsp:getProperty name='searchBean' property='book' />",
function(data){
var dpt=' ';
$.each(data,function(key,value){
dpt+='<tr>';
dpt+='<td>' + value.username + '</td>';
dpt+='<td>' +value.book + '</td>';
dpt+='<td>' +value.name + '</td>';
dpt+='<td>' +value.city + '</td>';
dpt+='<td>' +value.mobileNumber + '</td>';
dpt+='<td>' + '<a href=/bookExchange/intrested?username='+value.username+'&book='+value.book+'&name='+value.name+'&city='+value.city+'&mobileNumber='+value.mobileNumber+'>' +"Instrested"+ '</a>' + '</td>';
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
<span class='error'>
${errorBean.error}
</span>
</center>
<table id='table' border='2'>
<tr>
<th>Username</th>
<th>Book</th>
<th>Name</th>
<th>City</th>
<th>Mobile Number</th>
<th>Intrested</th>
</tr>
</table>
<h2>Using JavaBeans in JSP</h2>
Username<jsp:getProperty name='searchBean' property='book' /><br>
<h1>http://localhost:8080/bookExchange/searchBook?book=<jsp:getProperty name='searchBean' property='book' /></h1>
</body>
</html>