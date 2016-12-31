package application;
	
import AllScenes.HubScene;
import AllScenes.KeepScene;
import AllScenes.OpeningScene;
import AllScenes.TownScene;
import AllScenes.WildScene;
import GameData.PlayerData;
import GameScenes.GameScenes;
import GameScenes.SceneBranch;
import GameScenes.SceneChoice;
import GameScenes.SceneTitle;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			/*
			 * Quick note to self, right now the process of creating a Scene with complete back and forth relations
			 * involves the following steps;
			 * 1. Define all GameScenes
			 * 2. Next Define the SceneBranch
			 * 3. Use the .appendSceneBranch to append the Branch
			 * 4. Call the customEvents(); 
			 * 5. Run opening Scene
			 */
			
			PlayerData ourPlayer = new PlayerData(100, 100);
			
			/* 1. Define all GameScenes */
			OpeningScene ourOpeningScene = new OpeningScene(primaryStage, ourPlayer);
			HubScene hubScene = new HubScene(primaryStage, ourPlayer);
			KeepScene keepScene = new KeepScene(primaryStage, ourPlayer);
			TownScene townScene = new TownScene(primaryStage, ourPlayer);
			WildScene wildScene = new WildScene(primaryStage, ourPlayer);
			
			GameScenes[] gameScenes = new GameScenes[5];
			gameScenes[0] = ourOpeningScene;
			gameScenes[1] = hubScene;
			gameScenes[2] = keepScene;
			gameScenes[3] = townScene;
			gameScenes[4] = wildScene;
			
			/* 2. Define the sceneBranches */
			Scene[] futTitleScenes = {hubScene.getFrameWork()};
			Scene[] futHubSc = {keepScene.getFrameWork(), townScene.getFrameWork(), wildScene.getFrameWork()};
			Scene[] futKeepSc = null;
			Scene[] futTownScene = null;
			Scene[] futWildScene = null;
			
			SceneBranch sceneTitleBranch = new SceneBranch(ourOpeningScene.getFrameWork(), null, futTitleScenes, gameScenes);
			SceneBranch sceneHubBr = new SceneBranch(hubScene.getFrameWork(), ourOpeningScene.getFrameWork(), futHubSc, gameScenes);
			SceneBranch sceneKeepBr = new SceneBranch(keepScene.getFrameWork(), hubScene.getFrameWork(), futKeepSc, gameScenes);
			SceneBranch sceneTownBr = new SceneBranch(townScene.getFrameWork(), hubScene.getFrameWork(), futTownScene, gameScenes);
			SceneBranch sceneWildBr = new SceneBranch(wildScene.getFrameWork(), hubScene.getFrameWork(), futWildScene, gameScenes);
			
			/* 3. Use the .appendSceneBranch */
			hubScene.appendSceneBranch(sceneHubBr);
			ourOpeningScene.appendSceneBranch(sceneTitleBranch);
			keepScene.appendSceneBranch(sceneKeepBr);
			townScene.appendSceneBranch(sceneTownBr);
			wildScene.appendSceneBranch(sceneWildBr);
			
			/* 4. Call the customeEvents() */
			//ourHubScene.customEvents();
			//ourOpeningScene.customEvents();
			//ourKeepScene.customEvents();
			//ourTownScene.customEvents();
			
			/* 5. Run opening Scene*/
			primaryStage.setScene(ourOpeningScene.getFrameWork());
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
