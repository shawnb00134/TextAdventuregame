package edu.westga.cs3211.text_adventure_game.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Text Adventure Game - FileReader class
 * 
 * File Reader will read in a file of the game locations given to it by the GameManager.
 * 
 * @author Shawn Bretthauer
 * @version Fall 2024
 */
public class FileReader {

	private String gameMapFile;
	private String hazardFile;
	
	private HashMap<String, Location> gameLocations;
	
	/**
	 * Constructor with the file name.
	 * 
	 * @param gameMapFile name of the game location file
	 * @param hazardFile name of the file with hazards
	 */
	public FileReader(String gameMapFile, String hazardFile) {
		this.gameMapFile = gameMapFile;
		this.hazardFile = hazardFile;
		
		this.gameLocations = new HashMap<String, Location>();
		
		this.loadInGameMapFile();
		this.loadInHazardFile();
	}
	
	private void loadInGameMapFile() {
		int gameMapLines = 8;
		int lineCounter = 0;
		
		String name = "";
		String description1 = "";
		String description2 = "";
		String[] connectedRooms;
		boolean hazardFlag;
		Hazard attachedHazard;
		boolean isGoal;
		
		try {
			File loadInFile = new File(this.gameMapFile);
			Scanner fileReader = new Scanner(loadInFile);
			
			while (fileReader.hasNext()) {
				String data = fileReader.nextLine();
				
				//TODO: Add a switch statement here to put the data in the correct variable.
			}
			
			fileReader.close();
		} catch (FileNotFoundException fnfException) {
			System.err.println("FILE NOT FOUND.");
		}
	}
	
	private void loadInHazardFile() {
		//TODO: implement loading in hazards
	}
}
