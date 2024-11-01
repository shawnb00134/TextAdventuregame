package edu.westga.cs3211.text_adventure_game.test.testHazard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.text_adventure_game.model.Hazard;

public class TestHazard {

	@Test
	public void validHazard() {
		String name = "SmokeRoom";
		String description = "Fills with smoke";
		int damage = 0;
		Hazard newHazard = new Hazard(name, description, damage);
		
		assertEquals(name, newHazard.getHazardName());
		assertEquals(description, newHazard.getHazardDescription());
		assertEquals(damage, newHazard.getHazardDamageValue());
	}
	
	@Test
	public void invalidHazard() {
		String name = "SmokeRoom";
		String description = "Fills with smoke";
		int damage = 0;
		Hazard newHazard = new Hazard(name, description, damage);
		
		assertNotEquals("DartRoom", newHazard.getHazardName());
		assertNotEquals("Dart hit", newHazard.getHazardDescription());
		assertNotEquals(2, newHazard.getHazardDamageValue());		
	}
}
