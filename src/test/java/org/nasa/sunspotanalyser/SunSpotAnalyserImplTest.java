package org.nasa.sunspotanalyser;
import java.util.List;

import org.nasa.sunspotanalyser.SunSpotAnalyser;
import org.nasa.sunspotanalyser.SunSpotAnalyserImpl;
import org.nasa.sunspotanalyser.SunSpotAnalyserResult;
import org.nasa.sunspotanalyser.exception.SunSpotAnalyserException;
import org.nasa.sunspotanalyser.exception.SunSpotAnalyserTypeExceptionType;


import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * 
 * Sun Spot Analyser implementation
 * test case.
 *
 */
public class SunSpotAnalyserImplTest extends TestCase {

	//Test strings
    private static String grid3x3List;
    
    private static String grid4x4List;
    
    private static String grid5x5List;
    
    private static String grid3x3NotIntegerValuesList;
    
    private static String grid3x3OutOfRangeValuesList;
    
    private static String grid4x4OutOfRangeValuesList;
    
    /**
     * Constructs a SunSpotAnalyserNASATest with the specified name.
     * 
     * @param name Test case name.
     */
    public SunSpotAnalyserImplTest(String name) {
        super(name);
    }

    /**
     * Sets up the test fixture.
     * 
     */
    protected void setUp() {
    	
    	//Sets up the grids values
    	grid3x3List = "4 2 3 2 2 1 3 2 1";
    	
    	grid4x4List = "2 3 2 1 4 4 2 0 3 4 1 1 2 3 4 4";
    	
    	grid5x5List = "5 3 1 2 0 4 1 1 3 2 2 3 2 4 3 0 2 3 3 2 1 0 2 4 3";
    	
    	grid3x3NotIntegerValuesList = "4 2 3 x 2 1 y 2 1";
    	
    	grid3x3OutOfRangeValuesList = "2 2 15 0 2 1 3 2 1";
    	
    	grid4x4OutOfRangeValuesList = "2 3 2 -3 4 4 2 0 3 4 1 1 2 3 4 4";
    	       
    }

    /**
     * Tears down the test fixture.
     * 
     */
    protected void tearDown() {
    	
    }

    /**
     * Tests the number of results for a 3x3 grid with 1 result.
     */
    public void testNumberOfResultsFor3X3GridWithOneResult() {

        SunSpotAnalyser ssA = new SunSpotAnalyserImpl();
        
        List<SunSpotAnalyserResult> results;
		try {
			results = ssA.getResultsAsList("1","3",grid3x3List);
			assertEquals("The number of results should be 1",results.size(),1);
		} catch (SunSpotAnalyserException e) {
			Assert.fail();
		}

        
    }
    
    /**
     * Tests the number of results for a 4x4 grid with 3 result.
     */
    public void testNumberOfResultsFor4X4GridWithThreeResults() {

        SunSpotAnalyser ssA = new SunSpotAnalyserImpl();
        
        List<SunSpotAnalyserResult> results;
		try {
			results = ssA.getResultsAsList("3","4",grid4x4List);
			assertEquals("The number of results should be 3",results.size(),3);
		} catch (SunSpotAnalyserException e) {
			Assert.fail();
		}

        
    }
    
    /**
     * Tests the number of results for a 5x5 grid with 0 results.
     */
    public void testNumberOfResultsFor5X5GridWithZeroResults() {

        SunSpotAnalyser ssA = new SunSpotAnalyserImpl();
        
        List<SunSpotAnalyserResult> results;
		try {
			results = ssA.getResultsAsList("0","5",grid5x5List);
			assertEquals("The number of results should be 0",results.size(),0);
		} catch (SunSpotAnalyserException e) {
			Assert.fail();
		}

        
    }
    
    
    
