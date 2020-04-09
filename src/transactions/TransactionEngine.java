package transactions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TransactionEngine implements ITransactionEngine {

    private Map<String, Person> customerMap;

    public TransactionEngine(String filename) {
        // DataManager gets all Person data from the CSV provided
        DataManager customerData = new DataManager(filename);
        this.customerMap = customerData.getPersonMap();
    }

    @Override
    public List<String> getAllCustomerTransactionIDs() {
        List<String> customerIds = new ArrayList<String>();
        for (Person p: this.customerMap.values()) {
            customerIds.add(p.getTransactionId());
        }
        return customerIds;
    }

    @Override
    public String getCustomerTransactionID(String accountNumber) {
        return dataManager.personMap.get(accountNumber).getTransactionId();
    }
}
