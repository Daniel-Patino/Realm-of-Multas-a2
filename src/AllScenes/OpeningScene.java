package AllScenes;

import GameScenes.SceneTitle;
import javafx.stage.Stage;

public class OpeningScene extends SceneTitle{

	private static String pathToBackGround = "file:Resource/Images/download.png";
	private static String title = "Realm of Multas";
	private static boolean isBackButton = false;
	private static boolean isUserInterface = false;
	
	public OpeningScene(Stage primaryStage) {
		super(primaryStage, pathToBackGround, title, isBackButton, isUserInterface);
	}

	@Override
	public void customEvents() {
			
	}
}
