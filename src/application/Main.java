package application;
	
import AllScenes.HubScene;
import AllScenes.KeepScene;
import AllScenes.OpeningScene;
import AllScenes.TownScene;
import AllScenes.WildScene;
import GameData.PlayerData;
import GameData.WorldData;
import GameScenes.GameScenes;
import GameScenes.SceneBranch;
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
			 * 2. Store All GameScenes in a single Array (Can be automated)
			 * 2. Next Define the SceneBranch
			 * 3. Use the .setSceneBranch to append the Branch
			 * 4. Call the customEvents(); 
			 * 5. Run opening Scene
			 */
			
			PlayerData ourPlayer = new PlayerData(100, 100);
			WorldData ourWorld = new WorldData(0);
			
			/* 1. Define all GameScenes */
			OpeningScene openScene = new OpeningScene(primaryStage, ourPlayer, ourWorld);
			HubScene hubScene = new HubScene(primaryStage, ourPlayer, ourWorld);
			KeepScene keepScene = new KeepScene(primaryStage, ourPlayer, ourWorld);
			TownScene townScene = new TownScene(primaryStage, ourPlayer, ourWorld);
			WildScene wildScene = new WildScene(primaryStage, ourPlayer, ourWorld);
			
			/*  2. Store GameScenes */
			GameScenes[] gameScenes = new GameScenes[5];
			gameScenes[0] = openScene;
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
			
			SceneBranch sceneTitleBranch = new SceneBranch(openScene.getFrameWork(), null, futTitleScenes, gameScenes);
			SceneBranch sceneHubBr = new SceneBranch(hubScene.getFrameWork(), openScene.getFrameWork(), futHubSc, gameScenes);
			SceneBranch sceneKeepBr = new SceneBranch(keepScene.getFrameWork(), hubScene.getFrameWork(), futKeepSc, gameScenes);
			SceneBranch sceneTownBr = new SceneBranch(townScene.getFrameWork(), hubScene.getFrameWork(), futTownScene, gameScenes);
			SceneBranch sceneWildBr = new SceneBranch(wildScene.getFrameWork(), hubScene.getFrameWork(), futWildScene, gameScenes);
			
			/* 3. Use the .setSceneBranch */
			hubScene.setSceneBranch(sceneHubBr);
			openScene.setSceneBranch(sceneTitleBranch);
			keepScene.setSceneBranch(sceneKeepBr);
			townScene.setSceneBranch(sceneTownBr);
			wildScene.setSceneBranch(sceneWildBr);
			
			/* 4. Call the customeEvents() */
			openScene.customEvents();
			hubScene.customEvents();
			keepScene.customEvents();
			townScene.customEvents();
			wildScene.customEvents();
			
			/* 5. Run opening Scene*/
			primaryStage.setScene(openScene.getFrameWork());
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
