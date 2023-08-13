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
import com.mycompany.lab7_121.User;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;
import java.util.stream.Collectors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class  InsuranceCompany implements Cloneable, Serializable {
    String name;
//    private ArrayList<User> users;
    private HashMap<Integer, User> users;
    private HashMap <Integer, InsurancePolicy> policies;
    private String adminUsername;
    private String adminPassword;
    private int flatRate;
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    InsuranceCompany() {
        this.users = new HashMap<>();
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setUsers(HashMap users){this.users = users;}
    public HashMap<Integer, User> getUsers() {return users;}
    public InsuranceCompany(String name, String adminUsername, String adminPassword, int flatRate) {
        this.name = name;
        this.users = new HashMap<>();
        this.adminUsername = adminUsername;
        this.adminPassword = adminPassword;
        this.flatRate = flatRate;
    }
    //copy constructor
    public InsuranceCompany(InsuranceCompany another){
        this(another.name, another.adminUsername, another.adminPassword, another.flatRate);
    }
    @Override
    public InsuranceCompany clone () throws CloneNotSupportedException {
        return (InsuranceCompany) super.clone();
    }
    boolean validateAdmin(String username, String password){
        if (this.adminUsername.equals(username) && this.adminPassword.equals(password))
            return true;
        else
            return false;
    }
    public User validateUser(String userName, String userPassword){
        for(User user: users.values()){
            if(user != null && user.userValidate(userName, userPassword)){
                return user;
            }
        }
        return null;
    }
//    boolean addUser(User user){
//        if (findUser(user.getUserID()) == null) {
//            users.add(user);
//            return true;
//        }
//        else
//            return false;
//    }

//    boolean addUser(String name, int userID, Address address){
//        User user1 = new User(name, userID, address);
//        if (findUser(user1.getUserID()) == null){
//            users.add(user1);
//            return true;
//        }
//        else
//            return false;
//    }
    boolean addUser(User user){
        if (findUser(user.getUserID()) == null) {
            users.put(user.getUserID(), user);
            return true;
        }
        else
            return false;
    }
    boolean addUser(String name, int userID, Address address){
        User user1 = new User(name, userID, address);
        if (findUser(user1.getUserID()) == null){
            users.put(user1.getUserID(), user1);
            return true;
        }
        else
            return false;
    }
    // add User new version assignment2
    public boolean addUser(String name, Address address, String userName, String password) //automatic ID generation
    {
        User user = new User(name, address, password); // user constructor to generate ID automatically

        return addUser(user);
    }

//    public User findUser(int userID){
//        for (User user: users)
//        {
//            if (user.getUserID() == userID)
//                return user;
//        }
//        return null;
//    }
    public User findUser(int userID){
        for (Integer usID: users.keySet())
        {
            if (usID == userID)
                return users.get(userID);
        }
        return null;
    }
    boolean addPolicy(int userID, InsurancePolicy policy){
        User user2 = findUser(userID);
        if (user2 == null){
            return false;
        }
        else {
            InsurancePolicy check = user2.findPolicy(policy.getId());
            if (check == null)
            {
                user2.addPolicy(policy);
                return true;
            }
        }
        return false;
    }
    boolean addPolicy(String adminUsername, String adminPassword, int userID, InsurancePolicy policy){
        if(validateAdmin(adminUsername, adminPassword)){
            User user2 = findUser(userID);
            if (user2 == null){
                return false;
            }
            else {
                InsurancePolicy check = user2.findPolicy(policy.getId());
                if (check == null)
                {
                    user2.addPolicy(user2.getName(), user2.getPassword(), policy);
                    return true;
                }
            }
            return false;
        }
        else
            return false;
    }
//    InsurancePolicy findPolicy(int userID, int policyID){
//        for (User user: users){
//            if(user.getUserID() == userID)
//                return user.findPolicy(policyID);
//        }
//        return null;
//    }
    InsurancePolicy findPolicy(int userID, int policyID){
        for (Integer usID: users.keySet()){
            if(usID == userID){
                User user = users.get(usID);
                return user.findPolicy(policyID);
            }
        }
        return null;
    }
    void printPolicies(int userID){
        for(User user : users.values()){
            if(user.getUserID() ==  userID){
                user.print();
            }
        }
    }
    void print(){
        for(User user: users.values()){
            System.out.println(users);
            user.printPolicies(flatRate);
        }
    }
    public String toString() {
        String user="";
        for(User user1: users.values()){
            user += user1.toString();
        }
        return user;
    }
    boolean createThirdPartyPolicy(int userID, String policyHolderName, int id, Car car, int numberOfClaims, MyDate expiryDate, String comments){
        User user = findUser(userID);
        if (user != null){
            InsurancePolicy plc = user.findPolicy(id);
            if(plc == null && plc == null){
                user.createThirdPartyPolicy(policyHolderName, id, car, numberOfClaims, expiryDate, comments);
                return true;
            }
        }
        return false;
    }
    boolean createComprehensivePolicy( int userID, String policyHolderName, int id, Car car, int numberOfClaims, MyDate expiryDate, int driverAge, int level ){
        User user = findUser(userID);
        InsurancePolicy policyCheck = findPolicy(userID, id);
//        System.out.println(policyCheck);
        if (user != null && policyCheck == null){
            user.createComprehensivePolicy(policyHolderName, id, car, numberOfClaims, expiryDate, driverAge, level);
            return true;
        }
        return false;
    }
    double calcTotalPayments(int userID){
        for(User user: users.values()){
            if(user.getUserID() == userID)
                return user.calcTotalPremiums(flatRate);
        }
        return 0;
    }
    double calcTotalPayments(){
        double total =0;
        for(User user: users.values()){
            total += user.calcTotalPremiums(flatRate);
        }
        return total;
    }
    //Assignment 2
    double calcTotalPayments(String adminUsername, String adminPassword, int userID) {
        if(validateAdmin(adminUsername, adminPassword)){
            for(User user: users.values()){
                if(user.getUserID() == userID){
                    return user.calcTotalPremiums(flatRate);
                }
            }
            return 0;
        }
        else
            return 0;
    }
    boolean carPriceRise (int userID, double risePercent){
        User user = findUser(userID);
        if(user != null){
            user.carPriceRiseAll(risePercent);
            return true;
        }
        return false;
    }
    void carPriceRise(double risePercent){
        for(User user: users.values()){
            user.carPriceRiseAll(risePercent);
        }
    }

    public HashMap<Integer, InsurancePolicy> allPolicies (){
        HashMap<Integer, InsurancePolicy> allPolicies = new HashMap<>();
            for(User user: users.values()) {
                for (InsurancePolicy plc: user.getPolicies().values()){
                    if(!allPolicies.containsKey(plc.getId()))
                    {
                        allPolicies.put(plc.getId(), plc);
                    }
                }
            }
        return allPolicies;
    }
//    public ArrayList<InsurancePolicy> filterByCarModel (int userID, String carModel){
//        ArrayList<InsurancePolicy> filterByCarModel = new ArrayList<>();
//        User user = findUser(userID);
//        if(user != null) {
//            filterByCarModel = user.filterByCarModel(carModel);
//        }
//        return filterByCarModel;
//    }
//    public ArrayList<InsurancePolicy> filterByExpiryDate (int userID, MyDate date){
//        ArrayList<InsurancePolicy> filterByExpiryDate = new ArrayList<>();
//        User user = findUser(userID);
//        if(user != null){
//            filterByExpiryDate = user.filterByExpiryDate(date);
//        }
//        return filterByExpiryDate;
//    }
//    public ArrayList<InsurancePolicy> filterByCarModel (String carModel){
//        ArrayList<InsurancePolicy> filterByCarModel = new ArrayList<>();
//        for(User user: users){
//            ArrayList <InsurancePolicy> policyByCarModel = user.filterByCarModel(carModel);
//            for(InsurancePolicy plc: policyByCarModel) {
//                filterByCarModel.add(plc);
//            }
//        }
//        return filterByCarModel;
//    }
//    public ArrayList<InsurancePolicy> filterByExpiryDate (MyDate date){
//        ArrayList<InsurancePolicy> filterByExpiryDate = new ArrayList<>();
//        for(User user: users.values()){
//            ArrayList <InsurancePolicy> policyByExpiryDate = user.filterByExpiryDate(date).values();
//            for(InsurancePolicy plc: policyByExpiryDate) {
//                filterByExpiryDate.add(plc);
//            }
//        }
//        return filterByExpiryDate;
//    }
public HashMap<Integer, InsurancePolicy> filterByCarModel (int userID, String carModel){
    HashMap<Integer, InsurancePolicy> filterByCarModel = new HashMap<>();
    User user = findUser(userID);
    if(user != null) {
        filterByCarModel = user.filterByCarModel(carModel);
    }
    return filterByCarModel;
}
    public HashMap<Integer, InsurancePolicy> filterByExpiryDate (int userID, MyDate date){
        HashMap<Integer, InsurancePolicy> filterByExpiryDate = new HashMap<>();
        User user = findUser(userID);
        if(user != null){
            filterByExpiryDate = user.filterByExpiryDate(date);
        }
        return filterByExpiryDate;
    }
    public HashMap<Integer, InsurancePolicy> filterByCarModel (String carModel){
        HashMap<Integer, InsurancePolicy> filterByCarModel = new HashMap<>();
        for(User user: users.values()){
            HashMap <Integer, InsurancePolicy> policyByCarModel = user.filterByCarModel(carModel);
            for(InsurancePolicy plc: policyByCarModel.values()) {
                filterByCarModel.put(plc.getId(), plc);
            }
        }
        return filterByCarModel;
    }
    public HashMap<Integer, InsurancePolicy> filterByExpiryDate (MyDate date){
        HashMap<Integer, InsurancePolicy> filterByExpiryDate = new HashMap();
        for(User user: users.values()){
            for (InsurancePolicy plc : user.filterByExpiryDate(date).values()) {
                filterByExpiryDate.put(plc.getId(), plc);
            }
        }
        return filterByExpiryDate;
    }
    // Assignment 1
    //remove the user with the given ID
    public boolean removeUserById(int userID) {
        User findUser = findUser(userID);
        if (findUser != null)
        {
            users.remove(findUser);
            return true;
        }
        return false;
    }

    public boolean removePolicyForUser(int userId, int policyId)
    {
        User findUser = findUser(userId);
        if (findUser != null)
        {
            InsurancePolicy findPolicy = findUser.findPolicy(policyId);
            if (findPolicy != null)
            {
                findUser.getPolicies().remove(findPolicy);
                return true;
            }
            return false;
        }
        return false;
    }
    public ArrayList<String> populateDistinctCityNames(){
        ArrayList<String> populateDistinctCityNames = new ArrayList<>();
        for(User user: users.values()) {
            String city = user.getAddress().getCity();
            if (!populateDistinctCityNames.contains(city))
            {
                populateDistinctCityNames.add(city);
            }
        }
        return populateDistinctCityNames;
    }
    public double getTotalPaymentForCity(String city){

        double total = 0;
        for(User user: users.values()){
            if(user.getAddress().getCity().equals(city)){
                total += user.calcTotalPremiums(flatRate);
            }
        }
        return total;
    }
    public ArrayList<Double> getTotalPaymentPerCity(ArrayList<String> cities){
        ArrayList<Double> getTotalPaymentPerCity = new ArrayList<>();
        for (String city: cities){
            getTotalPaymentPerCity.add(getTotalPaymentForCity(city));
        }
        return getTotalPaymentPerCity;
    }
    public HashMap<String, Double> getTotalPaymentPerCity(){
        HashMap<String, Double> getTotalPaymentPerCity = new HashMap<>();
        for(String city: populateDistinctCityNames()){
            getTotalPaymentPerCity.put(city, getTotalPaymentForCity(city));
        }
        return getTotalPaymentPerCity;
    }
    public void reportPaymentPerCity(ArrayList<String> cities, ArrayList<Double> payments){
        System.out.printf("%1$-20s%2$-20s\n", "City Name", "Total Premium Payment");
        for(int i = 0; i < cities.size(); i++){
            System.out.printf("%1$-20s%2$-20s\n", cities.get(i), payments.get(i));
        }
    }
    public void reportPaymentPerCity(){
        ArrayList<String> cities = populateDistinctCityNames();
        ArrayList<Double> payments = getTotalPaymentPerCity(cities);
        System.out.printf("\n%1$-20s%2$-20s\n", "City Name", "Total Premium Payment");
        for(int i = 0; i < cities.size(); i++)
        {
            System.out.printf("%1$-20s%2$-20s\n", cities.get(i), payments.get(i));
        }
    }
    public ArrayList<String> populateDistinctCarModels()
    {
        ArrayList<String> allModels =new ArrayList<String>();
        for (User user: users.values())
        {
            ArrayList<String> userModels =user.populateDistinctCarModels();
            for (String userModel:userModels)
            {
                if (!allModels.contains(userModel))
                    allModels.add(userModel);
            }
        }
        return allModels;
    }

    public boolean changePassword (String oldPass, String newPass)
    {
        if (adminPassword.equals(oldPass)) {
            adminPassword = newPass;
            return true;
        }
        return false;
    }
    public ArrayList<Integer> getTotalCountForCarModel(ArrayList<String> carModels) {
        ArrayList<Integer> getTotalCountForCarModel = new ArrayList<>();
        for (String carModel: carModels)
        {
            int count =0;
            for (User user: users.values())
            {
                count += user.getTotalCountForCarModel(carModel);
            }
            getTotalCountForCarModel.add(count);
        }
        return getTotalCountForCarModel;
    }
    public HashMap<String, Integer> getTotalCountPerCarModel(){
        HashMap<String, Integer> getTotalCountPerCarModel = new HashMap<>(); //for insuranceCompany
        for (User user : users.values()) {
            HashMap<String, Integer> userCarModels = user.getTotalCountPerCarModel(); //for each user
            for (String modelName : userCarModels.keySet()) {
                if (getTotalCountPerCarModel.get(modelName) == null) {
                    getTotalCountPerCarModel.put(modelName, userCarModels.get(modelName)); //add key and value into allCarModels
                } else {
                    getTotalCountPerCarModel.put(modelName, getTotalCountPerCarModel.get(modelName) + userCarModels.get(modelName)); //add
                }
            }
        }
        return getTotalCountPerCarModel;
    }

    public ArrayList<Double> getTotalPaymentPerCarModel(ArrayList<String> carModels){
        ArrayList<Double> getTotalPaymentPerCarModel = new ArrayList<>();
        for (String carModel: carModels)
        {
            for (User user: users.values())
            {   
                double payment = user.calcTotalPremiums(10);
                getTotalPaymentPerCarModel.add(payment);
              }

        }
        return getTotalPaymentPerCarModel;
    }
    public HashMap<String, Double> getTotalPremiumPerCarModel(){
        HashMap<String, Double> getTotalPremiumPerCarModel = new HashMap<>(); //for insuranceCompany
        for (User user : users.values()) {
            HashMap<String, Double> userCarPremiums = user.getTotalPaymentPerCarModel(); //for each user
            for (String model : userCarPremiums.keySet()) {
                if (getTotalPremiumPerCarModel.get(model) == null) {
                    getTotalPremiumPerCarModel.put(model, userCarPremiums.get(model)); //add key and value into allCarModels
                } else {
                    getTotalPremiumPerCarModel.put(model, userCarPremiums.get(model) + userCarPremiums.get(model)); //add
                }
            }
        }
        return getTotalPremiumPerCarModel;
    }

    public void reportPaymentsPerCarModel ()
    {
        ArrayList<String> carModels = populateDistinctCarModels();
        ArrayList<Integer>counts = getTotalCountForCarModel(carModels);
        ArrayList<Double> premiumPayments = getTotalPaymentPerCarModel(carModels);
        System.out.printf("%1$-20s%2$-20s%3$-20s","Car Model","Total Premium","Average Premium");
        for (int i = 0; i < counts.size(); i++) {
//            System.out.printf("%-15s%-30s%-30s%-%n", carModels.get(i), premiumPayments.get(i), premiumPayments.get(i) / (double) counts.get(i));
            System.out.printf("\n%1$-20s%2$-20s%3$-20s", carModels.get(i), "$" + premiumPayments.get(i), "$" + premiumPayments.get(i) / (double) counts.get(i));
        }
    }
    public void reportPaymentsPerCarModelLabda() {
        
        Map<String,Long> groupByCarModelCount =
            allPolicies().values().stream().collect(Collectors.groupingBy(policy -> policy.getCar().getModel(),Collectors.counting()));
        Map<String,Double> groupByCarModelAverage =
            allPolicies().values().stream().collect(Collectors.groupingBy(policy -> policy.getCar().getModel(), Collectors.averagingDouble(policy -> policy.calcPayment(flatRate))));
        Map<String,Double> groupByCarModelPayment =
            allPolicies().values().stream().collect(Collectors.groupingBy(policy -> policy.getCar().getModel(),Collectors.summingDouble(policy -> policy.calcPayment(flatRate))));
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
    
    //implement cloneable interface
    public ArrayList<User>  deepCopyUsers() throws CloneNotSupportedException {
        return User.deepCopy((ArrayList<User>) users.values());
    }
    public ArrayList<User>  shallowCopyUsers(){
        return User.shallowCopy((ArrayList<User>) users.values());
    }
    public HashMap<Integer, User>  deepCopyUsersHashMap() throws CloneNotSupportedException {
        return User.deepCopyHashMap(users);
    }
    public HashMap<Integer, User>  shallowCopyUsersHashMap(){
        return User.shallowCopyHashMap(users);
    }


//    public ArrayList<User> sortUsers(String city){
//        ArrayList<User> sortUsers = new ArrayList<>();
//        for(User user: users){
//            if(user.getAddress().getCity().equals(city)){
//                sortUsers.add(user);
//            }
//        }
//        return sortUsers;
//    }
    public ArrayList<User> sortUsers(String city){
        ArrayList<User> userLists = new ArrayList<>();
        ArrayList<User> sortUsers = new ArrayList<>();
        HashMap<Integer, User> shallowCopyUserHashMap = shallowCopyUsersHashMap();
        for(User user: shallowCopyUserHashMap.values()){
            userLists.add(user);
        }
        for(User user: userLists){
            if(user.getAddress().getCity().equals(city)){
                sortUsers.add(user);
            }
        }
        return sortUsers;
    }
    //Lab 6: load method
    public Boolean load (String fileName) {
        ObjectInputStream inputst = null;

        try {
            inputst = new ObjectInputStream((Files.newInputStream(Paths.get(fileName))));
        } catch (IOException ex) {
            System.err.println("error in create/open the file");
            System.exit(1);
        }

        try {
            InsuranceCompany company = (InsuranceCompany) inputst.readObject();
            this.name = company.name;
            this.adminUsername = company.adminUsername;
            this.adminPassword = company.adminPassword;
            this.flatRate = company.flatRate;
        } catch (EOFException ex) {
            System.out.println("no more companies!");
        } catch (ClassNotFoundException ex) {
            System.out.println("error in wrong class in the file");
        } catch (IOException ex) {
            System.err.println("error in add object to the file");
            System.exit(1);
        }

        try {
            if (inputst != null) {
                inputst.close();
            }
        } catch (IOException ex) {
            System.err.println("error in close the file");
            System.exit(1);
        }

        return true;
    }

    //Lab 6: save method
    public Boolean save(String fileName) {
        ObjectOutputStream outputst = null;

        try {
            outputst = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)));
        } catch (IOException ex) {
            System.err.println("error in create/open the file");
            System.exit(1);
        }

        try {
            outputst.writeObject(this);
        } catch (IOException ex) {
            System.err.println("error in adding the objects to the file");
            System.exit(1);
        }

        try {
            if (outputst != null) {
                outputst.close();
            }
        } catch (IOException ex) {
            System.err.println("error in closing the file");
            System.exit(1);
        }

        return true;
    }
    //lab 6 toDelimitedString
    public String toDelimitedString() {
        String us ="";
        for(User user: users.values()){
            us += user.toDelimitedString();
        }
        return us;
    }
    //lab6
    public Boolean saveTextFile(String fileName) throws IOException {
        BufferedWriter out = new BufferedWriter (new FileWriter(fileName));

        out.write (toDelimitedString() + "\n");
        out.close ();

        return true;
    }
    public Boolean loadTextFile(String fileName) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(fileName));
        String line = in.readLine();
        line = line.trim();
        String[] field = line.split(",");

        String companyName = field[1];
        String adminUsername = field[2];
        String adminPassword = field[3];
        int flatRate  = Integer.parseInt(field[4]);
        int numberOfUsers =  Integer.parseInt(field[5]);

        InsuranceCompany company = new InsuranceCompany(companyName, adminUsername, adminPassword, flatRate);

        line = in.readLine();
        while (line!= null) {
            line = line.trim();
            HashMap<Integer, User> users = User.loadTextFile(fileName);
            line = in.readLine();
        }
        in.close();
        return true;
    }
    public ArrayList<User> sortUsersByPremiums() {
        ArrayList<User> sortUsersByPremiums = new ArrayList<>(users.values());
        sortUserByTotalPayments user = new sortUserByTotalPayments();
        Collections.sort(sortUsersByPremiums, user);
        return sortUsersByPremiums;
    }
    HashMap<String, ArrayList<User>> getUsersPerCity() {
        HashMap<String, ArrayList<User>> getUsersPerCity = new HashMap<>();
        for(String city: populateDistinctCityNames()){
            getUsersPerCity.put(city, sortUsers(city));
        }
        return getUsersPerCity;
    }
