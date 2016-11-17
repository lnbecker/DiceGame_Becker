import java.util.Random;

public abstract class Player{
	private int chipCount = 0;
	public String name;
	
	public Player(String s){
		name = s;
	}
	
	
	
	public int[] rollDie(int n){ //rolls n die and returns array of numbers rolled
		int[] results = new int[n];
		Random rand = new Random();
		for (int i=0; i<n; i++){
			int randomNum = rand.nextInt((4 - 1) + 1) + 1;
			results[i] = randomNum;
		}
		return results;
	} 
	
	public int getChipCount(){
		return chipCount;
	}
	
	public void setName(String s){
		name = s;
	}
	
	public String getName(){
		return name;
	}

	public void addChips(int n){
		chipCount += n;
	}
	
	public abstract boolean takePot(int n); //returns whether or not person decides to take Pot - different for every Type of Player
	//^ Do I put this here?
	

}