    /**
     * Tests the X and Y coords high scores for a 3x3 grid with 1 result.
     */
    public void testHighScoreXAndYCoordsFor3X3GridWithOneResult() {

        SunSpotAnalyser ssA = new SunSpotAnalyserImpl();
        
        List<SunSpotAnalyserResult> results;
		try {
			results = ssA.getResultsAsList("1","3",grid3x3List);
			SunSpotAnalyserResult result = results.get(0);
		    assertEquals("The high score X coord should be 1",result.getxLocation(),1);
		    assertEquals("The high score Y coord should be 1",result.getxLocation(),1);
		} catch (SunSpotAnalyserException e) {
			Assert.fail();
		}

       
        
    }
    
    /**
     * Tests the X and Y coords high scores for a 4x4 grid with 3 results.
     */
    public void testHighScoresXAndYCoordsFor4X4GridWithThreeResults() {

        SunSpotAnalyser ssA = new SunSpotAnalyserImpl();
        
        List<SunSpotAnalyserResult> results;
		try {
			results = ssA.getResultsAsList("3","4",grid4x4List);
	        SunSpotAnalyserResult firstResult = results.get(0);
	        assertEquals("The first high score X coord should be 2",firstResult.getxLocation(),2);
	        assertEquals("The first high score Y coord should be 1",firstResult.getyLocation(),1);
	        SunSpotAnalyserResult secondResult = results.get(1);
	        assertEquals("The second high score X coord should be 1",secondResult.getxLocation(),1);
	        assertEquals("The second high score Y coord should be 1",secondResult.getyLocation(),1);
	        SunSpotAnalyserResult thirdResult = results.get(2);
	        assertEquals("The third high score X coord should be 2",thirdResult.getxLocation(),2);
	        assertEquals("The third high score Y coord should be 2",thirdResult.getyLocation(),2);
	 
		} catch (SunSpotAnalyserException e) {
			Assert.fail();
		}

       
    }
    
    /**
     * Tests the X and Y coords high scores for a 5x5 grid with 2 results.
     */
    public void testHighScoresXAndYCoordsFor5X5GridWithTwoResults() {

        SunSpotAnalyser ssA = new SunSpotAnalyserImpl();
        
        List<SunSpotAnalyserResult> results;
		try {
			results = ssA.getResultsAsList("2","5",grid5x5List);
	        SunSpotAnalyserResult firstResult = results.get(0);
	        assertEquals("The high score X coord should be 3",firstResult.getxLocation(),3);
	        assertEquals("The high score Y coord should be 3",firstResult.getyLocation(),3);
	        SunSpotAnalyserResult secondResult = results.get(1);
	        assertEquals("The high score X coord should be 2",secondResult.getxLocation(),2);
	        assertEquals("The high score Y coord should be 3",secondResult.getyLocation(),3);

		} catch (SunSpotAnalyserException e) {
			Assert.fail();
		}

        
    }
    
    
    
    /**
     * Tests the high score for a 3x3 grid with 1 results.
     */
    public void testHighScoreFor3X3GridWithOneResult() {

        SunSpotAnalyser ssA = new SunSpotAnalyserImpl();
        
        List<SunSpotAnalyserResult> results;
		try {
			results = ssA.getResultsAsList("1","3",grid3x3List);
			SunSpotAnalyserResult result = results.get(0);
		     assertEquals("The high score should be 20",result.getScore(),20);
		} catch (SunSpotAnalyserException e) {
			 Assert.fail();
		}

       
    }
    
    /**
     * Tests the high scores for a 4x4 grid with 3 results.
     */
    public void testHighScoresFor4X4GridWithThreeResults() {

        SunSpotAnalyser ssA = new SunSpotAnalyserImpl();
        
        List<SunSpotAnalyserResult> results;
		try {
			results = ssA.getResultsAsList("3","4",grid4x4List);
			SunSpotAnalyserResult firstResult = results.get(0);
	        assertEquals("The first high score should be 27",firstResult.getScore(),27);
	        SunSpotAnalyserResult secondResult = results.get(1);
	        assertEquals("The second high score should be 25",secondResult.getScore(),25);
	        SunSpotAnalyserResult thirdResult = results.get(2);
	        assertEquals("The third high score should be 23",thirdResult.getScore(),23);
	    
		} catch (SunSpotAnalyserException e) {
			Assert.fail();
		}

        }
    
