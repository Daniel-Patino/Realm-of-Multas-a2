package GameScenes;

import GameData.PlayerData;
import GameData.WorldData;
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
 * 3. UserInterface
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
	protected NodeUserInterface ui;
	protected PlayerData player;
	protected WorldData world;
	
	boolean ifSet = false;
	
	public static final int GAME_WIDTH = 760;
	public static final int GAME_HEIGHT = 640;
	
	public abstract void sceneEvents();
	public abstract void sceneButtons(boolean isBackBut);
	
	public GameScenes(Stage primaryStage, String pathToBackGround, PlayerData player, WorldData world){
		this.primaryStage = primaryStage;
		this.player = player;
		this.world = world;
		constructScene(pathToBackGround);
	}
	
	/**
	 * This instantiates the User Interface, it must be called inside of the customEvents located in the
	 * grand children of this methods.
	 * 
	 * @param isUI	True or False to indicate whether the UI is created or not
	 */
	protected void loadUserInter(boolean isUI){
		if(isUI){
			NodeUserInterface ui = new NodeUserInterface(player, world, this, connectedScenes);
			this.ui = ui;
		} else {
			this.ui = null;
		}
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
	
	/* ---GETTERS AND SETTERS--- */
	
	public Scene getFrameWork(){
		return framework;
	}
	
	public StackPane getMasterPane(){
		return masterPane;
	}
	
	public BorderPane getBorderPane(){
		return contentPane;
	}
	
	public NodeUserInterface getUI(){
		return ui;
	}
	
	public SceneBranch getSceneBranch(){
		return connectedScenes;
	}
	
	public GameScenes getThis(){
		return this;
	}
	
	public void setBorderPane(BorderPane contentPane){
		this.contentPane = contentPane;
	}
	
	public void setMasterPane(StackPane masterPane){
		this.masterPane = masterPane;
	}
	
	public void setSceneBranch(SceneBranch connectedScenes){
		this.connectedScenes = connectedScenes;
	}
}
