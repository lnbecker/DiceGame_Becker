
public class Pot{
	public static int chipCount=0;
	
	public Pot(){
		
	}
	
	public int getChipCount(){ //returns number of chips in pot
		return chipCount;
	}
	
	public void addChips(int n){ //adds chips to pot     used in main class
		chipCount+=n;
	}
	
	public void takeChips(){ //signals person has taken all chips from pot
		chipCount=0;
	}
}