package main;

/** Transaction object that stores the details of each individual transaction */

public class Transaction
{
    private int date;
    private int category;
    private String recipient;
    private double amount;

    /** Constructor for user entry where the date is in the form dd/mm/yyyy
     * @param date Date of the transaction in the form dd/mm/yyyy
     * @param category Category of the transaction
     * @param recipient Recipient of the transaction
     * @param amount Amount of the transaction
     */
    public Transaction(String date, int category, String recipient, double amount)
    {
        this.category = category;
        this.recipient = recipient;
        this.amount = amount;
        this.date = convertDateToStorage(date);
    }

    /** Constructor for when the date is correctly formatted in the form yyyymmdd
     * @param category Category of the transaction
     * @param recipient Recipient of the transaction
     * @param amount Amount of the transaction
     * @param formattedDate Date in the form yyyymmdd
     */
    public Transaction(int category, String recipient, double amount, String formattedDate)
    {
        this.category = category;
        this.recipient = recipient;
        this.amount = amount;
        this.date = Integer.parseInt(formattedDate);
    }

    /** Converts the user inputted date (dd/mm/yyyy) to the form yyyymmdd for storage
     * @param userInputtedDate Date in the form dd/mm/yyyy
     * @return Date in the form yyyymmdd
     */
    public static int convertDateToStorage(String userInputtedDate)
    {
        String day = extractDayFromUserInput(userInputtedDate);
        String month = extractMonthFromUserInput(userInputtedDate);
        String year = extractYearFromUserInput(userInputtedDate);

        //Combines the strings to be in the yyyymmdd format and returns that as an integer
        return Integer.parseInt(year + month + day);
    }

    /** Converts the stored date (yyyymmdd) to the form dd/mm/yyyy for user readability
     * @param storedDate Date in the form yyyymmdd
     * @return Date in the form dd/mm/yyyy
     */
    public static String convertDateToUserReadable(int storedDate)
    {
        String storedDateString = Integer.toString(storedDate);
        return convertDateToUserReadable(storedDateString);
    }

    /** Converts the stored date (yyyymmdd) to the form dd/mm/yyyy for user readability
     * @param storedDate Date in the form yyyymmdd
     * @return Date in the form dd/mm/yyyy
     */
    public static String convertDateToUserReadable(String storedDate)
    {
        String year = extractYearFromStoredDate(storedDate);
        String month = extractMonthFromStoredDate(storedDate);
        String day = extractDayFromStoredDate(storedDate);

        //Combines the strings to be in the dd/mm/yyyy format and returns that as a String
        return day + "/" + month + "/" + year;
    }

    /** Extracts the day from an unformatted date
     * @param date Date in the form dd/mm/yyyy
     * @return Day
     */
    private static String extractDayFromUserInput(String date)
    {
        return date.substring(0, 2);
    }

    /** Extracts the month from an unformatted date
     * @param date Date in the form dd/mm/yyyy
     * @return Month
     */
    private static String extractMonthFromUserInput(String date)
    {
        return date.substring(3, 5);
    }

    /** Extracts the year from an unformatted date
     * @param date Date in the form dd/mm/yyyy
     * @return Year
     */
    private static String extractYearFromUserInput(String date)
    {
        return date.substring(6, 10);
    }

    /** Extracts the year from a formatted date
     * @param date Date in the form yyyymmdd
     * @return Year
     */
    private static String extractYearFromStoredDate(String date)
    {
        return date.substring(0,4);
    }

    /** Extracts the month from a formatted date
     * @param date Date in the form yyyymmdd
     * @return Month
     */
    private static String extractMonthFromStoredDate(String date)
    {
        return date.substring(4,6);
    }

    /** Extracts the day from a formatted date
     * @param date Date in the form yyyymmdd
     * @return Day
     */
    private static String extractDayFromStoredDate(String date)
    {
        return date.substring(6,8);
    }

    /** @return Date of the transaction */
    public int getDate()
    {
        return date;
    }

    /** @return Category of the transaction */
    public int getCategory()
    {
        return category;
    }

    /** @return Recipient of the transaction */
    public String getRecipient()
    {
        return recipient;
    }

    /** @return Amount of the transaction */
    public double getAmount()
    {
        return amount;
    }
}
