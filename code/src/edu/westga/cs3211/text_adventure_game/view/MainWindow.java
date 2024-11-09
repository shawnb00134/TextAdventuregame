package edu.westga.cs3211.text_adventure_game.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;

/** Codebehind for the Main Window of the application.
 * 
 * @author CS 3211
 * @version Fall 2024
 */
public class MainWindow {
	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonTakeAction;

    @FXML
    private ComboBox<?> comboBoxAvailableActions;

    @FXML
    private ImageView imageHealth;

    @FXML
    private TextArea textAreaMainText;
    
    @FXML
    private Label labelHealth;

    @FXML
    void initialize() {
        assert this.buttonTakeAction != null : "fx:id=\"button_TakeAction\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert this.comboBoxAvailableActions != null : "fx:id=\"comboBox_AvailableActions\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert this.imageHealth != null : "fx:id=\"image_Health\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert this.textAreaMainText != null : "fx:id=\"textArea_MainText\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert this.labelHealth != null : "fx:id=\"labelHealth\" was not injected: check your FXML file 'MainWindow.fxml'.";

    }
}
