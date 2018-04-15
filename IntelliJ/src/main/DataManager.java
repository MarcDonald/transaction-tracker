package main;

import lists.RecordList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/** Loads data from and stores data to a text file*/

public class DataManager
{
    private final RecordList records;
    private final File file = new File("src/resources/TransactionDetails.txt");

    private Scanner in = null;
    private PrintWriter out = null;

    private String date;
    private int category;
    private String name;
    private double amount;

    public DataManager()
    {
        this.records = new RecordList();
    }

    /** Loads data from a text file */
    void loadData()
    {
        instantiateScanner();
        fillRecordsArray();
        in.close();
        fillTransactionsArray();
    }

    /** Stores data from the program into a text file */
    public void storeData()
    {
        instantiateScanner();
        instantiatePrintWriter();
        storeNewRecordsInFile();

        out.close();
        in.close();
    }

    /** Instantiates the 'in' scanner with the file containing the stored information */
    private void instantiateScanner()
    {
        try
        {
            this.in = new Scanner(this.file);
        }catch(FileNotFoundException e)
        {
            e.printStackTrace();
            Main.print(e.getMessage());
            Main.print("in " + System.getProperty("user.dir"));
            System.exit(-1);
        }
    }

    /** Fills the records array with whole records from the text file */
    private void fillRecordsArray()
    {
        while(in.hasNextLine())
        {
            records.add(in.nextLine());
        }
    }

    /** Fills the transactions array with transaction objects made out of the information that has been loaded */
    private void fillTransactionsArray()
    {
        for(int i = 0; i < Main.transactions.getMaxSize(); i++)
        {
            if((Main.transactions.isEmpty(i)) && (!records.isEmpty(i)))
            {
                String currentRecord = records.getRecord(i);
                separateInformation(currentRecord);

                //Using constructor for already formatted date
                Transaction transaction = new Transaction(this.category, this.name, this.amount, this.date);
                Main.transactions.add(transaction);
            }
        }
    }

    /** Separates the information in a record into formatted date, category, name, and amount
     * @param record Record to extract information from
     */
    private void separateInformation(String record)
    {
        //Date is already in the form yyyymmdd so doesn't need any additional formatting
        this.date = RecordList.extractDate(record);
        this.category = RecordList.extractCategory(record);
        this.name = RecordList.extractName(record);
        this.amount = RecordList.extractAmount(record);
    }

    /** Instantiates the PrintWriter using the TransactionsDetails.txt file */
    private void instantiatePrintWriter()
    {
        try
        {
            this.out = new PrintWriter(this.file);
        }catch(FileNotFoundException e)
        {
            e.printStackTrace();
            Main.print(e.getMessage());
            Main.print("in " + System.getProperty("user.dir"));
            System.exit(-1);
        }
    }

    /** Stores all records in the file */
    private void storeNewRecordsInFile()
    {
        for(int i = 0; i < Main.transactions.getSize(); i++)
        {
            if(Main.transactions.getTransaction(i) != null)
            {
                String record = RecordList.createRecord(Main.transactions.getTransaction(i));
                out.println(record);
            }
        }
    }
}