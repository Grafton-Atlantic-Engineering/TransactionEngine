# TransactionEngine

![Java Continuous Integration](https://github.com/Grafton-Atlantic-Engineering/TransactionEngine/workflows/Java%20Continuous%20Integration/badge.svg?branch=master) 

[Github Repo](https://github.com/Grafton-Atlantic-Engineering/TransactionEngine)

TransactionEngine is a class suite which parses a CSV file of customers, 
creating a transaction ID for each customer, and providing an interface 
to map the account number to the transaction id.



## Usage

Clone the project into a repository and add   
`TransactionEngine/src/transactions` to your class path

```java 
	 TransactionEngine transactions = new TransactionEngine("customers.csv");

	 // to get all transaction IDs
	 List<String> txids = transactions.getAllCustomerTransactionIDs();

	 // get a specific transaction ID 
	 String txid = transactions.getCustomerTransactionID("12345");
```

## Contributing 
Pull requests are always welcome. 

Please open an issue for any changes, major or otherwise.

## License
[AGPLv3](LICENSE)

## Contact 

[Grafton Atlantic](https://github.com/Grafton-Atlantic-Engineering)
