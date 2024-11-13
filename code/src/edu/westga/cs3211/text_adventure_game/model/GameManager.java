package edu.westga.cs3211.text_adventure_game.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Text Adventure Game - Game Manager
 * 
 * Handles all of the interactions between classes.
 * 
 * @author Shawn Bretthauer
 * @version Fall 2024
 */
public class GameManager {
	private final String gameLocationsFileLocation = "src/edu/westga/cs3211/text_adventure_game/assets/testLocations.txt";
	private final String gameHazardsFileLocation = "src/edu/westga/cs3211/text_adventure_game//assets/testHazards.txt";
	
	private final String startingLocation = "EntryRoom";
	
	private FileReader gameFiles;
	private Player player;
	private Location playerLocation;
	private Hazard locationHazard;
//	private List<String> movementOptions;
	private List<Actions> movementOptions;
	
	private HashMap<String, Location> gameLocations;
	private HashMap<String, Hazard> gameHazards;

	/**
	 * Empty GameManager constructor
	 */
	public GameManager() {
		this.player = new Player();
		this.gameFiles = new FileReader(this.gameLocationsFileLocation, this.gameHazardsFileLocation);
//		this.movementOptions = new ArrayList<String>();
		this.movementOptions = new ArrayList<Actions>();
		
		this.initializeGameManger();
	}
	
	private void initializeGameManger() {
		this.setGameLocationsHazards();
	}
	
	private void setGameLocationsHazards()  {
		this.gameLocations = this.gameFiles.getLocationMap();
		this.gameHazards = this.gameFiles.getHazards();
		
		this.playerLocation = this.gameLocations.get(this.startingLocation);
	}
	
	/**
	 * Gets the room's description to be displayed.
	 * 
	 * @return gameLocations.getRoomDescription
	 */
	public String getLocationDescription() {
		if (this.playerLocation.getHazardCheck()) {
			this.player.reducePlayerHitPoint(this.gameHazards.get(this.playerLocation.getHazardName()).getHazardDamageValue());
			return this.gameHazards.get(this.playerLocation.getHazardName()).getHazardDescription();
		}
		return this.gameLocations.get(this.playerLocation.getRoomName()).getRoomDescription();
	}
	
	/**
	 * Returns the current HP for the player.
	 * 
	 * @return player.getPlayerHitPoints
	 */
	public int getPlayerHealthPoints() {
		return this.player.getPlayerHitPoints();
	}
	
	// May not need
//	private boolean getHazard() {
//		return this.gameLocations.get(this.playerLocation.getRoomName()).getHazardCheck();
//	}
	
	/**
	 * Moves the player from one location to the next based on their choice.
	 * 
	 * @param action the chosen player actions for movement
	 */
	public void movePlayer(Actions action) {
		String[] connectedRoom = this.playerLocation.getConnectedRooms();
		if (action.equals(Actions.NORTH)) {
//			System.out.println("NORTH");
			this.playerLocation = this.gameLocations.get(connectedRoom[action.getIndexValue()]);
//			this.getLocationDescription();
		} else if (action.equals(Actions.EAST)) {
//			System.out.println("EAST");
			this.playerLocation = this.gameLocations.get(connectedRoom[action.getIndexValue()]);
//			this.getLocationDescription();
		} else if (action.equals(Actions.SOUTH)) {
//			System.out.println("SOUTH");
			this.playerLocation = this.gameLocations.get(connectedRoom[action.getIndexValue()]);
//			this.getLocationDescription();
		} else {
//			System.out.println("WEST");
			this.playerLocation = this.gameLocations.get(connectedRoom[action.getIndexValue()]);
//			this.getLocationDescription();
		}
	}
	
	/**
	 * Gets the list of all possible directions the player can move.
	 */
	public void getActionList() {
		String[] options = this.playerLocation.getConnectedRooms();
		
		for (int index = 0; index < options.length; index++) {
			if (!options[index].isBlank()) {
				
				this.movementOptions.add(Actions.getActionByIndex(index));
			}
		}
	}
	
	/**
	 * Returns the list of movement options to the ViewModel
	 * 
	 * @return movementOptions
	 */
	public List<Actions> getMovementOptions() {
		this.getActionList();
		
		return this.movementOptions;
	}
	
	/**
	 * Checks the player's current location if it is the goal.
	 * 
	 * @return true if player.getIsGoal() == true, else false
	 */
	public Boolean checkRoomForGoal() {
		return this.playerLocation.getIsGoal();
	}
}
