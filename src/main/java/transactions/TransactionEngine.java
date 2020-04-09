package transactions;

import java.util.ArrayList;
import java.util.List;

public class TransactionEngine implements ITransactionEngine {

    private DataManager dataManager;

    public TransactionEngine(String filename) {
        this.dataManager = new DataManager(filename);
    }

    @Override
    public List<String> getAllCustomerTransactionIDs() {
        List<String> customerIds = new ArrayList<String>();
        for (Person p: dataManager.personMap.values()) {
            customerIds.add(p.getTransactionId());
        }
        return customerIds;
    }

    @Override
    public String getCustomerTransactionID(String accountNumber) {
        return dataManager.personMap.get(accountNumber).getTransactionId();
    }
}
