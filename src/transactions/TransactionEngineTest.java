package transactions;
import java.io.IOException;
import java.util.Map;
import java.io.File;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * TransactionEngineTest is used to test both the generateID() method in the Person
 * class to ensure that a random 24 alpha numeric transaction ID is created for each person
 * and also the getSchema() and getPersonMap() methods in the DataManager class
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
        Person person2 = new Person("0000000011", "Hogwarts", "Ron", "Weesley", "4 Wizard Way", null, "London", null, null);
        for(int i = 0; i < transactionIDs.length; i++) {
            transactionIDs[i] = person2.getTransactionId();
        }
        for(int i = 0; i < transactionIDs.length; i++) {
            //this checks to see if the transactionID at index i is exactly 24 digits with alpha numeric characters
            assertTrue((transactionIDs[i].matches("[a-zA-Z0-9]{24}")));
            //now check to see if all the transaction IDs are unique by comparing them to each other
            for(int j = i + 1; j < transactionIDs.length; j++) {
                assertNotEquals(transactionIDs[j], transactionIDs[i]);
            }
        }
    }
}

