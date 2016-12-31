package GameScenes;

import GameData.PlayerData;
import application.NodeUserInterface;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Scenes need to be constructed methodically in the following order for the sake of not confusing myself
 * UPDATE AS NECESSARY
 * 1. Background Image
 * 2. BorderPane
 * 		...
 * @author Dsp02_000
 *
 */
public abstract class GameScenes{
	
	protected Scene framework;
	protected StackPane masterPane;
	protected BorderPane contentPane;
	protected SceneBranch connectedScenes;
	protected Stage primaryStage;
	public NodeUserInterface ui;
	protected PlayerData player;
	
	public static final int GAME_WIDTH = 760;
	public static final int GAME_HEIGHT = 640;
	
	public abstract void sceneEvents();
	public abstract void sceneButtons(boolean isBackBut);
	
	public GameScenes(Stage primaryStage, String pathToBackGround, PlayerData player){
		this.primaryStage = primaryStage;
		this.player = player;
		constructScene(pathToBackGround);
	}
	
	protected void loadUserInter(boolean isUI){
		if(isUI){
			NodeUserInterface ui = new NodeUserInterface(player, this);
			this.ui = ui;
		}
	}
	
	public void appendSceneBranch(SceneBranch connectedScenes){
		this.connectedScenes = connectedScenes;
	}
	
	public Scene getFrameWork(){
		return framework;
	}
	
	public StackPane getMasterPane(){
		return masterPane;
	}
	
	public void replaceBorderPane(BorderPane toReplace){
		contentPane = toReplace;
	}
	
	public void replaceMasterPane(StackPane toReplace){
		masterPane = toReplace;
	}
	
	public BorderPane getBorderPane(){
		return contentPane;
	}
	
	private void constructScene(String pathToBackGround){
		
		masterPane = new StackPane();
		contentPane = new BorderPane();
		
		loadBackGround(pathToBackGround);
		
		masterPane.getChildren().add(contentPane);
		
		framework = new Scene(masterPane, GAME_WIDTH, GAME_HEIGHT);
	}
	
	public void loadTitle(String title, boolean isTitle){
		StackPane textTitle = new StackPane();
		Text titleToLoad = new Text();
		
		if(isTitle){
			textTitle.setAlignment(Pos.CENTER);
			textTitle.setTranslateY(-78);
			titleToLoad.setText(title);
			titleToLoad.setFont(Font.font("Mistral", FontWeight.BOLD, 78));
			textTitle.getChildren().add(titleToLoad);
			contentPane.setCenter(textTitle);
		}
		else{
			textTitle.setAlignment(Pos.TOP_CENTER);
			textTitle.setTranslateY(10);
			titleToLoad.setText(title);
			titleToLoad.setFont(Font.font("Mistral", FontWeight.BOLD, 32));
			textTitle.getChildren().add(titleToLoad);
			contentPane.setTop(textTitle);
		}		
	}
	
	private void loadBackGround(String pathToBackGround){
		Image image = new Image(pathToBackGround);
		ImageView imageView = new ImageView();
		imageView.setImage(image);
		masterPane.getChildren().add(imageView);
	}
}
