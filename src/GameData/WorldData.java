package GameData;

/**
 * This class contains data on the world elements as well as methods to manipulate the elements
 * 
 * Implemented Elements: Game Days
 * 
 * Likely Future Elements: Random Events
 * 
 * Potential Future Elements: Weather 
 * 
 * @author Dsp02_000
 *
 */
public class WorldData {

	private int currentDay;
	private int dayTick;
	
	public WorldData(int currentDay){
		this.currentDay = currentDay;
	}
	
	public void setcurrentDay(int value){
		currentDay = value;
	}
	
	public int getcurrentDay(){
		return currentDay;
	}
	
	/**
	 * 
	 * @param byXUnits
	 * @return
	 */
	public int incrementDay(int byXUnits){
		dayTick += byXUnits;
		return dayTick;
	}
}
