package main;

import lists.TransactionList;

import java.text.NumberFormat;

import static main.Main.print;

/** Generates a report of the user's choosing */

public class Report
{
    private NumberFormat money = NumberFormat.getCurrencyInstance();

    public Report()
    {}

    /** Generates a report of the total money spent between two dates supplied by the user
     * @param date1 First date
     * @param date2 Second date
     */
    public void totalSpent(int date1, int date2)
    {
        //Title
        String date1UserReadable = Transaction.convertDateToUserReadable(date1);
        String date2UserReadable = Transaction.convertDateToUserReadable(date2);
        print("TOTAL AMOUNT SPENT BETWEEN " + date1UserReadable + " AND " + date2UserReadable);

        //Logic
        TransactionList withinRange = ifWithinDateRangeAddToArray(date1, date2);
        double total = calculateTotal(withinRange);

        String totalCurrency = money.format(total);

        //Prints the total amount spent
        print("Amount spent: " + totalCurrency);
    }

    /** Generates a report of the total money spent on a single category between two dates supplied by the user
     * @param date1 First date
     * @param date2 Second date
     * @param category Category to search for
     */
    public void totalSpentSingleCategory(int date1, int date2, int category)
    {
        //Title
        String categoryName = categoryName(category).toUpperCase();
        String date1UserReadable = Transaction.convertDateToUserReadable(date1);
        String date2UserReadable = Transaction.convertDateToUserReadable(date2);
        print("TOTAL AMOUNT SPENT ON " + categoryName + " BETWEEN " + date1UserReadable + " AND " + date2UserReadable);

        //Logic
        TransactionList withinRange = ifWithinDateRangeAndCorrectCategoryAddToArray(date1, date2, category);
        double total = calculateTotal(withinRange);

        String totalCurrency = money.format(total);

        //Prints the total amount spent
        print("Amount spent: " + totalCurrency);
    }

    /** Generates a list of all the transactions between two dates supplied by the user
     * @param date1 First date
     * @param date2 Second date
     */
    public void listAll(int date1, int date2)
    {
        //Title
        String date1UserReadable = Transaction.convertDateToUserReadable(date1);
        String date2UserReadable = Transaction.convertDateToUserReadable(date2);
        print("ALL TRANSACTIONS MADE BETWEEN " + date1UserReadable + " AND " + date2UserReadable);
        print("");

        //Logic
        TransactionList withinRange = ifWithinDateRangeAddToArray(date1, date2);

        //Prints each transaction individually
        printTransactions(withinRange);
    }

    /** Generates a report listing all transactions to a recipient supplied by the user between two given dates
     * @param date1 First date
     * @param date2 Second date
     * @param recipient Recipient to search for
     */
    public void listAllToRecipient(int date1, int date2, String recipient)
    {
        //Title
        String date1UserReadable = Transaction.convertDateToUserReadable(date1);
        String date2UserReadable = Transaction.convertDateToUserReadable(date2);
        print("ALL TRANSACTIONS MADE TO " + recipient + " BETWEEN " + date1UserReadable + " AND " + date2UserReadable);
        print("");

        //Logic
        TransactionList withinRange = ifWithinDateRangeAndCorrectRecipientAddToArray(date1, date2, recipient);

        //Prints each transaction individually
        printTransactions(withinRange);
    }

    /** Converts the int value of a category into the String name
     * @param categoryNo Integer value of the category
     * @return Human readable name of the category
     */
    private String categoryName(int categoryNo)
    {
        switch(categoryNo)
        {
            case 1:
                return "Rent";
            case 2:
                return "Electricity";
            case 3:
                return "ISP";
            case 4:
                return "Gas";
            case 5:
                return "Mobile Phone";
            case 6:
                return "Groceries";
            case 7:
                return "Entertainment";
            case 8:
                return "Eating Out";
            case 9:
                return "Public Transport";
            case 10:
                return "Car";
            default:
                return "ERROR: Category Number Not Valid";
        }
    }

    /** Checks if a transaction is within the date range
     * @param item Transaction to check
     * @param date1 First date
     * @param date2 Second date
     * @return Whether the transaction took place between the first date and the second date
     */
    private boolean isWithinDateRange(Transaction item, int date1, int date2)
    {
        return ((item.getDate() >= date1) && (item.getDate() <= date2));
    }

