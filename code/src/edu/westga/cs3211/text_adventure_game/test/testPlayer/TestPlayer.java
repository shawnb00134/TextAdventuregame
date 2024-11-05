package edu.westga.cs3211.text_adventure_game.test.testPlayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.text_adventure_game.model.Hazard;
import edu.westga.cs3211.text_adventure_game.model.Player;

public class TestPlayer {

	@Test
	public void playerConstructorNoDamage() {
		Player newPlayer = new Player();
		
		assertEquals(10, newPlayer.getPlayerHitPoints());
	}
	
	@Test
	public void playerHitDamangeHardcoded() {
		Player newPlayer = new Player();
		newPlayer.reducePlayerHitPoint(2);
		
		assertEquals(8, newPlayer.getPlayerHitPoints());
	}
	
	@Test
	public void playerHitDamageHazard() {
		Player newPlayer = new Player();
		
		String name = "DartRoom";
		String description = "A dart hits you in the neck.";
		int damage = 4;
		Hazard newHazard = new Hazard(name, description, damage);
		
		newPlayer.reducePlayerHitPoint(newHazard.getHazardDamageValue());
		assertEquals(6, newPlayer.getPlayerHitPoints());
	}
	
	
	@Test
	public void playerHitDamageMultiHazardZeroHP() {
		Player newPlayer = new Player();
		
		String nameDart = "DartRoom";
		String descriptionDart = "A dart hits you in the neck.";
		int damageDart = 4;
		Hazard newHazardDart = new Hazard(nameDart, descriptionDart, damageDart);
		String nameSpike = "SpikeRoom";
		String descriptionSpike = "A dart hits you in the neck.";
		int damageSpike = 5;
		Hazard newHazardSpike = new Hazard(nameSpike, descriptionSpike, damageSpike);
		String nameSlip = "SlipperyRoom";
		String descriptionSlip = "A dart hits you in the neck.";
		int damageSlip = 1;
		Hazard newHazardSlip = new Hazard(nameSlip, descriptionSlip, damageSlip);
		
		newPlayer.reducePlayerHitPoint(newHazardDart.getHazardDamageValue());
		newPlayer.reducePlayerHitPoint(newHazardSpike.getHazardDamageValue());
		newPlayer.reducePlayerHitPoint(newHazardSlip.getHazardDamageValue());
		
		assertEquals(0, newPlayer.getPlayerHitPoints());
	}
	
	@Test
	public void playerHitDamageNotBelowZeroHP() {
		Player newPlayer = new Player();
		
		String nameSpike = "SpikeRoom";
		String descriptionSpike = "A dart hits you in the neck.";
		int damageSpike = 6;
		Hazard newHazardSpike = new Hazard(nameSpike, descriptionSpike, damageSpike);
		
		newPlayer.reducePlayerHitPoint(newHazardSpike.getHazardDamageValue());
		newPlayer.reducePlayerHitPoint(newHazardSpike.getHazardDamageValue());
		
		assertEquals(0, newPlayer.getPlayerHitPoints());
	}
}
