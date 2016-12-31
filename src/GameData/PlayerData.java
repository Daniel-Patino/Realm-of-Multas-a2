package GameData;

public class PlayerData {
	
	private int playerHealth;
	private int playerGold;
	
	public PlayerData(int playerHealth, int playerGold){
		this.playerHealth = playerHealth;
		this.playerGold = playerGold;
	}
		
	public int getPlayerGold(){
		return playerGold;
	}
	
	public int getPlayerHealth(){
		return playerHealth;
	}
	
	public void setPlayerGold(int value){
		playerGold = value;
	}
	
	public void setPlayerHealth(int value){
		playerHealth = value;
	}
}