    /**
     * Tests the high scores for a 5x5 grid with 1 result.
     */
    public void testHighScoresFor5X5GridWithOneResult() {

        SunSpotAnalyser ssA = new SunSpotAnalyserImpl();
        
        List<SunSpotAnalyserResult> results;
		try {
			results = ssA.getResultsAsList("1","5",grid5x5List);
	        SunSpotAnalyserResult result = results.get(0);
	        assertEquals("The high score should be 26",result.getScore(),26);
		} catch (SunSpotAnalyserException e) {
			Assert.fail();
		}

       
    }
    
    /**
     * Tests the SunSpotAnalyserNASAImpl toString override 
     * method for a 3x3 grid with 1 result.
     */
    public void testResultsAsStringFor3X3GridWithOneResult() {

        SunSpotAnalyser ssA = new SunSpotAnalyserImpl();
        
        
		try {
			String results = ssA.getResultsAsString("1","3",grid3x3List);
			assertEquals("The toString() method sould returns (1,1 score:20)",results,"(1,1 score:20)");
	   
		} catch (SunSpotAnalyserException e) {
			Assert.fail();
		}

         }
    
    /**
     * Tests the ResultsAsStringMethod of the SunSpotAnalyser.
     */
    public void testResultsAsStringFor4X4GridWithThreeResults() {

        SunSpotAnalyser ssA = new SunSpotAnalyserImpl();
              
        
		
        try {
			String results = ssA.getResultsAsString("3","4",grid4x4List);
			assertEquals("The toString() method sould returns (2,1 score:27)(1,1 score:25)(2,2 score:23)",results,"(2,1 score:27)(1,1 score:25)(2,2 score:23)");
	   
		} catch (SunSpotAnalyserException e) {
			Assert.fail();
		}

         
    }
    
    /**
     * Tests the GRID_DIMENSIONS_EXCEPTION.
     */
    public void testGridParameterExceptionFor4X4Grid() {

        SunSpotAnalyser ssA = new SunSpotAnalyserImpl();
        
        
        List<SunSpotAnalyserResult> results;
		
        try {
			results = ssA.getResultsAsList("3","2",grid4x4List);
	      
		} catch (SunSpotAnalyserException e) {
			assertEquals("The catched exception should be GRID_DIMENSIONS_EXCEPTION ",e.getExceptionType(),SunSpotAnalyserTypeExceptionType.GRID_DIMENSIONS_EXCEPTION);
		}
        
    }
    
    /**
     * Tests the NOT_INTEGER_VALUES_EXCEPTION.
     */
    public void testNotIntegerValuesListExceptionFor3X3Grid() {

        SunSpotAnalyser ssA = new SunSpotAnalyserImpl();
        
        
        List<SunSpotAnalyserResult> results;
		
        try {
			results = ssA.getResultsAsList("1","3",grid3x3NotIntegerValuesList);
	      
		} catch (SunSpotAnalyserException e) {
			assertEquals("The catched exception should be NOT_INTEGER_VALUES_EXCEPTION ",e.getExceptionType(),SunSpotAnalyserTypeExceptionType.NOT_INTEGER_VALUES_EXCEPTION);
			
		}
    }
    
    /**
     * Tests the VALUES_OUT_OF_RANGE_EXCEPTION.
     */
    public void testValuesOutOfRangeListExceptionFor3X3Grid() {

        SunSpotAnalyser ssA = new SunSpotAnalyserImpl();
   
        
        List<SunSpotAnalyserResult> results;
		
        try {
			results = ssA.getResultsAsList("1","3",grid3x3OutOfRangeValuesList);
	      
		} catch (SunSpotAnalyserException e) {
			assertEquals("The catched exception should be VALUES_OUT_OF_RANGE_EXCEPTION ",e.getExceptionType(),SunSpotAnalyserTypeExceptionType.VALUES_OUT_OF_RANGE_EXCEPTION);
			
		}
    }
    
