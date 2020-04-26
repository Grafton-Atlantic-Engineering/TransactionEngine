package transactions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 *  This class is responsible for creating our TransactionEngine
 *  The TransactionEngine takes in a string filename which will get all Person data from the CSV provided
 *
 */
public class TransactionEngine implements ITransactionEngine {

    private final static Logger LOGGER = Logger.getLogger(DataManager.class.getName());
    private Map<String, Person> customerMap;


    public TransactionEngine(String filename) {
        // DataManager gets all Person data from the CSV provided
        DataManager customerData = new DataManager(filename);
        this.customerMap = customerData.getPersonMap();
    }

    /**
     * If the user selects the getAllCustomerTransactionIDs method then every transactionID
     * that has been generated will be displayed to the console.
     *
     * We loop through the customerMap Hashmap and return every value in the dataset.
     *
     * @return CustomerIds - A List of Strings that hold all TransactionIds Associated with AccountNumbers.
     */
    @Override
    public List<String> getAllCustomerTransactionIDs() {
        LOGGER.info("Getting all customer transaction IDs");
        List<String> customerIds = new ArrayList<String>();
        for (Person p: this.customerMap.values()) {
            customerIds.add(p.getTransactionId());
        }
        return customerIds;
    }

    /**
     * This method is responsible for passing in an accountNumber and returning the
     * specific transactionID associated with the AccountNumber. We store all TransactionId's
     * in a Hashmap, the AccountNumber is the key and the transactionId will be the value associated and returned.
     *
     * If a user enters in the wrong accountNumber then the program will inform the user of the error.
     *
     * @param accountNumber Account number is located in the file customer.csv
     * @return
     */
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
