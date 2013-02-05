package org.nasa.sunspotanalyser;

/**
 * 
 * This class holds the sun spot data.
 * 
 *
 */
public class SunSpot {
	
	/**
	 * X coord. location.
	 */
	private int xCoord;
	
	/**
	 * Y coord. location.
	 */
    private int yCoord;
    
    /**
     * Heat value.
     */
	private int heat;
		
	
	/**
	 * Class constructor.
	 * 
	 * @param x
	 * @param y
	 * @param _heat
	 */
	public SunSpot(int x, int y, String _heat){
		this.xCoord = x;
		this.yCoord = y;
		this.heat = new Integer(_heat);
		
	}

	/**
	 * X coord getter.
	 * 
	 * @return the x location
	 */
	public final int getxCoord() {
		return xCoord;
	}

	/**
	 * Y coord getter.
	 * 
	 * @return the y location
	 */
	public final int getyCoord() {
		return yCoord;
	}

	/**
	 * Heat value getter.
	 * 
	 * @return the heat value
	 */
	public final int getHeat() {
		return heat;
	}

	
}
