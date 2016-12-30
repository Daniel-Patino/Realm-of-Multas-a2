package application;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * This type of scene is meant to contain x number of choices at the bottom for the player
 * to choose from, it should also contain the user interface at the top, optionally it might
 * contain a back button , optionally it should be able to contain text at the center
 * 
 * 1. X Button Choices
 * 2. User Interface
 * 3. Optionally Back Button
 * 4. Optionally Text Block
 * 
 * @author Dsp02_000
 *
 */
public class SceneChoice extends GameScenes{

	private Button[] choiceButtons;
	private String sceneClass = "SceneChoice";
	
	public SceneChoice(Stage primaryStage, String pathToBackGround, String[] choices, boolean isBackBut, boolean textBlock) {
		super(primaryStage, pathToBackGround);
		loadChoices(choices);
	}
	
	public Button accessButton(int buttonToReturn){
		return choiceButtons[buttonToReturn];
	}
	
	private void loadChoices(String[] choices){
		
		HBox choicesBox = new HBox(2);
		choicesBox.setAlignment(Pos.CENTER);
		choicesBox.setTranslateY(-10);
		choiceButtons = new Button[choices.length];
		
		char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		for(int i = 0; i < choices.length; i++){
			choiceButtons[i] = new Button(alphabet[i]+ ". " + choices[i]);
			choiceButtons[i].setMinSize((GAME_WIDTH / (choices.length * 2)), 25);
			choicesBox.getChildren().add(choiceButtons[i]);
		}
		contentPane.setBottom(choicesBox);
	}
	
	
	/**
	 * For choices, each button has an event applied to it. 
	 */
	@Override
	public void customEvents() {
		choiceButtons[0].setOnMouseClicked(e -> {
			primaryStage.setScene(connectedScenes.getPreviousScene());
			primaryStage.show();
		});
		choiceButtons[1].setOnMouseClicked(e -> {
			primaryStage.setScene(connectedScenes.getPreviousScene());
			primaryStage.show();
		});
		choiceButtons[2].setOnMouseClicked(e -> {
			primaryStage.setScene(connectedScenes.getPreviousScene());
			primaryStage.show();
		});
		choiceButtons[3].setOnMouseClicked(e -> {
			primaryStage.setScene(connectedScenes.getPreviousScene());
			primaryStage.show();
		});
	}

	@Override
	public void customButtons() {
		// TODO Auto-generated method stub
		
	}
	
	public String getSceneName(){
		return sceneClass;
	}
}
