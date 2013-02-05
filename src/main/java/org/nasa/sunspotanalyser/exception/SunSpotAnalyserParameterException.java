package org.nasa.sunspotanalyser.exception;

/**
 * Input Parameters Sun Spot Analyser Exception.
 * 
 */
public class SunSpotAnalyserParameterException extends SunSpotAnalyserException {
	
	
	/** Serial version UID.	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Class constructor.
	 * 
	 * @param _exceptionType
	 */
	public SunSpotAnalyserParameterException(
			SunSpotAnalyserTypeExceptionType _exceptionType) {
		super(_exceptionType);
	}

	/**
	 * Method that overrides the toString method
	 * to show formatted exception information.
	 */
	public String toString(){
	    return "SunSpotAnalyserParameterException["+exceptionType.toString()+"]";
	} 
}
