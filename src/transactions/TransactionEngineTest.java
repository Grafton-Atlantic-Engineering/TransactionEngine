package transactions;
import java.io.IOException;
import java.util.Map;
import java.io.File;

/**
 * TransactionEngineTest is used to test both the generateID() method in the Person
 * class to ensure that a random 24 alpha numeric transaction ID is created for each person
 * and also the getSchema() and getPersonMap() methods in the DataManager class
 */
public class TransactionEngineTest {
    public static void main(String[] args) {
        //create a few Person objects to use while testing
        //this Person object will have every field filled to make sure that a transaction ID is created for a normal Person object
        Person person1 = new Person("1564afdaave74", "LLBean", "John", "Doe", "555 A Street", "Apartment 1", "Framingham", "Massachusetts", "01701");
        //these Person objects will have several null fields and I want to make sure a transaction ID is still created
        Person person2 = new Person("0000000011", "Hogwarts", "Ron", "Weesley", "4 Wizard Way", null, "London", null, null);
        Person person3 = new Person("afdaea5481dd0", null, "Jane", "Biles", "1 Russell Street", null, null, null, "01721");
        //this Person object will have several empty strings as fields and I want to make sure a transaction ID is still created
        Person person4 = new Person("123456451aefa0", "Barnes and Noble", "", "Austen", "444 Pride and Prejudice Way", "", "London", "", "");
        //this Person object will have several white spaces as fields and I want to make sure a transaction ID is still created
        Person person5 = new Person("1564affdalvje", "Central Perk", "Rachel", "Green", "   ", "    ", "New York City", "New York", "  ");
        //this Person object will have a mix of null, empty strings, and white space and I want to make sure a transaction ID is still created
        Person person6 = new Person("01721aefdeesfe", "   ", null, "Parker", "", null, "Miami", "Florida", "");

        //here I test the generateID() method for the Person objects I've created by calling the
            //getTransactionId() method which calls generateID() to make sure transaction IDs are created for people
            //with null, empty strings, and white space for different fields
        System.out.printf("Transaction ID for person 1: %s%n", person1.getTransactionId());
        System.out.printf("Transaction ID for person 2: %s%n", person2.getTransactionId());
        System.out.printf("Transaction ID for person 3: %s%n", person3.getTransactionId());
        System.out.printf("Transaction ID for person 4: %s%n", person4.getTransactionId());
        System.out.printf("Transaction ID for person 5: %s%n", person5.getTransactionId());
        System.out.printf("Transaction ID for person 6: %s%n", person6.getTransactionId());

        //here I will generate 1000 transaction IDs for a Person object and store them in an array to make sure the
            //transaction IDs are all 24 digits, are alpha numeric, and are all unique
        String[] transactionIDs = new String[1000];
        for(int i = 0; i < transactionIDs.length; i++) {
            transactionIDs[i] = person2.getTransactionId();
        }
        //this boolean will hold if all of the transaction IDs are unique or not
        boolean allUnique = true;
        //this boolean will hold if all of the transaction IDs are alpha numeric
        boolean allAlphaNumeric = true;
        //this boolean will hold if all of the transaction IDs are 24 digits
        boolean all24Digits = true;
        for(int i = 0; i < transactionIDs.length; i++) {
            //this checks to see if transactionIDs at index i is alpha numeric. If it's not it sets allAlphaNumeric
                //to false
            if(!(transactionIDs[i].matches("[a-zA-z0-9]+"))) {
                allAlphaNumeric = false;
            }
            //this checks to see if transactionIDs at index i is 24 digits. If it's not it sets the all24Digits to false
            if(transactionIDs[i].length() != 24) {
                all24Digits = false;
            }
            for(int j = i + 1; j < transactionIDs.length; j++) {
                if(transactionIDs[i].equals(transactionIDs[j])) {
                    allUnique = false;
                }
            }
        }
        if(allUnique && allAlphaNumeric && all24Digits) {
            System.out.println("All of the transaction IDs out of the 1000 created are unique, alpha numeric, and 24 digits.");
        }
        else {
            if (!allUnique) {
                System.out.println("Not all of the transaction IDs out of the 1000 created are unique.");
            }
            if (!allAlphaNumeric) {
                System.out.println("Not all of the transaction IDs out of the 1000 created are alpha numeric.");
            }
            if (!all24Digits) {
                System.out.println("Not all of the transaction IDs out of the 1000 created are 24 digits.");
            }
        }
    }
}
