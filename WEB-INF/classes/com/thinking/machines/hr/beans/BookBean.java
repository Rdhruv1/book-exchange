package com.thinking.machines.hr.beans;
public class BookBean implements java.io.Serializable,Comparable<BookBean>
{
private String username;
private String name;
private String city;
private String mobileNumber;
private String book;
public BookBean()
{
this.username="";
this.name="";
this.city="";
this.mobileNumber="";
this.book="";
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
public void setMobileNumber(String mobileNumber)
{
this.mobileNumber=mobileNumber;
}
public String getMobileNumber()
{
return this.mobileNumber;
}
public void setBook(String book)
{
this.book=book;
}
public String getBook()
{
return this.book;
}
public boolean equals(Object object)
{
if(!(object instanceof BookBean)) return false;
BookBean other=(BookBean)object;
return this.username.equals(other.username);
}
public int compareTo(BookBean other)
{
return this.username.compareToIgnoreCase(other.username);
}
public int hashCode()
{
return username.hashCode();
}
}