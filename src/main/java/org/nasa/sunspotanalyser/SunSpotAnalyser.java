package org.nasa.sunspotanalyser;

import java.util.List;

import org.nasa.sunspotanalyser.exception.SunSpotAnalyserException;

/**
 * Sun Spot Analyser interface.
 *
 */
public interface SunSpotAnalyser {

	/**
	 * Method that returns the Sun Spot Analyser results
	 * as a list of SunSpotAnalyserResult objects.
	 * 
	 * @param theNumberOfResults
	 * @param theSizeOfTheGrid
	 * @param listOfSpaceDelimitedNumbers
	 * @return SunSpotAnalyserResult objects list
	 * @throws SunSpotAnalyserException
	 */
	public abstract List<SunSpotAnalyserResult> getResultsAsList(String theNumberOfResults, String theSizeOfTheGrid, String listOfSpaceDelimitedNumbers) throws SunSpotAnalyserException;
	
	/**
	 * Method that returns the Sun Spot Analyser results
	 * as the following String: (x1,y1 score:heat1)(x2,y2 score:heat2)...
	 * 
	 * @param theNumberOfResults
	 * @param theSizeOfTheGrid
	 * @param listOfSpaceDelimitedNumbers
	 * @return Sun Spot Analyser string containing the results
	 * @throws SunSpotAnalyserException
	 */
	public abstract String getResultsAsString(String theNumberOfResults, String theSizeOfTheGrid, String listOfSpaceDelimitedNumbers) throws SunSpotAnalyserException;

}