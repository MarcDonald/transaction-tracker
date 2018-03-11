package main;

import menu.MainMenu;

/** Main Class */

public class Main
{
    public static Transaction[] transactions = new Transaction[100];

    public static void main(String args[])
    {
        MainMenu mainMenu = new MainMenu();
        DataManager dataManager = new DataManager();

        dataManager.loadData();
        mainMenu.printMainMenu();
    }
}