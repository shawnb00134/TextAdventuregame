package edu.westga.cs3211.text_adventure_game.test.testFileReader;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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
//		FileReader testRead = new FileReader("src/edu/westga/cs3211/text_adventure_game/assets/testLocations.txt", "src/edu/westga/cs3211/text_adventure_game//assets/testHazards.txt");
		FileReader testRead = new FileReader("src/edu/westga/cs3211/text_adventure_game/assets/testLocations.txt", "");
		gameLocations = testRead.getLocationMap();
		gameHazards = testRead.getHazards();
	}
	
	@Test
	public void validLocationTestNoHazardNotGoal() {
		String name = "EntryRoom";
		String description1 = "You enter a mysterious dungeon and a stone slab shuts behind you. You face South and you see you can move East or West.";
		String description2 = "You are back at the entrence. You can move East or West.";
		String[] connectedRooms = new String[] {"", "DartRoom", "", "SmokeRoom"};
		boolean hasHazard = false;
		String hazardName = "";
		boolean isGoal = false;
		Location callLocation = new Location(name, description1, description2, connectedRooms, hasHazard, hazardName, isGoal);
		
		assertEquals(callLocation.getRoomName(), gameLocations.get(name).getRoomName());
		assertEquals(callLocation.getRoomDescription(), gameLocations.get(name).getRoomDescription());
		assertEquals(callLocation.getRoomDescription(), gameLocations.get(name).getRoomDescription());
		assertEquals(callLocation.getHazardCheck(), gameLocations.get(name).getHazardCheck());
		assertEquals(callLocation.getRoomDescription(), gameLocations.get(name).getRoomDescription());
		assertEquals(callLocation.getIsGoal(), gameLocations.get(name).getIsGoal());
	}
	
	@Test
	public void validLocationTestWithHazardNoGoal() {
		String name = "SmokeRoom";
		String description1 = "You went West. You enter a large square room with holes in the floor.";
		String description2 = "The room is still filled with smoke.";
		String[] connectedRooms = new String[] {"", "EntryRoom", "", ""};
		boolean hasHazard = true;
		String hazardName = "SmokeHazard";
		boolean isGoal = false;
		Location callLocation = new Location(name, description1, description2, connectedRooms, hasHazard, hazardName, isGoal);
		
		assertEquals(callLocation.getRoomName(), gameLocations.get(name).getRoomName());
		assertEquals(callLocation.getRoomDescription(), gameLocations.get(name).getRoomDescription());
		assertEquals(callLocation.getRoomDescription(), gameLocations.get(name).getRoomDescription());
		assertEquals(callLocation.getHazardCheck(), gameLocations.get(name).getHazardCheck());
		assertEquals(callLocation.getRoomDescription(), gameLocations.get(name).getRoomDescription());
		assertEquals(callLocation.getIsGoal(), gameLocations.get(name).getIsGoal());
	}
	
	@Test
	public void validLocationNoHazardYesGoal() {
		String name = "GoalRoom";
		String description1 = "You enter a roundish room and see a cake sitting on a table in the center of the room.";
		String description2 = "You enter a roundish room and see a cake sitting on a table in the center of the room.";
		String[] connectedRooms = new String[] {"DartRoom", "", "", ""};
		boolean hasHazard = false;
		String hazardName = "";
		boolean isGoal = true;
		Location callLocation = new Location(name, description1, description2, connectedRooms, hasHazard, hazardName, isGoal);
		
		assertEquals(callLocation.getRoomName(), gameLocations.get(name).getRoomName());
		assertEquals(callLocation.getRoomDescription(), gameLocations.get(name).getRoomDescription());
		assertEquals(callLocation.getRoomDescription(), gameLocations.get(name).getRoomDescription());
		assertEquals(callLocation.getHazardCheck(), gameLocations.get(name).getHazardCheck());
		assertEquals(callLocation.getRoomDescription(), gameLocations.get(name).getRoomDescription());
		assertEquals(callLocation.getIsGoal(), gameLocations.get(name).getIsGoal());
	}
	
	@Test
	public void invalidLocationTest() {
		String name = "DartRoom";
		String description1 = "You enter a medium sized room with many alcoves.";
		String description2 = "You watch your step enter this room.";
		String[] connectedRooms = new String[] {"", "", "GoalRoom", "EntryRoom"};
		boolean hasHazard = false;
		String hazardName = "";
		boolean isGoal = true;
		Location callLocation = new Location(name, description1, description2, connectedRooms, hasHazard, hazardName, isGoal);
		
		assertNotEquals(callLocation.getRoomName(), gameLocations.get("SmokeRoom").getRoomName());
		assertNotEquals(callLocation.getRoomDescription(), gameLocations.get("SmokeRoom").getRoomDescription());
		assertNotEquals(callLocation.getRoomDescription(), gameLocations.get("SmokeRoom").getRoomDescription());
		assertNotEquals(callLocation.getHazardCheck(), gameLocations.get("SmokeRoom").getHazardCheck());
		assertNotEquals(callLocation.getRoomDescription(), gameLocations.get("SmokeRoom").getRoomDescription());
		assertNotEquals(callLocation.getIsGoal(), gameLocations.get("SmokeRoom").getIsGoal());
	}
}
