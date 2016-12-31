package AllScenes;

import GameData.PlayerData;
import GameScenes.SceneChoice;
import javafx.stage.Stage;

public class WildScene extends SceneChoice{

	private static String pathToBackGround = "file:Resource/Images/Iceberg-Lake-Mount-Baker-Wilderness-Washington.jpg";
	private static String[] choices = {"FILLER", "FILLER"};
	private static boolean isBackBut = true;
	private static boolean textBlock = false;
	private static boolean isUI = true;	
	
	public WildScene(Stage primaryStage, PlayerData player) {
		super(primaryStage, pathToBackGround, choices, isBackBut, textBlock, player);
		loadTitle("The Wilderness", false);
		loadUserInter(isUI);
	}

	@Override
	public void customEvents() {
		// TODO Auto-generated method stub
		
	}

}