//    HashMap <String,ArrayList<InsurancePolicy>> filterPoliciesByExpiryDate (MyDate expiryDate){
//        HashMap<String, ArrayList<InsurancePolicy>> filterPoliciesByExpiryDate = new HashMap<>();
//        for(User user: users.values()) {
//            if (user.get) {
//                String userName = user.getName();
//                filterPoliciesByExpiryDate.put(userName, user.sortPoliciesByDate(expiryDate));
//            }
//        }
//        return filterPoliciesByExpiryDate;
//    }

//    public ArrayList<InsurancePolicy> filterPoliciesByExpiryDateArrayList (MyDate expiryDate){
//        ArrayList<InsurancePolicy> userByExpiryDate = new ArrayList<>();
//        for(User user: users.values()){
//            String userName = user.getName();
//            ArrayList<InsurancePolicy> expiryPolicies = new ArrayList<>();
//            for(InsurancePolicy policy: user.getPolicies().values()){
//                if(policy.getExpiryDate().isExpired(expiryDate)){
//                    expiryPolicies.add(policy);
//                }
//            }
//        }
//        return null;
//    }

    public HashMap <String,ArrayList<InsurancePolicy>> filterPoliciesByExpiryDate (MyDate expiryDate) {
        HashMap <String,ArrayList<InsurancePolicy>> userByExpiryDate = new HashMap<>();
        for (User user : users.values()) {
            String userName = user.getName();
            ArrayList<InsurancePolicy> expiredPolicies = new ArrayList<>();
            for (InsurancePolicy policy : user.getPolicies().values()) {
                if (policy.getExpiryDate().isExpired(expiryDate)) {
                    expiredPolicies.add(policy);
                }
            }
            if (!expiredPolicies.isEmpty()) {
                userByExpiryDate.put(userName, expiredPolicies);
            }
        }
        return userByExpiryDate;
    }
    
    public int policiesCountInRange(double lower,double higher)
    {
        int count=0;

        for (InsurancePolicy plc : allPolicies().values()) {
            if ((plc.calcPayment(20) >= lower) && (plc.calcPayment(20) < higher))
                count++;
        }

        return count;
    }

