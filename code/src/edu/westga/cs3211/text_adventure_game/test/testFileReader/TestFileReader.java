package edu.westga.cs3211.text_adventure_game.test.testFileReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.westga.cs3211.text_adventure_game.model.FileReader;
import edu.westga.cs3211.text_adventure_game.model.Hazard;
import edu.westga.cs3211.text_adventure_game.model.Location;

public class TestFileReader {

	private static HashMap<String, Location> gameLocations;
	private static HashMap<String, Hazard> gameHazards;
	
	@BeforeAll
	public static void init() {
		FileReader testRead = new FileReader("src/edu/westga/cs3211/text_adventure_game/assets/testLocations.txt", "src/edu/westga/cs3211/text_adventure_game//assets/testHazards.txt");
		gameLocations = testRead.getLocationMap();
		gameHazards = testRead.getHazards();
	}
	
	@Test
	public void validLocationTest() {
		String name = "EntryRoom";
		String description1 = "You enter a mysterious dungeon and a stone slab shuts behind you. You face South and you see you can move East or West.";
		String description2 = "You are back at the entrence. You can move East or West.";
		String[] connectedRooms = new String[] {"", "DartRoom", "", "SmokeRoom"};
		boolean hasHazard = false;
		String hazardName = null;
		boolean isGoal = false;
		Location callLocation = new Location(name, description1, description2, connectedRooms, hasHazard, hazardName, isGoal);
		
		assertEquals(callLocation.getRoomName(), this.gameLocations.get(name).getRoomName());
		assertEquals(callLocation.getRoomDescription(), this.gameLocations.get(name).getRoomDescription());
		assertEquals(callLocation.getRoomDescription(), this.gameLocations.get(name).getRoomDescription());
		assertEquals(callLocation.getHazardCheck(), this.gameLocations.get(name).getHazardCheck());
		assertEquals(callLocation.getRoomDescription(), this.gameLocations.get(name).getRoomDescription());
		assertEquals(callLocation.getIsGoal(), this.gameLocations.get(name).getIsGoal());
	}
}
