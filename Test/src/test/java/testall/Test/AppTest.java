package testall.Test;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    public void testBalance() {
    	String s = "{{{[[]]((()))}}}";
    	assertEquals(true, new App().balanceCheck(s));
    }
    public void testBalance1() {
    	String s = "{{{[[]]())}}}";
    	assertEquals(false, new App().balanceCheck(s));
    }
    public void testLos3() {
    	String s1 ="AGHTY";
    	String s2 ="GIUTYT";
    	String s3 ="ABHTYGH";
    	int i1 = s1.length();
    	int i2 = s2.length();
    	int i3 = s3.length();
    	assertEquals(2, new App().losOf3(s1,s2,s3,i1,i2,i3));
    	
    }
    public void testLosOf2() {
    	String s1 ="aggtab";
    	String s2 ="gxtxayb";
    	int m = s1.length();
    	int n = s2.length();
    	assertEquals(4, new App().losOf2(s1,s2,m,n));
    }
}
