package org.nasa.sunspotanalyser;

/**
 * 
 * This class will hold the sun spot analyser result.
 * 
 * It implements the Comparable interface to 
 * sort the results overriding the compareTo method.
 *
 */
public class SunSpotAnalyserResult implements Comparable<SunSpotAnalyserResult>{
	
	/**
	 * toString method start string separator.
	 */
	private static final String RESULT_START_SEPARATOR = "(";
	
	/**
	 * toString method end string separator.
	 */
	private static final String RESULT_END_SEPARATOR = ")";
	
	/**
	 * toString method x and y coords separator.
	 */
	private static final String RESULT_COORDS_SEPARATOR = ",";
	
	/**
	 * toString method score message.
	 */
	private static final String RESULT_SCORE_TXT = "score:";

	/**
	 * Sun surface X location.
	 */
	private int xLocation;
	
	/**
	 * Sun surface Y location.
	 */
	private int yLocation;
	
	/**
	 * Sun surface spot total score.
	 */
	private int score;
	
	/**
	 * Class constructor that receives coords 
	 * and a score value.
	 * 
	 * @param xValue
	 * @param yValue
	 * @param scoreValue
	 */
	public SunSpotAnalyserResult(int xValue, int yValue, int scoreValue){
		this.xLocation = xValue;
		this.yLocation = yValue;
		this.score = scoreValue;
		
	}
	
	/**
	 * X Location getter.
	 * 
	 * @return the sun surface X location.
	 */
	public final int getxLocation() {
		return xLocation;
	}

	/**
	 * Y Location getter.
	 * 
	 * @return the sun surface Y location.
	 */
	public final int getyLocation() {
		return yLocation;
	}

	/**
	 * Sun spot score getter.
	 * 
	 * @return the total score of the spot.
	 */
	public final int getScore() {
		return score;
	}

	/**
	 * Overriding compareTo method to sort
	 * the results by score.
	 * 
	 * @param result 
	 */
	@Override
	public final int compareTo(SunSpotAnalyserResult result) {
		int compareScore = result.getScore(); 
		//Descending order
		return compareScore - this.score;
 
	}
	
	 /**
	  * Overriding the toString method to show the result 
	  * as following: (x,y score: z) where x is the xLocation,
	  * y is the yLocation and z is the high score.
	  */
	@Override
	public String toString(){
		StringBuilder sunSpotAnalyserResult = new StringBuilder(RESULT_START_SEPARATOR);
		sunSpotAnalyserResult.append(xLocation);
		sunSpotAnalyserResult.append(RESULT_COORDS_SEPARATOR);
		sunSpotAnalyserResult.append(yLocation);
		sunSpotAnalyserResult.append(" ");
		sunSpotAnalyserResult.append(RESULT_SCORE_TXT);
		sunSpotAnalyserResult.append(score);
		sunSpotAnalyserResult.append(RESULT_END_SEPARATOR);
		return sunSpotAnalyserResult.toString();
		
	}
}