//    int[] policyCount(String adminUsername, String adminPassword, int[] ranges){
//
//        int[] policyCount = new int[ranges.length-1];
//        if(validateAdmin(adminUsername, adminPassword)){
//            for (int i=0;i<ranges.length-1;i++)
//            {
//                int count= policiesCountInRange(ranges[i],ranges[i+1]);
//                policyCount[i] = count;
//            }
//        }
//        return policyCount;
//    }
    public int[]  policyCount( String _adminUsername, String _adminPassword, int [] ranges) {
        if (!validateAdmin(_adminUsername, _adminPassword)) {
            return new int[] {};
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i=0;i<ranges.length-1;i++)
        {
            int count = 0;
            for (User u : users.values()) {
                count += u.policiesCountInRange(ranges[i], ranges[i+1], flatRate);
            }
            arrayList.add(count);
        }
        return arrayList.stream().mapToInt(i->i).toArray();
    }

//    public int policiesCountCityInRange(double lower,double higher, String city)
//    {
//        int count=0;
//        for(User user: getUsersPerCity().get(city)){
//            for(InsurancePolicy plc: user.getPolicies().values()){
//                if ((plc.calcPayment(20) >= lower) && (plc.calcPayment(20) < higher)) {
//                    count++;
//                }
//            }
//        }
//        return count;
//    }
//    HashMap <String, int[]> policyCityCount(String adminUsername, String adminPassword, int [] ranges){
//        HashMap<String, int[]> policyCityCount = new HashMap<>();
//        int[] plcCityCount = new int[ranges.length-1];
//        if(validateAdmin(adminUsername, adminPassword)) {
//            for (String city : populateDistinctCityNames()) {
//                for (int i = 0; i < ranges.length - 1; i++) {
//                    int count = policiesCountCityInRange(ranges[i], ranges[i+1], city);
//                    plcCityCount[i] = count;
//                    policyCityCount.put(city, plcCityCount);
//                }
//            }
//        }
//        return policyCityCount;
//    }
    public HashMap <String, Integer []> policyCityCount(String _adminUsername, String _adminPassword, int [] ranges) {
        HashMap<String, Integer []> hash = new HashMap<>();
        if (!validateAdmin(_adminUsername, _adminPassword)) {
            return hash;
        }
        ArrayList<String> arrayCities = populateDistinctCityNames();
        for (String city : arrayCities) {
            Integer[] array = new Integer[ranges.length - 1];
            for (int i=0;i<array.length;i++) {
                array[i] = 0;
            }
            for (User u : users.values()) {
                if (u.getCity().equals(city)) {
                    int[] arrayInt = u.policyCount(u.getName(), u.getPassword(), ranges, flatRate);
                    for (int i=0;i<arrayInt.length;i++) {
                        array[i] += arrayInt[i];
                    }
                }
            }
            hash.put(city, array);
        }
        return hash;
    }

