package transactions;
import java.io.IOException;
import java.util.Map;
import java.io.File;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * TransactionEngineTest is used to test both the generateID() method in the Person
 * class to ensure that a random 24 alpha numeric transaction ID is created for each person
 * and also the createPersonMap() method in the DataManager class
 * TransactionEngineTest also tests the methods in TransactionEngine to make sure they work correctly
 * by making sure that the transaction IDs are created for the given file or input
 */
public class TransactionEngineTest {
    @Test
    public void testTransactionGenerator() {
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
        //I am doing assertNotNull to make sure that the transaction IDs are actually created
        assertNotNull(person1.getTransactionId());
        assertNotNull(person2.getTransactionId());
        assertNotNull(person3.getTransactionId());
        assertNotNull(person4.getTransactionId());
        assertNotNull(person5.getTransactionId());
        assertNotNull(person6.getTransactionId());
    }

    @Test
    public void testUniquenessAndDigits() {
        //here I will generate 1000 transaction IDs for a Person object and store them in an array to make sure the
            //transaction IDs are all 24 digits, are alpha numeric, and are all unique
        String[] transactionIDs = new String[1000];
        for(int i = 0; i < transactionIDs.length; i++) {
            //we recreated this Person object inside the for loop so a new transaction ID would be generated each time
            Person person2 = new Person("0000000011", "Hogwarts", "Ron", "Weesley", "4 Wizard Way", null, "London", null, null);
            transactionIDs[i] = person2.getTransactionId();
        }
        for(int i = 0; i < transactionIDs.length; i++) {
            //this checks to see if the transactionID at index i is exactly 24 digits with alpha numeric characters
            assertTrue((transactionIDs[i].matches("[a-zA-Z0-9]{24}")));
            //now check to see if all the transaction IDs are unique by comparing them to each other
            for(int j = i + 1; j < transactionIDs.length; j++) {
                assertNotEquals("at i: " + i + ", j: " + j, transactionIDs[j], transactionIDs[i]);
            }
        }
    }
    //Now I will test the createPersonMap() methods in the DataManager class by creating a csv file
        //with a few Person objects in it then create a DataManager class and make sure that a Person map is created
        //for Person objects that have null fields (such as address) and that a transaction ID is created for the Person
        //objects in the csv file
    @Test
    public void testIDCreatedWithGetPersonMap() {
        DataManager dataManager = new DataManager("Test-Customers.csv");
        //now do the createPersonMap() method to create a map of Person objects with their account number
            //as their key
        Map<String, Person> personMap = dataManager.createPersonMap();
        //Now I will get a few of the Person objects in the csv file and store them here to see if there are
            //transaction IDs for them
        Person person1 = personMap.get("abc123");
        Person person2 = personMap.get("success789");
        Person person3 = personMap.get("16554846");
        //person1 has several empty fields in the CSV file so we want to make sure a transaction ID is created
        assertNotNull(person1.getTransactionId());
        //person2 also has an empty field in the CSV file
        assertNotNull(person2.getTransactionId());
        //person3 has no empty fields in the CSV file
        assertNotNull(person3.getTransactionId());
    }
    //Now I will test the getAllCustomerTransactionIDs and getCustomerTransactionID methods
    //To do this I created a csv file with a few Person objects stored in it and am using this csv file to create
        //a DataManager object to test these methods
    @Test
    public void testGetAllCustomerTransactionIDs() {
        TransactionEngine transactions = new TransactionEngine("Test-Customers.csv");
        //to test getAllCustomerTransactionIDs I will make sure the output of this method isn't null
        assertNotNull(transactions.getAllCustomerTransactionIDs());
        //Now I will make sure there are 5 transaction IDs in the list created by getAllCustomerTransactionIDs
            //since there's 5 customers in Test-Customers
        assertEquals(5, transactions.getAllCustomerTransactionIDs().size());
    }
    @Test
    public void testGetCustomerTransactionID() {
        TransactionEngine transactions = new TransactionEngine("Test-Customers.csv");
        //To test this I will make sure the output of getCustomerTransactionID is not null for a few of the
            //customers' account numbers which shows that the transaction IDs were created for those customers
            //and that it gets the transaction ID for that account number
        assertNotNull(transactions.getCustomerTransactionID("abc123"));
        assertNotNull(transactions.getCustomerTransactionID("success789"));
        assertNotNull(transactions.getCustomerTransactionID("147846894"));
        assertNull(transactions.getCustomerTransactionID("nonexistent-account"));
    }

}

