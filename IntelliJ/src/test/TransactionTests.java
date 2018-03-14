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
        userInputtedDateToStored();
        storedDateToUserReadable();
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
        test.ckEqualsI("Category: ", 1, transaction.getCategory());
        test.ckEqualsS("Recipient: ", "Stephen", transaction.getRecipient());
        test.ckEqualsD("Amount: ", 250.50, transaction.getAmount());
        System.out.println("");
    }

    /** Test for converting user inputted date format to a format for storage (dd/mm/yyyy to yyyymmdd) */
    private static void userInputtedDateToStored()
    {
        System.out.println("User Inputted Date to Storage Format");
        Transaction transaction = new Transaction("14/03/2018", 1, "Stephen", 250.50);

        test.ckEqualsI("Storage Formatted Date: ",20180314, transaction.convertDateToStorage("14/03/2018"));
        System.out.println("");
    }

    /** Test for converting stored date format to a user readable format (yyyymmdd to dd/mm/yyyy) */
    private static void storedDateToUserReadable()
    {
        System.out.println("Stored Date to User Readable Format");
        Transaction transaction = new Transaction("14/03/2018", 1, "Stephen", 250.50);

        String storedDate = Integer.toString(transaction.getDate());
        test.ckEqualsS("User Readable Date: ","14/03/2018", transaction.convertDateToUserReadable(storedDate));
        System.out.println("");
    }
}