package edu.westga.cs3211.text_adventure_game.viewmodel;

import java.util.ArrayList;
import java.util.List;

import edu.westga.cs3211.text_adventure_game.model.GameManager;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Text Adventure Game - ViewModel
 * 
 * Binds the GameManager and the MainWindow
 * 
 * @author Shawn Bretthauer
 * @version Fall 2024
 */
public class ViewModel {
	
	private StringProperty locationDescription;
	private List<SimpleStringProperty> movementDirection;
	private IntegerProperty playerHealth;
	
	private GameManager gameManager;
	
	/**
	 * Empty constructor for the ViewModel
	 */
	public ViewModel() {
		this.locationDescription = new SimpleStringProperty();
		this.movementDirection = new ArrayList<SimpleStringProperty>();
		this.playerHealth = new SimpleIntegerProperty();
		this.gameManager = new GameManager();
	}
	
	/**
	 * Returns the location description to he view
	 * 
	 * @return locationDescription
	 */
	public StringProperty getLocationDescriptionProperty() {
		return this.locationDescription;
	}
	
	/**
	 * Returns the 
	 * 
	 * @return movementDirection
	 */
	public List<SimpleStringProperty> getMovementDirectionProperty() {
		return this.movementDirection;
	}
	
	private void setMovementDirectionList() {
		List<String> movementDirections = this.gameManager.getMovementOptions();
		
		for (String direction : movementDirections) {
			if (direction != null && !direction.isBlank()) {
				StringProperty directionProperty = new SimpleStringProperty();
				directionProperty.set(direction);
				this.movementDirection.add((SimpleStringProperty) directionProperty);
			}
		}
	}
	
	/**
	 * Returns the player's health.
	 * 
	 * @return this.playerHealth
	 */
	public IntegerProperty getPlayerHealthProperty() {
		return this.playerHealth;
	}
	
	private void setPlayerHealthProperty() {
		this.playerHealth.set(this.gameManager.getPlayerHealthPoints());
	}
}
