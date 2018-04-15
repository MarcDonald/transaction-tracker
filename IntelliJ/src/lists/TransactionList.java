package lists;

import main.Main;
import main.Transaction;

/** Transaction array class */

public class TransactionList
{
    private Transaction[] transactions;
    private int size;
    private int maxSize;

    /**
     * Constructor to create a new TransactionList of max size 100
     */
    public TransactionList()
    {
        this.transactions = new Transaction[100];
        this.size = 0;
        this.maxSize = 100;
    }

    /**
     * Adds a new transaction to the next available space in the list
     * @param transaction Transaction to add
     */
    public void add(Transaction transaction)
    {
        if(this.size < this.maxSize)
        {
                this.transactions[this.size] = transaction;
                this.size++;
        }else
            Main.print("You have entered the maximum amount of transactions; new ones cannot be stored");
    }

    /**
     * Gets the transaction at a specific index in the list
     * @param index Index to check
     * @return Transaction
     */
    public Transaction getTransaction(int index)
    {
        if(index > this.maxSize)
        {
            Main.print("The number entered is larger than the maximum size of the list");
            return null;
        }

        if(isEmpty(index))
            Main.print("No transaction found at index " + index);
        return this.transactions[index];
    }

    /**
     * Checks if an index in the list is empty
     * @param index Index to check
     * @return Whether the index is empty
     */
    public boolean isEmpty(int index)
    {
        return this.transactions[index] == null;
    }

    /**
     * Current size of the list
     * @return Size of the list
     */
    public int getSize()
    {
        return size;
    }

    /**
     * Maximum size of the list
     * @return Maximum size of the list
     */
    public int getMaxSize()
    {
        return maxSize;
    }
}