    /** Prints out the details of transactions within an array
     * @param transactions Transaction storage array
     */
    private void printTransactions(TransactionList transactions)
    {
        for(int i = 0; i < transactions.getMaxSize(); i++)
        {
            if((i == 0) && transactions.isEmpty(i))
                print("None found");
            else if(!transactions.isEmpty(i))
            {
                String dateUserReadable = Transaction.convertDateToUserReadable(transactions.getTransaction(i).getDate());
                String categoryName = categoryName(transactions.getTransaction(i).getCategory());
                int transactionNumber = i + 1;

                print("Transaction " + transactionNumber + ":");
                print("Date: " + dateUserReadable);
                print("Category: " + categoryName);
                print("Recipient: " + transactions.getTransaction(i).getRecipient());
                print("Amount: " + money.format(transactions.getTransaction(i).getAmount()));
                print("---------------------------------");
            }
        }
    }

    /** For each index of Main.transactions, checks if it is null and if it isn't, checks if the date lies between
     * the given dates. If it does, adds it to a TransactionList
     * @param date1 First date
     * @param date2 Second date
     * @return A list of transactions within the date range
     */
    private TransactionList ifWithinDateRangeAddToArray(int date1, int date2)
    {
        TransactionList withinRange = new TransactionList();
        for(int i = 0; i < Main.transactions.getMaxSize(); i++)
        {
            if(!Main.transactions.isEmpty(i))
            {
                if(isWithinDateRange(Main.transactions.getTransaction(i), date1, date2))
                {
                    withinRange.addTransaction(Main.transactions.getTransaction(i));
                }
            }
        }
        return withinRange;
    }

    /** For each index of Main.transactions, checks if it is null and if it isn't, checks if the date lies between
     * the given dates. If it does, checks if it is of the category the user entered. If it is adds it to a TransactionList
     * @param date1 First date
     * @param date2 Second date
     * @param category Category to search for
     * @return TransactionList of transactions that are within the date range and are the appropriate category
     */
    private TransactionList ifWithinDateRangeAndCorrectCategoryAddToArray(int date1, int date2, int category)
    {
        TransactionList withinRange = new TransactionList();
        for(int i = 0; i < Main.transactions.getMaxSize(); i++)
        {
            if(!Main.transactions.isEmpty(i))
            {
                if(isWithinDateRange(Main.transactions.getTransaction(i), date1, date2))
                {
                    if(Main.transactions.getTransaction(i).getCategory() == category)
                    {
                        withinRange.addTransaction(Main.transactions.getTransaction(i));
                    }
                }
            }
        }
        return withinRange;
    }

    /** For each index of Main.transactions, checks if it is null and if it isn't, checks if the date lies between
     *  the given dates. If it does, adds it to an array
     * @param date1 First date
     * @param date2 Second date
     * @param recipient Recipient to search for
     * @return TransactionList of transactions within date range and appropriate recipient
     */
    private TransactionList ifWithinDateRangeAndCorrectRecipientAddToArray(int date1, int date2, String recipient)
    {
        TransactionList withinRange = new TransactionList();
        for(int i = 0; i < Main.transactions.getMaxSize(); i++)
        {
            if(!Main.transactions.isEmpty(i))
            {
                if(isWithinDateRange(Main.transactions.getTransaction(i), date1, date2))
                {
                    if(Main.transactions.getTransaction(i).getRecipient().equals(recipient))
                    {
                        withinRange.addTransaction(Main.transactions.getTransaction(i));
                    }
                }
            }
        }
        return withinRange;
    }

    /** For each index in the withinRange array checks if it is null, if it isn't, gets the amount of the transaction
     *  and then adds it onto the total amount
     * @param withinRange The array of transactions that are within range
     */
    private double calculateTotal(TransactionList withinRange)
    {
        double total = 0;

        for(int i = 0; i < withinRange.getMaxSize(); i++)
        {
            if(!withinRange.isEmpty(i))
            {
                double amount = withinRange.getTransaction(i).getAmount();
                total = total + amount;
            }
        }
        return total;
    }
}