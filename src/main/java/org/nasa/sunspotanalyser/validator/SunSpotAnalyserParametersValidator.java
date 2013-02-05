package org.nasa.sunspotanalyser.validator;

import org.nasa.sunspotanalyser.exception.SunSpotAnalyserParameterException;
import org.nasa.sunspotanalyser.exception.SunSpotAnalyserTypeExceptionType;

/**
 * 
 * Sun Spot Analyser input parameters validator class.
 *
 */
public class SunSpotAnalyserParametersValidator {
	
	/** Defines the lowest heat value that the grid can store.	 */
	private static final int LOWEST_HEAT_VALUE = 0;
	/** Defines the highest heat value that the grid can store.	 */
	private static final int HIGHEST_HEAT_VALUE =5;
	/** Number of results that the analyser will return.	 */
	private static int numberOfResults;
	/** Size of the grid. */
	private static int sizeOfTheGrid;

	/**
	 * Validate input parameters method.
	 * 
	 * @param theNumberOfResults
	 * @param theSizeOfTheGrid
	 * @param spotsHeatFromListOfNumbers
	 * @throws SunSpotAnalyserParameterException
	 */
	public static void validateParameters(String theNumberOfResults,
			String theSizeOfTheGrid, String[] spotsHeatFromListOfNumbers) throws SunSpotAnalyserParameterException{
		validateEmptyInputValues(theNumberOfResults,theSizeOfTheGrid,spotsHeatFromListOfNumbers);
		
		validateIntegerValue(theNumberOfResults);
		
		validateIntegerValue(theSizeOfTheGrid);
		
		setIntegerValues(theNumberOfResults,theSizeOfTheGrid);
		
		validateNumberOfResults(spotsHeatFromListOfNumbers);
		
		validateSizeOfTheGrid(spotsHeatFromListOfNumbers);
		
		validateValuesWithinTheGrid(spotsHeatFromListOfNumbers);
		
	}
	
	/**
	 * Checks that all the input parameters contain values.
	 *  
	 * @param theNumberOfResults
	 * @param theSizeOfTheGrid
	 * @param spotsHeatFromListOfNumbers
	 * @throws SunSpotAnalyserParameterException
	 */
	private static void validateEmptyInputValues(String theNumberOfResults,
			String theSizeOfTheGrid, String[] spotsHeatFromListOfNumbers) throws SunSpotAnalyserParameterException{
		if (theNumberOfResults.isEmpty() 
				|| theSizeOfTheGrid.isEmpty()
				  || spotsHeatFromListOfNumbers[0].isEmpty())
			throw new SunSpotAnalyserParameterException(SunSpotAnalyserTypeExceptionType.EMPTY_INPUT_VALUES_EXCEPTION); 
		
	}


	/**
	 * Checks the valueToValidate String to decide
	 * if it is an Integer value.
	 *  
	 * @param valueToValidate
	 * @throws SunSpotAnalyserParameterException
	 */
	private static void validateIntegerValue(String valueToValidate) throws SunSpotAnalyserParameterException {
		if (!isInteger(valueToValidate))
			throw new SunSpotAnalyserParameterException(SunSpotAnalyserTypeExceptionType.NOT_INTEGER_VALUES_EXCEPTION);
		
	}
	
	/**
	 * Casts the String parameters to their
	 * corresponding Integer value.
	 * 
	 * @param theNumberOfResults
	 * @param theSizeOfTheGrid
	 */
	private static void setIntegerValues(String theNumberOfResults,
			String theSizeOfTheGrid) {
		numberOfResults = new Integer(theNumberOfResults);
		sizeOfTheGrid = new Integer(theSizeOfTheGrid);
		
	}

	/**
	 * Checks the number of results is lesser than
	 * the length of the array.
	 * 
	 * @param spotsHeatFromListOfNumbers
	 * @throws SunSpotAnalyserParameterException
	 */
	private static void validateNumberOfResults(String[] spotsHeatFromListOfNumbers) throws SunSpotAnalyserParameterException{
		if (numberOfResults>spotsHeatFromListOfNumbers.length)
			throw new SunSpotAnalyserParameterException(SunSpotAnalyserTypeExceptionType.NUMBER_OF_RESULTS_EXCEPTION);
		
	}

	/**
	 * Checks the size of the grid to decide if is equals 
	 * to the spots array length.
	 * 
	 * @param spotsHeatFromListOfNumbers
	 * @throws SunSpotAnalyserParameterException
	 */
	private static final void validateSizeOfTheGrid(String[] spotsHeatFromListOfNumbers) throws SunSpotAnalyserParameterException{
		int totalSizeOfTheGrid = sizeOfTheGrid * sizeOfTheGrid;
		if (totalSizeOfTheGrid!=spotsHeatFromListOfNumbers.length)
			throw new SunSpotAnalyserParameterException(SunSpotAnalyserTypeExceptionType.GRID_DIMENSIONS_EXCEPTION);
	}
	
	/**
	 * Validates the values within the grid.
	 * 
	 * @param spotsHeatFromListOfNumbers
	 * @throws SunSpotAnalyserParameterException
	 */
	private static void validateValuesWithinTheGrid(
			String[] spotsHeatFromListOfNumbers) throws SunSpotAnalyserParameterException{
		for (int spotCounter=0;spotCounter<spotsHeatFromListOfNumbers.length;spotCounter++){
			if (!isInteger(spotsHeatFromListOfNumbers[spotCounter]))
				throw new SunSpotAnalyserParameterException(SunSpotAnalyserTypeExceptionType.NOT_INTEGER_VALUES_EXCEPTION);
		    else if (outOfRange(spotsHeatFromListOfNumbers[spotCounter]))
				throw new SunSpotAnalyserParameterException(SunSpotAnalyserTypeExceptionType.VALUES_OUT_OF_RANGE_EXCEPTION);
			
		}
		
	}

	/**
	 * Casts the spotValueAsString parameter and 
	 * catch a NumberFormatException to decide whether
	 * the String is an Integer value or not.
	 *  
	 * @param spotValueAsString
	 * @return true if spotValueAsString is integer
	 */
	private static boolean isInteger(String spotValueAsString) {
		boolean isInteger = true;
		try{
			Integer spotValue = new Integer(spotValueAsString);
		}catch(NumberFormatException numberFormatException){
		   isInteger=false;
		}
		return isInteger;
		
	}
	
	/**
	 * Checks the spot value to validates if is lesser than
	 * the highest value within the range and bigger than
	 * the lowest value within the range.
	 * 
	 * @param spotValueAsString
	 * @return true-> the spotValueAsString is out of range
	 */
	private static boolean outOfRange(String spotValueAsString) {
		boolean outOfRange = false;
		Integer spotValue = new Integer(spotValueAsString);
		if (spotValue>HIGHEST_HEAT_VALUE || spotValue<LOWEST_HEAT_VALUE)
			outOfRange = true;
		return outOfRange;
	}
	
}
