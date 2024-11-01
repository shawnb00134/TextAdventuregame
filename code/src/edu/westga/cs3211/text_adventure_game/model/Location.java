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

	private boolean firstTimeEntry;
	private String roomDescription1;
	private String roomDescription2;
	private String[] connectedRooms;
	private Boolean hasHazard;
	private Hazard roomHazard;
	private Boolean isGoal;
	
	/**
	 * Standard constructor for room with needed attributes
	 * 
	 * @param description1 the initial description of the room when the player first enters
	 * @param description2 the description of the room if the player has already been prior
	 * @param connectedRooms String array of connected rooms
	 * @param hasHazard does the room have a hazard
	 * @param hazard the hazard attached to the room
	 * @param goalStatus says if the room is the goal or not
	 */
	public Location(String description1, String description2, String[] connectedRooms, Boolean hasHazard, Hazard hazard, Boolean goalStatus) {
		this.firstTimeEntry = true;
		this.roomDescription1 = description1;
		this.roomDescription2 = description2;
		this.connectedRooms = connectedRooms;
		this.hasHazard = hasHazard;
		this.roomHazard = hazard;
		this.isGoal = goalStatus;
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
