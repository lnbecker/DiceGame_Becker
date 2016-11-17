import java.util.Random;

public class Computer2 extends Player{
	
	public Computer2(String name){
		super(name);
	}
	
	
	public boolean takePot(int n){ //takes chips if there are more than 6 in pot or if random number is divisible by 3 or 5
		if (n>6)
			return true;
		else{
			Random random = new Random();
			int number = (int) random.nextInt(1000-1+1)+1; //generate random number between 0-1000
			if (number % 3 == 0 || number % 5 == 0)
				return true;
			else
				return false;
		}
	}
	
	
	//random.nextInt(max - min + 1) + min
	/*public boolean takePot(int n){
		Random random = new Random();
		int bigger = (int) random.nextInt(1000 - 0 + 1) + 0; //generates random number between 0-1000
		int smaller = (int) random.nextInt(10 - 1 + 1) + 1; //generates random number between 1-10
		int number = bigger % smaller;
		if ((number % 2) == 0){ //if number is even
			return true; //take the pot
		}
		else
			return false; //continue to play the game
		}*/
	
}