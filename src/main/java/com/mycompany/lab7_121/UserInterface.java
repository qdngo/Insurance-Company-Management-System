package com.mycompany.lab7_121;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author qdaon
 */
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.*;
public class UserInterface{
    public static InsuranceCompany company ;
    public UserInterface (InsuranceCompany company)
    {
        this.company= company;
    }
    public static void displayMainMenu() {
        System.out.println("\n"); // clear screen
        System.out.println(" 1, Admin Login");
        System.out.println(" 2, User Login");
        System.out.println(" 3, exit");
        System.out.print("Please choose an option from 1 to 3: ");

    }

    public static void mainMenu() throws PolicyException, IOException, CloneNotSupportedException {
        Scanner scan = new Scanner(System.in);
        int option = 0;
        //while(true)
        while(option != 3) {
            displayMainMenu();
            option = scan.nextInt();
            switch (option) {
                case 1:
                    System.out.println("\n-----AdminLogIn-----");
                    adminLogIn();
                    break;
                case 2:
                    System.out.println("\n-----UserLogIn-----");
                    userLogIn();
                    break;
                case 3:
                    System.out.println("\nDo you want to exit?\n");
                    System.out.println("Press enter to continue");
                    scan.nextLine();
                    break;
                default:
                    System.out.println("\nWrong option\n");
            }
        }
    }
    public static void adminLogIn() throws PolicyException, IOException, CloneNotSupportedException {

        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter the username: ");
        String adminUserName = scan.nextLine();
        System.out.print("Please enter the password: ");
        String adminPassword = scan.nextLine();

        if (Main.company.validateAdmin(adminUserName, adminPassword)){
            System.out.println("Login successful.");
            adminMenu();
        }
        else{
            System.out.println("Login failed.");
            mainMenu();
        }
    }
    public static void displayAdminMenu(){
        System.out.println("\n");
        System.out.println("Admin Menu: ");
        System.out.println("----Core----");
        System.out.println(" 1, Test Code");
        System.out.println(" 2, Create User");
        System.out.println(" 3, Create ThirdParty Policy");
        System.out.println(" 4, Create Comprehensive Policy");
        System.out.println(" 5, Print User Information");
        System.out.println(" 6, Filter by Car Model");
        System.out.println(" 7, Filter by Expiry Date");
        System.out.println(" 8, Update Address");
        System.out.println(" 9, Log out");
        System.out.println("----Standard----");
        System.out.println(" 10, Report Payments for City");
        System.out.println("----Advanced----");
        System.out.println(" 11, Remove a policy of a userID ");
        System.out.println(" 12, Remove User");
        System.out.println(" 13, Change PassWord");
        System.out.println(" 14, Report Payments for all Car Models");
        System.out.println("------Lab 6------");
        System.out.println(" 15, Load Binary File ");
        System.out.println(" 16, Save Binary File ");
        System.out.println(" 17, Load Text File");
        System.out.println(" 18, Save Text File");
        System.out.println("------Assignment 2------");
        System.out.println(" 19, Create User(UserID is generated automatically)");
        System.out.println(" 20, Shallow Copy Policies");
        System.out.println(" 21, Deep Copy Policies");
        System.out.println(" 22, Shallow Copy User");
        System.out.println(" 23, Deep Copy User");
        System.out.println(" 24, Sort User By Premium Payments");
        System.out.println(" 25, Get User By City");
        System.out.println(" 26, Filter Policies By Expiry Date");
        System.out.print("Please choose an option from 1 to 26: ");
    }
    public static void adminMenu() throws PolicyException, IOException, CloneNotSupportedException {
        Scanner scan = new Scanner(System.in);
        int option = 0;
        //while(true)
        while(option != 10) {

            displayAdminMenu();
            option = scan.nextInt();
            switch (option) {
                case 1:
                    System.out.println("\nTest code: \n");
                    testCode();
                    adminMenu();
                    break;
                case 2:
                    createUser();
                    break;
                case 3:
                    createThirdPartyPolicy();
                    break;
                case 4:
                    createComprehensivePolicy();
                    break;
                case 5:
                    printUserInformation();
                    break;
                case 6:
                    filterByCarModel();
                    break;
                case 7:
                    filterByExpiryDate();
                    break;
                case 8:
                    updateAddress();
                    break;
                case 9:
                    mainMenu();
                    break;
                case 10:
                    Main.company.reportPaymentPerCity();
                    adminMenu();
                    break;
                case 11:
                    removePolicyForUser();
                    break;
                case 12:
                    removeUserForAdmin();
                    break;
                case 13:
                    changePassForAdmin();
                    break;
                case 14:
                    Main.company.reportPaymentsPerCarModel();
                    adminMenu();
                    break;
                case 15:
                    loadBinaryFile();
                    adminMenu();
                    break;
                case 16:
                    saveBinaryFile();
                    adminMenu();
                    break;
                case 17:
                    loadTextFile();
                    adminMenu();
                    break;
                case 18:
                    saveTextFile();
                    adminMenu();
                    break;

                //Assignment2
                case 19:
                    createUserNewVersion();
                    adminMenu();
                case 20:
                    shallowCopyPolicies();
                    adminMenu();
                case 21:
                    deepCopyPolicies();
                    adminMenu();
                case 22:
                    shalowCopyUsers();
                    adminMenu();
                case 23:
                    deepCopyUsers();
                    adminMenu();
                case 24:
                    sortUserByPremiumPayments();
                    adminMenu();
                case 25:
                    getUserByCity();
                    adminMenu();
                case 26:
                    filterPoliciesByExpiryDate();
                    adminMenu();
                default:
                    System.out.println("\nOption does not available\n");
                    adminMenu();
                    break;
            }
        }
    }
    // option of admin

