package GameScenes;

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
public abstract class SceneChoice extends GameScenes{

	private Button[] choiceButtons;
	private String sceneClass = "SceneChoice";
	
	public SceneChoice(Stage primaryStage, String pathToBackGround, String[] choices, boolean isBackBut, boolean textBlock) {
		super(primaryStage, pathToBackGround);
		loadChoices(choices);
	}
	
	public abstract void customEvents();
	
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
			choiceButtons[i].setMinSize((GAME_WIDTH / (choices.length * 1.5)), 25);
			choicesBox.getChildren().add(choiceButtons[i]);
		}
		contentPane.setBottom(choicesBox);
	}
	
	/**
	 * Buttons must be linked on a one to one basis for most practical ease of use
	 */
	@Override
	public void sceneEvents() {	
		for(int i = 0; i < choiceButtons.length; i++){
			final int choice = i;
			choiceButtons[i].setOnMouseClicked(e -> {
				if(connectedScenes.getFutureScenes(choice) == null){
					System.out.println("EMPTY");
				} 
				else{
					primaryStage.setScene(connectedScenes.getFutureScenes(choice));
					primaryStage.show();
				}
			});
		}
	}

	@Override
	public void sceneButtons() {
		// TODO Auto-generated method stub
		
	}
	
	public String getSceneName(){
		return sceneClass;
	}
}
