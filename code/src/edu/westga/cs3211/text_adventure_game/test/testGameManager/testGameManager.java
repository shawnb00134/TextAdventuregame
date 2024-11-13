package edu.westga.cs3211.text_adventure_game.test.testGameManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.text_adventure_game.model.Actions;
import edu.westga.cs3211.text_adventure_game.model.GameManager;
import edu.westga.cs3211.text_adventure_game.model.Hazard;
import edu.westga.cs3211.text_adventure_game.model.Location;
import edu.westga.cs3211.text_adventure_game.model.Player;

public class testGameManager {
	
	@Test
	public void testGameManagerStartingLocation() {
		String name = "EntryRoom";
		String descriptionOne = "You enter a mysterious dungeon and a stone slab shuts behind you. You face South and you see you can move East or West.";
		String descriptionTwo = "You are back at the entrence. You can move East or West.";
		String[] connectedRooms = new String[] {"","DartRoom","","SmokeRoom"};
		boolean hasHazard = false;
		boolean isGoal = false;
		
		GameManager gameManager = new GameManager();
		Location playerLocation = new Location(name, descriptionOne, descriptionTwo, connectedRooms, hasHazard, null, isGoal);
		
		assertEquals(playerLocation.getRoomDescription(), gameManager.getLocationDescription());
	}
	
//	@Test
//	public void testGameManagerPlayerMovementEast() {
//		String locationName = "SmokeRoom";
//		String descriptionOne = "You went West. You enter a large square room with holes in the floor.";
//		String descriptionTwo = "The room is still filled with smoke.";
//		String[] connectedRooms = new String[] {"","DartRoom","","SmokeRoom"};
//		boolean hasHazard = false;
//		boolean isGoal = false;
//		
//		String hazardName = "SmokeRoom";
//		String description = "The room quickly fills with smoke. You cannot see any details in the room.";
//		int damage = 0;
//		
//		
//		GameManager gameManager = new GameManager();
//		Location playerLocation = new Location(locationName, descriptionOne, descriptionTwo, connectedRooms, hasHazard, null, isGoal);
//		Hazard hazard = new Hazard(hazardName, description, damage);
//		
//		gameManager.movePlayer(Actions.WEST);
//		
//		assertEquals(hazard.getHazardDescription(), gameManager.getLocationDescription());
//	}
	
	@Test
	public void testGameManagerPlayerHealthFull() {
		GameManager gameManager = new GameManager();
		Player newPlayer = new Player();
	
		assertEquals(newPlayer.getPlayerHitPoints(), gameManager.getPlayerHealthPoints());
	}
	
	@Test
	public void testGameManagerPlayerHealthPartial() {
		GameManager gameManager = new GameManager();
		Player newPlayer = new Player();
	
		newPlayer.reducePlayerHitPoint(2);
				
		gameManager.movePlayer(Actions.EAST);
		
		assertEquals("A dart shoots out and hits you in the neck. It stung.", gameManager.getLocationDescription());
		assertEquals(newPlayer.getPlayerHitPoints(), gameManager.getPlayerHealthPoints());
	}
}
