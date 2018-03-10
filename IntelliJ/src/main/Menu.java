package main;

import java.util.InputMismatchException;
import java.util.Scanner;

/** User interface */

public class Menu
{
    private boolean optionChosen;

    public Menu()
    {}

    /**
     * Prints the main menu to the console
     */
    public void printMainMenu()
    {
        this.optionChosen = false;

        //Repeats until the user enters a valid option
        while(!this.optionChosen)
        {
            print("Please enter the number which correlates to the action you wish to perform");
            print("1 - Add a New Entry");
            print("2 - View a Report");

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
        int selectedOption;

        try
        {
            selectedOption = sc.nextInt();

            if(selectedOption == 1 || selectedOption == 2)
            {
                this.optionChosen = true;
                performMainMenuAction(selectedOption);
                print("");
            }else
            {
                print("ERROR: Please enter a valid option");
                print("");
            }
        } catch(InputMismatchException e)
        {
            e.getStackTrace();
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
        if(option == 1)
            printTransactionMenu();
        else if(option == 2)
            printReportMenu();
    }

    /**
     * Guides the user through adding a new transaction
     */
    private void printTransactionMenu()
    {
        //TODO
    }

    /**
     * Allows the user to select the type of report they would like to print
     */
    private void printReportMenu()
    {
        this.optionChosen = false;

        while(!this.optionChosen)
        {
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
        } catch(InputMismatchException e)
        {
            e.getStackTrace();
            print("ERROR: Please enter a valid option");
            print("");
        }
    }

    /**
     * Takes the appropriate action depending on what the user selected
     * @param selectedOption The option the user selected
     */
    private void performReportMenuOption(int selectedOption)
    {
        //TODO Take appropriate action
        switch(selectedOption)
        {
            case 1:
            {
                this.optionChosen = true;
                print("");
                print("Total spent");
                break;
            }
            case 2:
            {
                this.optionChosen = true;
                print("");
                print("Total for one category");
                break;
            }
            case 3:
            {
                this.optionChosen = true;
                print("");
                print("List all");
                break;
            }
            case 4:
            {
                this.optionChosen = true;
                print("");
                print("List all to a given recipient");
                break;
            }
            case 5:
            {
                this.optionChosen = true;
                print("");
                printMainMenu();
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

    /**
     * Prints a value to the console (Just System.out.println() but looks neater and is easier to type out
     * @param message Message to print to the screen
     */
    private void print(String message)
    {
        System.out.println(message);
    }
}
