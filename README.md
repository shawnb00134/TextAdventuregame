# TextAdventuregame

Notes:
The game is preset to the Game Map. For testing uncomment out the For Testing section and comment out the For Play section in the GameManager class.

In the TestFileReader class you will notice three tests commented out. These were attempts to test the FileNotFoundException but it appears the try/catch handled those. I left the System.err print to console to happen as a precaution. These tests did cause them to happen but had a CheckStyle warning of "local variable not used".

Simple Walkthrough:
Start - Move East
Move South
Move East - Goal

Hazards Can Be Found:
1. Start - Move North
Move West - Hazard (0 Damage)

2. Start - Move South - Hazard

3. Start - Move East
Move South - Hazard

4 & 5
Start - Move East
Move East - Hazard (0 Damage)
Move North - Hazard (8 Damage)



A map of both the dungeon for testing (dungeon02-testins.jpg) and play (dungeon03-final) purposes are located in the documentation folder. One version of the play map (dungeon03-final-edit.jpg) will have the locations for the 

Eclipse
--module-path "${eclipse_home}/javafx-sdk/lib"
--add-modules javafx.controls,javafx.fxml


Notes to self:
Set up Location to have Hazard in place of the name.