//    public int UserCountInRange(double lower,double higher)
//    {
//        int count=0;
//
//        for (User user: users.values()) {
//            count++;
//        }
//
//        return count;
//    }
//    int[] userCount (String adminUsername, String adminPassword, int [] ranges){
//        int[] userCount = new int[ranges.length-1];
//        if(validateAdmin(adminUsername, adminPassword)){
//            for (int i=0;i<ranges.length-1;i++)
//            {
//                int count= UserCountInRange(ranges[i],ranges[+1]);
//                userCount[i] = count;
//            }
//        }
//        return userCount;
//    }
    public int[] userCount (String _adminUsername, String _adminPassword, int [] ranges) {
        if (!validateAdmin(_adminUsername, _adminPassword)) {
            return new int[] {};
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i=0;i<ranges.length-1;i++)
        {
            int count = 0;
            for (User u : users.values()) {
                for(InsurancePolicy p:u.getPolicies().values())
                {
                    double premiumPayment = p.calcPayment(flatRate);
                    if((premiumPayment > ranges[i]) && (premiumPayment <= ranges[i+1])){
                        count++;
                        break;
                    }
                }
//                double premiumPayment = u.calcTotalPremiums(u.getUsername(), u.getPassword(), flatRate);
//                if((premiumPayment >= ranges[i]) && (premiumPayment < ranges[i + 1]))
//                    count++;
            }
            arrayList.add(count);
        }
        return arrayList.stream().mapToInt(i->i).toArray();
    }
