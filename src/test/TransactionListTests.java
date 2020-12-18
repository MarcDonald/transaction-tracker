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
        getTransactionValidTest();
        getTransactionEmptyIndexTest();
        getTransactionOnMoreThanMaxIndex();
        System.out.println("----------------");
    }

    /** Test for adding a transaction to the list whenever there is space available */
    private static void addNormalTransaction()
    {
        System.out.println("Add Normal Transaction");
        TransactionList transactionList = new TransactionList();
        transactionList.add(new Transaction("03/12/1998", 1, "Stephen", 250.50));

        boolean transactionAdded = transactionList.isEmpty(0);
        test.ckEqualsB("Transaction Added: ", false, transactionAdded);
        System.out.println();
    }

    /** Test for adding maximum amount of transactions */
    private static void add100Transactions()
    {
        System.out.println("Add 100 transactions");
        TransactionList transactionList = new TransactionList();
        for(int i = 0; i < 100; i++)
            transactionList.add(new Transaction("03/12/1998", 1, "Stephen", 250.50));

        test.ckEqualsI("Size: ", 100, transactionList.getSize());
        System.out.println();
    }

    /** Test for adding one more transaction than the maximum amount of transactions */
    private static void add101Transactions()
    {
        System.out.println("Add 101 transactions. Should display error");
        TransactionList transactionList = new TransactionList();
        for(int i = 0; i < 101; i++)
            transactionList.add(new Transaction("03/12/1998", 1, "Stephen", 250.50));

        System.out.println();
    }

    /** Test for getSize */
    private static void getSizeNormalTest()
    {
        System.out.println("Get Size Test");
        TransactionList transactionList = new TransactionList();
        for(int i = 0; i < 5; i++)
            transactionList.add(new Transaction("03/12/1998", 1, "Stephen", 250.50));

        test.ckEqualsI("Size: ", 5, transactionList.getSize());
        System.out.println();
    }

    /** Test for isEmpty */
    private static void isEmptyNormalTest()
    {
        System.out.println("Is Empty Normal Test");
        TransactionList transactionList = new TransactionList();
        transactionList.add(new Transaction("03/12/1998", 1, "Stephen", 250.50));

        test.ckEqualsB("Is empty on full: ", false, transactionList.isEmpty(0));
        test.ckEqualsB("Is empty on empty: ", true, transactionList.isEmpty(1));
        System.out.println();
    }

    /** Test for getTransaction on valid transaction */
    private static void getTransactionValidTest()
    {
        System.out.println("Get Transaction on Valid Transaction Test");
        TransactionList transactionList = new TransactionList();
        transactionList.add(new Transaction("03/12/1998", 1, "Stephen", 250.50));

        Transaction transactionToCheck = null;
        if(transactionList.getTransaction(0) != null)
             transactionToCheck = transactionList.getTransaction(0);

        test.ckEqualsB("Transaction exists: ", true, transactionToCheck != null);
        System.out.println();
    }

    /** Test for getTransaction on empty index */
    private static void getTransactionEmptyIndexTest()
    {
        System.out.println("Get Transaction on Empty Index Transaction Test. Should display error message");
        TransactionList transactionList = new TransactionList();

        Transaction transactionToCheck = transactionList.getTransaction(0);
        test.ckEqualsB("Index is null: ", true, transactionToCheck == null);
        System.out.println();
    }

    /** Test for getTransaction on index higher than maximum size */
    private static void getTransactionOnMoreThanMaxIndex()
    {
        System.out.println("Get Transaction on Index Higher than Max Size. Should display error message");
        TransactionList transactionList = new TransactionList();

        Transaction transactionToCheck = transactionList.getTransaction(101);
        test.ckEqualsB("Index is null: ", true, transactionToCheck == null);
        System.out.println();
    }
}
