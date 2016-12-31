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
 * This class handles the framework that will define any Scene created in the game, offering methods of retrieving
 * and manipulating the bones of a scene
 * 
 * Scenes as of now are constructed on a StackPane, masterPane, in the following order;
 * UPDATE AS NECESSARY
 * 1. Background Image
 * 2. BorderPane
 * 3. UserInterface
 * 		...
 * @author Dsp02_000
 *
 */
public abstract class GameScenes{
	
	private Scene framework;								/* */
	private StackPane masterPane;							/* */
	private BorderPane contentPane;							/* */
	private SceneBranch connectedScenes;					/* */
	private Stage primaryStage;								/* */
	private NodeUserInterface ui;							/* */
	protected PlayerData player;							/* Contains data on Player */
	protected WorldData world;								/* Contains data on World */
	
	public static final int GAME_WIDTH = 760;				/* */
	public static final int GAME_HEIGHT = 640;				/* */
	
	public abstract void sceneEvents();						/* */
	public abstract void sceneButtons(boolean isBackBut);	/* */
	
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
	
	/**
	 * Constructs the bones of the Scene, creates the masterPane and uploads the background image onto
	 * the bottom-most pane, then adds a borderPane on top for the content to define the scene
	 * here the size of the Scene is set
	 * 
	 * @param pathToBackGround	A string with a path to the image to serve as the background
	 */
	private void constructScene(String pathToBackGround){
		
		masterPane = new StackPane();
		contentPane = new BorderPane();
		
		loadBackGround(pathToBackGround);
		
		masterPane.getChildren().add(contentPane);
		
		framework = new Scene(masterPane, GAME_WIDTH, GAME_HEIGHT);
	}
	
	/**
	 * Adds the title to the borderPane of the masterPane, the title serves as the text to place on
	 * the borderPane. The title is always set in the top of the borderPane but depending on the boolean
	 * parameter, isTitle will determine if it serves as a big or small title. Useful if you want a 
	 * regional title or if you want a game title
	 * 
	 * @param title		The text that will be set as the title of the scene
	 * @param isTitle	If true the Title will be large and more centered, if false, smaller and closer to the top
	 */
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
	
	/**
	 * Sets the background image on the bottom layer of the masterPane
	 * 
	 * @param pathToBackGround	The path to the background
	 */
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
	
	public Stage getStage(){
		return primaryStage;
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
