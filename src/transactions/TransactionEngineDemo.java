package transactions;
import java.util.Scanner;

/**
 * This class is responsible for demonstrating the two methods in the TransactionEngine
 * class. This will be done by having the user interface with the command line and
 * getting to choose which method they'd like to try. The test data will be used
 * for this demo.
 */
public class TransactionEngineDemo {
    public static void main(String[] args) {
        //create Scanner object
        Scanner input = new Scanner(System.in);
        //create TransactionEngine object with the test data
        TransactionEngine transactionEngine = new TransactionEngine("Test-Customers.csv");
        String choice = getChoice();
        while(choice.equals("1") || choice.equals("2")) {
            //if the choice is 1, then all of the customer transaction IDs will be printed to the console
            if (choice.equals("1")) {
                System.out.println(transactionEngine.getAllCustomerTransactionIDs());
            }
            //if the choice is 2, then get the account number the user wants to get the transaction
            //ID for then get the transaction ID
            else {
                System.out.println("Please enter the account number you would like to get the " +
                        "transaction ID for: ");
                String accountNo = input.nextLine();
                System.out.println(transactionEngine.getCustomerTransactionID(accountNo));
            }
            //get next choice from user
            choice = getChoice();
        }
    }

    /**
     * This method gets the choice of which method the user wants to try
     * @return 1 if the user wants to try getAllCustomerTransactionIDs, 2 if the user wants to try
     * getCustomerTransactionID, and 3 if the user wants to exit the program
     */
    public static String getChoice() {
        Scanner input = new Scanner(System.in);
        System.out.printf("Please enter 1 if you want to get the transaction IDs for all the " +
                "customers in the CSV...%n");
        System.out.printf("Please enter 2 if you want the enter an account number and get the " +
                "transaction ID for the customer associated with that account...%n");
        System.out.printf("Please enter q if you want to exit the program...%n");
        String choice = input.nextLine();
        return choice;
    }

}
