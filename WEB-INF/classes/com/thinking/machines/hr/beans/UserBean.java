package com.thinking.machines.hr.beans;
public class UserBean implements java.io.Serializable,Comparable<UserBean>
{
private String username;
private String password;
private String name;
private String city;
private String mobileNumber;
public UserBean()
{
this.username="";
this.password="";
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
public void setPassword(String password)
{
this.password=password;
}
public String getPassword()
{
return this.password;
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
public boolean equals(Object object)
{
if(!(object instanceof UserBean)) return false;
UserBean other=(UserBean)object;
return this.username.equals(other.username);
}
public int compareTo(UserBean other)
{
return this.username.compareToIgnoreCase(other.username);
}
public int hashCode()
{
return username.hashCode();
}
}