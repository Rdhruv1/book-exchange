package com.thinking.machines.hr.servlets;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
import com.google.gson.*;
import java.io.*;
public class Service extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
PrintWriter pw=response.getWriter(); 
BookDAO bookDAO=new BookDAO();
List<BookDTO> list=bookDAO.getAllFromIntrested();
System.out.println("LIST SIZE :"+list.size());
/*
Object obj=bookDAO.getAllFromIntrested();
Gson gson=new Gson();
String jsonString=gson.toJson(obj);
pw.print(jsonString);
pw.flush();
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/profile.jsp");
requestDispatcher.forward(request,response);
*/
}catch(Exception e)
{
System.out.println(e);
}
}
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
//
}
}