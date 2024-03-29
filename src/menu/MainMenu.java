package menu;

import main.Main;

import java.util.Scanner;

import static main.Main.print;

/** Main Menu User Interface */

public class MainMenu
{
    //Whether or not an option has been chosen. Used for reprinting the menu if an invalid option is chosen
    private boolean optionChosen;

    public MainMenu()
    {}

    /** Prints the main menu to the console */
    public void printMainMenu()
    {
        this.optionChosen = false;

        //Repeats until the user enters a valid option
        while(!this.optionChosen)
        {
            print("MAIN MENU");
            print("Please enter the number which correlates to the action you wish to perform");
            print("1 - Add a New Entry");
            print("2 - View a Report");
            print("3 - Exit Application");

            Scanner sc = new Scanner(System.in);

            //Gets the user's input and handles it appropriately
            mainMenuInputHandler(sc);
        }
    }

    /**
     * Takes the user's input, if it's valid will perform the appropriate action, otherwise prints an error and reprints
     * the main menu
     * @param sc Scanner to use
     */
    private void mainMenuInputHandler(Scanner sc)
    {
        try
        {
            int selectedOption = sc.nextInt();

            if(selectedOption >= 1 && selectedOption <= 3)
            {
                this.optionChosen = true;
                performMainMenuAction(selectedOption);
                print("");
            }else
            {
                print("ERROR: Please enter a valid option");
                print("");
            }
        } catch(Exception e)
        {
            print("ERROR: Please enter a valid option");
            print("");
        }
    }

    /**
     * Prints either the new transaction menu or the report menu depending on what the user chose
     * @param option The option the user has chosen
     */
    private void performMainMenuAction(int option)
    {
        switch (option) 
        {
            case 1:
                boolean canStore = true;
                
                //Checks to see if there is any space left in the array to store a new transaction
                if(Main.transactions.getSize() >= 100)
                {
                    print("You have entered the maximum amount of transactions; new ones cannot be stored");
                    canStore = false;
                    print("");
                    printMainMenu();
                }
                
                if(canStore)
                {
                    TransactionMenu tm = new TransactionMenu();
                    tm.printTransactionMenu();
                }   
                break;
            case 2:
                ReportMenu rm = new ReportMenu();
                rm.printReportMenu();
                break;
            case 3:
                System.exit(1);
            default:
                break;
        }
    }
}