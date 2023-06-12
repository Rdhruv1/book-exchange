package com.thinking.machines.hr.dl;
import java.sql.*;
import java.util.*;
public class BookDAO implements java.io.Serializable
{

public List<BookDTO> getBooksByName(String book) throws DAOException
{
List<BookDTO> l=new ArrayList<>();
try
{
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select * from books where book_name=?");
preparedStatement.setString(1,book);
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
System.out.println("RESULT SET .NEXT");
BookDTO Book;
Book=new BookDTO();
Book.setUsername(resultSet.getString("username").trim());
Book.setBook(resultSet.getString("book_name").trim());
Book.setName(resultSet.getString("name").trim());
Book.setMobileNumber(resultSet.getString("mobile_number").trim());
Book.setCity(resultSet.getString("city").trim());
System.out.println("USERNAME :"+resultSet.getString("username"));
l.add(Book);
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


public List<BookDTO> getAllFromIntrested() throws DAOException
{
List<BookDTO> l=new ArrayList<>();
try
{
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select * from intrested");
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
System.out.println("RESULT SET .NEXT");
BookDTO Book;
Book=new BookDTO();
Book.setUsername(resultSet.getString("username").trim());
Book.setBook(resultSet.getString("book_name").trim());
Book.setName(resultSet.getString("name").trim());
Book.setMobileNumber(resultSet.getString("mobile_number").trim());
Book.setCity(resultSet.getString("city").trim());
System.out.println("USERNAME :"+resultSet.getString("username"));
l.add(Book);
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







public void add(BookDTO bookDTO) throws DAOException
{
try
{
String username=bookDTO.getUsername();
String book=bookDTO.getBook();
String name=bookDTO.getName();
String city=bookDTO.getCity();
String mobileNumber=bookDTO.getMobileNumber();
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select * from books where book_name=?");
preparedStatement.setString(1,book);
ResultSet resultSet=preparedStatement.executeQuery();
if(resultSet.next())
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("Book :"+book+" exists.");
}
resultSet.close();
preparedStatement.close();
resultSet.close();
preparedStatement.close();
preparedStatement=connection.prepareStatement("insert into books (username,book_name,name,city,mobile_number) values(?,?,?,?,?)");
preparedStatement.setString(1,username);
preparedStatement.setString(2,book);
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


public void intrested(BookDTO bookDTO) throws DAOException
{
try
{
String username=bookDTO.getUsername();
String book=bookDTO.getBook();
String name=bookDTO.getName();
String city=bookDTO.getCity();
String mobileNumber=bookDTO.getMobileNumber();
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select * from intrested where book_name=?");
preparedStatement.setString(1,book);
ResultSet resultSet=preparedStatement.executeQuery();
if(resultSet.next())
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("Book :"+book+" intrest exists.");
}
resultSet.close();
preparedStatement.close();
resultSet.close();
preparedStatement.close();
preparedStatement=connection.prepareStatement("insert into intrested (username,book_name,name,city,mobile_number) values(?,?,?,?,?)");
preparedStatement.setString(1,username);
preparedStatement.setString(2,book);
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







public List<BookDTO> getAll() throws DAOException
{
List<BookDTO> l=new ArrayList<>();
try
{
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select * from books");
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
BookDTO Book;
Book=new BookDTO();
Book.setUsername(resultSet.getString("username").trim());
Book.setBook(resultSet.getString("book_name").trim());
Book.setName(resultSet.getString("name").trim());
Book.setMobileNumber(resultSet.getString("mobile_number").trim());
Book.setCity(resultSet.getString("city").trim());
l.add(Book);
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