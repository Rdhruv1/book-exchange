package com.thinking.machines.hr.dl;
public class BookDTO implements java.io.Serializable,Comparable<BookDTO>
{
private String username;
private String book;
private String name;
private String city;
private String mobileNumber;
public BookDTO()
{
this.username="";
this.book="";
this.name="";
this.city="";
this.mobileNumber="";
}
public void setUsername(String username)
{
this.username=username;
}
public String getUsername()
{
return this.username;
}
public void setName(String name)
{
this.name=name;
}
public String getName()
{
return this.name;
}
public void setCity(String city)
{
this.city=city;
}
public String getCity()
{
return this.city;
}
public void setBook(String book)
{
this.book=book;
}
public String getBook()
{
return this.book;
}
public void setMobileNumber(String mobileNumber)
{
this.mobileNumber=mobileNumber;
}
public String getMobileNumber()
{
return this.mobileNumber;
}
public boolean equals(Object object)
{
if(!(object instanceof BookDTO)) return false;
BookDTO other=(BookDTO)object;
return this.username.equals(other.username);
}
public int compareTo(BookDTO other)
{
return this.username.compareToIgnoreCase(other.username);
}
public int hashCode()
{
return username.hashCode();
}
}