package application;

import GameData.PlayerData;
import GameScenes.GameScenes;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class NodeUserInterface {
	
	private PlayerData dataToDisplay;
	private StackPane GUIPane;
	public Text toDisplay;
	
	public NodeUserInterface(PlayerData playerData, GameScenes theScene){
		this.dataToDisplay = playerData;
		GUIPane = theScene.getMasterPane();
		userInterface();
		theScene.replaceMasterPane(getStackPane());
	}
	
	public void update(String toSet){
		toDisplay.setText(toSet);
	}
	
	private void userInterface(){
		toDisplay = new Text();
		toDisplay.setFont(Font.font("Mistral", FontWeight.BOLD, 28));
		toDisplay.setTextAlignment(TextAlignment.CENTER);
		toDisplay.setText("Health: " + dataToDisplay.getPlayerHealth() + " Gold: " + dataToDisplay.getPlayerGold());
		toDisplay.setTranslateY(50);
		StackPane.setAlignment(toDisplay, Pos.TOP_CENTER);
		GUIPane.getChildren().add(toDisplay);
	}
	
	private StackPane getStackPane(){
		return GUIPane;
	}
}
