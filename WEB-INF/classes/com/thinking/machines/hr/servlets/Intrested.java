package com.thinking.machines.hr.servlets;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
public class Intrested extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
PrintWriter pw=response.getWriter();
String username=request.getParameter("username");
String name=request.getParameter("name");
String city=request.getParameter("city");
String book=request.getParameter("book");
String mobileNumber=request.getParameter("mobileNumber");
System.out.println(username);
System.out.println(name);
System.out.println(city);
System.out.println(book);
BookDTO bookDTO=new BookDTO();
bookDTO.setUsername(username);
bookDTO.setBook(book);
bookDTO.setName(name);
bookDTO.setCity(city);
bookDTO.setMobileNumber(mobileNumber);
BookDAO bookDAO=new BookDAO();
bookDAO.intrested(bookDTO);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/Intrested.jsp");
requestDispatcher.forward(request,response);
return;
}catch(Exception exception)
{
System.out.println(exception);
/*
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("ErrorPage.jsp");
try
{
requestDispatcher.forward(request,response);
}catch(Exception e)
{
// do nothing
}
*/
}
}
}