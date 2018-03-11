package test;

/** Methods for unit testing */

public class Test
{
    public Test()
    {}

    /** Check equals for String values */
    public void ckEqualsS(String message, String expected, String actual)
    {
        if(expected.equals(actual))
            System.out.println("PASS: " + message + ". Expected value was " + expected + " and the actual value was " + actual);
        else
            System.out.println("FAIL: " + message + ". Expected value was " + expected + " and the actual value was " + actual);
    }

    /** Check equals for int values */
    public void ckEqualsI(String message, int expected, int actual)
    {
        if(expected == actual)
            System.out.println("PASS: " + message + ". Expected value was " + expected + " and the actual value was " + actual);
        else
            System.out.println("FAIL: " + message + ". Expected value was " + expected + " and the actual value was " + actual);
    }

    /** Check equals for double values */
    public void ckEqualsD(String message, double expected, double actual)
    {
        if(expected == actual)
            System.out.println("PASS: " + message + ". Expected value was " + expected + " and the actual value was " + actual);
        else
            System.out.println("FAIL: " + message + ". Expected value was " + expected + " and the actual value was " + actual);
    }

    /** Check equals for boolean values */
    public void ckEqualsB(String message, boolean expected, boolean actual)
    {
        if(expected == actual)
            System.out.println("PASS: " + message + ". Expected value was " + expected + " and the actual value was " + actual);
        else
            System.out.println("FAIL: " + message + ". Expected value was " + expected + " and the actual value was " + actual);
    }
}
