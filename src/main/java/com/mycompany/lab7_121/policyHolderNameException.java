package com.mycompany.lab7_121;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author qdaon
 */

public class policyHolderNameException extends Exception {
    private String policyHolderName;
    public policyHolderNameException(String policyHolderName) {
        this.policyHolderName = policyHolderName;
    }

    public String getPolicyHolderName() {
        return policyHolderName;
    }

    @Override
    public String toString() {
        return "The policy holder name " + policyHolderName + " is not valid, please enter again!";
    }
}
