package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/** Loads data and stores data to a text file*/

public class DataManager
{
    private Scanner in = null;
    private String[] records = new String[100];
    private String date;
    private int category;
    private String name;
    private double amount;

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

    }

    /** Instantiates the 'in' scanner with the file containing the stored information */
    private void instantiateScanner()
    {
        try
        {
            File file = new File("src/resources/TransactionDetails.txt");
            this.in = new Scanner(file);
        }catch(FileNotFoundException e)
        {
            e.getStackTrace();
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
        for(int i = 0; i < Main.transactions.length; i++)
        {
            if((Main.transactions[i] == null) && (records[i] != null))
            {
                String currentRecord = records[i];
                separateInformation(currentRecord);

                //Using constructor for already formatted date
                Transaction transaction = new Transaction(this.category, this.name, this.amount, this.date);
                Main.transactions[i] = transaction;
            }
        }
    }

    /** Separates the information in a record into formatted date, category, name, and amount */
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
            {
                commaIndex = record.indexOf(",");
                break;
            }
            case 2:
            {
                //Starts looking for the comma from the index of the first command, therefore finding the second comma
                commaIndex = record.indexOf(",", (record.indexOf(",") + 1));
                break;
            }
            case 3:
            {
                int secondComma = record.indexOf(",", (record.indexOf(",") + 1));
                commaIndex = record.indexOf(",", (secondComma + 1));
                break;
            }
            default:
            {
                commaIndex = 0;
                break;
            }
        }
        return commaIndex;
    }
}
