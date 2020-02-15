package transactions;

import java.io.IOException;
import java.util.Map;
import java.io.File;

public class EntryPoint {
    public static void main(String[] args) {
        // Gets the customers.csv file
        String filePath = new File("customers.csv").getAbsolutePath();
        DataManager dataManager = new DataManager(filePath);

        // Wrap the map in a try catch block to catch any file reading errors
        Map<String, Person> personMap;
        try {
            personMap = dataManager.getPersonMap();
            personMap.forEach((accountNumber, person) -> {
                System.out.println(person.toString());
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
