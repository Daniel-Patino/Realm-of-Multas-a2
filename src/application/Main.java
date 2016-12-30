package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


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
			 */
			
			//SceneFactory newFac = new SceneFactory();
			String[] choices = {"FILLER", "FILLER", "FILLER", "FILLER", "FILLER", "FILLER", "FILLER", "FILLER"};
			
			SceneTitle sceneTitle = new SceneTitle(primaryStage, "file:Resource/Images/download.png", "Realm of Multas", false, false);
			
			SceneChoice sceneChoice = new SceneChoice(primaryStage, "file:Resource/Images/download.png", choices, false, false);
			sceneChoice.loadTitle("CHOICES", false);
			
			Scene[] futureTitleScenes = {sceneChoice.framework};
			SceneBranch sceneTitleBranch = new SceneBranch(sceneTitle.framework, null, futureTitleScenes);
			
			Scene[] futureChoicesSc = {sceneTitle.framework};
			SceneBranch sceneChoicesBr = new SceneBranch(sceneChoice.framework, sceneTitle.framework, futureChoicesSc);
			
			sceneChoice.appendSceneBranch(sceneChoicesBr);
			sceneTitle.appendSceneBranch(sceneTitleBranch);
			
			sceneChoice.sceneEvents();
			sceneTitle.sceneEvents();
			
			primaryStage.setScene(sceneTitle.getFrameWorkScene());
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
