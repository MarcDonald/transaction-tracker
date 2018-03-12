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

    /** Runs all Transaction tests */
    private static void runTests()
    {
        normalEntryConstructor1();
        normalEntryConstructor2();
    }

    /** Test for normal entry. Tests date reformatting and storage ability*/
    private static void normalEntryConstructor1()
    {
        System.out.println("Normal Entry Constructor 1");

        Transaction transaction = new Transaction("03/12/1998", 1, "Stephen", 250.50);

        test.ckEqualsI("Date: ", 19981203, transaction.getDate());
        test.ckEqualsI("Category: ", 1, transaction.getCategory());
        test.ckEqualsS("Recipient: ", "Stephen", transaction.getRecipient());
        test.ckEqualsD("Amount: ", 250.50, transaction.getAmount());
        System.out.println("");
    }

    /** Test for normal entry using second constructor. Tests date storage for formatted date */
    private static void normalEntryConstructor2()
    {
        System.out.println("Normal Entry Constructor 2");
        Transaction transaction = new Transaction(1, "Stephen", 250.50, "19981203");

        test.ckEqualsS("Date: ", "19981203", Integer.toString(transaction.getDate()));
        test.ckEqualsI("Cateogory: ", 1, transaction.getCategory());
        test.ckEqualsS("Recipient: ", "Stephen", transaction.getRecipient());
        test.ckEqualsD("Amount: ", 250.50, transaction.getAmount());
        System.out.print("");
    }
}