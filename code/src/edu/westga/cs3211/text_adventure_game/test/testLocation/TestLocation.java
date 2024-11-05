package edu.westga.cs3211.text_adventure_game.test.testLocation;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.text_adventure_game.model.Location;

public class TestLocation {

	@Test
	public void validLocationTest() {
		String name = "Room1";
		String descriptionOne = "Round";
		String descriptionTwo = "Stil round";
		String[] connectedRooms = new String[] {"Room1","","Room3",""};
		boolean hasHazard = false;
		boolean isGoal = false;
		Location testLocation = new Location(name, descriptionOne, descriptionTwo, connectedRooms, hasHazard, null, isGoal);
		
		assertEquals(name, testLocation.getRoomName());
		assertEquals(descriptionOne, testLocation.getRoomDescription());
		assertEquals(descriptionTwo, testLocation.getRoomDescription());
		assertEquals(connectedRooms, testLocation.getConnectedRooms());
		assertEquals(hasHazard, testLocation.getHazardCheck());
		assertNull(testLocation.getHazardName());
		assertEquals(isGoal, testLocation.getIsGoal());
	}
	
	@Test
	public void invalidLocationTest() {
		String name = "Room1";
		String descriptionOne = "Round";
		String descriptionTwo = "Stil round";
		String[] connectedRooms = new String[] {"Room1","","Room3",""};
		boolean hasHazard = false;
		boolean isGoal = false;
		Location testLocation = new Location(name, descriptionOne, descriptionTwo, connectedRooms, hasHazard, null, isGoal);
		
		assertNotEquals("Room2", testLocation.getRoomName());
		assertNotEquals("Square", testLocation.getRoomDescription());
		assertNotEquals("Still square", testLocation.getRoomDescription());
		assertEquals(connectedRooms, testLocation.getConnectedRooms());
		assertNotEquals(true, testLocation.getHazardCheck());
		assertNotEquals("Smoke", testLocation.getHazardName());
		assertNotEquals(true, testLocation.getIsGoal());
	}
}
