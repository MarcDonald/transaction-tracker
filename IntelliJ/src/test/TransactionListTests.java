package test;

import lists.TransactionList;
import main.Transaction;

/** Tests for the TransactionList class */

class TransactionListTests
{
    private static final Test test = new Test();

    /** Runs all Transaction tests */
    static void runTests()
    {
        System.out.println("TRANSACTIONLIST TESTS");
        System.out.println("----------------");
        addNormalTransaction();
        add100Transactions();
        add101Transactions();
        getSizeNormalTest();
        isEmptyNormalTest();
        System.out.println("----------------");
    }

    /** Test for adding a transaction to the list whenever there is space available */
    private static void addNormalTransaction()
    {
        System.out.println("Add Normal Transaction");
        TransactionList transactionList = new TransactionList();
        transactionList.addTransaction(new Transaction("03/12/1998", 1, "Stephen", 250.50));

        boolean transactionAdded = transactionList.isEmpty(0);
        test.ckEqualsB("Transaction Added: ", false, transactionAdded);
        System.out.println("");
    }

    /** Test for adding maximum amount of transactions */
    private static void add100Transactions()
    {
        System.out.println("Add 100 transactions");
        TransactionList transactionList = new TransactionList();
        for(int i = 0; i < 100; i++)
            transactionList.addTransaction(new Transaction("03/12/1998", 1, "Stephen", 250.50));

        test.ckEqualsI("Size: ", 100, transactionList.getSize());
        System.out.println("");
    }

    /** Test for adding one more transaction than the maximum amount of transactions */
    private static void add101Transactions()
    {
        System.out.println("Add 101 transactions. Should display error");
        TransactionList transactionList = new TransactionList();
        for(int i = 0; i < 101; i++)
            transactionList.addTransaction(new Transaction("03/12/1998", 1, "Stephen", 250.50));

        System.out.println("");
    }

    /** Test for getSize */
    private static void getSizeNormalTest()
    {
        System.out.println("Get Size Test");
        TransactionList transactionList = new TransactionList();
        for(int i = 0; i < 5; i++)
            transactionList.addTransaction(new Transaction("03/12/1998", 1, "Stephen", 250.50));

        test.ckEqualsI("Size: ", 5, transactionList.getSize());
        System.out.println("");

    }

    /** Test for isEmpty */
    private static void isEmptyNormalTest()
    {
        System.out.println("Is Empty Normal Test");
        TransactionList transactionList = new TransactionList();
        transactionList.addTransaction(new Transaction("03/12/1998", 1, "Stephen", 250.50));

        test.ckEqualsB("Is empty on full: ", false, transactionList.isEmpty(0));
        test.ckEqualsB("Is empty on empty: ", true, transactionList.isEmpty(1));
        System.out.println("");
    }
}
