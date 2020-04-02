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

    public String getAccountNumber(){
        return this.accountNumber;
    }

    public String getCompany(){
        return this.company;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public String getAddress1(){
        return this.address1;
    }

    public String getAddress2(){
        return this.address2;
    }

    public String getCity(){
        return this.city;
    }

    public String getState(){
        return this.state;
    }

    public String getZip(){
        return this.zip;
    }

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

