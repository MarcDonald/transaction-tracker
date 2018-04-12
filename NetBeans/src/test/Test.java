package test;

/** Methods for unit testing */

class Test
{
    Test()
    {}

    /** Check equals for String values */
    void ckEqualsS(String message, String expected, String actual)
    {
        if(expected.equals(actual))
            System.out.println("PASS: " + message + ". Expected value was " + expected + " and the actual value was " + actual);
        else
            System.out.println("FAIL: " + message + ". Expected value was " + expected + " and the actual value was " + actual);
    }

    /** Check equals for int values */
    void ckEqualsI(String message, int expected, int actual)
    {
        if(expected == actual)
            System.out.println("PASS: " + message + ". Expected value was " + expected + " and the actual value was " + actual);
        else
            System.out.println("FAIL: " + message + ". Expected value was " + expected + " and the actual value was " + actual);
    }

    /** Check equals for double values */
    void ckEqualsD(String message, double expected, double actual)
    {
        if(expected == actual)
            System.out.println("PASS: " + message + ". Expected value was " + expected + " and the actual value was " + actual);
        else
            System.out.println("FAIL: " + message + ". Expected value was " + expected + " and the actual value was " + actual);
    }

    /** Check equals for boolean values */
    void ckEqualsB(String message, boolean expected, boolean actual)
    {
        if(expected == actual)
            System.out.println("PASS: " + message + ". Expected value was " + expected + " and the actual value was " + actual);
        else
            System.out.println("FAIL: " + message + ". Expected value was " + expected + " and the actual value was " + actual);
    }

    /** Check equals for null values */
    void ckEqualsN(String message, Object expected, Object actual)
    {
        if(expected == actual)
            System.out.println("PASS: " + message + ". Expected value was " + expected + " and the actual value was " + actual);
        else
            System.out.println("FAIL: " + message + ". Expected value was " + expected + " and the actual value was " + actual);
    }
}
