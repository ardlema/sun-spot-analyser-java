package org.nasa.sunspotanalyser.exception;

/**
 * 
 * Contains all the Sun Spot Analyser exception types.
 *
 */
public enum SunSpotAnalyserTypeExceptionType {

		/** GRID_DIMENSIONS_EXCEPTION. */
		GRID_DIMENSIONS_EXCEPTION ("The number of grid elements is not correct."),
		
		/** VALUES_OUT_OF_RANGE_EXCEPTION. */
		NOT_INTEGER_VALUES_EXCEPTION ("Some values are not integer."),
		
		/** VALUES_OUT_OF_RANGE_EXCEPTION. */
		VALUES_OUT_OF_RANGE_EXCEPTION ("Some values are out of range (0-5)."),
		
		/** NUMBER_OF_RESULTS_EXCEPTION. */
		NUMBER_OF_RESULTS_EXCEPTION ("The number of results is greater than the number of elements."),
		
		/** EMPTY_INPUT_VALUES_EXCEPTION. */
		EMPTY_INPUT_VALUES_EXCEPTION ("Some of the input values are empty."),;
		
		/** The description of the exception. */
		private String description;
		
		/**
		 * SunSpotAnalyserExceptionType 
		 *
		 * @param exceptionDescription
		 */
		private SunSpotAnalyserTypeExceptionType(String exceptionDescription) {
			this.description = exceptionDescription;
		}
		
		/** 
		 * Override toString() method to return description.
		 * 
		 * @return description
		 */
		@Override
		public String toString() {
			return this.description;
		}
		

}
