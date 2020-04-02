package transactions;

import java.io.IOException;
import java.util.Map;

public class EntryPoint {
    public static void main(String[] args) {
        DataManager data = new DataManager("customers.csv");
        try {
            String[] schema = data.getSchema();
            System.out.println("Record: (" + String.join(", ", schema) + ")");
            Map<String, Person> peopleData = data.getPersonMap();
            peopleData.forEach((k, v) -> {
                System.out.println(v);
            });

        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
