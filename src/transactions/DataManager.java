package transactions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * TODO: create CSV reader class
 * TODO: add essential field specification for csv parser
 * TODO: find hash function that produces a digest size & convert from hex to base32 so digest is 32 digits
 * TODO: add linter
 */


/**
 * DataManager is used to get values from the CSV file and map them
 * to account numbers
 */
public class DataManager {

    public String fileName;

    public DataManager(String fileName) {
        LOGGER.setLevel(Level.ALL);
        LOGGER.info("Initialized logger!");
        this.fileName = fileName;
        LOGGER.info("Using file: " + this.fileName);
    }

    /**
     * Gets the CSV file's header/schema/column names
     * @return String[] representing the header/schema/column names
     * @throws IOException when the FileReader is unable to read the specified fileName
     */
    protected String[] getSchema() throws IOException {
        // Creates a buffer to read the first line of the CSV file
        BufferedReader csvReader = new BufferedReader(new FileReader(this.fileName));
        String[] schema = csvReader.readLine().split(",", -1);

        // Close CSV reader to free up memory
        csvReader.close();
        return schema;
    }

    /**
     * Gets the data in the CSV files excluding the header and puts them into a Map
     * from account numbers to a Person's data
     * @return Map<String, Person> a map of account numbers to Persons
     * @throws IOException when the FileReader is unable to read the specified fileName
     */
    protected Map<String, Person> getPersonMap() throws IOException {
        // Creates a buffer to read from the file line by line
        BufferedReader csvReader = new BufferedReader(new FileReader(this.fileName));
        // just gets the schema
        String[] schema = csvReader.readLine().split(",", -1);


        // Creates a map to store the relation between account number to Person
        Map<String, Person> dataMap = new HashMap<>();
        String row;

        // Loop through whole CSV file to put all rows into a Map
        while ((row = csvReader.readLine()) != null) {
            // catch the empty strings
            String[] dataRow = row.split(",", -1);
            String accountNumber = dataRow[0];

            dataMap.put(accountNumber, new Person(dataRow));
        }

        // Close CSV Reader to free up memory
        csvReader.close();
        return dataMap;
    }
}
