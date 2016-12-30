package AllScenes;

import GameScenes.SceneTitle;
import javafx.stage.Stage;

public class OpeningScene extends SceneTitle{

	private static String pathToBackGround = "file:Resource/Images/download.png";
	public static String title = "Realm of Multas";
	public static boolean isBackButton = false;
	public static boolean isUserInterface = false;
	
	public OpeningScene(Stage primaryStage) {
		super(primaryStage, pathToBackGround, title, isBackButton, isUserInterface);

	}

	@Override
	public void customEvents() {
		
	}
}
