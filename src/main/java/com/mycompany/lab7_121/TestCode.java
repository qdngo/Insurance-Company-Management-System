package com.mycompany.lab7_121;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author qdaon
 */
import com.mycompany.lab7_121.ThirdPartyPolicy;
import com.mycompany.lab7_121.User;
import java.io.Serializable;
import java.util.*;
// begining of the class
public class TestCode implements Serializable {
    InsuranceCompany company1;

    public TestCode (InsuranceCompany insuranceCompany)
    {
        this.company1 = insuranceCompany;
    }
    public static void testData() {
        //for lab1
        double flatRate = 200; // flarRate is stored as a constant
        //create object for lab1
        Car car1 = new Car("Porsche Taycan", CarType.SED, 2010, 69000);
        Car car2 = new Car("Toyota Yaris", CarType.HATCH, 2022, 30000);
        Car car3 = new Car("Honda City", CarType.SED, 2019, 15000);
        Car car4 = new Car("Mercesdes C200", CarType.LUX, 2021, 50000);

        MyDate mydate1 = new MyDate(13, 06, 2016);
        MyDate mydate2 = new MyDate(17, 04, 2019);
        MyDate mydate3 = new MyDate(27, 05, 2027);
        MyDate mydate4 = new MyDate(06, 06, 2025);

        ComprehensivePolicy plc1 = new ComprehensivePolicy("Bob Smith", 100, car1, 10, mydate1, 18, 4);
        ThirdPartyPolicy plc2 = new ThirdPartyPolicy("Jane Carroll", 200, car2, 30, mydate2, "This is a comment.");
        ComprehensivePolicy plc3 = new ComprehensivePolicy("John James", 300, car3, 20, mydate3, 25, 6);
        ThirdPartyPolicy plc4 = new ThirdPartyPolicy("Tom Harley", 400, car4, 40, mydate4, "This is also a comment.");

        Address add1 = new Address(21, "Crown Street", "ACT", "Canberra");
        Address add2 = new Address(56, "Loftus Street", "NSW", "Wollongong");
        Address add3 = new Address(17, "George Street", "NSW", "Sydney");


        User user1 = new User("Bob Smith", 001, add1);
        User user2 = new User("Tom", 002, add2);
        User user3 = new User("Brown", 003, add3);

        InsuranceCompany company1 = Main.company;

        //------------for lab 1 --------------
        System.out.println("-----------------LAB 1----------------");
        ArrayList<InsurancePolicy> policies = new ArrayList<>(); //ArrayList of parent class
        policies.add(plc1);
        policies.add(plc2);
        policies.add(plc3);
        policies.add(plc4);

        for (InsurancePolicy policy : policies) {
            policy.print();                 //print using print method
        }

        for (InsurancePolicy policy : policies) {
            System.out.println(policy); //print using toString method
        }

        double total = 0;
        for (InsurancePolicy policy : policies) {
            total += policy.calcPayment(flatRate);
        }
        System.out.println("Total pay = $" + total);
        System.out.println();



        //-------------for lab 3------------
        System.out.println("-----------------LAB 3----------------");
        //Task 2
        System.out.println("Task 2:");
        System.out.println("Login with wrong username and pass:");
        boolean checkValidate = company1.validateAdmin("BidAnd", "pass123");
        if (checkValidate == true) {
            System.out.println("Login successfully");
        } else {
            System.out.println("Login failed");
        }

        System.out.println("Login with correct username and pass:");
        boolean checkValidate1 = company1.validateAdmin("Michael", "Password123");
        if (checkValidate1 == true) {
            System.out.println("Login successfully");
        } else {
            System.out.println("Login failed");
        }
        System.out.println("");

        //Task 3
        System.out.println("Task 3: ");
//        company1.addUser(user1);
        boolean checkUser1 = company1.addUser(user1);
        if (checkUser1 == true) {
            System.out.println("Add user successfully");
        } else {
            System.out.println("Add user failed");
        }
        boolean checkUser2 = company1.addUser(user2);
        if (checkUser2 == true) {
            System.out.println("Add user successfully");
        } else {
            System.out.println("Add user failed");
        }
        boolean checkUser3 = company1.addUser(user3);
        if (checkUser3 == true) {
            System.out.println("Add user successfully");
        } else {
            System.out.println("Add user failed");
        }
        System.out.println("");

        //Task 4
        System.out.println("Task 4:");
        System.out.println("Example about add policy successfully");
        boolean checkPolicy1 = company1.addPolicy(001, plc1);
        if (checkPolicy1 == true) {
            System.out.println("Add policy successfully");
        } else {
            System.out.println("UserId is wrong or duplicate policy.");
        }
        boolean checkPolicy2 = company1.addPolicy(001, plc2);
        if (checkPolicy2 == true) {
            System.out.println("Add policy successfully");
        } else {
            System.out.println("UserId is wrong or duplicate policy.");
        }
        boolean checkPolicy3 = company1.addPolicy(002, plc2);
        if (checkPolicy3 == true) {
            System.out.println("Add policy successfully");
        } else {
            System.out.println("UserId is wrong or duplicate policy.");
        }
        boolean checkPolicy4 = company1.addPolicy(002, plc3);
        if (checkPolicy4 == true) {
            System.out.println("Add policy successfully");
        } else {
            System.out.println("UserId is wrong or duplicate policy.");
        }
        System.out.println("Example about add policy failed by wrong user Id");
        boolean checkPolicy5 = company1.addPolicy(100, plc3);
        if (checkPolicy5 == true) {
            System.out.println("Add policy successfully");
        } else {
            System.out.println("UserId is wrong or duplicate policy.");
        }
        System.out.println("Example about add policy failed by duplicate policy");
        boolean checkPolicy6 = company1.addPolicy(002, plc2);
        if (checkPolicy6 == true) {
            System.out.println("Add policy successfully");
        } else {
            System.out.println("UserId is wrong or duplicate policy.");
        }
        System.out.println("");

        //Task 5
        System.out.println("Task 5: ");
        System.out.println("Example about add third party policy successfully");
        boolean checkThirdPartyPolicy1 = company1.createThirdPartyPolicy(001, "Jane Carroll", 101, car2, 30, mydate2, "This is a comment.");
        if (checkThirdPartyPolicy1 == true) {
            System.out.println("Create third party policy successfully.");
        } else {
            System.out.println("Create third party policy failed.");
        }
        System.out.println("Example about add third party policy failed by duplicate policy");
        boolean checkThirdPartyPolicy2 = company1.createThirdPartyPolicy(001, "Jane Carroll", 100, car2, 30, mydate2, "This is a comment.");
        if (checkThirdPartyPolicy2 == true) {
            System.out.println("Create third party policy successfully.");
        } else {
            System.out.println("Create third party policy failed.");
        }
        System.out.println("Example about add third party policy failed by wrong user ID");
        boolean checkThirdPartyPolicy3 = company1.createThirdPartyPolicy(010, "Jane Carroll", 100, car2, 30, mydate2, "This is a comment.");
        if (checkThirdPartyPolicy3 == true) {
            System.out.println("Create third party policy successfully.");
        } else {
            System.out.println("Create third party policy failed.");
        }
        System.out.println("");

        System.out.println("Example about add comprehensive policy successfully");
        boolean checkComprehensivePolicy1 = company1.createComprehensivePolicy(001, "Bob Smith", 201, car1, 10, mydate1, 18, 4);
        if (checkComprehensivePolicy1 == true) {
            System.out.println("Create third party policy successfully.");
        } else {
            System.out.println("Create third party policy failed.");
        }
        System.out.println("Example about add comprehensive policy failed by duplicate policy");
        boolean checkComprehensivePolicy2 = company1.createComprehensivePolicy(001, "Bob Smith", 200, car1, 10, mydate1, 18, 4);
        if (checkComprehensivePolicy2 == true) {
            System.out.println("Create third party policy successfully.");
        } else {
            System.out.println("Create third party policy failed.");
        }
        System.out.println("Example about add comprehensive policy failed by wrong user ID");
        boolean checkComprehensivePolicy3 = company1.createComprehensivePolicy(010, "Bob Smith", 200, car1, 10, mydate1, 18, 4);
        if (checkComprehensivePolicy3 == true) {
            System.out.println("Create third party policy successfully.");
        } else {
            System.out.println("Create third party policy failed.");
        }
        System.out.println("");

//        //Task6
//        System.out.println("Task 6: ");
//        System.out.print("Enter an user ID: ");
//        Scanner scan = new Scanner(System.in);
//        int userID1 = scan.nextInt();
//
//        company1.printPolicies(userID1);
//        System.out.println("");
//
//        //Task 7
//        System.out.println("Task 7: ");
//        System.out.print("Enter an user ID: ");
//        int userID2 = scan.nextInt();
//        System.out.print("Enter an policy ID: ");
//        int policyID2 = scan.nextInt();
//        System.out.print(company1.findPolicy(userID2, policyID2));

        //Task8
        System.out.println("Task 8: ");
        System.out.print("All the users inside Insurance Company: ");
        company1.print();


        //Task9
        System.out.println("Task 9:");
        double risePercent= 0.1;
        company1.carPriceRise(risePercent);
        company1.print();
        System.out.println("");

        //Task10
        System.out.println("Task 10: ");
        System.out.println("Premium Total Payment: " + company1.calcTotalPayments(user1.getUserID()));

        //Task11
        System.out.println("Task 11: ");
        System.out.println("Total Payment for all the users: " + company1.calcTotalPayments());

//        //Task12
//        System.out.println("Task 12: ");
//        ArrayList<InsurancePolicy> policy1 = new ArrayList<>();
//        policy1 = company1.allPolicies();
//        InsurancePolicy.printPolicies(policy1);
//        System.out.println("");

//        //Task13
//        System.out.print("Task 13: ");
//        ArrayList<InsurancePolicy> policy2 = new ArrayList<>();
//        policy2 = company1.filterByExpiryDate(user1.getUserID(), mydate1);
//        InsurancePolicy.printPolicies(policy2);
//        System.out.println("");
//
//        //Task14
//        System.out.print("Task 14: ");
//        ArrayList<InsurancePolicy> policy3 = new ArrayList<>();
//        policy3 = company1.filterByCarModel(car1.getModel());
//        InsurancePolicy.printPolicies(policy3);
//        System.out.println("");

//        //Task15
//        System.out.println("Task 15: ");
//        System.out.print("Enter a day: ");
//        int day = scan.nextInt();
//        System.out.print("Enter a month: ");
//        int month = scan.nextInt();
//        System.out.print("Enter a year: ");
//        int year = scan.nextInt();
//        MyDate date = new MyDate(day, month, year);
//        ArrayList<InsurancePolicy> policy4 = new ArrayList<>();
//        policy4 = company1.filterByExpiryDate(date);
//        InsurancePolicy.printPolicies(policy4);
//        System.out.println("");
//
//        //Task16
//        System.out.println("Task 16: ");
//        int userIDx;
//        while(true){
//            System.out.print("Enter an user ID: ");
//            userIDx = scan.nextInt();
//            if(company1.findUser(userIDx) != null) {
//                break;
//            }
//            else {
//                System.out.println("User does not exist.");
//            }
//        }
//        System.out.print("Enter a street number: ");
//        int strNum = scan.nextInt();
//        System.out.print("Enter a street name: ");
//        String strName = scan.nextLine();
//        scan.nextLine();
//        System.out.print("Enter a suburb: ");
//        String suburb = scan.nextLine();
//        System.out.print("Enter a city: ");
//        String city = scan.nextLine();
//        Address newAddress = new Address(strNum, strName, suburb, city);
//        company1.findUser(userIDx).setAddress(newAddress);

    }
}
// ending of the class TestCase
