package main;

import lists.TransactionList;
import menu.MainMenu;

/** Main Class */

public class Main
{
    //Contains all transactions that have been loaded in and new ones that are added
    public static TransactionList transactions;

    /**
     * Main method which loads all data from the text file and prints the main menu to the console
     * @param args Program Arguments
     */
    public static void main(String[] args)
    {
        Main.transactions = new TransactionList();
        MainMenu mainMenu = new MainMenu();
        DataManager dataManager = new DataManager();

        dataManager.loadData();
        mainMenu.printMainMenu();
    }

    /**
     * Prints a value to the console (Just System.out.println() but looks neater and is easier to type out
     * @param message Message to print to the screen
     */
    public static void print(String message)
    {
        System.out.println(message);
    }
}