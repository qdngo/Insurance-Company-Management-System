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
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class User implements Cloneable, Comparable<User>, Serializable{
    private static int count = 100;
    private String password;
    private String name; //the name of the account holder
    private int userID; //the user ID/number
    private Address address;
//    public ArrayList<InsurancePolicy> policies;
    private  HashMap<Integer, InsurancePolicy> policies;
    public User(String name, int userID, Address address) {
        this.name = name;
        this.userID = userID;
        this.address = address;
        this.policies = new HashMap<>();
    }
    public User(String name, int userID, Address address, String password) {
        this.name = name;
        this.userID = userID;
        this.address = address;
        this.password = password;
        this.policies = new HashMap<>();
    }
    //copy constructor
    public User(User another){
        this(another.name, another.userID, another.address);
    }
    public User(String name,Address address, String password)
    {
        this.name=name;
        // 3) ID generation for the User to be automatic by using a static count and increment it.
        this.userID=User.count++;
        this.address=address;
        this.password=password;
        this.policies= new HashMap<>();
    }
    @Override
    public User clone() throws CloneNotSupportedException{
        User output = (User) super.clone();
        return output;
    }
    boolean userValidate(String userName, String password){
        if(this.name.equals(userName) && this.password.equals(password)){
            return true;
        }
        else
            return false;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserID() {
        return userID;
    }
    public String getPassword() {
        return password;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public Address getAddress() {
        return address;
    }
    public String getCity(){return address.getCity();}

    public void setAddress(Address address) {
        this.address = address;
    }
    public void setPassword(String password){this.password = password;}

    public HashMap<Integer, InsurancePolicy> getPolicies() {
        return policies;
    }

    public void setPolicies(HashMap<Integer, InsurancePolicy> policies) {
        this.policies = policies;
    }

//    public boolean addPolicy(InsurancePolicy policy){
//        if (findPolicy(policy.getId()) == null)
//        {
//            policies.add(policy);
//            return true;
//        }
//        else
//            return false;
//    }
    public boolean addPolicy(InsurancePolicy policy){
        if (findPolicy(policy.getId()) == null)
        {
            policies.put(policy.getId(), policy);
            return true;
        }
        else
            return false;
    }
    public boolean addPolicy(String userName, String password, InsurancePolicy policy){
        if (userValidate(userName, password)) {
            if (findPolicy(policy.getId()) == null) {
                policies.put(policy.getId(), policy);
                return true;
            } else
                return false;
        }
        else
            return false;
    }
//    public InsurancePolicy findPolicy(int policyID){
//        for (InsurancePolicy pol: policies)
//        {
//            if (pol.getId() == policyID)
//                return pol;
//        }
//        return null;
//    }
    public InsurancePolicy findPolicy(int policyID){
        for (Integer polID: policies.keySet())
        {
            if (polID == policyID)
                return policies.get(polID);
        }
        return null;
    }

    public void print(){
        System.out.println("User: " + name + "- UserID: " + userID + "- Address:" + address.toString());
        System.out.println("List of policies: ");
        for (Integer polID: policies.keySet())
        {
            InsurancePolicy pol= policies.get(polID);
            pol.print();
        }
    }
    public String toString(){
        String poli = "Name: "+name+", UserID: "+userID+", Address: "+address.toString()+"\n";
        for (Integer polID: policies.keySet())
        {
            InsurancePolicy pol = policies.get(polID);
            poli += pol.toString()+"\n";
        }
        poli += "\n";
        return poli;
    }
//    public void printPolicies(double flatRate){
//        for (Integer polID: policies.keySet()) {
//            InsurancePolicy pol = policies.get(polID);
//            pol.calcPayment(flatRate);
//            pol.print();
////                if (userID == pol.getId()){
////                        pol.calcPayment(flatRate);
////                        pol.print();
////            }
//        }
//    }
    public void printPolicies(double flatRate){
        policies.values().forEach(x -> x.calcPayment(flatRate));
    }
    public double calcTotalPremiums(double flatRate){
        return InsurancePolicy.calcTotalPayments(policies, flatRate);
    }


    //Assignment 2
    public double calcTotalPremiums(String userName, String password){
        if(userValidate(userName, password)){
            return InsurancePolicy.calcTotalPayments(policies, 20);
        }
        else
            return 0;
    }
    public void carPriceRiseAll(double risePercent){
        InsurancePolicy.carPriceRiseAll(policies,risePercent);
    }
//    public ArrayList<InsurancePolicy> filterByCarModel (String carModel){
//        return InsurancePolicy.filterByCarModel(policies,carModel);
//    }
    HashMap<Integer, InsurancePolicy> filterByCarModel (String carModel){
        return InsurancePolicy.filterByCarModel(policies, carModel);
    }
    public void setCity(String city){
        address.setCity(city);
    }

    //start of lab 3
    boolean createThirdPartyPolicy(String policyHolderName, int id, Car car, int numberOfClaims, MyDate expiryDate, String comments) {
        ThirdPartyPolicy tpplc1 = new ThirdPartyPolicy(policyHolderName, id, car, numberOfClaims, expiryDate, comments);
        if (findPolicy(tpplc1.getId()) == null) {
            policies.put(tpplc1.getId(), tpplc1);
            return true; }
        else
            return false;
    }
    boolean createComprehensivePolicy (String policyHolderName, int id, Car car, int numberOfClaims, MyDate expiryDate, int driverAge, int level){
        ComprehensivePolicy cphplc1 = new ComprehensivePolicy(policyHolderName, id, car, numberOfClaims, expiryDate, driverAge, level);
        if (findPolicy(cphplc1.getId()) == null){
            policies.put(cphplc1.getId(), cphplc1);
            return true; }
        else
            return false;
        }
//    ArrayList<InsurancePolicy> filterByExpiryDate (MyDate date) {
//        return InsurancePolicy.filterByExpiryDate(policies, date);
//    }
    HashMap<Integer, InsurancePolicy> filterByExpiryDate (MyDate date) {
        return InsurancePolicy.filterByExpiryDate(policies, date);
    }

    //Advance
    //remove the policy with the given ID
    public boolean removePolicy(int policyID) {
        InsurancePolicy findPolicy = findPolicy(policyID);
        if (findPolicy != null)
        {
            policies.remove(findPolicy);
            return true;
        }
        return false;
    }
    public ArrayList<String> populateDistinctCarModels(){
        ArrayList<String> populateDistinctCarModels = new ArrayList<>();
        for (InsurancePolicy plc: policies.values()){
            String carModel = plc.getCar().getModel();
            if(!populateDistinctCarModels.contains(carModel)){
                populateDistinctCarModels.add(carModel);
            }
        }
        return populateDistinctCarModels;
    }
    public int getTotalCountForCarModel(String carModel){
        int totalCountOfPolicies = 0;
        for(InsurancePolicy plc: policies.values()){
            if(plc.getCar().getModel().equals(carModel)){
                totalCountOfPolicies ++;
            }
        }
        return totalCountOfPolicies;
    }
    public double getTotalPaymentForCarModel(String carModel, double flatRate){
        double total = 0;
        for(InsurancePolicy plc: policies.values()){
            if(plc.getCar().getModel().equals(carModel)){
                total += plc.calcPayment(flatRate);
            }
        }
        return total;
    }
//    public ArrayList<Integer> getTotalCountPerCarModel (ArrayList<String> carModels){
//        ArrayList<Integer> getTotalCountPerCarModel = new ArrayList<>();
//        for(String model :carModels){
//            getTotalCountPerCarModel.add(getTotalCountForCarModel(model));
//        }
//        return getTotalCountPerCarModel;
//    }
//    public ArrayList<Double> getTotalPaymentPerCarModel (ArrayList<String> carModels, double flatRate){
//        ArrayList<Double> getTotalPaymentPerCarModel = new ArrayList<>();
//        for(String model: carModels){
//            getTotalPaymentPerCarModel.add(getTotalPaymentForCarModel(model, flatRate));
//        }
//        return getTotalPaymentPerCarModel;
//    }
    public HashMap<String, Integer> getTotalCountPerCarModel() {
        HashMap<String, Integer> getTotalCountPerCarModel = new HashMap<>();
        for(String model: populateDistinctCarModels()){
            getTotalCountPerCarModel.put(model,getTotalCountForCarModel(model));
        }
        return getTotalCountPerCarModel;
    }
    public HashMap<String, Double> getTotalPaymentPerCarModel() {
        HashMap<String, Double> getTotalPaymentPerCarModel = new HashMap<>();
        for(String model: populateDistinctCarModels()){
            getTotalPaymentPerCarModel.put(model, getTotalPaymentForCarModel(model, 100.0));
        }
        return getTotalPaymentPerCarModel;
    }
    public void reportPaymentsPerCarModel (double flatRate) {
//        ArrayList<String> carModels = populateDistinctCarModels();
//        ArrayList<Integer> counts = getTotalCountPerCarModel(carModels);
        HashMap<String, Integer> counts = getTotalCountPerCarModel();
//        ArrayList<Double> premiumPayments = getTotalPaymentPerCarModel(carModels, flatRate);
        HashMap<String, Double> premiumPayments = getTotalPaymentPerCarModel();
        System.out.printf("%1$-20s%2$-20s%3$-20s","Car Model","Total Premium","Average Premium");
//        for (int i = 0; i < counts.size(); i++) {
//            System.out.printf("\n%1$-20s%2$-20s%3$-20s", carModels.get(i), premiumPayments.get(i), premiumPayments.get(i) / (double) counts.get(i));
//        }
        for(String i: premiumPayments.keySet()){
            System.out.printf("\n%1$-20s%2$-20s%3$-20s", i, premiumPayments.get(i), premiumPayments.get(i)/ (double)counts.get(i));
        }
    }
    public void reportPaymentsPerCarModelLabda(int flatRate) {
        Map<String,Long> groupByCarModelCount =
            policies.values().stream().collect(Collectors.groupingBy(policy -> policy.getCar().getModel(),Collectors.counting()));
        Map<String,Double> groupByCarModelAverage =
            policies.values().stream().collect(Collectors.groupingBy(policy -> policy.getCar().getModel(),Collectors.averagingDouble(policy -> policy.calcPayment(flatRate))));
        Map<String,Double> groupByCarModelPayment =
            policies.values().stream().collect(Collectors.groupingBy(policy -> policy.getCar().getModel(),Collectors.summingDouble(policy -> policy.calcPayment(flatRate))));
        System.out.printf("%-50s%50s%50s\n", "Car Model", "Total Premium Payment","Average Premium Payment");
        
        //option 1
//        for (String carModel : groupByCarModelCount.keySet()) {
//            System.out.printf("%-50s%,50.2f%,50.2f\n", carModel, groupByCarModelPayment.get(carModel), groupByCarModelPayment.get(carModel) / groupByCarModelCount.get(carModel));
//        }
        
        //option 2
        for (String carModel : groupByCarModelAverage.keySet()) {
            System.out.printf("%-50s%,50.2f%,50.2f\n", carModel, groupByCarModelPayment.get(carModel), groupByCarModelAverage.get(carModel));
        }
    }
//    public static ArrayList< User>  shallowCopy(ArrayList< User> users){
//        ArrayList<User> users1 = new ArrayList<>();
//        for (User user: users){
//            users1.add(user);
//        }
//        return users1;
//    }
    public static ArrayList<User> shallowCopy(ArrayList<User> users){
        return (ArrayList<User>) users.stream().collect(Collectors.toList());
    }

    public static HashMap<Integer, User>  shallowCopyHashMap(HashMap<Integer, User> users){
        HashMap<Integer, User> users1 = new HashMap<>();
        for (Integer usID: users.keySet()){
            User user= users.get(usID);
            users1.put(usID, user);
        }
        return users1;
    }
//    public static ArrayList< User>  deepCopy(ArrayList< User> users) throws CloneNotSupportedException {
//        ArrayList<User> users1 = new ArrayList<>();
//        for (User user: users){
//            users1.add(user.clone());
//        }
//        return users1;
//    }
    public static ArrayList<User> deepCopy(ArrayList<User> users) throws CloneNotSupportedException{
        return (ArrayList<User>) users.stream().map(user -> new User(user))
                .collect(Collectors.toList());
    }
    public static HashMap<Integer, User>  deepCopyHashMap(HashMap<Integer, User> users) throws CloneNotSupportedException {
        HashMap<Integer, User> users1 = new HashMap<>();
        for (Integer usID: users.keySet()){
            User user= users.get(usID);
            users1.put(usID, user.clone());
        }
        return users1;
    }
    public ArrayList< InsurancePolicy>  deepCopyPolicies() throws CloneNotSupportedException{
        return InsurancePolicy.deepCopy(policies);
    }
    public ArrayList< InsurancePolicy>  shallowCopyPolicies (){
        return InsurancePolicy.shallowCopy(policies);
    }
    public HashMap<Integer, InsurancePolicy>  deepCopyPoliciesHashMap() throws CloneNotSupportedException{
        return InsurancePolicy.deepCopyHashMap(policies);
    }
    public HashMap<Integer, InsurancePolicy>  shallowCopyPoliciesHashMap(){
        return InsurancePolicy.shallowCopyHashMap(policies);
    }


    //implement comparable interface
    @Override
    public int compareTo(User otherUser) {
        return address.compareTo(otherUser.address);
    }
//    public int compareTo1(User otherUser){
//        double calcTotalPaymentForOtherUser = otherUser.calcTotalPremiums(20);
//        double calcTotalPaymentForUser = calcTotalPremiums(20);
//        if(calcTotalPaymentForUser > calcTotalPaymentForOtherUser){
//            return 1;
//        }
//        else if(calcTotalPaymentForUser < calcTotalPaymentForOtherUser){
//            return -1;
//        }
//        else {
//            return 0;
//        }
//    }

    //sort the policie by date
//    public ArrayList< InsurancePolicy> sortPoliciesByDate(MyDate date1){
//        ArrayList<InsurancePolicy> sortPoliciesByDate = new ArrayList<>();
//        for(InsurancePolicy plc: policies){
//            int check = plc.getExpiryDate().compareTo(date1);
//            if (check == 0 || check == -1)
//                sortPoliciesByDate.add(plc);
//        }
//        Collections.sort(sortPoliciesByDate);
//        return sortPoliciesByDate;
//    }
    public ArrayList< InsurancePolicy> sortPoliciesByDate(MyDate date1){
        ArrayList<InsurancePolicy> sortPoliciesByDate = new ArrayList<>();
        ArrayList<InsurancePolicy> PoliciesList = new ArrayList<>();
        HashMap<Integer, InsurancePolicy> shallowCopyPolicy = shallowCopyPoliciesHashMap();

        for(InsurancePolicy plc: shallowCopyPoliciesHashMap().values()){
            PoliciesList.add(plc);
        }

        for(InsurancePolicy plc: PoliciesList){
            int check = plc.getExpiryDate().compareTo(date1);
            if (check == 0 || check == -1)
                sortPoliciesByDate.add(plc);
        }
        Collections.sort(sortPoliciesByDate);
        return sortPoliciesByDate;
    }
    static HashMap<Integer, User> loadUser (String fileName) throws IOException {
        HashMap<Integer, User> loadUser = new HashMap<>();
        ObjectInputStream inputst=null;
        loadUser.clear ();
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
                User user = (User) inputst.readObject();
                loadUser.put(user.getUserID(), user);
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
        return loadUser;
    }
    static Boolean saveUser (HashMap<Integer, User> loadUser, String fileName){

        ObjectOutputStream outputst = null;

        try
        {
            outputst = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)));
        }
        catch(IOException ex)
        {
            System.err.println("error in create/open the file ");
            System.exit(1);
        }
        try
        {
            for (User user : loadUser.values())
            {
                outputst.writeObject(user);
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
    public String toDelimitedString() {
        String poli = "Name: "+name+", UserID: "+userID+", Address: "+address.toString()+"\n";
        for (Integer polID: policies.keySet())
        {
            InsurancePolicy pol = policies.get(polID);
            poli += pol.toString()+"\n";
        }
        poli += "\n";
        return poli;
    }

    public static HashMap<Integer, User> loadTextFile (String fileName) throws IOException {
        HashMap<Integer, User> users = new HashMap<>();
        users.clear();

        BufferedReader in = new BufferedReader(new FileReader(fileName));
        String line = in.readLine();
        while (line != null) {
            line = line.trim();
            String[] field = line.split(",");
            // User
            String name = field[1];
            int userID = Integer.parseInt(field[2]);
            int streetNumber = Integer.parseInt(field[3]);
            String street = field[4];
            String suburb = field[5];
            String city = field[6];
            int numOfPolicies = Integer.parseInt(field[7]);
            //Create object of user
            Address add1 = new Address(streetNumber, street, suburb, city);
            User user1 = new User(name, userID, add1);
            //HashMap contains user policies
            HashMap<Integer, InsurancePolicy> userPolicies = new HashMap<>();
            if (numOfPolicies > 0) {
                for(int i = 0; i < numOfPolicies; i++) {
                    int fieldPosition = 0;
                    String policyType = field[8+fieldPosition];
                    switch (field[0]) {
                        case "TPP":
                            //case ThirdPartyPolicy
                            String policyHolderName = field[9+i*12];
                            int id = Integer.parseInt(field[10+i*12]);
                            String model = field[11+i*12];
                            String typeString = field[12+i*12];
                            int ManufacturingYear = Integer.parseInt(field[13+i*12]);
                            double price = Double.parseDouble(field[14+i*12]);
                            int numberOfClaims = Integer.parseInt(field[15+i*12]);
                            int day = Integer.parseInt(field[16+i*12]);
                            int month = Integer.parseInt(field[17+i*12]);
                            int year = Integer.parseInt(field[18+i*12]);
                            String comments = field[19+i*12];

                            CarType type = null;
                            switch (typeString) {
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
                            userPolicies.put(TPpolicy1.getId(), TPpolicy1);
                            fieldPosition += 12;
                            break;

                        case "CP":
                            policyHolderName = field[9+i*13];
                            id = Integer.parseInt(field[10+i*13]);
                            model = field[11+i*13];
                            typeString = field[12+i*13];
                            ManufacturingYear = Integer.parseInt(field[13+i*13]);
                            price = Double.parseDouble(field[14+i*13]);
                            numberOfClaims = Integer.parseInt(field[15+i*13]);
                            day = Integer.parseInt(field[16+i*13]);
                            month = Integer.parseInt(field[17+i*13]);
                            year = Integer.parseInt(field[18+i*13]);
                            int driverAge = Integer.parseInt(field[19+i*13]);
                            int level = Integer.parseInt(field[20+i*13]);

                            type = null;
                            switch (typeString) {
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
                            //Add the policy to the list of user's policies
                            userPolicies.put(Cpolicy2.getId(), Cpolicy2);
                            fieldPosition += 13;
                            break;
                    }
                }
            }
                user1.policies = userPolicies;
                users.put(userID, user1);
                line = in.readLine();
            }
            in.close();

            return users;
    }
    public static Boolean saveTextFile (HashMap<Integer, User> users, String fileName) throws IOException {
        BufferedWriter out = new BufferedWriter (new FileWriter (fileName));
        for (User user : users.values())
        {
            out.write (user.toDelimitedString() + "\n");
        }
        out.close ();

        return true;
    }

    //Assignment 2 add more
    static ArrayList< User>  shallowCopy (HashMap < Integer, User > users){
        ArrayList<User> users1 = new ArrayList<>();
        for (User user: users.values()){
            users1.add(user);
        }
        return users1;
    }

    static ArrayList< User>  deepCopy (HashMap < Integer, User > users) throws CloneNotSupportedException {
        ArrayList<User> users1 = new ArrayList<>();
        for (User user: users.values()){
            users1.add(user.getUserID(), user.clone());
        }
        return users1;
    }
    // Assignment 2
//    public int policiesCountInRange(double lower,double higher)
//    {
//        int count=0;
//        for( InsurancePolicy plc: policies.values())
//        {
//            if((plc.calcPayment(20)>=lower)&&(plc.calcPayment(20)<higher))
//                count++;
//        }
//        return count;
//    }
    public int policiesCountInRange(double lower, double higher, double flatRate)
    {
        int count=0;
        for(InsurancePolicy p:policies.values())
        {
            double premiumPayment = p.calcPayment(flatRate);
            if((premiumPayment > lower) && (premiumPayment <= higher))
                count++;
        }
        return count;    
    }

//    int[] policyCount(String userName, String password, int[] ranges){
//
//        int[] policyCount = new int[2];
//        if(userValidate(userName, password)){
//            for (int i=0;i<ranges.length-1;i++)
//            {
//                int count= policiesCountInRange(ranges[i],ranges[i+1]);
//                policyCount[i] = count;
//            }
//        }
//        return policyCount;
//    }
    
    public int policiesCarModelCountInRange(double lower,double higher, String carModel)
    {
        int count=0;
            for(InsurancePolicy plc: getPolicies().values()){
                if (plc.getCar().getModel().equals(carModel)){
                    if ((plc.calcPayment(20) >= lower) && (plc.calcPayment(20) < higher)) {
                        count++;
                    }
                }
            }
        return count;
    }
//    HashMap <String, int[]> policyCarModelCount (String userName, String password, int [] ranges){
//        HashMap<String, int[]> policyCarModelCount = new HashMap<>();
//        int[] plcCarModelCount = new int[ranges.length-1];
//        if(userValidate(userName, password)) {
//            for (String carModel : populateDistinctCarModels()) {
//                for (int i = 0; i < ranges.length - 1; i++) {
//                    int count = policiesCarModelCountInRange(ranges[i], ranges[i+1], carModel);
//                    plcCarModelCount[i] = count;
//                    policyCarModelCount.put(carModel, plcCarModelCount);
//
//                }
//            }
//        }
//        return policyCarModelCount;
//    }
    public HashMap <String, Integer []> policyCarModelCount (String username, String password, int [] ranges, double flatRate) {
        HashMap<String, Integer []> hash = new HashMap<String, Integer []>();
        if (!userValidate(username, password)) {
            return hash;
        }
        ArrayList<String> arrayCarModel = populateDistinctCarModels();
        for (String carModel : arrayCarModel) {
            Integer[] array = new Integer[ranges.length - 1];
            for (int i=0;i<array.length;i++) {
                array[i] = 0;
            }
            for (int i=0;i<ranges.length-1;i++) {
                int count = 0;
                for (InsurancePolicy p : policies.values()) {
                    if (carModel.equals(p.getCar().getModel())) {
                        double payment = p.calcPayment(flatRate);
                        if (payment > ranges[i] && payment <=  ranges[i+1]) {
                            count++;
                        }
                    }
                }
                array[i] = count;
            }
            hash.put(carModel, array);
        }

        return hash;
    }

    public int[] policyCount ( String _username, String _password, int [] ranges, double flatRate) {
        if (!userValidate(_username, _password)) {
            return new int[] {};
        }
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i=0;i<ranges.length-1;i++)
        {
            arrayList.add(policiesCountInRange(ranges[i], ranges[i+1], flatRate));
        }
        return arrayList.stream().mapToInt(i->i).toArray();
    }
}

