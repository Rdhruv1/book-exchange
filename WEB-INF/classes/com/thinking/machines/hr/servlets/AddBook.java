package com.thinking.machines.hr.servlets;
import javax.servlet.*;
import javax.servlet.http.*;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
public class AddBook extends HttpServlet
{
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
try
{
BookBean bookBean;
bookBean=(BookBean)request.getAttribute("bookBean");
if(bookBean==null)
{
System.out.println("BOOK NULL");
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/profile.jsp");
requestDispatcher.forward(request,response);
return;
}
String username=bookBean.getUsername();
String name=bookBean.getName();
String city=bookBean.getCity();
String mobileNumber=bookBean.getMobileNumber();
String book=bookBean.getBook();
BookDAO bookDAO=new BookDAO();
try
{
BookDTO bookDTO=new BookDTO();
bookDTO.setUsername(username);
bookDTO.setBook(book);
bookDTO.setName(name);
bookDTO.setCity(city);
bookDTO.setMobileNumber(mobileNumber);
bookDAO.add(bookDTO);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/profile.jsp");
requestDispatcher.forward(request,response);
return;
}catch(DAOException daoException)
{
ErrorBean errorBean;
errorBean=new ErrorBean();
errorBean.setError(daoException.getMessage());
request.setAttribute("errorBean",errorBean);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/RegistrationForm.jsp");
requestDispatcher.forward(request,response);
return;
}
}catch(Exception exception)
{
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("ErrorPage.jsp");
try
{
requestDispatcher.forward(request,response);
}catch(Exception e)
{
// do nothing
}
}
}
}