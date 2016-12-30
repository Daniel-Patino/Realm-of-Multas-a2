package AllScenes;

import GameScenes.SceneChoice;
import javafx.stage.Stage;

public class KeepScene extends SceneChoice{

	private static String pathToBackGround = "file:Resource/Images/download.png";
	private static String[] choices = {"FILLER"};
	private static boolean isBackBut = true;
	private static boolean textBlock = false;
	
	public KeepScene(Stage primaryStage) {
		super(primaryStage, pathToBackGround, choices, isBackBut, textBlock);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void customEvents() {
		// TODO Auto-generated method stub
	}
}
