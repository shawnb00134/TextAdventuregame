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

	private String roomName;
	private boolean firstTimeEntry;
	private String roomDescription1;
	private String roomDescription2;
	private String[] connectedRooms;
	private Boolean hasHazard;
	private String roomHazard;
	private Boolean isGoal;
	
	/**
	 * Standard constructor for room with needed attributes
	 * 
	 * @param name the name of the room which will be used a the key in a hashmap
	 * @param description1 the initial description of the room when the player first enters
	 * @param description2 the description of the room if the player has already been prior
	 * @param connectedRooms String array of connected rooms
	 * @param hasHazard does the room have a hazard
	 * @param hazardName the hazard attached to the room used a key
	 * @param goalStatus says if the room is the goal or not
	 */
	public Location(String name, String description1, String description2, String[] connectedRooms, Boolean hasHazard, String hazardName, Boolean goalStatus) {
		this.roomName = name;
		this.firstTimeEntry = true;
		this.roomDescription1 = description1;
		this.roomDescription2 = description2;
		this.connectedRooms = connectedRooms;
		this.hasHazard = hasHazard;
		this.roomHazard = hazardName;
		this.isGoal = goalStatus;
	}
	
	/**
	 * Gets the name of the room to use as a key
	 * 
	 * @return roomName
	 */
	public String getRoomName() {
		return this.roomName;
	}
	
	/**
	 * Returns the appropriate room description based on if the room has initially or returned
	 * 
	 * @return description1 if firstTimeEntry == true, description2 if firstTimeEntry == false
	 */
	public String getRoomDescription() {
		if (this.firstTimeEntry) {
			this.firstTimeEntry = false;
			return this.roomDescription1;
		}
		return this.roomDescription2;
	}
	
	/**
	 * Checks to see if the room has been visited for the firse time
	 * 
	 * @return firstTimeEntry
	 */
	public boolean getFirstVisit() {
		return this.firstTimeEntry;
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
	 * @return getHazardName if hasHazard is true, otherwise default description
	 */
	public String getHazardName() {
		if (this.hasHazard) {
			return this.getHazardName();
		}
//		return "No hazard present";
		return null;
	}
	
	/**
	 * Returns if the room is the goal room.
	 * 
	 * @return true if room is goal
	 */
	public boolean getIsGoal() {
		return this.isGoal;
	}
	
}
