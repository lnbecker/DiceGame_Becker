import java.util.Random;


public class Computer1 extends Player{
	
	public Computer1(String name){
		super(name);
	}
	
	
	public boolean takePot(int n){ //takes Pot if number of chips in pot is greater than number generated
		Random random = new Random();
		int number = (int) random.nextInt(6-1+1) + 1; //generate number between 1 and 6
		if (n>number)
			return true;
		else
			return false;
	}
	
	
	/*public boolean takePot(int n){
		Random random = new Random();
		int bigger = (int) random.nextInt(1000 - 0 + 1) + 0; //generates random number between 0-1000
		int smaller = (int) random.nextInt(100 - 1 + 1) + 1;; //generates random number between 1-100
		int number = bigger / smaller;
		if (number > 20){
			return true; //take the pot
		}
		else
			return false; //continue to play the game
		} */
	
}