//    public int UserCarModelCountInRange(double lower,double higher,String carModel)
//    {
//        int count=0;
//        for(User user: users.values()) {
//            for (InsurancePolicy plc : user.getPolicies().values()) {
//                if(plc.getCar().getModel().equals(carModel)){
//                    count++;
//                }
//            }
//        }
//        return count;
//    }
//    HashMap <String,  int[]> userCarModelCount (String adminUsername, String adminPassword, int [] ranges){
//        HashMap<String, int[]> userCarModelCount = new HashMap<>();
//        int[] usCarModelCount = new int[ranges.length-1];
//        if(validateAdmin(adminUsername, adminPassword)){
//            for(String carModel: populateDistinctCarModels()){
//                for(int i = 0; i < ranges.length - 1; i++){
//                    int count = UserCarModelCountInRange(ranges[i], ranges[i+1], carModel);
//                    usCarModelCount[i] = count;
//                    userCarModelCount.put(carModel, usCarModelCount);
//                }
//            }
//        }
//        return userCarModelCount;
//    }
    public HashMap <String, Integer []> userCarModelCount (String adminUsername, String adminPassword, int [] ranges) {
        HashMap<String, Integer []> hash = new HashMap<>();
        if (!validateAdmin(adminUsername, adminPassword)) {
            return hash;
        }
        ArrayList<String> arrayCarModel = populateDistinctCarModels();
        for (String carModel : arrayCarModel) {
            Integer[] array = new Integer[ranges.length - 1];
            for (int i=0;i<array.length;i++) {
                array[i] = 0;
            }
            for (User u : users.values()) {
                for (int i=0;i<ranges.length-1;i++)
                {
                    for (InsurancePolicy p : u.getPolicies().values()) {
                        if (p.car.getModel().equals(carModel)) {
                            double payment = p.calcPayment(flatRate);
                            if (payment > ranges[i] && payment <= ranges[i+1]) {
                                array[i]++;
                                break;
                            }
                        }
                    }
                }
            }
            hash.put(carModel, array);
        }
        return hash;
    }

