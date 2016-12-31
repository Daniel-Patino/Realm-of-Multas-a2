package AllScenes;

import GameScenes.SceneChoice;
import javafx.stage.Stage;

public class TownScene extends SceneChoice{
	
	private static String pathToBackGround = "file:Resource/Images/906741-town-wallpaper.jpg";
	private static String[] choices = {"FILLER", "FILLER"};
	private static boolean isBackBut = true;
	private static boolean textBlock = false;
	
	public TownScene(Stage primaryStage) {
		super(primaryStage, pathToBackGround, choices, isBackBut, textBlock);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void customEvents() {
		// TODO Auto-generated method stub
		
	}

}
