package GameData;

public class WorldData {

	private int currentDay;
	
	public WorldData(int currentDay){
		this.currentDay = currentDay;
	}
	
	public int getcurrentDay(){
		return currentDay;
	}
	
	public void setcurrentDay(int value){
		currentDay = value;
	}
}
