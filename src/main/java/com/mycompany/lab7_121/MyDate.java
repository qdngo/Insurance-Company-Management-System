package com.mycompany.lab7_121;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author qdaon
 */
import java.io.Serializable;

public class MyDate implements Comparable<MyDate>, Cloneable, Serializable
{
    int year;
    int month;
    int day;

    public MyDate(int day, int month, int year) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    //copy constructor
    public MyDate(MyDate another){
        this(another.year, another.month, another.day);
    }


    public String toString(){
        return day + "/" +month + "/" + year;
    }
    public int getYear() { return year;}
    public int getMonth(){ return month; }
    public int getDay(){ return day; }
    //mutators for set
    public void setYear(int year){
        this.year = year;
    }
    public void setMonth(int month){
        this.month = month;
    }
    public void setDay(int day){
        this.day = day;
    }

    public boolean isExpired(MyDate expiryDate){
        if (expiryDate.getYear() < this.year)
            return true;
        else if (expiryDate.getYear() > this.year)
            return false;
        else if (expiryDate.getYear() == this.year){
            if (expiryDate.getMonth() < this.month)
                return true;
            else if (expiryDate.getMonth() > this.month)
                return false;
            else if (expiryDate.getMonth() == this.month){
                if(expiryDate.getDay() < this.day)
                    return true;
                else
                    return false;
            }
            else
                return false;
        }
        else
            return false;
    }
    //implement cloneable interface
    @Override
    public MyDate clone () throws CloneNotSupportedException
    {
        return (MyDate) super.clone();
    }

    //implement the comparable interface
    @Override
    public int compareTo(MyDate otherDate) {
        if(year > otherDate.year){
            return 1;
        }
        else if (year < otherDate.year) {
            return -1;
        }
        else {
            if (month > otherDate.month){
                return 1;
            }
            else if (month < otherDate.month){
                return -1;
            }
            else {
                if (day > otherDate.day){
                    return 1;
                }
                else if (day < otherDate.day){
                    return -1;
                }
                else{
                    return 0;
                }
            }
        }
    }
    //lab6 toDelimitedString
    public String toDelimitedString(){
            return day + "/" +month + "/" + year;
    }
}

