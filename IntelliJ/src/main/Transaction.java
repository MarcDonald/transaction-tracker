package main;

/** Transaction object that stores the details of each individual transaction */

public class Transaction
{
    private int date;
    private Category category;
    private String recipient;
    private double amount;

    public Transaction(String date, Category category, String recipient, double amount)
    {
        this.category = category;
        this.recipient = recipient;
        this.amount = amount;

        //TODO Convert date from dd/mm/yyyy to yyymmdd

    }

    public int getDate()
    {
        return date;
    }

    public Category getCategory()
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
