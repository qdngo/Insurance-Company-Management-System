package com.mycompany.lab7_121;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author qdaon
 */
import com.mycompany.lab7_121.MyDate;
import com.mycompany.lab7_121.PolicyException;
import com.mycompany.lab7_121.ThirdPartyPolicy;
import com.mycompany.lab7_121.User;
import com.mycompany.lab7_121.UserInterface;
import java.io.IOException;
import java.util.HashMap;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class Main {
    public static double flatRate = 20;
    public static InsuranceCompany company = new InsuranceCompany("Bob","nobita", "nobita", (int) flatRate);//using default constructor

    public static final int [] ranges={0,10000,100000};

    public static void main(String args[]) throws CloneNotSupportedException, PolicyException, IOException {

        MyDate date1 = new MyDate(13, 05, 2020);
        MyDate date2 = new MyDate(13, 03, 2020);
        MyDate date3 = new MyDate(13, 04, 2020);

        Address add1 = new Address(13, "Crown", "North Wollongong", "Wollongong");
        Address add2 = new Address(16, "Alma", "Maccquaire", "Sydney");
        Address add3 = new Address(27, "Tuff", "North Melbourne", "Melbourne");


        Car car1 = new Car("Toyota Vios", CarType.LUX, 2010, 1000);
        Car car2 = new Car("Toyota Camry", CarType.SED, 2005, 3000);
        Car car3 = new Car("Mercesdes C200", CarType.LUX, 2021, 5000);

        ComprehensivePolicy policy10 = new ComprehensivePolicy("John", 100, car1, 20, date1, 34, 3);
        ComprehensivePolicy policy20 = new ComprehensivePolicy("John", 200, car2, 20, date2, 34, 3);
        ThirdPartyPolicy policy30 = new ThirdPartyPolicy("John", 300, car3, 20, date3, "Comment");
        ComprehensivePolicy policy1 = new ComprehensivePolicy( "John", 300001, new Car("Toyota", CarType.LUX, 2004, 8000), 10, new MyDate(10,2,2025), 19, 1);
        ThirdPartyPolicy policy2 = new ThirdPartyPolicy( "Quang", 300002, new Car("Mercedes", CarType.LUX, 2018, 50000), 10, new MyDate(15,12,2024), "Value Customer");
        ComprehensivePolicy policy3 = new ComprehensivePolicy( "Dao", 300003, new Car("Toyota", CarType.SUV, 2004, 60000), 10, new MyDate(14,2,2025), 20, 3);
        ThirdPartyPolicy policy4 = new ThirdPartyPolicy("Dao", 300004, new Car("Mercedes", CarType.LUX, 2018, 70000), 10, new MyDate(1,1,2025), "Bad Customer");
        ComprehensivePolicy policy5 = new ComprehensivePolicy( "Quang", 300005, new Car("Toyota", CarType.HATCH, 2004, 5000), 10, new MyDate(25,12,2024), 19, 1);
        ThirdPartyPolicy policy6 = new ThirdPartyPolicy("Quang", 300006, new Car("Lexus", CarType.LUX, 2004, 80000), 10, new MyDate(10,6,2025), "Old Customer");
        ComprehensivePolicy policy7 = new ComprehensivePolicy( "John Smith", 300007, new Car("Toyota", CarType.SED, 2010, 10000), 1, new MyDate(5,5,2020), 31, 1);
        ThirdPartyPolicy policy8 = new ThirdPartyPolicy("John Smith", 300008, new Car("Kia", CarType.SED, 2018, 20000), 1, new MyDate(2,6,2020), "Poor Customer");



        InsuranceCompany company10 = new InsuranceCompany("Dawn Comp", "nobita", "nobita", 20);

        Address address2 = new Address(26, "Lava", "Canberra", "Canberra");
        User user2 = new User("John", address2, "sizuka");
        user2.addPolicy(user2.getName(), user2.getPassword(), policy2);
        user2.addPolicy(user2.getName(), user2.getPassword(), policy1);
        user2.addPolicy(user2.getName(), user2.getPassword(), policy20);
        user2.addPolicy(user2.getName(), user2.getPassword(), policy30);
        user2.addPolicy(user2.getName(), user2.getPassword(), policy10);
        user2.addPolicy(user2.getName(), user2.getPassword(), policy3);
        user2.addPolicy(user2.getName(), user2.getPassword(), policy4);
        user2.addPolicy(user2.getName(), user2.getPassword(), policy5);
        user2.addPolicy(user2.getName(), user2.getPassword(), policy6);
        user2.addPolicy(user2.getName(), user2.getPassword(), policy7);
        user2.addPolicy(user2.getName(), user2.getPassword(), policy8);
        company.addUser(user2);

        testCodeLab8(company);

//        UserInterface.mainMenu();


        //main
        //create arrayList
//        ArrayList<InsurancePolicy> policyDeepCopy = new ArrayList<>();
//        ArrayList<InsurancePolicy> policyShallowCopy = new ArrayList<>();
//        HashMap<Integer, InsurancePolicy> policyDeepCopy = new HashMap<>();
//        HashMap<Integer, InsurancePolicy> policyShallowCopy = new HashMap<>();
//
//        //create object
//        User user1 = new User("Nobita", 001, add1);
//        user1.addPolicy(cplc1);
//        policyDeepCopy = user1.deepCopyPolicies();
//        policyShallowCopy = user1.shallowCopyPolicies();
//
//        //change the city to New York
//        user1.getAddress().setCity("New York");
//        user1.addPolicy(cplc2);
//
//        //call method to sort the policies
//        user1.sortPoliciesByDate(date1);

//        //shallow copy
//        System.out.println("Shallow Copy policies: ");
//        for(InsurancePolicy plcShallowCopy: policyShallowCopy){
//            plcShallowCopy.print();
//        }
//
//        //deep copy
//        System.out.println("\nDeep Copy policies:");
//        for(InsurancePolicy plcDeepCopy: policyDeepCopy){
//            plcDeepCopy.print();
//        }
//
//        //print user policies after sorting
//        System.out.println("\nUser's policies: ");
//        user1.print();
//
//        //create arrayList
////        ArrayList<User> userDeepCopy = new ArrayList<>();
////        ArrayList<User> userShallowCopy = new ArrayList<>();
//        HashMap<Integer, User> userDeepCopy = new HashMap();
//        HashMap<Integer, User> userShallowCopy = new HashMap();
//
//
//        //create new object


//
//        userDeepCopy = company1.deepCopyUsers();
//        userShallowCopy = company1.shallowCopyUsers();
//
//        //call the method to sort the user
//        company1.sortUsers("Canberra");
//
//        //shallow copy
//        System.out.println("\nShallow Copy User: ");
//        for(User usShallowCopy: userShallowCopy){
//            usShallowCopy.print();
//        }
//
//        //deep copy
//        System.out.println("\nDeep Copy User:");
//        for(User usDeepCopy: userDeepCopy){
//            usDeepCopy.print();
//        }
//
//        //print company's user
//        System.out.println("\nCompany's user: ");
//        System.out.println(company1);
//
//        //clone insuranceCompany
//        InsuranceCompany company2 = (InsuranceCompany) company1.clone();
//
//        System.out.println("The original version: " );
//        company1.setName("Giant");
//        System.out.println(company1.getName());
//
//        System.out.println("\nThe clone version: " );
//        System.out.println(company2.getName());
//        System.out.println("Total count per Car Model for 1 user");
//        HashMap<String, Integer> userCounts = user1.getTotalCountPerCarModel();
//        System.out.println(userCounts);
//
//        System.out.println("Total payment per Car Model for 1 User");
//        HashMap<String, Double> userPayments = user1.getTotalPaymentPerCarModel();
//        System.out.println(userPayments);
//
//        System.out.println("Report payment per car Model for 1 user");
//        user1.reportPaymentsPerCarModel(flatRate);
//
//        System.out.println("Total Payment per city");
//        HashMap<String, Double> cities = company1.getTotalPaymentPerCity();
//        System.out.println(cities);
//
//        System.out.println("Total Count per Car Model for all user");
//        HashMap <String, Integer> counts = company1.getTotalCountPerCarModel();
//        System.out.println(counts);
//
//        System.out.println("Total Payment per Car Model for all User");
//        HashMap <String, Double> payments = company1.getTotalPremiumPerCarModel();
//        System.out.println(payments);
//
//        System.out.println("Report Payment per Car Model");
//        company1.reportPaymentsPerCarModel();
//
//        System.out.println("Report Payment per City");
//        company1.reportPaymentPerCity();

        //testing binary file and list of policies
//        HashMap<Integer,InsurancePolicy> policies= InsurancePolicy.load("policies.ser");
//        for(InsurancePolicy pol: policies.values()){
//            System.out.println(pol.toDelimitedString());
//        }
//
//        InsurancePolicy.printPolicies(policies);
//
//
//        InsurancePolicy.save(policies,"policies.ser");
//        policies.clear();
//
//        policies=InsurancePolicy.load("policies.ser");
//        InsurancePolicy.printPolicies(policies);

//------------------------------------------------------------------------
//testing binary file and list of users
//        HashMap<Integer,User> users=User.loadUser("users.ser");
//        for(User us: users.values()){
//            System.out.println(us.toDelimitedString());
//        }
//
//        User user=new User(120,......);
//        user.addPolicy(new ThirdPartyInsurance(.....));
//        users.put(120,user);
//        User.saveUser(users,"users.ser");
//        users.clear();
//
//        users=User.loadUser("users.ser");
//        User.printUsers(users);
//
////----------------------------------------------------------------------
////InsuranceCompany and binary file
//        InsuranceCompany insuranceCompany1=new InsuranceCompany();//using default constructor
//        insuranceCompany1.load("company.ser");//the whole company including all users and all policies are loaded
//        System.out.println(insuranceCompany1);
//
//        insuranceCompany1.addUser(116,....);
//        insuranceCompany1.addPolicy(11,.....);
//        insuranceCompany1.save("company.ser");
//        InsuranceCompany insuranceCompany2=new InsuranceCompany();
//
//        insuranceCompany2.load("company.ser");
//        System.out.println(insuranceCompany2);
//
//-----------------------------------------------------------------------------
//testing text file and list of policies with toDilimitedString
//        HashMap<Integer,InsurancePolicy> policiesText =InsurancePolicy.load("/Users/quangdaongo/Desktop/Year1Sem2/DPIT121/LabExercise/Lab6/policies.txt");
//        for(InsurancePolicy pol: policiesText.values()){
//            System.out.println(pol.toDelimitedString());
//        }
//        InsurancePolicy.printPolicies(policiesText);
//
//        InsurancePolicy.saveTextFile(policiesText,"/Users/quangdaongo/Desktop/Year1Sem2/DPIT121/LabExercise/Lab6/policies.txt");
//        policiesText.clear();
//
//        policiesText=InsurancePolicy.loadTextFile("/Users/quangdaongo/Desktop/Year1Sem2/DPIT121/LabExercise/Lab6/policies.txt");
//        InsurancePolicy.printPolicies(policiesText);

////------------------------------------------------------------------------------
////testing text file and list of users with toDilimitedString
//        HashMap<Integer,User> usersText = User.loadTextFile("users.txt");
//        for(User us: usersText.values()){
//            System.out.println(us.toDelimitedString());
//        }
//        User.print(users);
//
//        User user=new User(122,......);
//        user.addPolicy(new ThirdPartyInsurance(.....));
//        users.put(122,user);
//        User.saveTextFile(users, "users.txt");
//        users.clear();
//
//        users=User.loadTextFile("users.txt");
//        User.printUser(users);
//
////-------------------------------------------------------------------
////InsuranceCompany and text file
//        InsuranceCompany insuranceCompany1=new InsuranceCompany();//using default constructor
//        insuranceCompany1.loadTextFile("company.txt");//the whole company including all users and all policies are loaded
//        System.out.println(insuranceCompany1);
//
//        insuranceCompany1.addUser(117,....);
//        insuranceCompany1.addPolicy(12,.....);
//        insuranceCompany1.saveTextFile("company.txt");
//        InsuranceCompany insuranceCompany2=new InsuranceCompany();
//
//        insuranceCompany2.loadTextFile("company.txt");
//        System.out.println(insuranceCompany2);
//
//
//        String fileName = "/Users/quangdaongo/Desktop/Year1Sem2/DPIT121/LabExercise/Lab6/text.txt";
//        HashMap<Integer, InsurancePolicy> plc = company1.allPolicies();
//
//        HashMap<Integer, InsurancePolicy> pl = InsurancePolicy.load(fileName);
//        for(InsurancePolicy pol: pl.values()){
//            System.out.println(pol.toString());
        //Lab 6: Test binary file for Insurance Policy
//        System.out.print("\n======================Lab 6: Binary for Policy=======================\n");
//
//        HashMap<Integer,InsurancePolicy> policies1 = new HashMap<>();
//        policies1.put(policy1.getId(), policy1);
//        policies1.put(policy2.getId(), policy2);
//
//        InsurancePolicy.save(policies1, "policies.ser");
//        policies1.clear();
//
//        policies1 = InsurancePolicy.load("policies.ser");
//        InsurancePolicy.printPolicies(policies1);
//
//        //Lab 6: Test binary file for User
//        System.out.print("\n======================Lab 6: Binary for User=======================\n");
//
//        HashMap<Integer,User> users1 = new HashMap<>();
//        users1.put(user2.getUserID(), user2);
//
//        User.saveUser(users1, "users.ser");
//        users1.clear();
//
//        users1 = User.loadUser("users.ser");
//        for (User user : users1.values()) {
//            user.print();
//        }
//
//        //Lab 6: Test binary file for Company
//        System.out.print("\n======================Lab 6: Binary for Company=======================\n");
//        InsuranceCompany company1 = new InsuranceCompany("Bob","1", "1", (int) flatRate);//using default constructor
//
//        company1.addUser("Jane", 69, new Address(10, "Crown St", "Keiraville", "Wollongong"));
//        company1.addPolicy(69, new ComprehensivePolicy("Jane", 300100, policy1.getCar(), 10, policy1.getExpiryDate(), 20, 3));
//        company1.addPolicy(69, new ThirdPartyPolicy("Jane", 300200, policy2.getCar(), 10, policy2.getExpiryDate(), "Customer"));
//
//        company1.save("company1.ser");//the whole company including all users and all policies are loaded
//        company1.load("company1.ser");
//        System.out.println(company1);
//
//        InsuranceCompany insuranceCompany2 = new InsuranceCompany("Bob", "1", "1", (int) flatRate);
//        insuranceCompany2.saveTextFile("company.txt");
//        insuranceCompany2.loadTextFile("company.txt");
//        System.out.println(insuranceCompany2);
//
//        //Lab 6: Test text file for Insurance Policy
//        System.out.print("\n======================Lab 6: Text File for Policy=======================\n");
//
//        HashMap<Integer,InsurancePolicy> policies2 = new HashMap<>();
//        policies2.put(policy1.getId(), policy1);
//        policies2.put(policy2.getId(), policy2);
//
//        InsurancePolicy.saveTextFile(policies2, "policies.txt");
//        policies2.clear();
//
//        policies2 = InsurancePolicy.loadTextFile("policies.txt");
//        InsurancePolicy.printPolicies(policies2);
//
//        //Lab 6: Test text file for User
//        System.out.print("\n======================Lab 6: Text File for User=======================\n");
//
//        HashMap<Integer,User> users2 = new HashMap<>();
//        users2.put(user2.getUserID(), user2);
//
//        User.saveTextFile(users2, "users.txt");
//        users1.clear();
//
//        users2 = User.loadTextFile("users.txt");
//        for (User user : users2.values()) {
//            user.print();
//        }
//
//        //Lab 6: Test text file for Company
//        System.out.print("\n======================Lab 6: Text File for Company=======================\n");
//
//        insuranceCompany3.addUser("Jane", 69, new Address(10, "Crown St", "Keiraville", "Wollongong"));
//        insuranceCompany3.addPolicy(69, new ComprehensivePolicy("Jane", 300100, policy1.getCar(), 10, policy1.getExpiryDate(), 20, 3));
//        insuranceCompany3.addPolicy(69, new ThirdPartyPolicy("Jane", 300200, policy2.getCar(), 10, policy2.getExpiryDate(), "Customer"));
//
//        insuranceCompany3.addUser("Anson", 96, new Address(10, "Crown St", "Keiraville", "Wollongong"));
//        insuranceCompany3.addPolicy(96, new ComprehensivePolicy("Anson", 300300, policy1.getCar(), 10, policy1.getExpiryDate(), 20, 3));
//        insuranceCompany3.addPolicy(96, new ThirdPartyPolicy("Anson", 300400, policy2.getCar(), 10, policy2.getExpiryDate(), "Customer"));
//
//        insuranceCompany3.saveTextFile("company1.txt");//the whole company including all users and all policies are loaded
//        insuranceCompany3.loadTextFile("company1.txt");
//        System.out.println(insuranceCompany3);
//
//        InsuranceCompany company4 = new InsuranceCompany("Tom4", "1", "1", (int) flatRate);
//        company4.saveTextFile("company2.txt");
//        company4.loadTextFile("company2.txt");
//        System.out.println(company4);

    }
    private static void testCodeLab8(InsuranceCompany company){

        HashMap<Integer, InsurancePolicy> policies = company.allPolicies();


        // Lab 8: a) Search for the name containing “John” in the list of policies and displays the information for all the policies with the given name pattern.
        System.out.println("\n-----a) Search for the name containing “John” in the list of policies and displays the information for all the policies with the given name pattern------");
        policies.values().stream()
                .filter(policy -> policy.getPolicyHolderName().contains("John"))
                .forEach(System.out::println);


        // Lab 8: b) Search for the name containing “John” in the list of policies and displays the total premiums for all the policies with the given name pattern.
        System.out.println("\n----b) Search for the name containing “John” in the list of policies and displays the total premiums for all the policies with the given name pattern----");
        System.out.println("Total Premium Payment: $" +
                policies.values().stream()
                        .filter(policy -> policy.getPolicyHolderName().contains("John"))
                        .mapToDouble(policy -> policy.calcPayment(flatRate))
                        .sum());


        // Lab 8: Find the first policy with the premium between $200 to $500 and display the name, ID and premium
        System.out.println("\n-----c) Find the first policy with the premium between $200 to $500 and display the name, ID and premium -----=");
        Optional<String> result = policies.values().stream()
                .filter(policy -> policy.calcPayment(flatRate) >= 200 && policy.calcPayment(flatRate) <= 500)
                .findFirst()
                .map(policy -> "Name: " + policy.getPolicyHolderName() + ", ID: " + policy.getId() + ", Premium: $" + policy.calcPayment(flatRate));
        if (result.isPresent()) {
            System.out.println(result.get());
        }
        else {
            System.out.println("Error");
        }


        // Lab 8: Find all policies with the premium between $200 to $500, sort them by ID and display the name, ID and premium for each policy.
        System.out.println("\n-----d) Find all policies with the premium between $200 to $500 and display the name, ID and premium -----");
        policies.values().stream()
                .filter(policy -> policy.calcPayment(flatRate) >= 200 && policy.calcPayment(flatRate) <= 500)
                .sorted(Comparator.comparing(InsurancePolicy::getId))
                .map(policy -> "Name: " + policy.getPolicyHolderName() + ", ID: " + policy.getId() + ", Premium: $" + policy.calcPayment(flatRate))
                .forEach(System.out::println);


        // Lab 8: e) Calculate the total premium for all policies with the premium between $200 to $500.
        System.out.println("\n-----e) Calculate the total premium for all policies with the premium between $200 to $500. -----");
        System.out.println("Total Premium Payment: $" +
                policies.values().stream()
                        .filter(policy -> policy.calcPayment(flatRate) >= 200 && policy.calcPayment(flatRate) <= 500)
                        .mapToDouble(policy -> policy.calcPayment(flatRate))
                        .sum());


        // Lab 8: f)
        System.out.println("\n f)");
        Predicate<InsurancePolicy> c1 = x -> x.getPolicyHolderName().equals("John Smith");
        ArrayList<InsurancePolicy> policies1 = filterPolicies(policies,c1);
        InsurancePolicy.printPolicies(policies1);

        System.out.println("\n-----f) Print policy that expired in 2020 -----");
        InsurancePolicy.printPolicies(filterPolicies(policies, x->x.getExpiryDate().getYear()==2020));

        System.out.println("\n-----f) Print policy that contains Toyota -----");
        InsurancePolicy.printPolicies(filterPolicies(policies, x->x.getCarModel().contains("Toyota")));


        // Lab 8: g) Call your filterPolicy method to filter a list of policies with Car Type equal to LUX. Then sort the filtered list based on car price and finally print the sorted filtered list.
        System.out.println("\n------g) Call your filterPolicy method to filter a list of policies with Car Type equal to LUX. Then sort the filtered list based on car price and finally print the sorted filtered list------");
        ArrayList<InsurancePolicy> policies2 = filterPolicies(policies, x->x.getCar().getCarType().toString().equals("LUX"));
        policies2.stream().sorted(Comparator.comparing(InsurancePolicy::getCarPrice)).forEach(System.out::println);
        // Lab 8: h) Aggregate (by using group by) the list of policies based on expiryDate year and print the report
        System.out.println("\n-----h) Aggregate (by using group by) the list of policies based on expiryDate year and print the report -----");
        Map<String, Long> policyCountsByYear = policies.values().stream()
                .collect(Collectors.groupingBy(policy -> String.valueOf(policy.getExpiryDate().getYear()), Collectors.counting()));

        policyCountsByYear.forEach((year, count) -> System.out.println("Year: " + year + " - Policy count: " + count));

 }

    //Lab 8: filterPolicies
    public static ArrayList<InsurancePolicy> filterPolicies (HashMap<Integer,InsurancePolicy> policies, Predicate<InsurancePolicy> criteria) {
        return (ArrayList<InsurancePolicy>) policies.values().stream().filter(criteria).collect(Collectors.toList());
    }
    
}

