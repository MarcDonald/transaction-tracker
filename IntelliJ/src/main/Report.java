package main;

/** Generates a report of the user's choosing */

public class Report
{
    public Report()
    {}

    /** Generates a report of the total money spent between two dates supplied by the user */
    public void totalSpent(int date1, int date2)
    {
        //TODO Add functionality
        String date1UserReadable = Transaction.convertDateToUserReadable(date1);
        String date2UserReadable = Transaction.convertDateToUserReadable(date2);

        print("TOTAL AMOUNT SPENT BETWEEN " + date1UserReadable + " AND " + date2UserReadable);
    }

    /** Generates a report of the total money spent on a single category between two dates supplied by the user */
    public void totalSpentSingleCategory(int date1, int date2, int category)
    {
        //TODO Add functionality
        String categoryName = categoryName(category).toUpperCase();
        String date1UserReadable = Transaction.convertDateToUserReadable(date1);
        String date2UserReadable = Transaction.convertDateToUserReadable(date2);

        print("TOTAL AMOUNT SPENT ON " + categoryName + " BETWEEN " + date1UserReadable + " AND " + date2UserReadable);
    }

    /** Generates a list of all the transactions between two dates supplied by the user */
    public void listAll(int date1, int date2)
    {
        //TODO Add functionality
        String date1UserReadable = Transaction.convertDateToUserReadable(date1);
        String date2UserReadable = Transaction.convertDateToUserReadable(date2);

        print("ALL TRANSACTIONS MADE BETWEEN " + date1UserReadable + " AND " + date2UserReadable);
    }

    /** Generates a report listing all transactions to a recipient supplied by the user between two given dates */
    public void listAllToRecipient(int date1, int date2, String recipient)
    {
        //TODO Add functionality
        String date1UserReadable = Transaction.convertDateToUserReadable(date1);
        String date2UserReadable = Transaction.convertDateToUserReadable(date2);

        print("ALL TRANSACTIONS MADE TO " + recipient + " BETWEEN " + date1UserReadable + " AND " + date2UserReadable);
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

    /**
     * Prints a value to the console (Just System.out.println() but looks neater and is easier to type out
     * @param message Message to print to the screen
     */
    private void print(String message)
    {
        System.out.println(message);
    }
}
