package edu.westga.cs3211.text_adventure_game.model;

/**
 * Text Adventure Game - Location Class
 * 
 * Holds all the information related to the location.
 * 
 * @author Shawn Bretthauer
 * @version Fall 2024
 */
public class Location {

	private Hazard roomHazard;
	private Boolean hasHazard;
	
	/**
	 * Basic Location constructor with no hazards by default.
	 */
	public Location() {
		this.hasHazard = false;
	}
	
	/**
	 * Constructor for Location possibly with a hazard.
	 * 
	 * @param hasHazard true if room has hazard, otherwise false
	 */
	public Location(Boolean hasHazard) {
		this.roomHazard = new Hazard();
		this.hasHazard = hasHazard;
	}
	
	/**
	 * Checks to see if the room does or does not have a hazard attached.
	 * 
	 * @return true if hazard, otherwise false
	 */
	public Boolean getHazardCheck() {
		return this.hasHazard;
	}
	
	/**
	 * Gets the description of the hazard if one is there. If no hazard is in the room
	 * then a default message will be sent back.
	 *  
	 * @return hazardDescription if hasHazard is true, otherwise default description
	 */
	public String getHazardDescription() {
		//TODO: implement hazard description
		return null;
	}
	
	/**
	 * Gets the hazard damage value if a hazard is in the room. If no hazard if in the room
	 * then it will not affect the player.
	 * 
	 * @return hazardDamageValue if hasHazard is true, otherwise return 0
	 */
	public int getHazardDamageValue() {
		//TODO: implement hazard damage
		return 0;
	}
}
