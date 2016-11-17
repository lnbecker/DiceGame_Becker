

import java.util.*;

public class HW2DiceGame {
	public static Pot pot = new Pot();
	public static int NUM_PLAYERS = 0; //does it need to be global variable?
	public static int turnN=1;
	public static boolean winner = false;
	public String winnerName;
	private static List<Player> players = new ArrayList<Player>();
	
	public static void main(String[] args){
		 //SETS UP PLAYERS
		 System.out.println("Welcome to the Dice Game. Please enter the number of players: ");
		 Scanner scan = new Scanner(System.in);
		 NUM_PLAYERS = scan.nextInt();
		 //public static Player[] players = new Player[NUM_PLAYERS]; 
			
		 
		 for (int p=0; p<NUM_PLAYERS; p++){ //set up players
			 System.out.print("Please enter a name for Player " + (p+1) + ": ");
			 System.out.println("");
			 String name = scan.next();
			 name = name.toLowerCase();
			 System.out.println("What type of Player is " + name + "?");
			 System.out.println("0 = Human");
			 System.out.println("1 = Computer1");
			 System.out.println("2 = Computer2");
			 System.out.println("");
			 Player newPlayer; 	//??  declare this outside of switch?
			 int type = scan.nextInt();
			 switch (type){
				 case 0:
					 newPlayer = new Human(name);
					 players.add(newPlayer);
					 break;
				 case 1:
					 newPlayer = new Computer1(name);
					 players.add(newPlayer);
					 break;
				 case 2:
					 newPlayer = new Computer2(name);
					 players.add(newPlayer);
					 break;
				default:
					System.out.println("Type not valid. Player was made Type Computer2.");
					newPlayer = new Computer2(name);	
					players.add(newPlayer);
				 }
		}
		 System.out.println("Players created. Ready to start.");
		 //scan.close();


	
		//STARTS GAME
		 int round = 0;
		 boolean done = false; 	//true if player AcedOut or took chips
		 int chipsWon = 0;
		 boolean acedOut=false;
		 
		while(!winner){
			
			done=false; 		//reset
			acedOut=false; 		//reset
			chipsWon = 0; 		//reset
			turnN=1; 			//reset
			pot.addChips(1);    // adds 1 chip to pot
			int p = (round % NUM_PLAYERS);
			Player currentPlayer = players.get(p); //p index wrong? ***************
			while(!done){
				int[] dieResult = currentPlayer.rollDie(turnN);
				acedOut = acedOut(dieResult);
				if (acedOut){
					acedOut=true;
					done=true;
					break;
				}
				else { 
					done = currentPlayer.takePot(pot.getChipCount()); //see if player would like to continue
					if (done){ 			//if Player would like to take pot
						chipsWon = pot.getChipCount();
						currentPlayer.addChips(chipsWon); 	//add chips to player's total
						pot.takeChips(); 	//remove chips from pot
						break;
					}
					else{ 	//player wants to continue playing
						turnN++; 				//increment turnN
						pot.addChips(turnN);	//add more chips to the pot
					}
				}
				
			}
			winner = (currentPlayer.getChipCount() > 29);
			if (winner){ //player just won
				printStandings(currentPlayer, turnN, chipsWon, acedOut, winner);
				break;
			}
			else{ //continue game
				printStandings(currentPlayer, turnN, chipsWon, acedOut, winner);
				round++;//p++;
			}
		}
			
	} //end of main
	
	
	
	
	
	
	public static boolean acedOut(int[] numbers){  //returns whether or not person aced Out on turn   
		for (int a : numbers){
			if (a==1){
				return true;
			}
		}
		return false;
	}
	
	public static void printStandings(Player recentPlayer, int rollNumber, int chipsWon, boolean acedOut, boolean gameOver){
		String standings = "Chip Count:    ";
		for (int p=0; p<NUM_PLAYERS; p++){
			Player currentPlayer = players.get(p);
			String playerName = currentPlayer.getName();
			int chipCount = currentPlayer.getChipCount();
			standings += (playerName + ": " + chipCount + "     ");
			}
		if (acedOut){
			String roundAced = recentPlayer.getName() + " aced out after " + rollNumber + " rolls.";
			System.out.println(roundAced);
		}
		else{
			String round = recentPlayer.getName() + " stopped after " + rollNumber + " rolls and won " + chipsWon + " chips.";
			System.out.println(round);
		}
		System.out.println(standings);
		System.out.println("The pot contains " + pot.getChipCount() + " chips.");
		System.out.println("");
		if(winner){
			String gameOverString = recentPlayer.getName() + " won the game with " + recentPlayer.getChipCount() + " chips.";
			System.out.println(gameOverString);
		}
	}
	
	
}
	