package com.mycompany.lab7_121;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author qdaon
 */
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public abstract class InsurancePolicy implements Comparable<InsurancePolicy>, Cloneable, Serializable {
    //start of lab 1
    // attributes
    String policyHolderName;
    private int id;
    Car car;
    int numberOfClaims;
    MyDate expiryDate;

    //constructor
    public InsurancePolicy(String policyHolderName, int id, int numberOfClaims) {
        this.policyHolderName = policyHolderName;
        this.id = id;       
        this.numberOfClaims = numberOfClaims;
    }
    public InsurancePolicy(String policyHolderName, int id, Car car, int numberOfClaims, MyDate expiryDate) {
        this.policyHolderName = policyHolderName;
        this.car = car;
        this.id = id;
        this.numberOfClaims = numberOfClaims;
        this.expiryDate = expiryDate;
    }
    //copy constructor
    public InsurancePolicy(InsurancePolicy another){
        this(another.policyHolderName, another.id, another.car, another.numberOfClaims, another.expiryDate);
    }
    //method toString
    @Override
    public abstract String toString();
    //method print
    public void print() {
        System.out.println("Policy Holder Name: " + policyHolderName + "- ID: " + id+ "- Number Of Claims: " + numberOfClaims + "- Expiry Date: " + expiryDate);
        car.print();
    }
    public abstract double calcPayment(double flatRate);//abstract class
    //end of lab 1

    //start of lab 2

    public String getPolicyHolderName(){
        return policyHolderName;
    }
    public int getId(){
        return id;
    }
    public Car getCar(){
        return car;
    }
    public String getCarModel(){return car.getModel();}
    public double getCarPrice(){return car.getPrice();}
    public int getNumberOfClaims(){
        return numberOfClaims;
    }
    public MyDate getExpiryDate(){
        return expiryDate;
    }
    //mutators
    public void setPolicyHolderName(String policyHolderName){
        this.policyHolderName = policyHolderName;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setCar(Car car){
        this.car = car;
    }
    public void setNumberOfClaims(int numberOfClaims){
        this.numberOfClaims = numberOfClaims;
    }
    public void setExpiryDate(MyDate expiryDate){
        this.expiryDate = expiryDate;
    }
    //print a list of policies.

//    public static void printPolicies(ArrayList<InsurancePolicy> policies){
//        for(InsurancePolicy plc : policies)
//            plc.print();
//    }
    //HashMap of print
    public static void printPolicies(HashMap<Integer, InsurancePolicy> policies){
        for(Integer polID : policies.keySet()) {
            InsurancePolicy plc = policies.get(polID);
            plc.print();
        }
    }
    public static void printPolicies(ArrayList<InsurancePolicy> policies)
    {
        policies.forEach(System.out::println);
        // or this: policies.forEach(x->x.print());
        // or this: policies.forEach(x->System.out.println(x));
    }



    //calculates the total premium payments for a list of policies.
//    public static double calcTotalPayments(ArrayList<InsurancePolicy> policies, double flatRate){
//        double total=0;
//        for (InsurancePolicy plc: policies){
//            total += plc.calcPayment(flatRate);
//        }
//        return total;
//    }
    //HashMap of calcTotalPayments
    public static double calcTotalPayments(HashMap<Integer, InsurancePolicy> policies, double flatRate){
        double total=0;
        for (Integer polID: policies.keySet()){
            InsurancePolicy plc = policies.get(polID);
            total += plc.calcPayment(flatRate);
        }
        return total;
    }
    public static double calcTotalPayments(ArrayList<InsurancePolicy> policies, double flatRate)
    {
//        return policies.stream()
//                .map(x->x.calcPayment(flatRate))
//                .reduce(0.0,(x,y)->x+y);
        // or this :
        return policies.stream()
                .mapToDouble(x->x.calcPayment(flatRate))
                .sum();
    }


    //It has one parameter, a price rise in percent
    public void carPriceRise(double risePercent){
        car.priceRise(risePercent);
    }
    //calls the carPriceRise method for all the policies in a given list (in a for each loop)

//    public static void carPriceRiseAll(ArrayList<InsurancePolicy> policies, double risePercent){
//        for (InsurancePolicy plc: policies){
//            plc.carPriceRise(risePercent);
//        }
//    }
    public static void carPriceRiseAll(ArrayList<InsurancePolicy> policies, double risePercent){
        policies.forEach(x-> x.carPriceRise(risePercent));
    }
    //HashMap of carPriceRiseAll
    public static void carPriceRiseAll(HashMap<Integer, InsurancePolicy> policies, double risePercent){
        for (Integer polID: policies.keySet()){
            InsurancePolicy plc = policies.get(polID);
            plc.carPriceRise(risePercent);
        }
    }

    //which filter a list of policies and creates a filtered list of policies
//    public static ArrayList<InsurancePolicy> filterByCarModel (ArrayList<InsurancePolicy> policies, String carModel){
//        ArrayList <InsurancePolicy> filterByCarModel = new ArrayList<>();
//        for (InsurancePolicy pol: policies)
//        {
//            if (pol.getCar().getModel().equals(carModel))
//                filterByCarModel.add(pol);
//        }
//        return filterByCarModel;
//    }

    public static ArrayList<InsurancePolicy> filterByCarModel (ArrayList<InsurancePolicy> policies, String carModel)
    {
        return (ArrayList<InsurancePolicy>)(policies.stream()
                .filter(x->x.getCar().getModel().contains(carModel))
                .collect(Collectors.toList()));
    }

    //HashMap of filterByCarModel
    public static HashMap<Integer, InsurancePolicy> filterByCarModel (HashMap<Integer, InsurancePolicy> policies, String carModel){
        HashMap <Integer, InsurancePolicy> filterByCarModel = new HashMap<>();
        for (Integer polID: policies.keySet())
        {
            InsurancePolicy pol = policies.get(polID);
            if (pol.getCar().getModel().equals(carModel))
                filterByCarModel.put(polID, pol);
        }
        return filterByCarModel;
    }

    public void setCarModel(String model) {
        car.setModel(model);
    }
    //arraylist filter policies by the expiry date
//    public static ArrayList<InsurancePolicy> filterByExpiryDate (ArrayList<InsurancePolicy> policies, MyDate date) {
//         ArrayList<InsurancePolicy> filterByExpiryDate = new ArrayList<>();
//         for (InsurancePolicy pl: policies){
//            if (pl.expiryDate.isExpired(date))
//                filterByExpiryDate.add(pl);
//         }
//         return filterByExpiryDate;
//    }
    //HashMap of filterByExpiryDate
    public static HashMap<Integer, InsurancePolicy> filterByExpiryDate (HashMap<Integer, InsurancePolicy> policies, MyDate date) {
        HashMap<Integer, InsurancePolicy> filterByExpiryDate = new HashMap<>();
        for (Integer polID: policies.keySet()){
            InsurancePolicy pol = policies.get(polID);
            if (pol.expiryDate.isExpired(date))
                filterByExpiryDate.put(polID, pol);
        }
        return filterByExpiryDate;
    }
    public static ArrayList<InsurancePolicy> filterByExpiryDate (ArrayList<InsurancePolicy> policies, MyDate date){
        return (ArrayList<InsurancePolicy>)(policies.stream()
                .filter(x -> x.getExpiryDate().isExpired(date))
                .collect(Collectors.toList()));
    }
    static ArrayList< InsurancePolicy> shallowCopy(HashMap<Integer, InsurancePolicy> policies) {
        ArrayList<InsurancePolicy> policies1 = new ArrayList<>();
        for (InsurancePolicy plc: policies.values()){
            policies1.add(plc);
        }
        return policies1;
    }
    public static ArrayList<InsurancePolicy> shallowCopyLambda(ArrayList<InsurancePolicy> policies){
        ArrayList<InsurancePolicy> shallowCopy = new ArrayList<>();
        policies.forEach(x -> shallowCopy.add(x));
        return shallowCopy;
    }
    static ArrayList< InsurancePolicy>  deepCopy (HashMap< Integer, InsurancePolicy> policies) throws CloneNotSupportedException {
        ArrayList<InsurancePolicy> policies1 = new ArrayList<>();
        for (InsurancePolicy plc : policies.values()) {
            policies1.add(plc.getId(), plc.clone());
        }
        return policies1;
    }
    public static ArrayList<InsurancePolicy> deepCopyLambda(ArrayList<InsurancePolicy> policies) throws CloneNotSupportedException{
        ArrayList<InsurancePolicy> deepCopy = new ArrayList<>();
        policies.forEach(x -> {
            try{
                deepCopy.add(x.clone());
            }
            catch(CloneNotSupportedException e){
                e.printStackTrace();
            }
        });
        return deepCopy;
    }
    static HashMap< Integer, InsurancePolicy> shallowCopyHashMap (HashMap< Integer, InsurancePolicy> policies){
        HashMap<Integer, InsurancePolicy> policies1 = new HashMap();
        for (InsurancePolicy plc: policies.values()){
            policies1.put(plc.getId(), plc);
        }
        return policies1;
    }
    static HashMap< Integer, InsurancePolicy > deepCopyHashMap (HashMap< Integer, InsurancePolicy > policies) throws CloneNotSupportedException {
        HashMap<Integer, InsurancePolicy> policies1 = new HashMap<>();
        for (InsurancePolicy plc : policies.values()) {
            policies1.put(plc.getId(), plc.clone());
        }
        return policies1;
    }

    // cloneable interface
    @Override
    public InsurancePolicy clone() throws CloneNotSupportedException{
        InsurancePolicy output = (InsurancePolicy) super.clone();
        return output;
    }

    public static ArrayList< InsurancePolicy >  shallowCopy(ArrayList< InsurancePolicy> policies){
        ArrayList<InsurancePolicy> policies1 = new ArrayList<>();
        for (InsurancePolicy plc: policies){
            policies1.add(plc);
        }
        return policies1;
    }
    //implement clonable interface
    public static ArrayList< InsurancePolicy>   deepCopy(ArrayList< InsurancePolicy> policies) throws CloneNotSupportedException {
        ArrayList<InsurancePolicy> policies1 = new ArrayList<>();
        for (InsurancePolicy plc : policies) {
            policies1.add(plc.clone());
        }
        return policies1;
    }

    //implement the comparable interface
    @Override
    public int compareTo(InsurancePolicy otherInsurancePolicy) {
        return expiryDate.compareTo(otherInsurancePolicy.expiryDate);
    }
    static HashMap<Integer, InsurancePolicy> load (String fileName) throws IOException {
        HashMap<Integer, InsurancePolicy> load = new HashMap<>();
        ObjectInputStream inputst = null;
        load.clear ();
        try
        {
            inputst = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)));
        }
        catch(IOException ex)
        {
            System.err.println("error in create/open the file ");
            System.exit(1);
        }
        try
        {
            while(true)
            {
                InsurancePolicy plc = (InsurancePolicy) inputst.readObject();
                load.put(plc.getId(), plc);
            }
        }
        catch(EOFException ex)
        {
            System.out.println("no more record!");
        }
        catch (ClassNotFoundException ex)
        {
            System.err.println("error in wrong class in the file ");
        }
        catch(IOException ex)
        {
            System.err.println("error in add object to the file ");
            System.exit(1);
        }
        try
        {
            if(inputst !=null)
                inputst.close();
        }
        catch(IOException ex)
        {
            System.err.println("error in close the file ");
            System.exit(1);
        }
        return load;
    }
    static Boolean save (HashMap<Integer, InsurancePolicy> plcs, String fileName){

        ObjectOutputStream outputst = null;

        try
        {
            FileOutputStream streamOut = new FileOutputStream(fileName);
            outputst = new ObjectOutputStream(streamOut);
        }
        catch(IOException ex)
        {
            System.err.println("error in create/open the file ");
            System.exit(1);
        }
        try
        {
            for (InsurancePolicy plc : plcs.values())
            {
                outputst.writeObject(plc);
            }
        }
        catch(IOException ex)
        {
            System.err.println("error in adding the objects to the file ");
            System.exit(1);
        }
        try
        {
            if(outputst !=null)
            {
                outputst.close();
                return true;
            }
        }
        catch(IOException ex)
        {
            System.err.println("error in closing the file ");
            System.exit(1);
        }
        return false;
    }
    //lab 6 toDelimitedString
    public abstract String toDelimitedString();
    public static HashMap<Integer, InsurancePolicy> loadTextFile (String fileName) throws IOException {
        HashMap<Integer, InsurancePolicy> policies= new HashMap<Integer, InsurancePolicy>();
        policies.clear();

        BufferedReader in = new BufferedReader (new FileReader (fileName));
        String line = in.readLine();
        while (line != null)
        {
            line = line.trim ();
            String[] field = line.split(",");
            switch (field[0])
            {
                case "TPP":
                    //case ThirdPartyPolicy
                    String policyHolderName = field[1];
                    int id = Integer.parseInt(field[2]);
                    String model = field[3];
                    String typeString = field[4];
                    int ManufacturingYear = Integer.parseInt(field[5]);
                    double price = Double.parseDouble(field[6]);
                    int numberOfClaims = Integer.parseInt(field[7]);
                    int day = Integer.parseInt(field[8]);
                    int month = Integer.parseInt(field[9]);
                    int year = Integer.parseInt(field[10]);
                    String comments = field[11];

                    CarType type = null;
                    switch (typeString){
                        case "SUV":
                            type = CarType.SUV;
                            break;
                        case "SED":
                            type = CarType.SED;
                            break;
                        case "HATCH":
                            type = CarType.HATCH;
                            break;
                        case "LUX":
                            type = CarType.LUX;
                            break;
                    }
                    //create object for ThirdPartyPolicy
                    Car car1 = new Car(model, type, ManufacturingYear, price);
                    MyDate date1 = new MyDate(day, month, year);
                    ThirdPartyPolicy TPpolicy1 = new ThirdPartyPolicy(policyHolderName, id, car1, numberOfClaims, date1, comments);
                    //put new policy to a list of policies
                    policies.put(TPpolicy1.getId(), TPpolicy1);
                    break;

                case "CP":
                    policyHolderName = field[1];
                    id = Integer.parseInt(field[2]);
                    model = field[3];
                    typeString = field[4];
                    ManufacturingYear = Integer.parseInt(field[5]);
                    price = Double.parseDouble(field[6]);
                    numberOfClaims = Integer.parseInt(field[7]);
                    day = Integer.parseInt(field[8]);
                    month = Integer.parseInt(field[9]);
                    year = Integer.parseInt(field[10]);
                    int driverAge = Integer.parseInt(field[11]);
                    int level = Integer.parseInt(field[12]);

                    type = null;
                    switch (typeString){
                        case "SUV":
                            type = CarType.SUV;
                            break;
                        case "SED":
                            type = CarType.SED;
                            break;
                        case "HATCH":
                            type = CarType.HATCH;
                            break;
                        case "LUX":
                            type = CarType.LUX;
                            break;
                    }
                    //create object for comprehensivePolicy
                    Car car2 = new Car(model, type, ManufacturingYear, price);
                    MyDate date2 = new MyDate(day, month, year);
                    ComprehensivePolicy Cpolicy2 = new ComprehensivePolicy(policyHolderName, id, car2, numberOfClaims, date2, driverAge, level);
                    policies.put(Cpolicy2.getId(), Cpolicy2);
                    break;
            }

            line = in.readLine();
        }
        in.close ();

        return policies;
    }
    public static Boolean saveTextFile (HashMap<Integer, InsurancePolicy> policies, String fileName) throws IOException {
        try (BufferedWriter out = new BufferedWriter (new FileWriter (fileName))) {
            for (InsurancePolicy plc : policies.values())
            {
                out.write (plc.toDelimitedString () + "\n");
            }
        }

        return true;
    }
    // Assignment 2
}

