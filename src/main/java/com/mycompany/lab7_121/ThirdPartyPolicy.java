package com.mycompany.lab7_121;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author qdaon
 */
public class ThirdPartyPolicy extends InsurancePolicy {
    //start of lab 1
    // attribute
    String comments;
    //constructor
    public ThirdPartyPolicy(String policyHolderName, int id, Car car, int numberOfClaims, MyDate expiryDate, String comments) {
        super(policyHolderName, id, car, numberOfClaims, expiryDate);
        this.comments= comments;
    }
    public ThirdPartyPolicy(ThirdPartyPolicy another){
        this(another.getPolicyHolderName(), another.getId(), another.getCar(), another.getNumberOfClaims(), another.getExpiryDate(), another.comments);
    }
    //method toString
    @Override
    public String toString() {
        return "Policy Holder Name: " + super.getPolicyHolderName()+ ", ID: " + super.getId()
                + ", Number of claims " + super.getNumberOfClaims() + ", Expiry Date: " + super.getExpiryDate() + ", Comments: " + comments
                +"\nCar: " +  super.getCar().toString() ;
    }
    //method print
    @Override
    public void print(){
        System.out.print("\n");
        super.print();
        System.out.println("Comments: " + comments);
    }
    //method caclPayment
    @Override
    public double calcPayment(double flatRate) {
        return (double) (super.getCar().price/100 + super.getNumberOfClaims()*200 + flatRate);
    }
    //lab6 toDelimitedString
    public String toDelimitedString() {
        return "Policy Holder Name: " + super.getPolicyHolderName()+ ", ID: " + super.getId()
                + ", Number of claims " + super.getNumberOfClaims() + ", Expiry Date: " + super.getExpiryDate() + ", Comments: " + comments
                +"\nCar: " +  super.getCar().toString() ;
    }
}