    public static void changePassForAdmin() throws PolicyException, IOException, CloneNotSupportedException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the old password: ");
        String oldPass = sc.nextLine();
        System.out.print("Please enter the new password: ");
        String newPass = sc.nextLine();
        boolean check = Main.company.changePassword(oldPass, newPass);
        if (check)
        {
            System.out.println("Password changed successfully");
            adminMenu();
        }
        else
        {
            System.out.println("Old Password is wrong.");
            adminMenu();
        }
    }

    public static void removeUserForAdmin() throws PolicyException, IOException, CloneNotSupportedException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the user ID: ");
        int userID = sc.nextInt();
        boolean check = Main.company.removeUserById(userID);
        if (check)
        {
            System.out.println("Delete successfully");
            adminMenu();
        }
        else
        {
            System.out.println("Wrong UserID.");
            adminMenu();
        }
    }
    public static void removePolicyForUser() throws PolicyException, IOException, CloneNotSupportedException {
        Scanner scan = new Scanner(System.in);
        System.out.println("\n-----Remove Policy For A User-----");
        System.out.print("Enter User ID: ");
        int userID = scan.nextInt();
        System.out.print("Enter Policy Id: ");
        int policyId = scan.nextInt();
        scan.nextLine();
        boolean check = Main.company.removePolicyForUser(userID, policyId);
        if (check)
        {
            System.out.println("Delete successfully");
            adminMenu();
        }
        else
        {
            System.out.println("Wrong UserID or PolicyID");
            adminMenu();
        }
    }
    public static void testCode() throws PolicyException{
        TestCode.testData();
    }
    public static void createUser(){
        Scanner scan = new Scanner(System.in);
        System.out.println("\n-----Create User-----");
        System.out.print("Enter User Name: ");
        String name = scan.nextLine();
        int userID = 0;
        boolean inputIsValid = false;
        while (!inputIsValid) {
            try {
                System.out.print("Enter user ID: ");
                userID = scan.nextInt();
                scan.nextLine();
                inputIsValid = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter an integer for user ID.");
                scan.next(); //for the wrong input
            }
        }
        System.out.println("Address: ");
        int strNum = 0;
        boolean inputValid = false;
        while (!inputValid) {
            try {
                System.out.print("Enter user street number: ");
                scan.nextLine();
                inputValid = true;
            }
            catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter an integer for street number.");
                scan.next(); //for the wrong input
            }
        }
        scan.nextLine();
        System.out.print("Enter Street Name: ");
        String strName = scan.nextLine();
        System.out.print("Enter Suburb: ");
        String suburb = scan.nextLine();
        System.out.print("Enter City: ");
        String city = scan.nextLine();
        Main.company.addUser(name, userID, new Address(strNum,strName,suburb,city));
        System.out.println("Create user successfully");
    }
    public static void createThirdPartyPolicy() throws PolicyException {
        Scanner scan = new Scanner(System.in);
        System.out.println("\n-------Create ThirdParty Policy-------");
        int userID = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("Please enter an User ID to add policy to: ");
                userID = scan.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter an integer.");
                scan.next(); //for the wrong input
            }
        }
        scan.nextLine();
        System.out.print("Enter Policy Holder Name: ");
        String policyHolderName = scan.nextLine();
        int policyID = 0;
        validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter the policy ID: ");
                policyID = scan.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter an integer.");
                scan.next(); //for the wrong input
            }
        }
        scan.nextLine();
        System.out.print("Enter the car model: ");
        String carModel = scan.nextLine();
        int manuYear = 0;
        validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter the car manufactured year: ");
                manuYear = scan.nextInt();
                scan.nextLine();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter an integer.");
                scan.next(); //for the wrong input
            }
        }
        double price = 0;
        validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter the car price: $");
                price = scan.nextDouble();
                scan.nextLine();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a double.");
                scan.next(); //for the wrong input
            }
        }
        System.out.print("Choose 1 type of car (SUV, HATCH, LUX, SED): ");
                CarType carType = CarType.valueOf(scan.next());

        int numOfClaims = 0;
        validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter the policy number of claims: ");
                numOfClaims = scan.nextInt();
                scan.nextLine();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter an integer.");
                scan.next(); //for the wrong input
            }
        }

        System.out.println("----Expiry Date---- ");
        int day = 0;
        validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter the day for the car expiry date: ");
                day = scan.nextInt();
                scan.nextLine();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter an integer.");
                scan.next(); //for the wrong input
            }
        }
        int month = 0;
        validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter the month for the car expiry date: ");
                month = scan.nextInt();
                scan.nextLine();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter an integer.");
                scan.next(); //for the wrong input
            }
        }
        int year = 0;
        validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter the year for the car expiry date: ");
                year = scan.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter an integer.");
                scan.next(); //for the wrong input
            }
        }
        scan.nextLine();
        System.out.print("Enter the comment: ");
        String comments = scan.nextLine();

        Main.company.createThirdPartyPolicy(userID, policyHolderName, policyID, new Car(carModel, carType, manuYear, price), numOfClaims, new MyDate(day, month, year), comments);
        System.out.println("Create policy succesfully");
    }

    public static void createComprehensivePolicy() throws PolicyException {
        Scanner scan = new Scanner(System.in);
        System.out.println("\n-------Create Comprehensive Policy-------");
        int userID = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter the ID for the user you want to create policy: ");
                userID = scan.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter an integer.");
                scan.next(); //for the wrong input
            }
        }
        scan.nextLine();
        System.out.print("Enter Policy Holder Name: ");
        String policyHolderName = scan.nextLine();
        int policyID = 0;
        validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter the policy ID: ");
                policyID = scan.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter an integer.");
                scan.next(); //for the wrong input
            }
        }
        scan.nextLine();
        System.out.print("Enter the car model: ");
        String carModel = scan.nextLine();

        int manuYear = 0;
        validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter the car manufactured year: ");
                manuYear = scan.nextInt();
                scan.nextLine();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter an integer.");
                scan.next(); //for the wrong input
            }
        }

        double price = 0;
        validInput = false;
        while (!validInput) {
            try{
                System.out.print("Enter the price: $");
                price = scan.nextDouble();
                validInput = true;
            }
            catch(InputMismatchException e){
                System.out.println("Invalid input! Please enter a decimal number for the price.");
                scan.next(); //for the wrong input
            }
        }
        System.out.print("Choose 1 type of car (SUV, HATCH, LUX, SED): ");
        CarType carType = CarType.valueOf(scan.next());

        int numOfClaims = 0;
        validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter the policy number of claims: ");
                numOfClaims = scan.nextInt();
                scan.nextLine();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter an integer.");
                scan.next(); //for the wrong input
            }
        }

        int day = 0;
        validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter the day for the car expiry date: ");
                day = scan.nextInt();
                scan.nextLine();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter an integer.");
                scan.next(); //for the wrong input
            }
        }
        int month = 0;
        validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter the month for the car expiry date: ");
                month = scan.nextInt();
                scan.nextLine();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter an integer.");
                scan.next(); //for the wrong input
            }
        }
        int year = 0;
        validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter the year for the car expiry date: ");
                year = scan.nextInt();

                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter an integer.");
                scan.next(); //for the wrong input
            }
        }
        System.out.print("Enter the driver age: ");
        int driverAge = scan.nextInt();
        int level = 0;
        validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter the policy holder level: ");
                level = scan.nextInt();
                scan.nextLine();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter an integer.");
                scan.next(); //for the wrong input
            }
        }

        Main.company.createComprehensivePolicy(userID, policyHolderName, policyID, new Car(carModel, carType, manuYear, price), numOfClaims, new MyDate(day, month, year), driverAge, level);
        System.out.println("Create policy successfully");
    }

    public static void printUserInformation(){
        Scanner scan = new Scanner(System.in);
        System.out.println("\n-----Print User Information-----");
        System.out.print("Please enter an User ID: ");
        int userID = scan.nextInt();
        scan.nextLine();
        Main.company.printPolicies(userID);
    }
    public static void filterByCarModel(){
        Scanner scan = new Scanner(System.in);
        System.out.println("\n-----Filter By Car Model-----");
        System.out.print("Please enter a car model: ");
        String carModel = scan.nextLine();

        HashMap<Integer, InsurancePolicy> policy = Main.company.filterByCarModel(carModel);
        System.out.println("----Policy filtered by Car Model: ");
        InsurancePolicy.printPolicies(policy);

        double total = InsurancePolicy.calcTotalPayments(policy, 100);

    }
    public static void filterByExpiryDate(){
        Scanner scan = new Scanner(System.in);
        System.out.println("\n-----Filter by Expiry Date-----");
        System.out.print("Please enter a day: ");
        int day = scan.nextInt();
        System.out.print("Please enter a month: ");
        int month = scan.nextInt();
        System.out.print("Please enter a year: ");
        int year = scan.nextInt();
        MyDate date = new MyDate(day, month, year);

        HashMap<Integer, InsurancePolicy> policy = Main.company.filterByExpiryDate(date);
        System.out.println("----Policy filtered by Expiry Date----");
        InsurancePolicy.printPolicies(policy);
    }
    public static void updateAddress(){
        Scanner scan = new Scanner(System.in);
        System.out.println("\n---Update Address---");
        int userID = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter the user ID to change the address of that user: ");
                userID = scan.nextInt();
                scan.nextLine();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter an integer.");
                scan.next(); //for the wrong input
            }
        }
        System.out.println("New Address");
        int strNum = 0;
        validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter user new street number: ");
                strNum = scan.nextInt();
                scan.nextLine();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter an integer.");
                scan.next(); //for the wrong input
            }
        }
        scan.nextLine();
        System.out.print("Enter Street Name: ");
        String strName = scan.nextLine();
        System.out.print("Enter Suburb: ");
        String suburb = scan.nextLine();
        System.out.print("Enter City: ");
        String city = scan.nextLine();
        Address newAddress1 = new Address(strNum, strName, suburb, city);

        User user = Main.company.findUser(userID);
        if(user != null){
            user.setAddress(newAddress1);
            System.out.println("The new address: " + user.getAddress());
        }
        else {
            System.out.println("User does not exist.");
        }
    }
    // user interface
    public static void userLogIn() throws PolicyException, IOException, CloneNotSupportedException {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter the Username: ");
        String userName = scan.nextLine();

        System.out.print("Please enter the User Password: ");
        String userPassword = scan.nextLine();

        for (User user : Main.company.getUsers().values()) {
            if (Main.company.validateUser(userName, userPassword) != null) {
                System.out.println("Login successful.");
                userMenu(user.getUserID());
            } else {
                System.out.println("Login failed.");
                mainMenu();
            }
        }
    }
    public static void displayUserMenu(){
        System.out.println("\n\n");
        System.out.println("User Menu: ");
        System.out.println("-----Core-----");
        System.out.println(" 1, Print policies and total payment");
        System.out.println(" 2, Create Third Party Policy");
        System.out.println(" 3, Create Comprehensive Policy");
        System.out.println(" 4, Print User Information");
        System.out.println(" 5, Update Address");
        System.out.println(" 6, Log Out");
        System.out.println("-----Standard-----");
        System.out.println(" 7, Report Payments for Car Model");
        System.out.println("-----Advanced-----");
        System.out.println(" 8, Remove policy");
        System.out.print("Please choose an option from 1 to 8: ");
    }
    public static void userMenu(int userID) throws PolicyException, IOException, CloneNotSupportedException {
        Scanner scan = new Scanner(System.in);
        int option = 0;
        //while(true)
        while(option != 6) {
            displayUserMenu();
            option = scan.nextInt();
            switch (option) {
                case 1:
                    System.out.println("\n-----Print policies and total payments----- ");
                    printUser(userID);
                    break;
                case 2:
                    createThirdPartyPolicyUser();
                    break;
                case 3:
                    createComprehensivePolicyUser();
                    break;
                case 4:
                    printUserInformation();
                    break;
                case 5:
                    System.out.println("\n-----Update Address----- ");
                    updateAddress();
                    break;
                case 6:
                    mainMenu();
                    break;
                case 7:
                    Main.company.findUser(userID).reportPaymentsPerCarModel(100);
                    userMenu(userID);
                    break;
                case 8:
                    removePolicy(userID);
                    break;
                default:
                    System.out.println("Option does not available");
                    userMenu(userID);
                    break;
            }
        }
    }


    public static void removePolicy(int userID) throws PolicyException, IOException, CloneNotSupportedException {
        Scanner scan = new Scanner(System.in);
        int policyID = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter the policy ID to remove that policy: ");
                policyID = scan.nextInt();
                scan.nextLine();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter an integer.");
                scan.next(); //for the wrong input
            }
        }

        Main.company.findUser(userID).removePolicy(policyID);
        if (Main.company.findPolicy(userID, policyID) == null)
            System.out.println("Remove policy successfully");
        else
            System.out.println("Remove policy failed");
    }

    public static void printUser(int userID){
        System.out.println("User Information: ");
        Main.company.findUser(userID).print();
    }
    public static void createThirdPartyPolicyUser(){
        Scanner scan = new Scanner(System.in);
        System.out.println("\n-------Create ThirdParty Policy-------");
        int userID = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("Please enter an User ID to add policy to: ");
                userID = scan.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter an integer.");
                scan.next(); //for the wrong input
            }
        }
        scan.nextLine();
        System.out.print("Enter Policy Holder Name: ");
        String policyHolderName = scan.nextLine();
        int policyID = 0;
        validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter the policy ID: ");
                policyID = scan.nextInt();
                scan.nextLine();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter an integer.");
                scan.next(); //for the wrong input
            }
        }
        System.out.print("Enter the car model: ");
        String carModel = scan.nextLine();
        int manuYear = 0;
        validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter the car manufactured year: ");
                manuYear = scan.nextInt();
                scan.nextLine();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter an integer.");
                scan.next(); //for the wrong input
            }
        }
        double price = 0;
        validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter the car price: $");
                price = scan.nextDouble();
                scan.nextLine();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a double.");
                scan.next(); //for the wrong input
            }
        }
        System.out.print("Choose 1 type of car (SUV, HATCH, LUX, SED): ");
        CarType carType = CarType.valueOf(scan.next());

        int numOfClaims = 0;
        validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter the policy number of claims: ");
                numOfClaims = scan.nextInt();
                scan.nextLine();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter an integer.");
                scan.next(); //for the wrong input
            }
        }

        System.out.println("----Expiry Date---- ");
        int day = 0;
        validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter the day for the car expiry date: ");
                day = scan.nextInt();
                scan.nextLine();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter an integer.");
                scan.next(); //for the wrong input
            }
        }
        int month = 0;
        validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter the month for the car expiry date: ");
                month = scan.nextInt();
                scan.nextLine();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter an integer.");
                scan.next(); //for the wrong input
            }
        }
        int year = 0;
        validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter the year for the car expiry date: ");
                year = scan.nextInt();
                scan.nextLine();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter an integer.");
                scan.next(); //for the wrong input
            }
        }
        System.out.print("Enter the comment: ");
        String comments = scan.nextLine();

        Main.company.findUser(userID).createThirdPartyPolicy(policyHolderName, policyID, new Car(carModel, carType, manuYear, price), numOfClaims, new MyDate(day, month, year), comments);
    }
    public static void createComprehensivePolicyUser(){
        Scanner scan = new Scanner(System.in);
        System.out.println("\n-------Create Comprehensive Policy-------");
        int userID = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter the ID for the user you want to create policy: ");
                userID = scan.nextInt();
                scan.nextLine();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter an integer.");
                scan.next(); //for the wrong input
            }
        }
        scan.nextLine();
        System.out.print("Enter Policy Holder Name: ");
        String policyHolderName = scan.nextLine();
        int policyID = 0;
        validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter the policy ID: ");
                policyID = scan.nextInt();
                scan.nextLine();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter an integer.");
                scan.next(); //for the wrong input
            }
        }
        System.out.print("Enter the car model: ");
        String carModel = scan.nextLine();

        int manuYear = 0;
        validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter the car manufactured year: ");
                manuYear = scan.nextInt();
                scan.nextLine();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter an integer.");
                scan.next(); //for the wrong input
            }
        }

        double price = 0;
        validInput = false;
        while (!validInput) {
            try{
                System.out.print("Enter the price: ");
                price = scan.nextDouble();
                validInput = true;
            }
            catch(InputMismatchException e){
                System.out.println("Invalid input! Please enter a decimal number for the price.");
                scan.next(); //for the wrong input
            }
        }
        System.out.print("Choose 1 type of car (SUV, HATCH, LUX, SED): ");
        CarType carType = CarType.valueOf(scan.next());

        int numOfClaims = 0;
        validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter the policy number of claims: ");
                numOfClaims = scan.nextInt();
                scan.nextLine();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter an integer.");
                scan.next(); //for the wrong input
            }
        }

        int day = 0;
        validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter the day for the car expiry date: ");
                day = scan.nextInt();
                scan.nextLine();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter an integer.");
                scan.next(); //for the wrong input
            }
        }
        int month = 0;
        validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter the month for the car expiry date: ");
                month = scan.nextInt();
                scan.nextLine();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter an integer.");
                scan.next(); //for the wrong input
            }
        }
        int year = 0;
        validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter the year for the car expiry date: ");
                year = scan.nextInt();
                scan.nextLine();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter an integer.");
                scan.next(); //for the wrong input
            }
        }

        System.out.print("Enter the driver age: ");
        int driverAge = scan.nextInt();
        int level = 0;
        validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter the policy holder level: ");
                level = scan.nextInt();
                scan.nextLine();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter an integer.");
                scan.next(); //for the wrong input
            }
        }

        Main.company.findUser(userID).createComprehensivePolicy(policyHolderName, policyID, new Car(carModel, carType, manuYear, price), numOfClaims, new MyDate(day, month, year), driverAge, level);

    }
    public static void loadBinaryFile() {
        Main.company.load("company1.ser");
    }
    public static void saveBinaryFile(){
        Main.company.save("company1.ser");
    }
    public static void loadTextFile() throws IOException {
        Main.company.loadTextFile("company1.txt");
    }
    public static void saveTextFile() throws IOException {
        Main.company.saveTextFile("company1.txt");
    }

    //Assignment 2
    public static void createUserNewVersion() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\n-----Create User-----");
        System.out.print("Enter User Name: ");
        String name = scan.nextLine();
        scan.nextLine();
        System.out.println("Enter the username to login: ");
        String userName = scan.nextLine();
        System.out.println("Address: ");
        int strNum = 0;
        boolean inputValid = false;
        while (!inputValid) {
            try {
                System.out.print("Enter user street number: ");
                strNum = scan.nextInt();
                inputValid = true;
            }
            catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter an integer for street number.");
                scan.next(); //for the wrong input
            }
        }

        System.out.print("Enter Street Name: ");
        String strName = scan.nextLine();
        scan.nextLine();
        System.out.print("Enter Suburb: ");
        String suburb = scan.nextLine();
        System.out.print("Enter City: ");
        String city = scan.nextLine();
        System.out.print("Enter the password: ");
        String password = scan.nextLine();

        Main.company.addUser(name, new Address(strNum,strName,suburb,city), userName, password);

        System.out.println("Create user successfully.");
    }
    public static void shallowCopyPolicies(){
        Scanner scan = new Scanner(System.in);
        System.out.println("\n-------Shallow Copy Policies-------");
        int userID = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter the ID for the user you want to make shallow copy policies: ");
                userID = scan.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter an integer.");
                scan.next(); //for the wrong input
            }
        }
        Main.company.findUser(userID).shallowCopyPoliciesHashMap();
        System.out.println("Shallow Copy Policies successfully");
    }
    public static void deepCopyPolicies() throws CloneNotSupportedException {
        Scanner scan = new Scanner(System.in);
        System.out.println("\n-------Deep Copy Policies-------");
        int userID = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter the ID for the user you want to make deep copy policies: ");
                userID = scan.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter an integer.");
                scan.next(); //for the wrong input
            }
        }
        Main.company.findUser(userID).deepCopyPoliciesHashMap();
        System.out.println("Deep Copy Policies successfully");
    }
    public static void shalowCopyUsers(){
        Main.company.shallowCopyUsersHashMap();
        System.out.println("Shallow Copy User successfully.");
    }
    public static void deepCopyUsers() throws CloneNotSupportedException {
        Main.company.deepCopyUsersHashMap();
        System.out.println("Deep Copy User successfully.");
    }
    public static void sortUserByPremiumPayments() {
        ArrayList<User> usersPerCity = Main.company.sortUsersByPremiums();
        for (User user : usersPerCity) {
            user.print();
            System.out.println("Total payment for " + user.getName() + ": $" +user.calcTotalPremiums(Main.flatRate) + "\n");
        }
    }
    public static void getUserByCity(){
        HashMap<String, ArrayList<User>> usersPerCity = Main.company.getUsersPerCity();
        for (String city : usersPerCity.keySet()) {
            System.out.println("List of users in " + city + ":");
            ArrayList<User> users = usersPerCity.get(city);
            for (User user : users) {
                user.print();
            }
        }
    }
    public static void filterPoliciesByExpiryDate(){
        Scanner scan = new Scanner(System.in);
        System.out.println("\n-------Filter By Expiry Date-------");
        int day = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter the expiry day: ");
                day = scan.nextInt();
                scan.nextLine();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter an integer.");
                scan.next(); //for the wrong input
            }
        }
        int month = 0;
        validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter the expiry month: ");
                month = scan.nextInt();
                scan.nextLine();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter an integer.");
                scan.next(); //for the wrong input
            }
        }
        int year = 0;
        validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter the expiry year: ");
                year = scan.nextInt();
                scan.nextLine();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter an integer.");
                scan.next(); //for the wrong input
            }
        }

        System.out.println("Filter Policies By Expiry Date Successfully.");
        HashMap<String, ArrayList<InsurancePolicy>> policy = Main.company.filterPoliciesByExpiryDate(new MyDate(day, month, year));
        for(String userName: policy.keySet()){
            System.out.println("Expired policies for user " + userName + ":");
            ArrayList<InsurancePolicy> policies = policy.get(userName);
            for (InsurancePolicy plc: policies){
                plc.print();
            }
        }
    }
}

