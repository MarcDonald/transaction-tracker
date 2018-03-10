package main;

import menu.MainMenu;

/**
 * //TODO documentation
 * Main Class
 */
public class Main
{
    public static Transaction[] transactions = new Transaction[100];

    public static void main(String args[])
    {
        MainMenu mainMenu = new MainMenu();

        loadData();
        mainMenu.printMainMenu();
    }

    private static void loadData()
    {
        //TODO load data from a text file
    }
}