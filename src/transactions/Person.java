package transactions;

import java.util.UUID;

/**
 * A Person is an abstraction for a bunch of details containing a Person
 */
public class Person {
    private String
            accountNumber,
            company,
            firstName,
            lastName,
            address1,
            address2,
            city,
            state,
            zip,
            transactionId;

    public Person(String accountNumber,
                  String company,
                  String firstName,
                  String lastName,
                  String address1,
                  String address2,
                  String city,
                  String state,
                  String zip
    ) {
        this.accountNumber = accountNumber;
        this.company = company;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.transactionId = generateId();
    }

    public Person(String[] paramList) {
        this.accountNumber = paramList[0];
        this.company = paramList[1];
        this.firstName = paramList[2];
        this.lastName = paramList[3];
        this.address1 = paramList[4];
        this.address2 = paramList[5];
        this.city = paramList[6];
        this.state = paramList[7];
        this.zip = paramList[8];
        this.transactionId = generateId();
    }

    /** Gets the Account Number
     * @return String
     */
    public String getAccountNumber(){
        return this.accountNumber;
    }

    /** Gets the Company associated with the Person Object
     * @return String
     */
    public String getCompany(){
        return this.company;
    }

    /** Gets the First name for the object
     * @return String
     */
    public String getFirstName(){
        return this.firstName;
    }

    /**
     * @return String Retrieves the Last Name Associated with the Object
     */
    public String getLastName(){
        return this.lastName;
    }

    /**
     * @return  String First Address associated with the object
     */
    public String getAddress1(){
        return this.address1;
    }

    /**
     * @return  String Second Address associated with the object
     */
    public String getAddress2(){
        return this.address2;
    }

    /**
     * @return the city associated with the object
     */
    public String getCity(){
        return this.city;
    }

    /**
     * @return String - State associated with the Object
     */
    public String getState(){
        return this.state;
    }

    /**
     * @return String - ZipCode Associated with the Object
     */
    public String getZip(){
        return this.zip;
    }

    /**
     * @return String - Returns the transactionID associated with the Object.
     */
    public String getTransactionId() {
        return this.transactionId;
    }

    /**
     * Generate's a unique 24 digit alphanumeric transaction ID for this Person
     * @return String which is a 24 digit alphanumeric transaction ID
     */
    private String generateId(){
        UUID uuid = UUID.randomUUID();
        String txId = uuid.toString();
        txId = txId.replaceAll("-","");
        return txId.substring(0,24);
    }

    /**
     * @return String - All information belonging to the particular person object.
     */
    @Override
    public String toString(){
        return ("Account: " + this.accountNumber + "\n" +
                    "Company: " + this.company + "\n" +
                    "First Name: " + this.firstName + "\n" +
                    "Last Name: " + this.lastName + "\n" +
                    "Address 1: " + this.address1 + "\n" +
                    "Address 2: " + this.address2 + "\n" +
                    "City: " + this.city + "\n" +
                    "State: " + this.state + "\n" +
                    "Zip: " + this.zip + "\n" +
                    "Transaction ID: " + this.getTransactionId() + "\n"
        );
    }
}

