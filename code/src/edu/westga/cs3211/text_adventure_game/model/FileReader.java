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
	private HashMap<String, Hazard> hazards;
	
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
		this.hazards = new HashMap<String, Hazard>();
		
		this.loadInGameMapFile();
		this.loadInHazardFile();
	}
	
	private void loadInGameMapFile() {
		int lineCounter = 0;
		
		String name = "";
		String description1 = "";
		String description2 = "";
		String[] connectedRooms = new String[4];
		boolean hazardFlag = false;
		String attachedHazard = "";
		boolean isGoal = false;
		
		try {
			File loadInFile = new File(this.gameMapFile);
			Scanner fileReader = new Scanner(loadInFile);
			
			while (fileReader.hasNext()) {
				String data = fileReader.nextLine();
								
				switch (lineCounter) {
				case 0:
					name = data;
					lineCounter++;
					break;
				case 1:
					description1 = data;
					lineCounter++;
					break;
				case 2:
					description2 = data;
					lineCounter++;
					break;
				case 3:
					connectedRooms = data.split(",");
					lineCounter++;
					break;
				case 4:
					hazardFlag = Boolean.valueOf(data);
					lineCounter++;
					break;
				case 5:
					attachedHazard = data;
					lineCounter++;
					break;
				case 6:
					isGoal = Boolean.valueOf(data);
					lineCounter++;
					break;
				default:
					Location newLocation = new Location(name, description1, description2, connectedRooms, hazardFlag, attachedHazard, isGoal);
					this.gameLocations.put(newLocation.getRoomName(), newLocation);
					lineCounter = 0;
					break;
				}
			}
			
			fileReader.close();
		} catch (FileNotFoundException fnfException) {
			System.err.println("FILE NOT FOUND.");
		}
	}
	
	private void loadInHazardFile() {
		int lineCounter = 0;
		
		String name = "";
		String description = "";
		int damageValue = 0;
		
		try {
			File loadInFile = new File(this.hazardFile);
			Scanner fileReader = new Scanner(loadInFile);
			
			while (fileReader.hasNext()) {
				String data = fileReader.nextLine();
				
				switch (lineCounter) {
				case 0:
					name = data;
					lineCounter++;
					break;
				case 1:
					description = data;
					lineCounter++;
				case 2:
					damageValue = Integer.parseInt(data);
					lineCounter++;
					break;
				default:
					Hazard newHazard = new Hazard(name, description, damageValue);
					this.hazards.put(newHazard.getHazardName(), newHazard);
					lineCounter = 0;
					break;
				}
			}
			
			fileReader.close();
		} catch (FileNotFoundException fnfException) {
			System.err.println("FILE NOT FOUND.");
		}
	}
	
	/**
	 * Gets the locations in a HashMap
	 * 
	 * @return gameLocations
	 */
	public HashMap<String, Location> getLocationMap() {
		return this.gameLocations;
	}
	
	/**
	 * Gets the hazards in a HashMap
	 * 
	 * @return hazards
	 */
	public HashMap<String, Hazard> getHazards() {
		return this.hazards;
	}
}
