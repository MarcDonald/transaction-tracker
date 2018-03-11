package main;

/** Transaction object that stores the details of each individual transaction */

public class Transaction
{
    private int date;
    private int category;
    private String recipient;
    private double amount;

    /** Constructor for user entry where the date is in the form dd/mm/yyy */
    public Transaction(String date, int category, String recipient, double amount)
    {
        this.category = category;
        this.recipient = recipient;
        this.amount = amount;

        String day = extractDay(date);
        String month = extractMonth(date);
        String year = extractYear(date);

        //Combines the strings to be in the yyyymmdd format and stores that as an integer
        String formattedDateString = year + month + day;
        this.date = Integer.parseInt(formattedDateString);
    }

    /** Constructor for when the date is correctly formatted in the form yyyymmdd */
    public Transaction(int category, String recipient, double amount, String formattedDate)
    {
        this.category = category;
        this.recipient = recipient;
        this.amount = amount;
        this.date = Integer.parseInt(formattedDate);
    }

    private String extractDay(String date)
    {
        return date.substring(0, 2);
    }

    private String extractMonth(String date)
    {
        return date.substring(3, 5);
    }

    private String extractYear(String date)
    {
        return date.substring(6, 10);
    }

    public int getDate()
    {
        return date;
    }

    public int getCategory()
    {
        return category;
    }

    public String getRecipient()
    {
        return recipient;
    }

    public double getAmount()
    {
        return amount;
    }
}
