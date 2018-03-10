package test;

/** Methods for unit testing */

public class Test
{
    public Test()
    {}

    public void ckEqualsS(String message, String expected, String actual)
    {
        if(expected.equals(actual))
            System.out.println("PASS: " + message + ". Expected value was " + expected + " and the actual value was " + actual);
        else
            System.out.println("FAIL: " + message + ". Expected value was " + expected + " and the actual value was " + actual);
    }

    public void ckEqualsI(String message, int expected, int actual)
    {
        if(expected == actual)
            System.out.println("PASS: " + message + ". Expected value was " + expected + " and the actual value was " + actual);
        else
            System.out.println("FAIL: " + message + ". Expected value was " + expected + " and the actual value was " + actual);
    }

    public void ckEqualsD(String message, double expected, double actual)
    {
        if(expected == actual)
            System.out.println("PASS: " + message + ". Expected value was " + expected + " and the actual value was " + actual);
        else
            System.out.println("FAIL: " + message + ". Expected value was " + expected + " and the actual value was " + actual);
    }

    public void ckEqualsB(String message, boolean expected, boolean actual)
    {
        if(expected == actual)
            System.out.println("PASS: " + message + ". Expected value was " + expected + " and the actual value was " + actual);
        else
            System.out.println("FAIL: " + message + ". Expected value was " + expected + " and the actual value was " + actual);
    }
}
