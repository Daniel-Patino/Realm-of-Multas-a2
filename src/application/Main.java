package application;
	
import AllScenes.HubScene;
import AllScenes.OpeningScene;
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
			 * 5. Show the very first Scene to run
			 */
			
			OpeningScene ourOpeningScene = new OpeningScene(primaryStage);
			HubScene ourHubScene = new HubScene(primaryStage);

			Scene[] futureTitleScenes = {ourHubScene.getFrameWorkScene()};
			SceneBranch sceneTitleBranch = new SceneBranch(ourOpeningScene.getFrameWorkScene(), null, futureTitleScenes);
			Scene[] futureChoicesSc = {ourOpeningScene.getFrameWorkScene()};
			SceneBranch sceneChoicesBr = new SceneBranch(ourHubScene.getFrameWorkScene(), ourOpeningScene.getFrameWorkScene(), futureChoicesSc);
			
			ourHubScene.appendSceneBranch(sceneChoicesBr);
			ourOpeningScene.appendSceneBranch(sceneTitleBranch);
			
			ourHubScene.sceneEvents();
			ourOpeningScene.sceneEvents();
			
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
