package com.thinking.machines.hr.beans;
public class AdministratorBean implements java.io.Serializable,Comparable<AdministratorBean>
{
private String username;
private String password;
private String name;
private String city;
private String mobileNumber;
public AdministratorBean()
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
if(!(object instanceof AdministratorBean)) return false;
AdministratorBean other=(AdministratorBean)object;
return this.username.equals(other.username);
}
public int compareTo(AdministratorBean other)
{
return this.username.compareToIgnoreCase(other.username);
}
public int hashCode()
{
return username.hashCode();
}
}