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

public class Address implements Cloneable, Comparable<Address>, Serializable
{
    //start of lab2
    int streetNum;
    String street;
    String suburb;
    String city;

    public Address(int streetNum, String street, String suburb, String city) {
        this.streetNum = streetNum;
        this.street = street;
        this.suburb = suburb;
        this.city = city;
    }
    //copy constructor
    public Address(Address another){
        this(another.streetNum, another.street, another.suburb, another.city);
    }
    public String toString(){
        return streetNum + ", " + street + ", " + suburb + ", " + city;
    }
    public int getStreetNum(){
        return streetNum;
    }
    public String getStreet(){
        return street;
    }
    public String getSuburb(){
        return suburb;
    }
    public String getCity(){
        return city;
    }
    // mutators
    public void setStreetNum(int streetNum){
        this.streetNum = streetNum;
    }
    public void setStreet(String street){
        this.street = street;
    }
    public void setSuburb(String suburb){
        this.suburb = suburb;
    }
    public void setCity(String city){
        this.city = city;
    }
    //implement cloneable interface
    @Override
    public Address clone() throws CloneNotSupportedException{
        Address output = (Address) super.clone();
        return output;
    }
    //implement comparable interface
    @Override
    public int compareTo(Address otherAddress){
        return city.compareTo(otherAddress.city);
    }
}

