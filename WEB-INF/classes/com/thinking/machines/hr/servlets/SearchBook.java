package com.thinking.machines.hr.servlets;
import java.util.*;
import com.google.gson.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
public class SearchBook extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
String book=request.getParameter("book");
System.out.println("BOOK :"+book);

/*
try
{
SearchBean searchBean;
searchBean=(SearchBean)request.getAttribute("searchBean");
if(searchBean==null)
{
System.out.println("SEARCH NULL");
ErrorBean errorBean;
errorBean=new ErrorBean();
errorBean.setError("Book not found");
request.setAttribute("errorBean",errorBean);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/RecieveForm.jsp");
requestDispatcher.forward(request,response);
return;
}
*/
try
{
PrintWriter pw=response.getWriter(); 
BookDAO bookDAO=new BookDAO();
Object obj=bookDAO.getBooksByName(book);
Gson gson=new Gson();
String jsonString=gson.toJson(obj);
pw.print(jsonString);
pw.flush();
}catch(DAOException daoException)
{
System.out.println("DAO EXCEPTION");
System.out.println(daoException);
return;
}catch(Exception exception)
{
System.out.println(" EXCEPTION");
System.out.println(exception);
return;
}
}
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
//
}
}