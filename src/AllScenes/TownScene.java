package AllScenes;

import GameData.PlayerData;
import GameData.WorldData;
import GameScenes.SceneChoice;
import javafx.stage.Stage;

public class TownScene extends SceneChoice{
	
	private static String pathToBackGround = "file:Resource/Images/906741-town-wallpaper.jpg";
	private static String[] choices = {"FILLER", "FILLER"};
	private static boolean isBackBut = true;
	private static boolean textBlock = false;
	private static boolean isUI = true;
	
	public TownScene(Stage primaryStage, PlayerData player, WorldData world) {
		super(primaryStage, pathToBackGround, choices, isBackBut, textBlock, player, world);
		loadTitle("The Town", false);
	}

	@Override
	public void customEvents() {
		loadUserInter(isUI);
		
		choiceButtons[0].setOnMouseClicked(e -> {
			player.setPlayerGold(player.getPlayerGold() + 50);
			player.setPlayerHealth(player.getPlayerHealth() + 25);
			world.setcurrentDay(world.getcurrentDay() + 1);
			getUI().update("Health: " + player.getPlayerHealth() + " Gold: " + player.getPlayerGold() +
					  " Day: " + world.getcurrentDay());
		});
	}
}
