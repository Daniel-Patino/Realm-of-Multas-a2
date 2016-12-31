package application;

import GameData.PlayerData;
import GameData.WorldData;
import GameScenes.GameScenes;
import GameScenes.SceneBranch;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
/**
 * This class creates and thereafter manipulates the GUI, please note that the GUI must be loaded
 * inside of the custom events due to the order that the scenes load
 * 
 * @author Dsp02_000
 *
 */
public class NodeUserInterface {
	
	private PlayerData playerToDisplay;
	private WorldData worldToDisplay;
	private StackPane GUIPane;
	private SceneBranch connectedScenes;
	public Text toDisplay;
	public boolean removeOnce = true;
	
	public NodeUserInterface(PlayerData playerData, WorldData worldData, GameScenes theScene, SceneBranch connectedScenes){
		this.playerToDisplay = playerData;
		this.worldToDisplay = worldData;
		this.connectedScenes = connectedScenes;
		
		GUIPane = theScene.getMasterPane();
		userInterface();
		theScene.setMasterPane(getStackPane());
	}
	
	public void update(String toSet){
		
//		if(removeOnce){
//			StringProperty blankSlate = new SimpleStringProperty();
//			toDisplay.textProperty().bind(blankSlate);
//			for(int i = 0; i < connectedScenes.gameScenes.length; i++){
//				if(connectedScenes.getGameScenes(i).getUI() == null){
//					// Do Nothing
//				} else {
//					System.out.println(connectedScenes.getGameScenes(i).getUI().toDisplay.textProperty().isBound());
//					System.out.println(connectedScenes.getGameScenes(i).toString());
//					connectedScenes.getGameScenes(i).getUI().toDisplay.textProperty().bind(blankSlate);
//				}
//			}
//			removeOnce = false;
//		}
		
		StringProperty set = new SimpleStringProperty(toSet);
		toDisplay.textProperty().bind(set);
		
		for(int i = 0; i < connectedScenes.gameScenes.length; i++){
			if(connectedScenes.getGameScenes(i).getUI() == null){
				// Do Nothing
			} else {
				System.out.println(connectedScenes.getGameScenes(i).getUI().toDisplay.textProperty().isBound());
				System.out.println(connectedScenes.getGameScenes(i).toString());
				connectedScenes.getGameScenes(i).getUI().toDisplay.textProperty().bind(set);
			}
		}
	}
	
	private void userInterface(){
		toDisplay = new Text();
		toDisplay.setFont(Font.font("Mistral", FontWeight.BOLD, 28));
		toDisplay.setTextAlignment(TextAlignment.CENTER);
		toDisplay.setText("Health: " + playerToDisplay.getPlayerHealth() +
						 " Gold: " + playerToDisplay.getPlayerGold() +
						 " Day: " + worldToDisplay.getcurrentDay());
		toDisplay.setTranslateY(50);
		StackPane.setAlignment(toDisplay, Pos.TOP_CENTER);
		GUIPane.getChildren().add(toDisplay);
	}
	
	/* ---GETTERS AND SETTERS--- */
	
	private StackPane getStackPane(){
		return GUIPane;
	}
}
