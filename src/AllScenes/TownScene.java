package AllScenes;

import GameData.PlayerData;
import GameScenes.SceneChoice;
import javafx.stage.Stage;

public class TownScene extends SceneChoice{
	
	private static String pathToBackGround = "file:Resource/Images/906741-town-wallpaper.jpg";
	private static String[] choices = {"FILLER", "FILLER"};
	private static boolean isBackBut = true;
	private static boolean textBlock = false;
	private static boolean isUI = false;
	
	public TownScene(Stage primaryStage, PlayerData player) {
		super(primaryStage, pathToBackGround, choices, isBackBut, textBlock, player);
		loadUserInter(isUI);
	}

	@Override
	public void customEvents() {
		sceneEvents();
	}

}
