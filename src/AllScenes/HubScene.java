package AllScenes;

import GameScenes.SceneChoice;
import javafx.stage.Stage;

public class HubScene extends SceneChoice{

	private static String pathToBackGround = "file:Resource/Images/download.png";
	private static String[] choices = {"Go To Keep", "Go to Town", "Explore Wilderness"};
	private static boolean isBackBut = false;
	private static boolean textBlock = false;
	
	public HubScene(Stage primaryStage) {
		super(primaryStage, pathToBackGround, choices, isBackBut, textBlock);
		loadTitle("The Realm of Multas", false);
	}

	@Override
	public void customEvents() {
		
	}	
}
