package main;

import java.io.*;
import java.util.Scanner;

/** Loads data from and stores data to a text file*/

public class DataManager
{
    private Scanner in = null;
    private PrintWriter out = null;
    private final String[] records = new String[100];
    private String date;
    private int category;
    private String name;
    private double amount;
    private File file = new File("src/resources/TransactionDetails.txt");

    public DataManager()
    {}

    /** Loads data from a text file */
    public void loadData()
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
            System.out.println(e.getMessage());
            System.out.println("in " + System.getProperty("user.dir"));
            System.exit(-1);
        }
    }

    /** Fills the records array with whole records from the text file */
    private void fillRecordsArray()
    {
        while(in.hasNextLine())
        {
            //Finds the next available slot in the records array to store the information
            for(int i = 0; i < records.length; i++)
            {
                if(records[i] == null)
                {
                    records[i] = in.nextLine();
                    break;
                }
            }
        }
    }

    /** Fills the transactions array with transaction objects made out of the information that has been loaded */
    private void fillTransactionsArray()
    {
        for(int i = 0; i < Main.transactions.getMaxSize(); i++)
        {
            if((Main.transactions.isEmpty(i)) && (records[i] != null))
            {
                String currentRecord = records[i];
                separateInformation(currentRecord);

                //Using constructor for already formatted date
                Transaction transaction = new Transaction(this.category, this.name, this.amount, this.date);
                Main.transactions.addTransaction(transaction);
            }
        }
    }

    /** Separates the information in a record into formatted date, category, name, and amount
     * @param record Record to extract information from
     */
    private void separateInformation(String record)
    {
        int comma1 = findComma(record, 1);
        int comma2 = findComma(record, 2);
        int comma3 = findComma(record, 3);

        String date = record.substring(0, comma1);
        String categoryS = record.substring(comma1 + 1, comma2);
        String name = record.substring(comma2 + 1, comma3);
        String amountS = record.substring(comma3 + 1);
        int categoryI = 0;
        double amountD = 0;

        //Converts the string values in the text file to int and double for category and amount
        try
        {
            categoryI = Integer.parseInt(categoryS);
            amountD = Double.parseDouble(amountS);
        }catch(NumberFormatException e)
        {
            System.out.println("Number Format Exception");
            System.out.println(e.getMessage());
        }

        //Date is already in the form yyyymmdd so doesn't need any additional formatting
        this.date = date;
        this.category = categoryI;
        this.name = name;
        this.amount = amountD;
    }

    /** Finds the index of the given occurrence of a comma in a given string
     * @param record String to find comma in
     * @param occurrence Occurrence of comma (1, 2, or 3
     * @return Index of that occurrence of a comma
     */
    private int findComma(String record, int occurrence)
    {
        int commaIndex;

        switch(occurrence)
        {
            case 1:
                commaIndex = record.indexOf(',');
                break;
            case 2:
                //Starts looking for the comma from the index of the first command, therefore finding the second comma
                commaIndex = record.indexOf(',', (record.indexOf(',') + 1));
                break;
            case 3:
                int secondComma = record.indexOf(',', (record.indexOf(',') + 1));
                commaIndex = record.indexOf(',', (secondComma + 1));
                break;
            default:
                commaIndex = 0;
                break;
        }
        return commaIndex;
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
            System.out.println(e.getMessage());
            System.out.println("in " + System.getProperty("user.dir"));
            System.exit(-1);
        }
    }

    /** Creates a transaction in the format required for the text file
     * @param transaction Transaction to make the record from
     * @return Record form of the transaction
     */
    private String createRecord(Transaction transaction)
    {
        int dateI = transaction.getDate();
        int categoryI = transaction.getCategory();
        String name = transaction.getRecipient().trim();
        double amountD = transaction.getAmount();

        //Convert all to strings
        String dateS = Integer.toString(dateI).trim();
        String categoryS = Integer.toString(categoryI).trim();
        String amountS = Double.toString(amountD).trim();

        //Create record in the form required for the text file
        return dateS + "," + categoryS + "," + name + "," + amountS;
    }

    /** Stores all records in the file */
    private void storeNewRecordsInFile()
    {
        for(int i = 0; i < Main.transactions.getSize(); i++)
        {
            if(Main.transactions.getTransaction(i) != null)
            {
                String record = createRecord(Main.transactions.getTransaction(i));
                out.println(record);
            }
        }
    }
}