    /**
     * Tests the VALUES_OUT_OF_RANGE_EXCEPTION.
     */
    public void testValuesOutOfRangeListExceptionFor4X4Grid() {

        SunSpotAnalyser ssA = new SunSpotAnalyserImpl();
        
        
        List<SunSpotAnalyserResult> results;
		
        try {
			results = ssA.getResultsAsList("1","4",grid4x4OutOfRangeValuesList);
	      
		} catch (SunSpotAnalyserException e) {
			assertEquals("The catched exception should be VALUES_OUT_OF_RANGE_EXCEPTION ",e.getExceptionType(),SunSpotAnalyserTypeExceptionType.VALUES_OUT_OF_RANGE_EXCEPTION);
			
		}
    }
    
    /**
     * Tests the NUMBER_OF_RESULTS_EXCEPTION.
     */
    public void testNumberOfResultsGreaterThanNumberOfElementsFor3X3Grid() {

        SunSpotAnalyser ssA = new SunSpotAnalyserImpl();
        
        
        List<SunSpotAnalyserResult> results;
		
        try {
			results = ssA.getResultsAsList("20","4",grid3x3List);
	      
		} catch (SunSpotAnalyserException e) {
			assertEquals("The catched exception should be NUMBER_OF_RESULTS_EXCEPTION ",e.getExceptionType(),SunSpotAnalyserTypeExceptionType.NUMBER_OF_RESULTS_EXCEPTION);
			
		}
    }
    
    /**
     * Tests the EMPTY_INPUT_VALUES_EXCEPTION.
     */
    public void testEmptyNumberOfElementsFor3X3Grid() {

        SunSpotAnalyser ssA = new SunSpotAnalyserImpl();
        
        
        List<SunSpotAnalyserResult> results;
		
        try {
			results = ssA.getResultsAsList("","3",grid3x3List);
	      
		} catch (SunSpotAnalyserException e) {
			assertEquals("The catched exception should be EMPTY_INPUT_VALUES_EXCEPTION ",e.getExceptionType(),SunSpotAnalyserTypeExceptionType.EMPTY_INPUT_VALUES_EXCEPTION);
			
		}
    }
    
    /**
     * Tests the EMPTY_INPUT_VALUES_EXCEPTION.
     */
    public void testEmptySizeOfTheGridFor3X3Grid() {

        SunSpotAnalyser ssA = new SunSpotAnalyserImpl();
        
        
        List<SunSpotAnalyserResult> results;
		
        try {
			results = ssA.getResultsAsList("2","",grid3x3List);
	      
		} catch (SunSpotAnalyserException e) {
			assertEquals("The catched exception should be EMPTY_INPUT_VALUES_EXCEPTION ",e.getExceptionType(),SunSpotAnalyserTypeExceptionType.EMPTY_INPUT_VALUES_EXCEPTION);
			
		}
    }
    
    /**
     * Tests the EMPTY_INPUT_VALUES_EXCEPTION.
     */
    public void testEmptyListOfNumbers3X3Grid() {

        SunSpotAnalyser ssA = new SunSpotAnalyserImpl();
        
        
        List<SunSpotAnalyserResult> results;
		
        try {
			results = ssA.getResultsAsList("2","3","");
	      
		} catch (SunSpotAnalyserException e) {
			assertEquals("The catched exception should be EMPTY_INPUT_VALUES_EXCEPTION ",e.getExceptionType(),SunSpotAnalyserTypeExceptionType.EMPTY_INPUT_VALUES_EXCEPTION);
			
		}
    }
    
 

    /**
     * Assembles and returns a test suite for
     * all the test methods of this test case.
     * @return A non-null test suite.
     */
    public static Test suite() {

        TestSuite suite = new TestSuite(SunSpotAnalyserImplTest.class);

        return suite;
    }

    /**
     * Runs the test case.
     */
    public static void main(String args[]) {
    	junit.textui.TestRunner.run(suite());
    }
}
