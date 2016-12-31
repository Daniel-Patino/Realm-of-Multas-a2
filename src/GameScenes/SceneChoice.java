package GameScenes;

import GameData.PlayerData;
import GameData.WorldData;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
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
public abstract class SceneChoice extends GameScenes{

	protected Button[] choiceButtons;
	private String sceneClass = "SceneChoice";
	protected PlayerData player;
	
	public abstract void customEvents();
	
	public SceneChoice(Stage primaryStage, String pathToBackGround, String[] choices, boolean isBackBut,
			boolean textBlock, PlayerData player, WorldData world) {
		super(primaryStage, pathToBackGround, player, world);
		
		this.player = player;
		
		loadChoices(choices);
		sceneButtons(isBackBut);
	}
	
	protected void loadTextBlock(String textBlock){
		
		getFrameWork().getStylesheets().add(SceneChoice.class.getResource("application.css").toExternalForm());
		
		TextArea textToDisplay = new TextArea(textBlock);
		
		textToDisplay.setWrapText(true);
		textToDisplay.setFocusTraversable(false);
		textToDisplay.setEditable(false);
		textToDisplay.setMaxWidth(GAME_WIDTH / 2);
		textToDisplay.setMaxHeight(GAME_HEIGHT / 2);
		getBorderPane().setCenter(textToDisplay);
	}
	
	private void loadChoices(String[] choices){
		HBox choicesBox = new HBox(2);
		choicesBox.setAlignment(Pos.CENTER);
		choicesBox.setTranslateY(-10);
		choiceButtons = new Button[choices.length];
		
		char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		for(int i = 0; i < choices.length; i++){
			choiceButtons[i] = new Button(alphabet[i]+ ". " + choices[i]);
			choiceButtons[i].setMinSize((GAME_WIDTH / (choices.length * 1.5)), 25);
			choicesBox.getChildren().add(choiceButtons[i]);
		}
		getBorderPane().setBottom(choicesBox);
	}
	
	@Override
	public void sceneEvents() {	
		
	}

	@Override
	public void sceneButtons(boolean isBackBut) {
		if(isBackBut){
			Button backButton = new Button();
			StackPane.setAlignment(backButton, Pos.BOTTOM_LEFT);
			
			backButton.setTranslateX(20);
			backButton.setTranslateY(-10);
			backButton.setText("Back");
			getMasterPane().getChildren().add(backButton);
			
			backButton.setOnMouseClicked(e -> {
				getStage().setScene(getSceneBranch().getPreviousScene());
			});
		}
	}
	
	/* ---GETTERS AND SETTERS--- */
	
	public Button getButton(int buttonToReturn){
		return choiceButtons[buttonToReturn];
	}
	
	public String getSceneName(){
		return sceneClass;
	}
}
