package edu.westga.cs3211.text_adventure_game.test.testGameManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.westga.cs3211.text_adventure_game.model.FileReader;
import edu.westga.cs3211.text_adventure_game.model.GameManager;
import edu.westga.cs3211.text_adventure_game.model.Hazard;
import edu.westga.cs3211.text_adventure_game.model.Location;
import edu.westga.cs3211.text_adventure_game.model.Player;

public class testGameManager {
	
	private static HashMap<String, Location> gameLocations;
	private static HashMap<String, Hazard> gameHazards;
	
	@BeforeAll
	public static void init() {
		FileReader testRead = new FileReader("src/edu/westga/cs3211/text_adventure_game/assets/testLocations.txt", 
				"src/edu/westga/cs3211/text_adventure_game//assets/testHazards.txt");
		gameLocations = testRead.getLocationMap();
		gameHazards = testRead.getHazards();
	}
	
	@Test
	public void testGameManagerPlayerHealthFull() {
		GameManager gameManager = new GameManager();
		Player newPlayer = new Player();
	
		assertEquals(newPlayer.getPlayerHitPoints(), gameManager.getPlayerHealthPoints());
	}
}
