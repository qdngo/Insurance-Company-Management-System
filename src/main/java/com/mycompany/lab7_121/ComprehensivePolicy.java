package com.mycompany.lab7_121;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author qdaon
 */
import com.mycompany.lab7_121.InsurancePolicy;
import com.mycompany.lab7_121.MyDate;
import java.io.Serializable;

public class ComprehensivePolicy extends InsurancePolicy {
    //start of lab 1//attributes
    int driverAge;
    int level;
    //constructor
    public ComprehensivePolicy(String policyHolderName, int id, Car car, int numberOfClaims, MyDate expiryDate, int driverAge, int level) {
        super(policyHolderName, id, car, numberOfClaims, expiryDate);
        this.driverAge = driverAge;
        this.level = level;
    }
    public ComprehensivePolicy(ComprehensivePolicy another){
        this(another.getPolicyHolderName(), another.getId(), another.getCar(), another.getNumberOfClaims(), another.getExpiryDate(), another.driverAge, another.level);
    }
    //method toString
    @Override
    public String toString() {
        return "Policy Holder Name: " + super.getPolicyHolderName()+ ", id:" + super.getId()+ ", age: " + driverAge + ", level: " + level  + ", Number Of Claims: " + super.getNumberOfClaims() + ", Expiry Date: " + getExpiryDate()  +"\nCar: "
                +  super.getCar().toString() ;
    }
    //method print
    @Override
    public void print() {
        super.print();
        System.out.println("DriverAge: " + driverAge);
        System.out.println("Level: "+ level);
    }
    //caclPayment method to calculate the ComprehensivePolicy Price
    @Override
    public double calcPayment(double flatRate) {
        if (driverAge < 30){
            return (double) super.getCar().price/50 + super.getNumberOfClaims() * 200 + flatRate + (30-driverAge)* 50 ;}
        else {
            return (double) super.getCar().price/50 + super.getNumberOfClaims() * 200 + flatRate;
        }
    }
    //end of lab 1
    //lab 6 toDelimitedString
    public String toDelimitedString() {
        return "Policy Holder Name: " + super.getPolicyHolderName()+ ", id:" + super.getId()+ ", age: " + driverAge + ", level: " + level  + ", Number Of Claims: " + super.getNumberOfClaims() + ", Expiry Date: " + getExpiryDate()  +"\nCar: "
                +  super.getCar().toString() ;
    }
}
