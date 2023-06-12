package com.thinking.machines.hr.servlets;
import javax.servlet.*;
import javax.servlet.http.*;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
public class Login extends HttpServlet
{
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
try
{
AdministratorBean administratorBean;
administratorBean=(AdministratorBean)request.getAttribute("administratorBean");
if(administratorBean==null)
{
System.out.println("ADMIN NULL");
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/LoginForm.jsp");
requestDispatcher.forward(request,response);
return;
}
String username=administratorBean.getUsername();
String password=administratorBean.getPassword();
AdministratorDAO administratorDAO=new AdministratorDAO();
try
{
AdministratorDTO administrator=administratorDAO.getByUsername(username);
if(password.equals(administrator.getPassword())==false)
{
System.out.println("PASS FALSE");
ErrorBean errorBean;
errorBean=new ErrorBean();
errorBean.setError("Invalid username/password");
request.setAttribute("errorBean",errorBean);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/LoginForm.jsp");
requestDispatcher.forward(request,response);
return;
}
UserBean userBean=new UserBean();
HttpSession session=request.getSession();
session.setAttribute("userBean",userBean);
userBean.setUsername(username);
userBean.setPassword(password);
userBean.setName(administrator.getName());
userBean.setCity(administrator.getCity());
userBean.setMobileNumber(administrator.getMobileNumber());
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/profile.jsp");
requestDispatcher.forward(request,response);
}catch(DAOException daoException)
{
System.out.println("DAO EXCEPTION");
ErrorBean errorBean;
errorBean=new ErrorBean();
errorBean.setError(daoException.getMessage());
request.setAttribute("errorBean",errorBean);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/LoginForm.jsp");
requestDispatcher.forward(request,response);
return;
}
}catch(Exception exception)
{
System.out.println(" EXCEPTION");
ErrorBean errorBean;
errorBean=new ErrorBean();
errorBean.setError(exception.getMessage());
request.setAttribute("errorBean",errorBean);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/LoginForm.jsp");
try
{
requestDispatcher.forward(request,response);
}catch(Exception e)
{
}
return;
/*
try
{
//requestDispatcher.forward(request,response);
}catch(Exception e)
{
// do nothing
} */
}
}
}