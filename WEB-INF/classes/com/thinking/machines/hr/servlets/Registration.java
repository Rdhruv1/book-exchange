package com.thinking.machines.hr.servlets;
import javax.servlet.*;
import javax.servlet.http.*;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
public class Registration extends HttpServlet
{
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
try
{
AdministratorBean administratorBean;
administratorBean=(AdministratorBean)request.getAttribute("administratorBean");
if(administratorBean==null)
{
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/RegistrationForm.jsp");
requestDispatcher.forward(request,response);
return;
}
String username=administratorBean.getUsername();
String password=administratorBean.getPassword();
String name=administratorBean.getName();
String city=administratorBean.getCity();
String mobileNumber=administratorBean.getMobileNumber();
AdministratorDAO administratorDAO=new AdministratorDAO();
try
{
AdministratorDTO administratorDTO=new AdministratorDTO();
administratorDTO.setUsername(username);
administratorDTO.setPassword(password);
administratorDTO.setName(name);
administratorDTO.setCity(city);
administratorDTO.setMobileNumber(mobileNumber);
administratorDAO.add(administratorDTO);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/LoginForm.jsp");
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