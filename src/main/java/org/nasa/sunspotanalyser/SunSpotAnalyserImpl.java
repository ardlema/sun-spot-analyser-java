package org.nasa.sunspotanalyser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.nasa.sunspotanalyser.exception.SunSpotAnalyserException;
import org.nasa.sunspotanalyser.validator.SunSpotAnalyserParametersValidator;

/**
 * This class implements the SunSpotAnalyser interface.
 * 
 * It implements both getResults methods that return a
 * List of SunSpotAnalyserResult objects and a String with
 * the results.
 * 
 */
public class SunSpotAnalyserImpl implements SunSpotAnalyser {

	/** Size of the NxN grid.	 */
	private static int sizeOfTheGrid;
	/** Number of SunSpotAnalyserResults objects that returns the class.	 */
	private static int numberOfResults;
	/** String that contains the size of the grid.	 */
	private static String strSizeOfTheGrid;
	/** String that contains the size of the grid.	 */
	private static String strNumberOfResults;
	/** List of numbers to fill the grid.	 */
	private static String spaceDelimitedListOfNumbers;
	
	/** Initial x and y coord constant.	 */
	private static final int INITIAL_X_Y_COORD = 0;
	
	/** List that contains N SunSportAnalyserResults, where  N is the numberOfResults.	 */
	private List<SunSpotAnalyserResult> finalSpotsResultsList;
	/** Auxiliar list that stores all the SunSportAnalyserResults. */
	private List<SunSpotAnalyserResult> allSpotsResultList;
	/** Bidimensional array that holds the SunSpots grid. */
	private SunSpot[][] gridOfSpots;

	
	/**
	 * @see SunSpotAnalyser#getResultsAsList
	 * 
	 */
	public final List<SunSpotAnalyserResult> getResultsAsList(String theNumberOfResults, String theSizeOfTheGrid, String listOfSpaceDelimitedNumbers) throws SunSpotAnalyserException{
		initializeValues(theNumberOfResults,theSizeOfTheGrid,listOfSpaceDelimitedNumbers);
		
		SunSpotAnalyserParametersValidator.validateParameters(strNumberOfResults,strSizeOfTheGrid,getSpotsHeatFromListOfNumbers());
		
	    setIntegerInputParameters();
	    
	    addSpotsToTheGrid(getSpotsHeatFromListOfNumbers());
	    
	    calculateScoreOfTheSpotsAndAddValuesToSpotsResultList();
		
	    sortAllSpotsResultList();
	    
	    addResultsToFinalSpotsResultsList();
			
		return finalSpotsResultsList;
	}
	
	/**
	 * @see SunSpotAnalyser#getResultsAsString
	 */
	public String getResultsAsString(String theNumberOfResults, String theSizeOfTheGrid, String listOfSpaceDelimitedNumbers) throws SunSpotAnalyserException {
		StringBuilder resultsAsString = new StringBuilder();
		if (finalSpotsResultsList==null)		
				getResultsAsList(theNumberOfResults, theSizeOfTheGrid, listOfSpaceDelimitedNumbers);
		for (SunSpotAnalyserResult result: finalSpotsResultsList)
			resultsAsString.append(result.toString());
		return resultsAsString.toString();
		
	}
	
	/**
	 * Class values initialization.
	 * 
	 * @param theNumberOfResults
	 * @param theSizeOfTheGrid
	 * @param listOfSpaceDelimitedNumbers
	 */
	private void initializeValues(String theNumberOfResults, String theSizeOfTheGrid, String listOfSpaceDelimitedNumbers){
		strNumberOfResults = theNumberOfResults;
		strSizeOfTheGrid = theSizeOfTheGrid;
		spaceDelimitedListOfNumbers = listOfSpaceDelimitedNumbers;
		allSpotsResultList = new ArrayList<SunSpotAnalyserResult>();
		finalSpotsResultsList = new ArrayList<SunSpotAnalyserResult>();
	}
	
