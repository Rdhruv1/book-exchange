function validateForm(frm)
{
var bookName=frm.bookName.value.trim();
var errorSection=document.getElementById('errorSection');
errorSection.innerHTML='';
if(bookName.length==0)
{
errorSection.innerHTML='required';
frm.bookName.focus();
return false;
}
return true;
}
function cancelAddition()
{
document.getElementById('cancelAdditionForm').submit();
}