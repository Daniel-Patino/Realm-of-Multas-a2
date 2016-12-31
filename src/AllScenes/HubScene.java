package AllScenes;

import GameData.PlayerData;
import GameData.WorldData;
import GameScenes.SceneChoice;
import javafx.stage.Stage;

public class HubScene extends SceneChoice{

	private static String pathToBackGround = "file:Resource/Images/download.png";
	private static String[] choices = {"Go To Keep", "Go to Town", "Explore Wilderness"};
	private static boolean isBackBut = true;
	private static boolean textBlock = false;
	private static boolean isUI = true;
	
	public HubScene(Stage primaryStage, PlayerData player, WorldData world) {
		super(primaryStage, pathToBackGround, choices, isBackBut, textBlock, player, world);
		loadTitle("The Realm of Multas", false);
		//customEvents();
	}

	@Override
	public void customEvents() {
		
		loadUserInter(isUI);

		for(int i = 0; i < choiceButtons.length; i++){
			final int choice = i;
			choiceButtons[i].setOnMouseClicked(e -> {
				if(getSceneBranch().getFutureScenes(choice) == null){
					System.out.println("EMPTY");
				} 
				else{
					getStage().setScene(getSceneBranch().getFutureScenes(choice));
				}
			});
		}
		
//		choiceButtons[choiceButtons.length - 1].setOnMouseClicked(e -> {
//			player.setPlayerGold(player.getPlayerGold() + 50);
//			player.setPlayerHealth(player.getPlayerHealth() + 25);
//			StringProperty x = new SimpleStringProperty("Health: " + player.getPlayerHealth() + " Gold: " + player.getPlayerGold());
//			ui.toDisplay.textProperty().bind(x);
//			connectedScenes.getGameScenes(2).ui.toDisplay.textProperty().bind(x);
//		});
	}	
}