	/**
	 * Set the integer input parameters.
	 */
	private void setIntegerInputParameters() {
		numberOfResults=new Integer(strNumberOfResults);
		sizeOfTheGrid=new Integer(strSizeOfTheGrid);
		gridOfSpots = new SunSpot[sizeOfTheGrid][];
		
	}

	/**
	 * This method adds all the spots to the NxN grid.
	 * 
	 * @param spotsHeatValuesArray
	 */
	private final void addSpotsToTheGrid(String[] spotsHeatValuesArray) {
		int spotsHeatValuesArrayCount = 0;
		for (int row=INITIAL_X_Y_COORD;row<sizeOfTheGrid;row++){
			gridOfSpots[row] = new SunSpot[sizeOfTheGrid];
			for (int column=INITIAL_X_Y_COORD;column<sizeOfTheGrid;column++){
				SunSpot spot = new SunSpot(row,column,spotsHeatValuesArray[spotsHeatValuesArrayCount]);
				gridOfSpots[row][column] = spot;
				spotsHeatValuesArrayCount++;
			}
		}
	}
	
	/**
	 * This method calculate the total score of all the spots
	 * and add these results to the allSpotsResultList.
	 */
	private final void calculateScoreOfTheSpotsAndAddValuesToSpotsResultList(){
		for (int row=INITIAL_X_Y_COORD;row<sizeOfTheGrid;row++){
			for (int column=INITIAL_X_Y_COORD;column<sizeOfTheGrid;column++){
				SunSpotAnalyserResult result = new SunSpotAnalyserResult(row,column,calculateSpotScore(row,column));
				allSpotsResultList.add(result);
		
			}
		}
	}
	
	/**
	 * Method that sorts the allSpotsResultList calling
	 * the Collections sort method as the SunSpotAnalyserResult 
	 * class implements Comparable interface. 
	 */
	private final void sortAllSpotsResultList() {
		Collections.sort(allSpotsResultList);
	}
	
	/**
	 * Method that adds N results to the finalSpotsResultsList
	 * where N is the numberOfResults variable.
	 */
	private final void addResultsToFinalSpotsResultsList() {
		for (int result=0;result<numberOfResults;result++){
			finalSpotsResultsList.add(allSpotsResultList.get(result));
		}
	}
	
	/**
	 * This method returns a String array that
	 * will contain the spots heat.
	 * 
	 * @return String[] spots heat
	 */
	private final String[] getSpotsHeatFromListOfNumbers() {
		return spaceDelimitedListOfNumbers.split(" ");
		
	}

	/**
	 * This method works out the score of a specific spot
	 * by looping its surrounded spots.
	 * 
	 * @param row of the spot
	 * @param column of the spot
	 * @return score of the spot
	 */
	private final int calculateSpotScore(int row, int column){
		int scoreOfTheSpot = 0;
	    for (int rowPointer = -1; rowPointer <= 1; ++rowPointer) {
	      for (int columnPointer = -1; columnPointer <= 1; ++columnPointer) {
	    	int neighbourX = rowPointer+row;
	    	int neighbourY = columnPointer+column;
	        if (isInRange(neighbourX, neighbourY))
	        	scoreOfTheSpot += gridOfSpots[neighbourX][neighbourY].getHeat();
	      }
	    }
	    return scoreOfTheSpot;
	}
	
	/**
	 * This method checks whether a spot
	 * is in the range of the grid or not.
	 * 
	 * @param column of the spot
	 * @param row of the spot
	 * @return true->column and row are in range
	 */
	private final boolean isInRange(int column, int row) {
		boolean isInRange = true;
	    if (!inRange(column) || !inRange(row))
	      return false;
	    return isInRange; 
	  }
	
	/**
	 * Checks if a value is in the range
	 * of the grid.
	 * 
	 * @param value to check
	 * @return true->the value is in range
	 */
	private final boolean inRange(int value){
		boolean inRange=true;
		if (value<INITIAL_X_Y_COORD || value==sizeOfTheGrid)
		    inRange=false;
		return inRange;
	}

}
