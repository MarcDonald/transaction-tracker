package lists;

import main.Main;
import main.Transaction;

/** Records Array Class */

public class RecordList
{
    private String[] records;
    private int size;
    private int maxSize;

    /**
     * Constructor to create a new RecordList of max size 100
     */
    public RecordList()
    {
        this.records = new String[100];
        this.size = 0;
        this.maxSize = 100;
    }

    /**
     * Adds a new record to the next available space in the list
     * @param record Record to add
     */
    public void add(String record)
    {
        if(this.size < this.maxSize)
        {
            this.records[this.size] = record;
            this.size++;
        }else
            Main.print("You have entered the maximum amount of records; new ones cannot be stored");
    }

    /**
     * Gets the record at a specific index in the list
     * @param index Index to check
     * @return Record
     */
    public String getRecord(int index)
    {
        if(greaterThanMax(index))
            return null;

        //Checks if the index is empty, if it is it will display an error message and return null
        if(isEmpty(index))
            Main.print("No record found at index " + index);
        return this.records[index];
    }

    /**
     * Checks if an index in the list is empty
     * @param index Index to check
     * @return Whether the index is empty
     */
    public Boolean isEmpty(int index)
    {
        if(greaterThanMax(index))
        {
            return null;
        }
        return this.records[index] == null;
    }

    /** Creates a transaction in the format required for the text file
     * @param transaction Transaction to make the record from
     * @return Record form of the transaction
     */
    public static String createRecord(Transaction transaction)
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

    /** Extract's date from a given record
     * @param record Record to extract date from
     * @return Date
     */
    public static String extractDate(String record)
    {
        int comma = findComma(record, 1);
        return record.substring(0, comma);
    }

    /** Extract's category from a given record
     * @param record Record to extract category from
     * @return Category
     */
    public static int extractCategory(String record)
    {
        int comma1 = findComma(record, 1);
        int comma2 = findComma(record, 2);
        String categoryS = record.substring(comma1 + 1, comma2);
        int categoryI = 0;

        //Converts the string values of category to an int value
        try
        {
            categoryI = Integer.parseInt(categoryS);
        }catch(NumberFormatException e)
        {
            Main.print("Number Format Exception");
            Main.print(e.getMessage());
        }
        return categoryI;
    }

    /** Extract's name from a given record
     * @param record Record to extract name from
     * @return Name
     */
    public static String extractName(String record)
    {
        int comma2 = findComma(record, 2);
        int comma3 = findComma(record, 3);
        return record.substring(comma2 + 1, comma3);
    }

    /** Extract's amount from a given record
     * @param record Record to extract amount from
     * @return Amount
     */
    public static double extractAmount(String record)
    {
        int comma3 = findComma(record, 3);
        String amountS = record.substring(comma3 + 1);
        double amountD = 0;

        //Converts the string values in the text file to int and double for category and amount
        try
        {
            amountD = Double.parseDouble(amountS);
        }catch(NumberFormatException e)
        {
            Main.print("Number Format Exception");
            Main.print(e.getMessage());
        }
        return amountD;
    }

    /** Finds the index of the given occurrence of a comma in a given string
     * @param record String to find comma in
     * @param occurrence Occurrence of comma (1, 2, or 3
     * @return Index of that occurrence of a comma
     */
    private static int findComma(String record, int occurrence)
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

    /**
     * Current size of the list
     * @return Size of the list
     */
    public int getSize()
    {
        return size;
    }

    /**
     * Checks if the number entered is larger than the maximum size of the list and if it is displays a warning
     * @param index Index to check
     * @return Whether the index entered is larger than the max size of the list
     */
    private boolean greaterThanMax(int index)
    {
        if(index > this.maxSize)
        {
            Main.print("The number entered is larger than the maximum size of the list");
            return true;
        }else
            return false;
    }
}
