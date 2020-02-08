package transactions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* TODO: create CSV reader class
 *   TODO: add essential field specification for csv parser
 *    TODO: find hash function that produces a digest size & convert from hex to base32 so digest is 32 digits
 *     TODO: add linter */

public class DataManager {
    public static void main(String[] args) throws IOException {
        String[] schema = getSchema("customers.csv");
        Map<String, String[]> dataRows = getDataRows("customers.csv");
        dataRows.forEach((account, data) -> {
            for (int i = 0; i < schema.length; i++) {
                System.out.println('\t' + schema[i] + ": " + data[i]);
            }
            System.out.println();
        });
    }

    public static String[] getSchema(String fileName) throws IOException {
        BufferedReader csvReader = new BufferedReader(new FileReader(fileName));
        String[] schema = csvReader.readLine().split(",", -1);
        csvReader.close();
        return schema;
    }

    public static Map<String, String[]> getDataRows(String fileName) throws IOException {
        BufferedReader csvReader = new BufferedReader(new FileReader(fileName));
        // just gets the schema
        csvReader.readLine();

        Map<String, String[]> dataMap = new HashMap<>();
        String row;
        while((row = csvReader.readLine()) != null) {
            // catch the empty strings
            String[] dataRow = row.split(",", -1);
            String accountNo = dataRow[0];
            dataMap.put(accountNo, dataRow);
        }
        csvReader.close();
        return dataMap;
    }

    public static Map<String, Person> getPersonMap(String fileName) throws IOException {
        Map<String, String[]> dataRows = getDataRows(fileName);
        Map<String, Person> personMap = new HashMap<>();
        dataRows.forEach((accountNo, dataRow) -> {
            personMap.put(accountNo, new Person(dataRow));
        });
        return personMap;
    }

}
