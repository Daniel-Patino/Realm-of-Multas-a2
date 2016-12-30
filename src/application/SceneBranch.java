package application;

import javafx.scene.Scene;

public class SceneBranch {
	private Scene currentScene;
	private Scene previousScene;
	private Scene[] futureScenes;
	
	public SceneBranch(Scene currentScene, Scene previousScene, Scene[] futureScenes){
		this.currentScene = currentScene;
		this.previousScene = previousScene;
		this.futureScenes = futureScenes;
	}
	
	public Scene getCurrentScene(){
		return currentScene;
	}
	
	public Scene getPreviousScene(){
		return previousScene;
	}
	
	public Scene accessFutureScenes(int sceneToAccess){
		return futureScenes[sceneToAccess];
	}
	
	public String toString(){
		
		String toReturn = "[Previous: " + previousScene.toString() + "] [Current: " + currentScene.toString()
			+ "] [Future: ";
		String toConcat = "";
		
		if(futureScenes == null){
			toConcat = "NULL";
		}
		else {
			for(int i = 0; i < futureScenes.length; i++){
				toConcat += futureScenes[i].toString() + " ";
			}
		}
		
		return toReturn + toConcat + "]";
	}
}
