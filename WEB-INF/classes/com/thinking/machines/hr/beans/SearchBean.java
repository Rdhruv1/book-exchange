package com.thinking.machines.hr.beans;
public class SearchBean implements java.io.Serializable
{
private String book;
public SearchBean()
{
this.book="";
}
public void setBook(String book)
{
this.book=book;
}
public String getBook()
{
return this.book;
}
}