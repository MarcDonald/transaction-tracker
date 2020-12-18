package test;

import lists.RecordList;

/** Tests for the RecordList class */

class RecordListTests
{
    private static final Test test = new Test();

    /** Runs all Transaction tests */
    static void runTests()
    {
        System.out.println("RECORDLIST TESTS");
        System.out.println("----------------");
        addNormalRecord();
        add100Records();
        add101Records();
        getSizeNormalTest();
        isEmptyNormalTest();
        isEmptyMoreThanMaxTest();
        getRecordValidTest();
        getRecordEmptyIndexTest();
        getRecordOnMoreThanMaxIndex();
        System.out.println("----------------");
    }

    /** Test for adding a record to the list whenever there is space available */
    private static void addNormalRecord()
    {
        System.out.println("Add Normal Record");
        RecordList recordList = new RecordList();
        recordList.add("19900101,1,Alpha,100.0");

        boolean recordAdded = recordList.isEmpty(0);
        test.ckEqualsB("Record Added: ", false, recordAdded);
        System.out.println();
    }

    /** Test for adding maximum amount of transactions */
    private static void add100Records()
    {
        System.out.println("Add 100 Records");
        RecordList recordList = new RecordList();
        for(int i = 0; i < 100; i++)
            recordList.add("19900101,1,Alpha,100.0");

        test.ckEqualsI("Size: ", 100, recordList.getSize());
        System.out.println();
    }

    /** Test for adding one more transaction than the maximum amount of transactions */
    private static void add101Records()
    {
        System.out.println("Add 101 Records. Should display error");
        RecordList recordList = new RecordList();
        for(int i = 0; i < 101; i++)
            recordList.add("19900101,1,Alpha,100.0");

        System.out.println();
    }

    /** Test for getSize */
    private static void getSizeNormalTest()
    {
        System.out.println("Get Size Test");
        RecordList recordList = new RecordList();
        for(int i = 0; i < 5; i++)
            recordList.add("19900101,1,Alpha,100.0");

        test.ckEqualsI("Size: ", 5, recordList.getSize());
        System.out.println();
    }

    /** Test for isEmpty */
    private static void isEmptyNormalTest()
    {
        System.out.println("Is Empty Normal Test");
        RecordList recordList = new RecordList();
        recordList.add("19900101,1,Alpha,100.0");

        test.ckEqualsB("Is empty on full: ", false, recordList.isEmpty(0));
        test.ckEqualsB("Is empty on empty: ", true, recordList.isEmpty(1));
        System.out.println();
    }

    /** Test for isEmpty on index larger than maximum */
    private static void isEmptyMoreThanMaxTest()
    {
        System.out.println("Is Empty More Than Max Test. Should display a warning");
        RecordList recordList = new RecordList();

        test.ckEqualsN("Is null: ", null, recordList.isEmpty(101));
        System.out.println();
    }

    /** Test for getRecord on valid transaction */
    private static void getRecordValidTest()
    {
        System.out.println("Get Transaction on Valid Transaction Test");
        RecordList recordList = new RecordList();
        recordList.add("19900101,1,Alpha,100.0");

        String recordToCheck = null;
        if(recordList.getRecord(0) != null)
            recordToCheck = recordList.getRecord(0);

        test.ckEqualsB("Record exists: ", true, recordToCheck != null);
        System.out.println();    }

    /** Test for getRecord on empty index */
    private static void getRecordEmptyIndexTest()
    {
        System.out.println("Get Record on Empty Index RecordList Test. Should display error message");
        RecordList recordList = new RecordList();

        String recordToCheck = recordList.getRecord(0);
        test.ckEqualsB("Index is null: ", true, recordToCheck == null);
        System.out.println();
    }

    /** Test for getRecord on index higher than maximum size */
    private static void getRecordOnMoreThanMaxIndex()
    {
        System.out.println("Get Record on Index Higher than Max Size. Should display error message");
        RecordList recordList = new RecordList();

        String recordToCheck = recordList.getRecord(101);
        test.ckEqualsN("Index is null: ", null, recordToCheck);
        System.out.println();
    }
}