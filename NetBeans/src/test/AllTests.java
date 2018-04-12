package test;

/** Class to run all tests from */

public class AllTests
{
    public static void main(String[] args)
    {
        TransactionTests.runTests();
        TransactionListTests.runTests();
        RecordListTests.runTests();
    }
}
