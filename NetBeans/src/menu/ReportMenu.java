package menu;

import main.Report;
import main.Transaction;

import java.util.InputMismatchException;
import java.util.Scanner;

import static main.Main.print;

/** Report Menu User Interface */
public class ReportMenu
{
    private boolean optionChosen;

    /** Allows the user to select the type of report they would like to print */
    public void printReportMenu()
    {
        this.optionChosen = false;

        while(!this.optionChosen)
        {
            print("");
            print("REPORT MENU");
            print("Please enter the number which correlates to the report you wish to generate");
            print("1 - The total amount of money spent between two dates");
            print("2 - The amount spent on a given category between two dates");
            print("3 - A list of all transactions between two given dates");
            print("4 - A list of all transactions to a given recipient between two given dates");
            print("5 - Back to Main Menu");

            Scanner sc = new Scanner(System.in);

            //Gets the user's input and handles it appropriately
            reportMenuInputHandler(sc);
        }
    }

    /**
     * Determines if the input from the user is valid
     * @param sc Scanner to use
     */
    private void reportMenuInputHandler(Scanner sc)
    {
        int selectedOption;

        try
        {
            selectedOption = sc.nextInt();

            if(selectedOption >= 1 && selectedOption <= 5)
            {
                this.optionChosen = true;
                performReportMenuOption(selectedOption);
                print("");
            }else
            {
                print("ERROR: Please enter a valid option");
                print("");
            }
        }catch(InputMismatchException e)
        {
            e.getStackTrace();
            print("ERROR: Please enter a valid option");
            print("");
        }
    }

    /**
     * Takes the appropriate action depending on what the user selected then returns to the main menu
     * @param selectedOption The option the user selected
     */
    private void performReportMenuOption(int selectedOption)
    {
        Report report = new Report();
        MainMenu mainMenu = new MainMenu();

        switch(selectedOption)
        {
            case 1:
            {
                //Stops the while loop
                this.optionChosen = true;
                //Asks the user for the parameters then creates the report
                print("");
                int date1 = askForDate(1);
                int date2 = askForDate(2);
                report.totalSpent(date1, date2);

                //Returns to main menu
                print("");
                mainMenu.printMainMenu();
                break;
            }
            case 2:
            {
                this.optionChosen = true;
                print("");
                int date1 = askForDate(1);
                int date2 = askForDate(2);
                int category = askForCategory();
                report.totalSpentSingleCategory(date1, date2, category);

                print("");
                mainMenu.printMainMenu();
                break;
            }
            case 3:
            {
                this.optionChosen = true;
                print("");
                int date1 = askForDate(1);
                int date2 = askForDate(2);
                report.listAll(date1, date2);

                print("");
                mainMenu.printMainMenu();
                break;
            }
            case 4:
            {
                this.optionChosen = true;
                print("");
                int date1 = askForDate(1);
                int date2 = askForDate(2);
                String recipient = askForRecipient();
                report.listAllToRecipient(date1, date2, recipient);
                print("");
                mainMenu.printMainMenu();
                break;
            }
            case 5:
            {
                this.optionChosen = true;
                print("");
                mainMenu.printMainMenu();
                break;
            }
            default:
            {
                print("ERROR: Please enter a valid option");
                print("");
                break;
            }
        }
    }

    /** Asks the user to input a date and returns the formatted int version of the date */
    private int askForDate(int whichDate)
    {
        if(whichDate == 1)
            System.out.println("Please enter the first date in the form dd/mm/yyyy");
        else if(whichDate == 2)
            System.out.println("Please enter the second date in the form dd/mm/yyyy");
        else
        {
            System.out.println("ERROR: Date to ask for is neither 1st or 2nd");
            return 0;
        }

        Scanner sc = new Scanner(System.in);
        String dateUserInputted = sc.next();
        print("");
        return Transaction.convertDateToStorage(dateUserInputted);
    }

    /** Asks the user to input the name of a recipient and returns the String value of what the user inputted */
    private String askForRecipient()
    {
        print("Please enter the recipient's name");
        Scanner sc = new Scanner(System.in);
        String recipient = sc.nextLine().trim();

        print("");
        return recipient;
    }

    /** Asks the user to input the category they want and returns the int value of what the user inputted */
    private int askForCategory()
    {
        this.optionChosen = false;
        int category = 0;

        while(!this.optionChosen)
        {
            print("Please enter the number which correlates to the category you wish to generate the report with");
            print("1 - Rent");
            print("2 - Electricity");
            print("3 - ISP");
            print("4 - Gas");
            print("5 - Mobile Phone");
            print("6 - Groceries");
            print("7 - Entertainment");
            print("8 - Eating Out");
            print("9 - Public Transport");
            print("10 - Car");

            Scanner sc = new Scanner(System.in);
            category = categoryInputHandler(sc);
        }

        print("");
        return category;
    }

    /**
     * Takes the user's input, if it's valid will return the int value of the category, otherwise prints an error and
     * reprints the category list
     * @param sc Scanner to use
     */
    private int categoryInputHandler(Scanner sc)
    {
        try
        {
            int selectedOption = sc.nextInt();

            if(selectedOption >= 1  && selectedOption <= 10)
            {
                this.optionChosen = true;
                return selectedOption;
            }else
            {
                print("ERROR: Please enter a valid option");
                print("");
                return 0;
            }
        } catch(InputMismatchException e)
        {
            e.getStackTrace();
            print("ERROR: Please enter a valid option");
            print("");
            return 0;
        }
    }
}