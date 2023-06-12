<!DOCTYPE HTML>
<html lang='en'>
<meta charset='utf-8'>
<head>
<title>Books</title>
<script src='jquery/jquery.js'></script>
<script>
$(document).ready(function(){
$.getJSON("http://localhost:8080/bookExchange/service",
function(data){
var dpt=' ';
$.each(data,function(key,value){
dpt+='<tr>';
dpt+='<td>' + value.username + '</td>';
dpt+='<td>' +value.password + '</td>';
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
<table id='table' border='2'>
<tr>
<th>Username</th>
<th>Password</th>
<th>Name</th>
<th>City</th>
<th>Mobile Number</th>
</tr>
</table>
</body>
</html>
