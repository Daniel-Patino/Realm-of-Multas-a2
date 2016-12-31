package AllScenes;

import GameData.PlayerData;
import GameData.WorldData;
import GameScenes.SceneChoice;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.stage.Stage;

public class KeepScene extends SceneChoice{

	private static String pathToBackGround = "file:Resource/Images/castle-1821609_960_720.jpg";
	private static String[] choices = {"FILLER", "+25hp, +50g"};
	private static boolean isBackBut = true;
	private static boolean textBlock = false;
	private static boolean isUI = true;
	
	public KeepScene(Stage primaryStage, PlayerData player, WorldData world) {
		super(primaryStage, pathToBackGround, choices, isBackBut, textBlock, player, world);
		
		loadTitle("The Keep", false);
		loadTextBlock("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam vulputate ipsum ut nunc"
				+ " accumsan faucibus. Nam sodales in quam quis iaculis. Maecenas gravida diam at tristique "
				+ "rutrum. Ut vestibulum lacinia tortor, ut ultricies metus eleifend quis. Donec sodales leo"
				+ " nec dolor aliquam cursus. In tempus, ante lacinia ultrices vulputate, ante mauris pretium"
				+ " nisl, a laoreet felis leo id odio. Morbi interdum ipsum ut nibh cursus cursus.");
	}

	@Override
	public void customEvents() {
		
		loadUserInter(isUI);
	
//		for(int i = 0; i < choiceButtons.length; i++){
//			final int choice = i;
//			choiceButtons[i].setOnMouseClicked(e -> {
//				if(connectedScenes.getFutureScenes(choice) == null){
//					System.out.println("EMPTY");
//				} 
//				else{
//					primaryStage.setScene(connectedScenes.getFutureScenes(choice));
//				}
//			});
//		}
		
		choiceButtons[0].setOnMouseClicked(e -> {
			player.setPlayerGold(player.getPlayerGold() + 50);
			player.setPlayerHealth(player.getPlayerHealth() + 25);
			world.setcurrentDay(world.getcurrentDay() + 1);
			getUI().update("Health: " + player.getPlayerHealth() + " Gold: " + player.getPlayerGold() +
					  " Day: " + world.getcurrentDay());
		});
	}
}
