package test;

import main.Transaction;

/** Tests for the Transaction class */

public class TransactionTests
{
    private static Test test = new Test();

    public static void main(String args[])
    {
        runTests();
    }

    private static void runTests()
    {
        normalEntry();
    }

    private static void normalEntry()
    {
        Transaction transaction = new Transaction("03/12/1998", 1, "Stephen", 250.50);

        test.ckEqualsI("Date: ", 19981203, transaction.getDate());
        test.ckEqualsI("Category: ", 1, transaction.getCategory());
        test.ckEqualsS("Recipient: ", "Stephen", transaction.getRecipient());
        test.ckEqualsD("Amount: ", 250.50, transaction.getAmount());
    }
}