//    HashMap <String, int[]> policyCarModelCount (String adminUsername, String adminPassword, int[] ranges){
//        HashMap<String, int[]> policyCarModelCount = new HashMap<>();
//
//        return policyCarModelCount;
//    }
    public HashMap <String, Integer []> policyCarModelCount (String _adminUsername, String _adminPassword, int [] ranges) {
        HashMap<String, Integer []> hash = new HashMap<>();
        if (!validateAdmin(_adminUsername, _adminPassword)) {
            return hash;
        }
        ArrayList<String> arrayCarModel = populateDistinctCarModels();
        for (String carModel : arrayCarModel) {
            Integer[] array = new Integer[ranges.length - 1];
            for (int i=0;i<array.length;i++) {
                array[i] = 0;
            }
            for (User u : users.values()) {
                HashMap <String, Integer []> hashUser = u.policyCarModelCount(u.getName(), u.getPassword(), ranges, flatRate);
                for (String carModelUser : hashUser.keySet()) {
                    if (carModel.equals(carModelUser)) {
                        for (int i=0;i<array.length;i++) {
                            array[i] = array[i] + hashUser.get(carModelUser)[i];
                        }
                    }
                }
            }
            hash.put(carModel, array);
        }
        return hash;
    }
    public void saveDatabase() {
           try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        }
        catch(ClassNotFoundException e) {
            System.out.println("Problem in saving Access ");
            e.printStackTrace();
        }
            try {
                String dataUrl = "jdbc:ucanaccess://CarInsurance.accdb";
                connection = DriverManager.getConnection(dataUrl);
                statement = connection.createStatement();
                statement.executeUpdate("DELETE FROM User");
                statement.executeUpdate("DELETE FROM InsurancePolicy");
                
                for (User user: users.values()) {
                    String query = "INSERT INTO User (Name, userID, Address, password) VALUES('"+user.getName()+"','"+user.getUserID()+"', '"+user.getAddress()+"','"+user.getPassword()+"')";
                    statement = connection.createStatement();
                    statement.executeUpdate(query);
                }             
                for (User user: users.values()) {
                    for (InsurancePolicy policy: policies.values())  {
                        String query = "INSERT INTO InsurancePolicy (userID, policyHolderName, policyID, numberOfClaims) VALUES('"+user.getUserID()+"','"+policy.getPolicyHolderName()+"','"+policy.getId()+"','"+policy.getNumberOfClaims()+"')";
                        statement = connection.createStatement();
                        statement.executeUpdate(query);
                    }   
                }
            }
            catch(SQLException e) {
                e.printStackTrace();
            } finally {
                if (connection !=null) {
                    try { if (resultSet != null) resultSet.close(); } catch (Exception e) {};
                    try { if (statement != null) statement.close(); } catch (Exception e) {};
                    try { if (connection != null) connection.close(); } catch (Exception e) {}
                }
            }
            System.out.println("Data was saved by database!");
        }
        
    public void loadDatabase() {
         try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        }
        catch(ClassNotFoundException e) {
            System.out.println("Problem in loading Access ");
            e.printStackTrace();
        }
         try {
         String dataUrl = "jdbc:ucanaccess://UniversityDatabase.accdb" ;
            connection = DriverManager.getConnection(dataUrl);
            statement = connection.createStatement();
            users.clear();
            policies.clear();
            
            resultSet = statement.executeQuery("SELECT * FROM User");
             while(resultSet.next())
            {
                String name = resultSet.getString(1);
                int userID = resultSet.getInt(2);
                int streetNum = resultSet.getInt(3);
                String street = resultSet.getString(4);
                String suburb = resultSet.getString(5);
                String city = resultSet.getString(6);
                String password = resultSet.getString(7);
                
                Address newAdd = new Address(streetNum, street, suburb, city);
                try 
                {
                    User userNew = new User( name, userID, newAdd, password);
                    this.addUser( userNew);
//                    if(this.addSubject(adminUsername, adminPassword, subject))
//                    {
//                        System.out.println(subject);
//                    } else System.out.println("error") ;
                } catch (Exception ex) 
                {
                    Logger.getLogger(InsuranceCompany.class.getName()).log(Level.SEVERE, null, ex);
                }     
            }
            
//-------------------------------------------------------------------------------------------  
//userID, policyHolderName, policyID, numberOfClaims
            resultSet = statement.executeQuery("SELECT * FROM InsurancePolicy");
             while(resultSet.next())
            {   
                int userID = resultSet.getInt(1);
                String policyHolderName = resultSet.getString(2);
                int policyID = resultSet.getInt(3);
                int numberOfClaims = resultSet.getInt(4);
                try 
                {
                    InsurancePolicy policyData = new InsurancePolicy (policyHolderName, policyID, numberOfClaims) {
                        @Override
                        public String toString() {
                            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                        }

                        @Override
                        public double calcPayment(double flatRate) {
                            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                        }

                        @Override
                        public String toDelimitedString() {
                            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                        }
                        
                    };
                    this.addPolicy( userID,policyData);
                    if(this.addPolicy(userID, policyData))
                    {
                        System.out.println(policyData);
                    } else System.out.println("error") ;
                } catch (Exception ex) 
                {
                    Logger.getLogger(InsuranceCompany.class.getName()).log(Level.SEVERE, null, ex);
                }     
            }

         } catch (SQLException e) {
             e.printStackTrace();
         } 
         if(connection != null) {
             try { if (resultSet != null) resultSet.close(); } catch (Exception e) {};
             try { if (statement != null) statement.close(); } catch (Exception e) {};
             try { if (connection != null) connection.close(); } catch (Exception e) {}
         }
        System.out.println("Data was Loaded from database");
    }    
}
class sortUserByTotalPayments implements Comparator<User> {
    @Override
    public int compare(User user1, User user2) {
        return Integer.compare((int) user1.calcTotalPremiums(20), (int) user2.calcTotalPremiums(20));
    }
    
}

