package transactions;


import java.util.List;


/**
 * ITransactionEngine
 * Interface that TransactionEngine will implement,
 * Necessary functions that need to be implemented are getAllCustomerTransactionIDs and getCustomerTransactionID
 */
public interface ITransactionEngine {

    List<String> getAllCustomerTransactionIDs();


    // just returns the corresponding txid from the accountNumber
    String getCustomerTransactionID(String accountNumber);
}