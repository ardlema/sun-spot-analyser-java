package org.nasa.sunspotanalyser.exception;

/**
 * Sun Spot Analyser generic exception.
 * 
 */
public class SunSpotAnalyserException extends Exception {
	
	/** Serial Version UID.	 */
	private static final long serialVersionUID = 1L;
	
	/** Exception type.  */
	SunSpotAnalyserTypeExceptionType exceptionType;
	
	/**
	 * Sun Spot Analyser Exception constructor.
	 */
	public SunSpotAnalyserException() {
		super();
	}

	/**
	 * Sun Spot Analyser Exception constructor.
	 * @param _exceptionType
	 */
	public SunSpotAnalyserException(
			SunSpotAnalyserTypeExceptionType _exceptionType) {
		exceptionType = _exceptionType;
	}
	
	/**
	 * Exception type getter.
	 * 
	 * @return the exception type
	 */
	public SunSpotAnalyserTypeExceptionType getExceptionType(){
		return exceptionType;
	}
	
}
