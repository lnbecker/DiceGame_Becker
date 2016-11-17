import java.util.Scanner;


public class Human extends Player{
	
	public Human(String name){
		super(name);
	}
	
	public boolean takePot(int n){
		System.out.println("There are " + n + " chips in the pot. Would you like to take the chips?");
		System.out.println("0 - No, I would like to keep playing");
		System.out.println("1 - Yes, I want to take the chips");
		Scanner scan = new Scanner(System.in);
		//String s = scan.next();
		//System.out.println(s);
		int keepGoing = scan.nextInt(); //***********
		//scan.close();
		if (keepGoing == 0)
			return false;
		else if (keepGoing == 1)
			return true;
		else {
			System.out.println("Invalid input. Continuing turn.");
		    return false;
		}
	}
	
}