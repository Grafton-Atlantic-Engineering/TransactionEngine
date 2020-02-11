package transactions;

import java.util.Map;
import java.util.UUID;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Person {
    private String AccountName, Company,FirstName,LastName,Address_1,Address_2,City,State,Zip,TransactionID;

    public Person(String AccountName, String Company, String FirstName, String LastName, String Address_1, String Address_2, String City, String State, String Zip) throws NoSuchAlgorithmException {
        this.AccountName = AccountName;
        this.Company = Company;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Address_1 = Address_1;
        this.Address_2 = Address_2;
        this.City = City;
        this.State = State;
        this.Zip = Zip;
        this.TransactionID = generateId();
    }

    public Person(String[] paramList) {
        this.AccountName = paramList[0];
        this.Company = paramList[1];
        this.FirstName = paramList[2];
        this.LastName = paramList[3];
        this.Address_1 = paramList[4];
        this.Address_2 = paramList[5];
        this.City = paramList[6];
        this.State = paramList[7];
        this.Zip = paramList[8];
        this.TransactionID = generateId();
    }

    public Person(Map<String, String> props) {
        this.AccountName = props.getOrDefault("Account", "");
        this.Company = props.getOrDefault("Company", "");
        this.FirstName = props.getOrDefault("FirstName", "");
        this.LastName = props.getOrDefault("LastName", "");
        this.Address_1 = props.getOrDefault("Address_1", "");
    }

    public String getAccountName(){
        return AccountName;
    }

    public void setAccountName(String accountName){
        AccountName = accountName;
    }

    public String getCompany(){
        return Company;
    }

    public void setCompany(String company){
        Company = company;
    }

    public String getFirstName(){
        return FirstName;
    }

    public void setFirstName(String firstName){
        FirstName = firstName;
    }

    public String getLastName(){
        return LastName;
    }

    public void setLastName(String lastName){
        LastName = lastName;
    }

    public String getAddress_1(){
        return Address_1;
    }

    public void setAddress_1(String address_1){
        Address_1 = address_1;
    }

    public String getAddress_2(){
        return Address_2;
    }

    public void setAddress_2(String address2){
        Address_2 = address2;
    }

    public String getCity(){
        return City;
    }

    public void setCity(String city){
        City = city;
    }

    public String getState(){
        return State;
    }

    public void setState(String state){
        State = state;
    }

    public String getZip(){
        return Zip;
    }

    public void setZip(String zip){
        Zip = zip;
    }

    // creates txid by hashing attributes with sha1
    private String generateId() {
        UUID uuid = UUID.randomUUID();
        String txid = null;
        try {
            txid = sha1(String.join("",
                    this.AccountName, this.Company, this.FirstName, this.LastName,
                    this.Address_1, this.Address_2, this.City, this.State, this.Zip,
                    uuid.toString()
            ));
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
        return txid.substring(0, 24);
    }

    public String toString(){
        return(
                "Account: " + AccountName + "\n" +
                        "Company: " + Company + "\n" +
                        "First Name: " + FirstName + "\n" +
                        "Last Name: " + LastName + "\n" +
                        "Address 1: " + Address_1 + "\n" +
                        "Address 2: " + Address_2 + "\n" +
                        "City: " + City + "\n" +
                        "State: " + State + "\n" +
                        "Zip: " + Zip + "\n" +
                        "TransactionID: " + TransactionID + "\n"
        );
    }

    private static String sha1(String input) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA1");
        byte[] byteDigest = digest.digest(input.getBytes());
        StringBuffer buffer = new StringBuffer();
        for (byte b : byteDigest) {
            buffer.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
        }
        return buffer.toString();
    }
}

