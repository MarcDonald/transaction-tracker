package main;

/** Generates a report of the user's choosing */

public class Report
{
    public Report()
    {}

    /** Generates a report of the total money spent between two dates supplied by the user */
    public void totalSpent(int date1, int date2)
    {
        //Title
        String date1UserReadable = Transaction.convertDateToUserReadable(date1);
        String date2UserReadable = Transaction.convertDateToUserReadable(date2);
        print("TOTAL AMOUNT SPENT BETWEEN " + date1UserReadable + " AND " + date2UserReadable);

        //Logic
        Transaction[] withinRange = new Transaction[100];
        ifWithinDateRangeAddToArray(withinRange, date1, date2);
        double total = calculateTotal(withinRange);

        //Prints the total amount spent
        print("Amount spent: £" + total);
    }

    /** Generates a report of the total money spent on a single category between two dates supplied by the user */
    public void totalSpentSingleCategory(int date1, int date2, int category)
    {
        //Title
        String categoryName = categoryName(category).toUpperCase();
        String date1UserReadable = Transaction.convertDateToUserReadable(date1);
        String date2UserReadable = Transaction.convertDateToUserReadable(date2);
        print("TOTAL AMOUNT SPENT ON " + categoryName + " BETWEEN " + date1UserReadable + " AND " + date2UserReadable);

        //Logic
        Transaction[] withinRange = new Transaction[100];
        ifWithinDateRangeAndCorrectCategoryAddToArray(withinRange, date1, date2, category);
        double total = calculateTotal(withinRange);

        //Prints the total amount spent
        print("Amount spent: £" + total);
    }

    /** Generates a list of all the transactions between two dates supplied by the user */
    public void listAll(int date1, int date2)
    {
        //Title
        String date1UserReadable = Transaction.convertDateToUserReadable(date1);
        String date2UserReadable = Transaction.convertDateToUserReadable(date2);
        print("ALL TRANSACTIONS MADE BETWEEN " + date1UserReadable + " AND " + date2UserReadable);
        print("");

        //Logic
        Transaction[] withinRange = new Transaction[100];
        ifWithinDateRangeAddToArray(withinRange, date1, date2);

        //Prints each transaction individually
        printTransactions(withinRange);
    }
    /** Generates a report listing all transactions to a recipient supplied by the user between two given dates */
    public void listAllToRecipient(int date1, int date2, String recipient)
    {
        //Title
        String date1UserReadable = Transaction.convertDateToUserReadable(date1);
        String date2UserReadable = Transaction.convertDateToUserReadable(date2);
        print("ALL TRANSACTIONS MADE TO " + recipient + " BETWEEN " + date1UserReadable + " AND " + date2UserReadable);
        print("");

        //Logic
        Transaction[] withinRange = new Transaction[100];
        ifWithinDateRangeAndCorrectRecipientAddToArray(withinRange, date1, date2, recipient);

        //Prints each transaction individually
        printTransactions(withinRange);
    }

    /** Converts the int value of a category into the String name */
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

    /** Checks if a transaction is within the date range */
    private boolean isWithinDateRange(Transaction item, int date1, int date2)
    {
        return ((item.getDate() >= date1) && (item.getDate() <= date2));
    }

    /** Prints out the details of transactions within an array */
    private void printTransactions(Transaction[] transactions)
    {
        for(int i = 0; i < transactions.length; i++)
        {
            if((i == 0) && transactions[i] == null)
                print("None found");
            else if(transactions[i] != null)
            {
                String dateUserReadable = Transaction.convertDateToUserReadable(transactions[i].getDate());
                String categoryName = categoryName(transactions[i].getCategory());
                int transactionNumber = i + 1;

                print("Transaction " + transactionNumber + ":");
                print("Date: " + dateUserReadable);
                print("Category: " + categoryName);
                print("Recipient: " + transactions[i].getRecipient());
                print("Amount: " + transactions[i].getAmount());
                print("---------------------------------");
            }
        }
    }

    /** For each index of Main.transactions, checks if it is null and if it isn't, checks if the date lies between
     * the given dates. If it does, adds it to an array */
    private void ifWithinDateRangeAddToArray(Transaction[] withinRange, int date1, int date2)
    {
        int withinRangeCounter = 0;

        for(int i = 0; i < Main.transactions.length; i++)
        {
            if(Main.transactions[i] != null)
            {
                if(isWithinDateRange(Main.transactions[i], date1, date2))
                {
                    withinRange[withinRangeCounter] = Main.transactions[i];
                    withinRangeCounter++;
                }
            }
        }
    }

    /** For each index of Main.transactions, checks if it is null and if it isn't, checks if the date lies between
     * the given dates. If it does, checks if it is of the category the user entered. If it is adds it to an array */
    private void ifWithinDateRangeAndCorrectCategoryAddToArray(Transaction[] withinRange, int date1, int date2, int category)
    {
        int withinRangeCounter = 0;

        for(int i = 0; i < Main.transactions.length; i++)
        {
            if(Main.transactions[i] != null)
            {
                if(isWithinDateRange(Main.transactions[i], date1, date2))
                {
                    if(Main.transactions[i].getCategory() == category)
                    {
                        withinRange[withinRangeCounter] = Main.transactions[i];
                        withinRangeCounter++;
                    }
                }
            }
        }
    }

    /** For each index of Main.transactions, checks if it is null and if it isn't, checks if the date lies between
     *  the given dates. If it does, adds it to an array */
    private void ifWithinDateRangeAndCorrectRecipientAddToArray(Transaction[] withinRange, int date1, int date2, String recipient)
    {
        int withinRangeCounter = 0;
        for(int i = 0; i < Main.transactions.length; i++)
        {
            if(Main.transactions[i] != null)
            {
                if(isWithinDateRange(Main.transactions[i], date1, date2))
                {
                    if(Main.transactions[i].getRecipient().equals(recipient))
                    {
                        withinRange[withinRangeCounter] = Main.transactions[i];
                        withinRangeCounter++;
                    }
                }
            }
        }
    }

    /** For each index in the withinRange array checks if it is null, if it isn't, gets the amount of the transaction
     *  and then adds it onto the total amount */
    private double calculateTotal(Transaction[] withinRange)
    {
        double total = 0;

        for(int i = 0; i < withinRange.length; i++)
        {
            if(withinRange[i] != null)
            {
                double amount = withinRange[i].getAmount();
                total = total + amount;
            }
        }
        return total;
    }

    /**
     * Prints a value to the console (Just System.out.println() but looks neater and is easier to type out
     * @param message Message to print to the screen
     */
    private void print(String message)
    {
        System.out.println(message);
    }
}
