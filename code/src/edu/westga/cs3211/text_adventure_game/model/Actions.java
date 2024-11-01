package edu.westga.cs3211.text_adventure_game.model;

/**
 * Text Adventure Game - Action Enum
 * 
 * Lists all possible actions available in Text Adventure Game
 * 
 * @author Shawn Bretthauer
 * @version Fall 2024
 */
public enum Actions {
	NORTH("MOVE NORTH"),
	SOUTH("MOVE SOUTH"),
	EAST("MOVE EAST"),
	WEST("MOVE WEST");
		
	private String action;
	
	Actions(String action) {
		this.action = action;
	}
	
	/**
	 * Returns a single string for the action available.
	 * @return action
	 */
	public String toString() {
		return this.action;
	}
}
