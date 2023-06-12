package com.thinking.machines.hr.dl;
import java.sql.*;
import java.util.*;
public class AdministratorDAO implements java.io.Serializable
{
public AdministratorDTO getByUsername(String username) throws DAOException
{
try
{
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select * from users where username=?");
preparedStatement.setString(1,username);
ResultSet resultSet;
resultSet=preparedStatement.executeQuery();
if(resultSet.next()==false)
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("Invalid username :"+username);
}
AdministratorDTO administrator;
administrator=new AdministratorDTO();
administrator.setUsername(resultSet.getString("username").trim());
administrator.setPassword(resultSet.getString("password").trim());
administrator.setName(resultSet.getString("name").trim());
administrator.setMobileNumber(resultSet.getString("mobile_number").trim());
administrator.setCity(resultSet.getString("city").trim());
resultSet.close();
preparedStatement.close();
connection.close();
return administrator;
}catch(Exception exception)
{
throw new DAOException(exception.getMessage());
}
}
public void add(AdministratorDTO administratorDTO) throws DAOException
{
try
{
String username=administratorDTO.getUsername();
String password=administratorDTO.getPassword();
String name=administratorDTO.getName();
String city=administratorDTO.getCity();
String mobileNumber=administratorDTO.getMobileNumber();
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select * from users where mobile_number=?");
preparedStatement.setString(1,mobileNumber);
ResultSet resultSet=preparedStatement.executeQuery();
if(resultSet.next())
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("Mobile number :"+mobileNumber+" exists.");
}
resultSet.close();
preparedStatement.close();
preparedStatement=connection.prepareStatement("select * from users where username=?");
preparedStatement.setString(1,username);
resultSet=preparedStatement.executeQuery();
if(resultSet.next())
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("username :"+username+" exists.");
}
resultSet.close();
preparedStatement.close();
preparedStatement=connection.prepareStatement("insert into users (username,password,name,city,mobile_number) values(?,?,?,?,?)");
preparedStatement.setString(1,username);
preparedStatement.setString(2,password);
preparedStatement.setString(3,name);
preparedStatement.setString(4,city);
preparedStatement.setString(5,mobileNumber);
preparedStatement.executeUpdate();
preparedStatement.close();
connection.close();
}catch(Exception exception)
{
throw new DAOException(exception.getMessage());
}
}

public List<AdministratorDTO> getAll() throws DAOException
{
List<AdministratorDTO> l=new ArrayList<>();
try
{
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select * from users");
ResultSet resultSet;
resultSet=preparedStatement.executeQuery();
if(resultSet.next()==false)
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("No data");
}
while(resultSet.next())
{
AdministratorDTO administrator;
administrator=new AdministratorDTO();
administrator.setUsername(resultSet.getString("username").trim());
administrator.setPassword(resultSet.getString("password").trim());
administrator.setName(resultSet.getString("name").trim());
administrator.setMobileNumber(resultSet.getString("mobile_number").trim());
administrator.setCity(resultSet.getString("city").trim());
l.add(administrator);
}
resultSet.close();
preparedStatement.close();
connection.close();
}catch(Exception exception)
{
throw new DAOException(exception.getMessage());
}
return l;
}
}