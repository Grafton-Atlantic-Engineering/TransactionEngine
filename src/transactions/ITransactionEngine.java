package transactions;


import java.util.List;

// This was the requirements he mentioned in class on 3/11/20
public interface ITransactionEngine {

    // Need I say more
    List<String> getAllCustomerTransactionIDs();


    // just returns the corresponding txid from the accountNumber
    String getCustomerTransactionID(String accountNumber);
}