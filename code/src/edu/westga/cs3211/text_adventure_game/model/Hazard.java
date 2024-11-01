package edu.westga.cs3211.text_adventure_game.model;


/**
 * Text Adventure Game - Hazard Class
 * 
 * Holds all the information related to the hazard.
 * 
 * @author Shawn Bretthauer
 * @version Fall 2024
 */
public class Hazard {

	private String hazardDescription;
	private int hazardDamageValue;
	
	/**
	 * Hazard constructor that requires a description and damage value
	 * @param description the description of the hazard
	 * @param value the amount of damage the hazard does to the player
	 */
	public Hazard(String description, int value) {
		this.hazardDescription = description;
		this.hazardDamageValue = value;
	}
	
	/**
	 * The description of the hazard
	 * @return hazardDescription
	 */
	public String getHazardDescription() {
		return this.hazardDescription;
	}
	
	/**
	 * The amount of damage the hazard does to the player
	 * @return hazardDamageValue
	 */
	public int getHazardDamageValue() {
		return this.hazardDamageValue;
	}
}
