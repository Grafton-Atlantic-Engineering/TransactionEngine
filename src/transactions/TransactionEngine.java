package transactions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class TransactionEngine implements ITransactionEngine {

    private final static Logger LOGGER = Logger.getLogger(DataManager.class.getName());
    private Map<String, Person> customerMap;

    public TransactionEngine(String filename) {
        // DataManager gets all Person data from the CSV provided
        DataManager customerData = new DataManager(filename);
        this.customerMap = customerData.getPersonMap();
    }

    @Override
    public List<String> getAllCustomerTransactionIDs() {
        LOGGER.info("Getting all customer transaction IDs");
        List<String> customerIds = new ArrayList<String>();
        for (Person p: this.customerMap.values()) {
            customerIds.add(p.getTransactionId());
        }
        return customerIds;
    }

    @Override
    public String getCustomerTransactionID(String accountNumber) {
        LOGGER.info("Getting customer with account number: " + accountNumber);
        // if-else for this since we aren't playing code golf
        if (this.customerMap.containsKey(accountNumber)) {
            return this.customerMap.get(accountNumber).getTransactionId();
        } else {
            LOGGER.warning("Customer with account number \"" + accountNumber + "\", doesn't exist");
            return null;
        }
    }
}
