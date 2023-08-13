
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

enum CarType {SUV,SED,LUX,HATCH}
public class Car implements Cloneable, Serializable {
    //start of lab 1
    // attributes
    String model;
    CarType carType;
    int ManufacturingYear;
    double price;
    //constructor
    public Car(String model,CarType carType ,int manufacturingYear, double price) {
        this.model = model;
        this.carType = carType;
        this.ManufacturingYear = manufacturingYear;
        this.price = price;
    }
    public Car(Car another){
        this(another.model, another.carType, another.ManufacturingYear, another.price);
    }
    //method toString
    public String toString(){
        return model + ", " + carType +", " + ManufacturingYear + ", " + price;
    }
    //method print
    public void print() {
        System.out.println("Model: " + model + "- Car Type: " + carType +"- Manufacturing Year: " + ManufacturingYear +"- Price: $" + price);
    }//end of lab1

    //start of lab 2
    //accessors: get methods
    public String getModel(){
        return model;
    }
    public int getManufacturingYear(){
        return ManufacturingYear;
    }
    public CarType getCarType(){
        return carType;
    }
    public double getPrice(){
        return price;
    }
    // mutators: set methods
    public void setModel(String newModel){
        this.model = newModel;
    }
    public void setManufacturingYear(int newManufactureYear){
        this.ManufacturingYear = newManufactureYear;
    }
    public void setCarType(CarType newCarType){
        this.carType = newCarType;
    }
    public void setPrice(double newPrice){
        this.price = newPrice;
    }

    public void priceRise(double rise) {
        price = this.price*(1+rise);
    }

    //implement cloneable interface
    @Override
    public Car clone () throws CloneNotSupportedException{
        return (Car)super.clone();
    }
    // lab 6 toDelimitedString
    public String toDelimitedString(){
        return  model + ", " + carType +", " + ManufacturingYear + ", " + price;
    }
}

