<jsp:useBean id='bookBean' scope='request' class='com.thinking.machines.hr.beans.BookBean'/>
<jsp:setProperty name='bookBean' property='*'/>
<jsp:forward page='/addBook' />