package com.thinking.machines.hr.servlets;
import javax.servlet.*;
import javax.servlet.http.*;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
public class Donate extends HttpServlet
{
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
try
{
DonateBean donateBean;
donateBean=(DonateBean)request.getAttribute("donateBean");
if(donateBean==null)
{
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/profile.jsp");
requestDispatcher.forward(request,response);
return;
}
String username=donateBean.getUsername();
String password=donateBean.getPassword();
String name=donateBean.getName();
String city=donateBean.getCity();
String mobileNumber=donateBean.getMobileNumber();
DonateDAO donateDAO=new donateDAO();
try
{
DonateDTO donateDTO=new DonateDTO();
donateDTO.setUsername(username);
donateDTO.setPassword(password);
donateDTO.setName(name);
donateDTO.setCity(city);
donateDTO.setMobileNumber(mobileNumber);
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