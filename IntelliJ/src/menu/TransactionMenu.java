package menu;

import main.DataManager;
import main.Main;
import main.Transaction;

import java.util.InputMismatchException;
import java.util.Scanner;

/** Transaction Menu User Interface*/

public class TransactionMenu
{
    private int category;
    private double amount;
    private boolean optionChosen;

    /**
     * Guides the user through adding a new transaction
     */
    public void printTransactionMenu()
    {
        Scanner sc = new Scanner(System.in);

        print("");
        print("NEW TRANSACTION");
        print("Please enter the date of the transaction in the form dd/mm/yyyy");
        String date = sc.next();

        print("");
        promptCategory();

        print("");
        print("Please enter the name of the recipient");
        //Skips to the next line of user input
        sc.nextLine();
        //Stores the whole line as the name (so that there can be spaces e.g. John Smith)
        String name = sc.nextLine();

        print("");
        promptAmount();

        confirmInfoAndStore(date, name);
    }

    /**
     * Prints the information the user entered, and stores the transaction in the next available slot in the array, then
     * returns to main menu
     * @param date Date of the transaction
     * @param name Name of the recipient
     */
    private void confirmInfoAndStore(String date, String name)
    {
        print("");
        print("New transaction stored with the following details:");
        print("Date: " + date);
        print("Category: " + this.category);
        print("Recipient: " + name);
        print("Amount: " + this.amount);

        Transaction transaction = new Transaction(date, this.category, name, this.amount);

        //Add the transaction to the next available slot in the array
        for(int i = 0; i < Main.transactions.length; i++)
        {
            if(Main.transactions[i] == null)
            {
                Main.transactions[i] = transaction;
                break;
            }
        }

        //Store new information
        DataManager dataManager = new DataManager();
        dataManager.storeData();

        //Go back to the main menu
        print("");
        MainMenu mainMenu = new MainMenu();
        mainMenu.printMainMenu();
    }

    /**
     * Prints the category menu and launches the input handler
     */
    private void promptCategory()
    {
        this.optionChosen = false;

        while(!this.optionChosen)
        {
            print("Please enter the number which correlates to the category of the transaction");
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

            //Gets the user's input and handles it appropriately
            categoryInputHandler(sc);
        }
    }

    /**
     * Takes the user's input, if it's valid will set the category to the input, otherwise prints an error and reprints
     * the category list
     * @param sc Scanner to use
     */
    private void categoryInputHandler(Scanner sc)
    {
        int selectedOption;

        try
        {
            selectedOption = sc.nextInt();

            if(selectedOption >= 1  && selectedOption <= 10)
            {
                this.optionChosen = true;
                this.category = selectedOption;
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
     * Prompts the user to enter an amount for the transaction and launches the input handler
     */
    private void promptAmount()
    {
        this.optionChosen = false;

        while(!this.optionChosen)
        {
            print("Please enter the amount of the transaction without any currency symbols (e.g. £250.50 would be entered as 250.50)");

            Scanner sc = new Scanner(System.in);
            amountInputHandler(sc);
        }
    }

    /**
     * Takes the user's input, if it's valid will set the amount to the input, otherwise prints an error and asks the
     * user to re-enter the amount
     * @param sc Scanner to use
     */
    private void amountInputHandler(Scanner sc)
    {
        double amountEntered;

        try
        {
            amountEntered = sc.nextDouble();
            this.optionChosen = true;
            this.amount = amountEntered;
        } catch(InputMismatchException e)
        {
            e.getStackTrace();
            print("ERROR: Please enter a valid option");
            print("");
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