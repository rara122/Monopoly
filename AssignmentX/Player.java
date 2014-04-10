package AssignmentX;
import java.util.Random;

class Player {
	private double balance;
	private int position;
	private Random rando;
	
	public Player(){
		balance = 1500.00;
		position = 0;
		rando = new Random(System.currentTimeMillis());
	}
	
		// Returns Status
	public String takeTurn(){
		moveSpaces(rollDice());
		return getStatus();
	}
	
	boolean withdraw (double amount){
		if (amount < balance){
			balance -= amount;
			return true;
		}
		else{
			System.out.println("Throw exception buddy: Not enough money!");
			return false;
		}
	}
	boolean deposit (double amount){
		balance += amount;
		return true;
	}
	// Roll Dice
	// Action based upon Landing Property... Figure out where this can go.
	
	public double getBalance(){
		return balance;
	}
	
	public int getPosition(){
		return position;
	}
	
	public int moveSpaces(int spaces){
		position += spaces;
		if (position  > 39){
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$\nPassed Go, Collect $200\n$$$$$$$$$$$$$$$$$$$$$$$");
			deposit(200.00);
		}

		return position %= 40;
	}
	
		// Set position. Return new position or -1 if bad input.
	public int setPosition(int pos){
		if(pos >= 0 && pos < 40){
			position = pos;
			return pos;
		}
		else{
			return -1;
		}
	}
	
	public int rollDice (){
		int roll1,roll2;
		roll1 = (rando.nextInt() % 6 + 6) % 6 + 1;
		roll2 = (rando.nextInt() % 6 + 6) % 6 + 1;
		System.out.println("Rolled: " + roll1 + ", " + roll2);
		if(roll1 == roll2){
			//RETAKE TURN UNLESS 3 times
			System.out.println("###################\n     DOUBLES!\n###################");
		}
		return roll1 + roll2;
	}
	
	public String getStatus(){
		String status = "Pos: " + getPosition() + ", $" + getBalance();
		return status;
	}
	
	// public static void main (String args[]){
		// Player p1;
		// Player p2;
		// p1 = new Player();
		// p2 = new Player();
		
		// int roll;
		
		// for(int i = 0; i < 5; i++){
			// System.out.println("p1 balance: " + p1.getBalance());
			// System.out.println("p1 position: " + p1.getPosition());
			// System.out.print("p1 rolled: ");
			// roll = p1.rollDice();
			// System.out.println("p1 moving to space: " + p1.moveSpaces(roll) + "\n");
		// }
		
	// }
}