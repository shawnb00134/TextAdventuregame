package edu.westga.cs3211.text_adventure_game.viewmodel;

import java.util.ArrayList;
import java.util.List;

import edu.westga.cs3211.text_adventure_game.model.Actions;
import edu.westga.cs3211.text_adventure_game.model.GameManager;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;

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
	private ListProperty<Actions> movementDirection;
	private StringProperty playerHealth;
	private ObjectProperty<Actions> selectedDirection;
	
	private GameManager gameManager;
	
	/**
	 * Empty constructor for the ViewModel
	 */
	public ViewModel() {
		this.locationDescription = new SimpleStringProperty();
		this.movementDirection = new SimpleListProperty<>(FXCollections.observableArrayList(new ArrayList<>()));
		this.playerHealth = new SimpleStringProperty();
		this.selectedDirection = new SimpleObjectProperty<Actions>();
		this.gameManager = new GameManager();
		
		this.setupGame();
	}
	
	private void setupGame() {
		this.setLocationDescriptionProperty();
		this.setMovementDirectionList();
		this.setPlayerHealthProperty();
	}
	
	/**
	 * Moves the player
	 */
	public void movePlayerGetLocatinDescription() {
		Actions selectedDirection = this.getSelectedDirection().getValue();
		if (selectedDirection == null) {
		    return;
		}
		
		if (selectedDirection == Actions.NORTH) {
		    this.gameManager.movePlayer(Actions.NORTH);
		} else if (selectedDirection == Actions.EAST) {
		    this.gameManager.movePlayer(Actions.EAST);
		} else if (selectedDirection == Actions.SOUTH) {
		    this.gameManager.movePlayer(Actions.SOUTH);
		} else if (selectedDirection == Actions.WEST) {
		    this.gameManager.movePlayer(Actions.WEST);
		}
				
		this.setLocationDescriptionProperty();
		this.setMovementDirectionList();
		this.setPlayerHealthProperty();		
	}
	
	/**
	 * Returns the location description to he view
	 * 
	 * @return locationDescription
	 */
	public StringProperty getLocationDescriptionProperty() {
		return this.locationDescription;
	}
	
	private void setLocationDescriptionProperty() {
		String description = this.gameManager.getLocationDescription();
        if (description != null) {
            this.locationDescription.set(description);
        }
	}
	
	/**
	 * Returns the 
	 * 
	 * @return movementDirection
	 */
	public ListProperty<Actions> getMovementDirectionProperty() {
		return this.movementDirection;
	}
	
	private void setMovementDirectionList() {
		List<Actions> options = this.gameManager.getMovementOptions();
        this.movementDirection.clear();
        this.movementDirection.setValue(FXCollections.observableArrayList(options));
	}
	
	/**
	 * Returns the player's health.
	 * 
	 * @return this.playerHealth
	 */
	public StringProperty getPlayerHealthProperty() {
		return this.playerHealth;
	}
	
	private void setPlayerHealthProperty() {
		this.playerHealth.set(Integer.toString(this.gameManager.getPlayerHealthPoints()));
	}
	
	/**
	 * Returns the selected direction
	 * 
	 * @return selectedDirection
	 */
	public ObjectProperty<Actions> getSelectedDirection() {
		return this.selectedDirection;
	}
}
