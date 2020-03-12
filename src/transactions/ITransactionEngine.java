package transactions;


// This was the requirements he mentioned in class on 3/11/20
public interface ITransactionEngine {

    // A method that returns all transaction IDs as an array
    // of Strings from a CSV file with filename fileString
    String[] getAllCustomerTransactionIDs(String fileString);


    // A method that returns a transaction ID from a specific account number
    // contained in a CSV file with filename fileString
    String getCustomerTransactionID(String fileString, String accountNumber);
}