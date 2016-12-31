package AllScenes;

import GameScenes.SceneChoice;
import javafx.stage.Stage;

public class KeepScene extends SceneChoice{

	private static String pathToBackGround = "file:Resource/Images/castle-1821609_960_720.jpg";
	private static String[] choices = {"FILLER", "FILLER"};
	private static boolean isBackBut = true;
	private static boolean textBlock = false;
	
	public KeepScene(Stage primaryStage) {
		super(primaryStage, pathToBackGround, choices, isBackBut, textBlock);
		loadTextBlock("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam vulputate ipsum ut nunc accumsan faucibus. Nam sodales in quam quis iaculis. Maecenas gravida diam at tristique rutrum. Ut vestibulum lacinia tortor, ut ultricies metus eleifend quis. Donec sodales leo nec dolor aliquam cursus. In tempus, ante lacinia ultrices vulputate, ante mauris pretium nisl, a laoreet felis leo id odio. Morbi interdum ipsum ut nibh cursus cursus.");
	}

	@Override
	public void customEvents() {
		// TODO Auto-generated method stub
	}
}
