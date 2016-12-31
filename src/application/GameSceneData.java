package application;

import GameScenes.SceneChoice;
import GameScenes.SceneTitle;

public class GameSceneData {
	
	public SceneChoice[] choiceDataBase;
	public SceneTitle[] titleDataBase;
	
	public GameSceneData(SceneChoice[] choiceDataBase, SceneTitle[] titleDataBase){
		this.choiceDataBase = choiceDataBase;
		this.titleDataBase = titleDataBase;
	}
}
