package GameScenes;

import javafx.scene.Scene;

/**
 * A simpler way to handle scene transition
 * Inputs are in order of currentScene, previousScene and futureScenes
 * @author Dsp02_000
 *
 */
public class SceneBranch {
	private Scene currentScene;
	private Scene previousScene;
	private Scene[] futureScenes;
	
	public GameScenes[] gameScenes;
	
	public SceneBranch(Scene curScene, Scene prevScene, Scene[] futScenes, GameScenes[] gameScenes)
	{
		this.currentScene = curScene;
		this.previousScene = prevScene;
		this.futureScenes = futScenes;
		this.gameScenes = gameScenes;
	}
	
	public Scene getCurrentScene(){
		return currentScene;
	}
	
	public Scene getPreviousScene(){
		return previousScene;
	}
	
	public Scene getFutureScenes(int sceneToAccess){
		if(futureScenes == null){
			return null;
		} 
		else{
			if(sceneToAccess >= futureScenes.length){
				System.out.println("Exceeded futureScene[]");
				return null;
			}
			else{
				return futureScenes[sceneToAccess];
			}
		}
	}
	
	public GameScenes getGameScenes(int gameScene){
		return gameScenes[gameScene];
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
