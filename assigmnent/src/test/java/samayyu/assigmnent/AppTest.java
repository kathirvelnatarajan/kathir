package samayyu.assigmnent;

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
        assertEquals(new App().add(2, 3),5);
        
    }
   
    public void testAppString()
    {
        assertEquals("qwerty", new App().word("qwerty"));
        
    }
    public void testCountWords() {
    	String s = "testing a string";
    	assertEquals(3, new App().countWords(s));
    }
    public void testCountWords2() {
    	String s = "testing a valid string";
    	assertEquals(4, new App().countWords(s));
    }
    public void testStringArray() {
    	String s ="array of string test";
    	String[] result = new App().stringArray(s);
    	assertEquals(4, result.length);
    }
    public void testSameChar() {
    	String s ="althoughl";
    	String s1 = "thoughtherel";
    	char[] c =s.toCharArray();
    	char[] c1 = s1.toCharArray();
    	int y =c1.length;
    	int x = c.length;
    	new App();
		int result = App.sameChar(c,c1,x,y);
    	assertEquals(7, result);
    }
    public void testBalance() {
    	String s ="{{}}";
    	assertEquals(true, new App().balanceCheck(s));
    }
    public void testBalance1() {
    	String s ="{{}}((()))[[]][][]";
    	assertEquals(true, new App().balanceCheck(s));
    }
    
    public void testParan() {
    	String s = "{[[(((())))]]}";
    	assertEquals(true, new App().checkPara(s));
    }
}
