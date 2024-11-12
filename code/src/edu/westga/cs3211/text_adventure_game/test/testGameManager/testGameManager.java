package edu.westga.cs3211.text_adventure_game.test.testGameManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.text_adventure_game.model.GameManager;
import edu.westga.cs3211.text_adventure_game.model.Player;

public class testGameManager {
	
	
	@Test
	public void testGameManagerPlayerHealthFull() {
		GameManager gameManager = new GameManager();
		Player newPlayer = new Player();
	
		assertEquals(newPlayer.getPlayerHitPoints(), gameManager.getPlayerHealthPoints());
	}
}
