package menu;

import main.DataManager;
import main.Main;
import main.Transaction;

import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

import static main.Main.print;


/** Transaction Menu User Interface*/
public class TransactionMenu
{
    private int category;
    private double amount;
    private String name;
    private boolean optionChosen;

    /** Guides the user through adding a new transaction */
    public void printTransactionMenu()
    {
        Scanner sc = new Scanner(System.in);

        print("");
        print("NEW TRANSACTION");

        //Allows the user to set the date of the transaction
        print("Please enter the date of the transaction in the form dd/mm/yyyy");
        String date = sc.next();

        print("");
        promptCategory();

        print("");
        promptName();

        print("");
        promptAmount();

        confirmInfoAndStore(date);
    }

    /**
     * Prints the information the user entered, and stores the transaction in the next available slot in the array, then
     * returns to main menu
     * @param date Date of the transaction
     */
    private void confirmInfoAndStore(String date)
    {
        //Converts the amount into a currency
        NumberFormat money = NumberFormat.getCurrencyInstance();
        String amountCurrency = money.format(this.amount);

        print("");
        print("New transaction stored with the following details:");
        print("Date: " + date);
        print("Category: " + this.category);
        print("Recipient: " + this.name);
        print("Amount: " + amountCurrency);

        Transaction transaction = new Transaction(date, this.category, this.name, this.amount);

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

    /** Prints the category menu and launches the input handler */
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
        try
        {
            int selectedOption = sc.nextInt();

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
            e.printStackTrace();
            print("ERROR: Please enter a valid option");
            print("");
        }
    }

    /** Prompts the user to enter an amount for the transaction and launches the input handler */
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
        try
        {
            double amountEntered = sc.nextDouble();
            this.optionChosen = true;
            this.amount = amountEntered;
        } catch(InputMismatchException e)
        {
            e.getStackTrace();
            print("ERROR: Please enter a valid option, ensure that you are not including any currency symbols (e.g. £, $, €, etc)");
            print("");
        }
    }

    /** Prompts the user to enter a recipient for the transaction and launches the input handler */
    private void promptName()
    {
        this.optionChosen = false;

        while(!this.optionChosen)
        {
            print("Please enter the name of the recipient");

            Scanner sc = new Scanner(System.in);
            nameInputHandler(sc);
        }
    }

    /**
     * Takes the user's input, if it's non-empty will set the name to the input, otherwise prints an error and asks the
     * user to re-enter the name
     * @param sc Scanner to use
     */
    private void nameInputHandler(Scanner sc)
    {
        //Stores the whole line as the name (so that there can be spaces e.g. John Smith)
        String name = sc.nextLine().trim();

        //Makes sure the name entered is non-empty
        if(!name.equals(""))
        {
            this.name = name;
            this.optionChosen = true;
        }else
        {
            print("ERROR: Please enter a valid name");
            print("");
        }
    }
}