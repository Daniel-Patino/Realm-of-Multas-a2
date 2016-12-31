package AllScenes;

import GameData.PlayerData;
import GameData.WorldData;
import GameScenes.SceneChoice;
import javafx.stage.Stage;

public class WildScene extends SceneChoice{

	private static String pathToBackGround = "file:Resource/Images/Iceberg-Lake-Mount-Baker-Wilderness-Washington.jpg";
	private static String[] choices = {"FILLER", "FILLER"};
	private static boolean isBackBut = true;
	private static boolean textBlock = false;
	private static boolean isUI = true;	
	
	public WildScene(Stage primaryStage, PlayerData player, WorldData world) {
		super(primaryStage, pathToBackGround, choices, isBackBut, textBlock, player, world);
		loadTitle("The Wilderness", false);
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
