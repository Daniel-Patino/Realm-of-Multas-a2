package application;
	
import AllScenes.HubScene;
import AllScenes.KeepScene;
import AllScenes.OpeningScene;
import AllScenes.TownScene;
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
			 * 2. Next Define the SceneBranch
			 * 3. Use the .appendSceneBranch to append the Branch
			 * 4. Call the customEvents(); 
			 * 5. Run opening Scene
			 */
			
			/* 1. Define all GameScenes */
			OpeningScene ourOpeningScene = new OpeningScene(primaryStage);
			HubScene ourHubScene = new HubScene(primaryStage);
			KeepScene ourKeepScene = new KeepScene(primaryStage);
			TownScene ourTownScene = new TownScene(primaryStage);
			
			/* 2. Define the sceneBranches */
			Scene[] futureTitleScenes = {ourHubScene.getFrameWorkScene()};
			Scene[] futureHubSc = {ourKeepScene.getFrameWorkScene(), ourTownScene.getFrameWorkScene()};
			Scene[] futureKeepSc = null;
			Scene[] futureTownScene = null;
			
			SceneBranch sceneTitleBranch = new SceneBranch(ourOpeningScene.getFrameWorkScene(), null, futureTitleScenes);
			SceneBranch sceneHubBr = new SceneBranch(ourHubScene.getFrameWorkScene(), ourOpeningScene.getFrameWorkScene(), futureHubSc);
			SceneBranch sceneKeepBr = new SceneBranch(ourKeepScene.getFrameWorkScene(), ourHubScene.getFrameWorkScene(), futureKeepSc);
			SceneBranch sceneTownBr = new SceneBranch(ourTownScene.getFrameWorkScene(), ourHubScene.getFrameWorkScene(), futureTownScene);
			
			/* 3. Use the .appendSceneBranch */
			ourHubScene.appendSceneBranch(sceneHubBr);
			ourOpeningScene.appendSceneBranch(sceneTitleBranch);
			ourKeepScene.appendSceneBranch(sceneKeepBr);
			ourTownScene.appendSceneBranch(sceneTownBr);
			
			/* 4. Call the customeEvents() */
			ourHubScene.customEvents();
			ourOpeningScene.customEvents();
			ourKeepScene.customEvents();
			ourTownScene.customEvents();
			
			/* 5. Run opening Scene*/
			primaryStage.setScene(ourOpeningScene.getFrameWorkScene());
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
