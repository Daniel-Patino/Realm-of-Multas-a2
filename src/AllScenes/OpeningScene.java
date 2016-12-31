package AllScenes;

import GameData.PlayerData;
import GameData.WorldData;
import GameScenes.SceneTitle;
import javafx.stage.Stage;

public class OpeningScene extends SceneTitle{

	private static String pathToBackGround = "file:Resource/Images/download.png";
	private static String title = "Realm of Multas";
	private static boolean isBackButton = false;
	private static boolean isUserInterface = false;
	
	public OpeningScene(Stage primaryStage, PlayerData player, WorldData world) {
		super(primaryStage, pathToBackGround, title, isBackButton, isUserInterface, player, world);
	}

	@Override
	public void customEvents() {
			
	}
}
